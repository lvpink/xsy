package other.hht.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.Product;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.BatchOperateResult;
import com.rkhd.platform.sdk.service.XObjectService;

public class ProductWs {

	private static final Logger logger = LoggerFactory.getLogger();
    
	/*调用webService接口，并执行同步产品信息操作*/
    public static String webservice() {
    	logger.info("查询sapWS产品信息");
    	ZFMCRMCPBM_Service zfmcrmcpbm_Service = new ZFMCRMCPBM_Service();
    	ZFMCRMCPBM port = zfmcrmcpbm_Service.getBinding();
    	BindingProvider bp = (BindingProvider) port;
        Map<String, Object> context = bp.getRequestContext();
        context.put(BindingProvider.USERNAME_PROPERTY, Constants.USERNAME);
        context.put(BindingProvider.PASSWORD_PROPERTY, Constants.PASSWORD);
        //上线时生成环境地址需要进行替换  ，如果根据生产wsdl生成代理类  可以不进行替换
        // context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"http://SAPD02.HITEVISION.COM:8090/sap/bc/srt/rfc/sap/zfm_as_0025/300/zfm_as_0025/binding");
        TableOfZfgCrmMatnrS tableOfZfgCrmMatnrS = new  TableOfZfgCrmMatnrS();
        javax.xml.ws.Holder<TableOfZfgCrmMatnrS> tZfgCrmMatnrS=new   javax.xml.ws.Holder<TableOfZfgCrmMatnrS>(tableOfZfgCrmMatnrS);
        String iFlag = "Q";
        //执行webservice 方法
		port.zfmCrmCpbm(tZfgCrmMatnrS, iFlag);
		//获取返回值
		List<ZfgCrmMatnrS> allItems = tZfgCrmMatnrS.value.getItem();
		List<ZfgCrmMatnrS> items;
		if(allItems.size()>200){
			items = allItems.subList(0, 200);//每次同步300条数据
		}else{
			items = allItems;
		}
		
		logger.info("WS接口返回产品allItems大小："+allItems.size());
		/**构建返回数据*/
		JSONObject result = new JSONObject();
		result.put("status", 0);
		result.put("msg", "同步产品表成功");
		//产品临时表
		List<Product> proList = new ArrayList<Product>();
		//只获取一次业务类型product
		Long productEntityTypeId = PassUtils.getEntityTypeId("product");
		//查询产品目录id
		Long productParentId = PassUtils.getProductParentId();
		String unameCodeErr = "";
		if(null!=items&&items.size()>0){
			Product product;
			for (ZfgCrmMatnrS zfgCrmMatnrS : items) {
				product = new Product();
				String uname = zfgCrmMatnrS.getUname();
				Long userId = PassUtils.getUserId(uname);//用户名
				if(null!=userId){
					product.setOwnerId(userId);
				}else{
					unameCodeErr+=uname+",";
					continue;
				}
				product.setEntityType(productEntityTypeId);
				product.setProductName(zfgCrmMatnrS.getCpbm());
				product.setEnableStatus(1);//1启用，0禁用
				product.setParentId(productParentId);
				product.setDescription(zfgCrmMatnrS.getCpms());
				product.setFscProductModel(zfgCrmMatnrS.getHpmc());
				product.setFscProductSpec(zfgCrmMatnrS.getXhgg());
				product.setCPX__c(Integer.valueOf(zfgCrmMatnrS.getXslx()));//销售团队（产品线）
				product.setXSZZ__c(zfgCrmMatnrS.getVkorg());//销售机构
				product.setXSFZ__c(zfgCrmMatnrS.getVkbur());//销售部门（销售分支
				product.setZJBX__c(Integer.parseInt(zfgCrmMatnrS.getZjbx())+"");//整机保修
				product.setHCBX__c(Integer.parseInt(zfgCrmMatnrS.getHcbx())+"");//耗材保修
				product.setCB1NFY__c(zfgCrmMatnrS.getZcb1F().doubleValue());//超保1年费用 
				product.setCB2NFY__c(zfgCrmMatnrS.getZcb2F().doubleValue());//超保2年费用 
				product.setCB3NFY__c(zfgCrmMatnrS.getZcb3F().doubleValue());//超保3年费用 
				product.setSYBJL__c(zfgCrmMatnrS.getSname().equals("") ? null :PassUtils.getUserIdByCode(zfgCrmMatnrS.getSname()));//事业部经理
				product.setFHJL__c(zfgCrmMatnrS.getFname().equals("") ? null :PassUtils.getUserIdByCode(zfgCrmMatnrS.getFname()));//分货经理
				product.setZCJL__c(zfgCrmMatnrS.getZname().equals("") ? null :PassUtils.getUserIdByCode(zfgCrmMatnrS.getZname()));//转储经理
				product.setFZJLSPJ__c(zfgCrmMatnrS.getFzjlsp().doubleValue());//分支经理审批价格
				product.setDQJLSPJ__c(zfgCrmMatnrS.getDqjlsp().doubleValue());//大区经理审批价格
				product.setSYBJLSPJ__c(zfgCrmMatnrS.getHtmsj().doubleValue());//事业部经理审批价
				product.setSYBZJLSPJ__c(zfgCrmMatnrS.getSybzsp().doubleValue());//事业部总经理审批价
				product.setYYBGZJL__c(zfgCrmMatnrS.getYyzsp().doubleValue());//营业BG总经理审批价
				product.setJYJTZCSPJ__c(zfgCrmMatnrS.getJtzcsp().doubleValue());//教育集团总裁审批价
				product.setHTZDJ__c(zfgCrmMatnrS.getHtzdj().doubleValue());//合同最低价
				product.setHTZDS__c(zfgCrmMatnrS.getHtzds().longValue());//合同最大数
				product.setBZ__c(zfgCrmMatnrS.getWaers().equals("RMB")? 1:0);//货币码 
				product.setSL__c((double)zfgCrmMatnrS.getTaxrate()/100);//税率
//				product.setFDBS__c(Boolean.valueOf(zfgCrmMatnrS.getZfdbs()));//返点标识
				product.setZHBS__c(zfgCrmMatnrS.getZzhbs());//组合标识
				product.setTJBS__c(zfgCrmMatnrS.getZtjbs());//套件标识
				product.setDFLG__c(zfgCrmMatnrS.getDflag().equals("true")? true:false);//删除标识
				product.setPriceUnit(Double.valueOf("99999999"));
				proList.add(product);
			}
		}else{
			logger.info("sap返回数据为空。");
			result.put("status", 0);
			result.put("msg", "sap没有可同步产品数据。");
			return result.toString();
		}
		
		logger.info(JSONObject.toJSONString(proList));
		if(!unameCodeErr.equals("")){
			unameCodeErr+="用户编码不存在。对应的产品数据未同步。";
		}
		if(proList.size()==0){
			logger.info("proList数据为空。");
			result.put("status", -1);
			result.put("msg", "sap返回的数据中所有的uname在SRM都不存在，没有可同步产品数据。");
			return result.toString();
		}
		//创建产品正式表待同步数据
		logger.info("构建产品表数据");
		List<Product> updateList = new ArrayList<Product>();
		List<Product> insertList = new ArrayList<Product>();
		
		try {
			//批量同步产品正式表
			Boolean addFlag = false;
			List<Product> allproduct = PassUtils.doQueryProduct();
			logger.info("查询产品表数据size："+allproduct.size());
			
			for (Product proPdut : proList) {
				addFlag = false;
				for (Product tprduc : allproduct) {//产品表的数据
					if(proPdut.getProductName().equals(tprduc.getProductName())
							&&proPdut.getCPX__c().equals(tprduc.getCPX__c())
							&&proPdut.getXSZZ__c().equals(tprduc.getXSZZ__c())
							&&proPdut.getXSFZ__c().equals(tprduc.getXSFZ__c())){
						//更新
						proPdut.setId(tprduc.getId());
						updateList.add(proPdut);
						addFlag = true;//已存在产品表
						break;
					}
				}
				if(!addFlag){//添加新增数据
					insertList.add(proPdut);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("插入产品表失败: "+e.getMessage());
			e.printStackTrace();
		}
		 logger.info(insertList.size()+"===insertList大小");
	     logger.info(updateList.size()+"===updateList大小");
	     //更新
        String updateErr = "";
        try {
			if(updateList.size()>0){
			  BatchOperateResult update = XObjectService.instance().update(updateList);
			  if(update.getSuccess()){
				  updateErr+="更新成功记录数 ："+ updateList.size()+"\n";
				  logger.info("更新成功记录数 ："+ updateList.size());
				}else{
					updateErr+="更新失败记录数 ："+ updateList.size()+"\n"+"失败原因："+update.getErrorMessage();
					logger.info("更新失败记录数 ："+ updateList.size()+"\n"+"失败原因："+update.getErrorMessage());
				}
			}
		} catch (ApiEntityServiceException e) {
			logger.error("执行更新报错: "+e.getMessage());
			e.printStackTrace();
		}
       //新增
        logger.info(JSONObject.toJSONString(insertList));
        String insertErr = "";
        try {
			if(insertList.size()>0){
				BatchOperateResult insert = XObjectService.instance().insert(insertList);
				if(insert.getSuccess()){
					
					insertErr+="新增成功记录数 ："+ insertList.size()+"\n";
					logger.info("新增成功记录数 ："+ insertList.size());
				}else{
					insertErr+="新增失败记录数 ："+ insertList.size()+"\n"+"失败原因："+insert.getErrorMessage();
					logger.info("新增失败记录数 ："+ insertList.size()+"\n"+"失败原因："+insert.getErrorMessage());
				}
			}
		} catch (ApiEntityServiceException e) {
			logger.error("执行新增报错: "+e.getMessage());
			e.printStackTrace();
		}
        if(insertErr.contains("失败原因")||updateErr.contains("失败原因")){
        	result.put("status", -1);
        }else{
        	result.put("status", 0);//全部成功
        	//调用接口，更新产品状态为已下达
        	iFlag = "I";
        	tableOfZfgCrmMatnrS = new TableOfZfgCrmMatnrS();
        	tZfgCrmMatnrS=new javax.xml.ws.Holder<TableOfZfgCrmMatnrS>(tableOfZfgCrmMatnrS);
        	tZfgCrmMatnrS.value.getItem().addAll(items);
        	port.zfmCrmCpbm(tZfgCrmMatnrS, iFlag);
        }
       String msg = updateErr+", \n "+insertErr+", \n";
       if(unameCodeErr.contains(",")){
    	   msg+=unameCodeErr;
       }
		result.put("msg", msg);
		return result.toString();
    }
    public static void main(String[] args) {
		webservice();
	}
}
