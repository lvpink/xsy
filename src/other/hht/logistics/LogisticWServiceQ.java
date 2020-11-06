package other.hht.logistics;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.api.ApiSupport;
import com.rkhd.platform.sdk.http.Request;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;

/**
 * 物流单查询 --Q查询; G订单追踪; L货品清单;W相关物流单
 * @author XSY
 */
public class LogisticWServiceQ implements ApiSupport{
	private static final Logger logger = LoggerFactory.getLogger();
	
	@Override
	public String execute(Request paramRequest, Long paramLong1, Long paramLong2) {
		logger.info("查询物流单信息-->start");
		logger.info(JSONObject.toJSONString(paramRequest));
		String wsResult = webservice(paramRequest);
		logger.info("查询物流单返回数据："+wsResult);
		
		return wsResult;
	}

	/**
	 * 查询物流单webService请求接口
	 * @param paramRequest
	 * @return
	 */
	 public static String webservice(Request paramRequest) {
		 
		 	JSONObject retJson = new JSONObject();
			retJson.put("code", -1);
			
			String  req = paramRequest.getReader().toString();
			JSONObject Jsonreq = JSONObject.parseObject(req);
			if(null==Jsonreq||Jsonreq.toString().equals("")){
				retJson.put("msg", "查询物流单上送参数为空");
				return retJson.toString();
			}
		 
	    	ZFMCRMLGCSP_Service zfmcrmlgcsp_Service = new ZFMCRMLGCSP_Service();
	    	ZFMCRMLGCSP port = zfmcrmlgcsp_Service.getBinding();
	    	BindingProvider bp = (BindingProvider) port;
	        Map<String, Object> context = bp.getRequestContext();
	        context.put(BindingProvider.USERNAME_PROPERTY, Constants.USERNAME);
	        context.put(BindingProvider.PASSWORD_PROPERTY, Constants.PASSWORD);
	        String iFlag = "Q";
	        ZcrmOutpo1T zcrmOutpo1T = new ZcrmOutpo1T();
	        Holder<ZcrmOutpo1T> etOutpo1 = new Holder<ZcrmOutpo1T>(zcrmOutpo1T);
	        
	        String param = Jsonreq.getString("param");
	        JSONObject content = JSONObject.parseObject(param);
	        String userId = content.getString("lifnr");//用户id
	        String userCode = PaasUtils.queryCodeByUserId(userId);
	        
	        if(null==userId||userId.equals("")||userCode==userId||userCode.equals("")){
				retJson.put("msg", "该用户不存在");
				logger.error("用户id:"+userId+",用户编号："+userCode);
				return retJson.toString();
			}
	        String zcrmQslx = content.getString("zcrmQslx");
	        if(null==zcrmQslx||zcrmQslx.equals("")){
				retJson.put("msg", "CRM签收类型不存在");
				return retJson.toString();
			}
	        String zcrmVbelnJh = content.getString("zcrmVbelnJh");
	        /*if(null==zcrmVbelnJh||zcrmVbelnJh.equals("")){
				retJson.put("msg", "交货单号不存在");
				return retJson.toString();
			}*/
	        
	        Date begda = HhtTools.stringToJavaDate(content.getString("begda"));
	        if(null==begda||begda.equals("")){
				retJson.put("msg", "开始日期不合法");
				return retJson.toString();
			}
	        Date endda = HhtTools.stringToJavaDate(content.getString("endda"));
	        if(null==endda||endda.equals("")){
				retJson.put("msg", "结束日期不合法");
				return retJson.toString();
			}
	        
	        ZcrmOutpi1S zcrmOutpi1S = new ZcrmOutpi1S();
	        zcrmOutpi1S.setLifnr(userCode);
	        zcrmOutpi1S.setZcrmVbelnJh(zcrmVbelnJh);
	        zcrmOutpi1S.setZcrmQslx(zcrmQslx);
	        zcrmOutpi1S.setBegda(begda);
	        zcrmOutpi1S.setEndda(endda);
	     
	        logger.info("上送ws参数："+JSONObject.toJSONString(zcrmOutpi1S));
			//执行webservice 方法
	        port.zfmCrmLgcsP(iFlag, zcrmOutpi1S, null, null, null,
	        		etOutpo1 , null, null, null);
	        JSONArray jsonArray = new JSONArray();
			//获取返回值
	        List<ZcrmOutpo1S> item = etOutpo1.value.getItem();
	        for (ZcrmOutpo1S zcrmOutpo1S : item) {
	        	Date budat = zcrmOutpo1S.getBudat();
	        	String date = HhtTools.JavaDateToString(budat);
	        	String jsonString = JSONObject.toJSONString(zcrmOutpo1S);
	        	JSONObject parseObject = JSONObject.parseObject(jsonString);
	        	parseObject.put("budat", date);
	        	jsonArray.add(parseObject);
			}
	        retJson.put("data", jsonArray);
	        retJson.put("msg", "查询物流单成功");
	        retJson.put("code", 0);
	        logger.info("返回前端参数："+retJson.toString());
	        return retJson.toString();
	 }
	 public static void main(String[] args) {
		 JSONObject param = new JSONObject();
		 param.put("param", "{\"begda\": \"2020-07-01\",\"endda\": \"2020-07-30\",\"lifnr\": \"8004602\",\"zcrmQslx\": \"A\",\"zcrmVbelnJh\": null}");
//		webservice(param.toString());
	}

}
