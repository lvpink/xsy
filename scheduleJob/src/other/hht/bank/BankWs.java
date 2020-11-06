package other.hht.bank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.xml.ws.BindingProvider;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.YHDM__c;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.http.RkhdHttpClient;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.BatchOperateResult;
import com.rkhd.platform.sdk.service.XObjectService;
/**
 * 同步银行编码信息
 * @author XSY
 *
 */
public class BankWs {

	private static final Logger logger= LoggerFactory.getLogger();

    /*调用webService接口，并执行同步银行信息操作*/
    public static String webservice() {
        ZFMCRMBNKA_Service zfmcrmbnkaService = new ZFMCRMBNKA_Service();
        ZFMCRMBNKA port = zfmcrmbnkaService.getBinding();
        // 设置访问接口服务器的用户名和密码  需要提取到系统自定义对象保存
        BindingProvider bp = (BindingProvider) port;
        Map<String, Object> context = bp.getRequestContext();
        context.put(BindingProvider.USERNAME_PROPERTY, Constants.USERNAME);
        context.put(BindingProvider.PASSWORD_PROPERTY, Constants.PASSWORD);
        //上线时生成环境地址需要进行替换  ，如果根据生产wsdl生成代理类  可以不进行替换
       // context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"http://SAPD02.HITEVISION.COM:8090/sap/bc/srt/rfc/sap/zfm_as_0025/300/zfm_as_0025/binding");
        TableOfZssrmBnka tableOfZssrmBnka=new TableOfZssrmBnka();
        javax.xml.ws.Holder<TableOfZssrmBnka> tBnka=new   javax.xml.ws.Holder<TableOfZssrmBnka>(tableOfZssrmBnka);
        port.zfmCrmBnka(tBnka);  //执行webservice 方法
        List<ZssrmBnka> sapItems = tBnka.value.getItem(); //获取返回值
        logger.info("sap银行数据集合大小"+sapItems.size());
        
        ArrayList<ZssrmBnka> items = sapItems.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ZssrmBnka::getBankl))),
                                zsrmBnka -> new ArrayList<>(zsrmBnka)
                        )
                );
        logger.info("sap银行数据根据银行编码去重后集合大小"+items.size());
        /**构建返回数据*/
    	JSONObject result = new JSONObject();
        //更新集合
    	List<YHDM__c> updateList = new ArrayList<YHDM__c>();
    	//新增集合
    	List<YHDM__c> insertList = new ArrayList<YHDM__c>();
    	//业务类型只获取一次
    	Long entityTypeId = PassUtils.getEntityTypeId("YHDM__c");
    	//重复的银行代码
    	String codeRepErr = "重复的银行代码：-> ";
        if(null!=items&&items.size()>0){
        	YHDM__c bank = new YHDM__c();
        	//设置业务类型
        	bank.setEntityType(entityTypeId);
        	try {
        			RkhdHttpClient rkhdHttpClient = new RkhdHttpClient();
            		List<YHDM__c> bankList = PassUtils.doQuery(rkhdHttpClient);
            		
            		Boolean addFlag = false;
            		//外层循环xsy环境的数据，内层循环webService接口查询到的数据
            		for (ZssrmBnka zsrmBnka : items) {
            			for (YHDM__c yhdm__c : bankList) {
            				if(zsrmBnka.getBankl().equals(yhdm__c.getName())){
            					//根据银行编码查重，已存在数据添加到updateList,结束本次循环
            					yhdm__c.setEntityType(entityTypeId);
            					yhdm__c.setBankName__c(zsrmBnka.getBanka());
            					yhdm__c.setBankCountryName__c(zsrmBnka.getLandx());//国家银行名称
            					updateList.add(yhdm__c);
            					addFlag = true;
            					break;
            				}
            			}
            			if(!addFlag){
            				bank = new YHDM__c();
            				bank.setEntityType(entityTypeId);
            				bank.setName(zsrmBnka.getBankl());
                			bank.setBankCountryCode__c(zsrmBnka.getBanks());
                			bank.setBankCountryName__c(zsrmBnka.getLandx());//国家银行名称
                			bank.setBankName__c(zsrmBnka.getBanka());
                			insertList.add(bank);
            			}
            		}
        	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else{
        	logger.info("sap返回银行信息为空。");
        	result.put("status", -1);
    		result.put("msg", "sap无可同步银行数据。");
    		return  result.toString();
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
        	result.put("status", 0);
        }
       String msg = updateErr+"\n"+insertErr+" \n";
       if(codeRepErr.contains(",")){
    	   msg+=codeRepErr;
       }
		result.put("msg", msg);
		return result.toString();
    }
}