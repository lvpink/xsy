package other.logistics.manager;

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
 * （管理员）查询物流单信息
 * I_FLAG = Q 查询  M 修改
 * @author XSY
 *
 */
public class LogisticManagerWServiceQ implements ApiSupport {
	
	private static final Logger logger = LoggerFactory.getLogger();

	@Override
	public String execute(Request paramRequest, Long paramLong1, Long paramLong2) {
		logger.info("（管理员）查询物流单信息-->start");
		logger.info(JSONObject.toJSONString(paramRequest));
		String wsResult = webservice(paramRequest);
		logger.info("（管理员）查询物流单返回数据："+wsResult);
		
		return wsResult;
	}

	/**
	 * 查询物流单webService请求接口--管理员模式
	 * @param paramRequest
	 * @return
	 */
	 public static String webservice(Request paramRequest) {
		 
		 	JSONObject retJson = new JSONObject();
			retJson.put("code", -1);
			
			String  req = paramRequest.getReader().toString();
			JSONObject Jsonreq = JSONObject.parseObject(req);
			if(null==Jsonreq||Jsonreq.toString().equals("")){
				retJson.put("msg", "（管理员）查询物流单上送参数为空");
				return retJson.toString();
			}
			String param = Jsonreq.getString("param");
	        JSONObject content = JSONObject.parseObject(param);
	        String userId = content.getString("lifnr");//用户id
	        //查询用户编号
	        String userCode = PaasUtils.queryCodeByUserId(userId);
	        if(null==userId||userId.equals("")||userCode==userId||userCode.equals("")){
				retJson.put("msg", "该用户不存在");
				logger.error("用户id:"+userId+",用户编号："+userCode);
				return retJson.toString();
			}
	        String zcrmQslx = content.getString("zcrmQslx");
	        if(null==zcrmQslx||zcrmQslx.equals("")||!PaasUtils.arr.contains(zcrmQslx)){
				retJson.put("msg", "CRM签收类型不合法");
				return retJson.toString();
			}
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
	        String vbeln = content.getString("vbeln");
	        //设置查询参数
	        ZcrmOutdiS isHead = new ZcrmOutdiS();
			isHead.setLifnr(userCode);//8004602
			isHead.setBegda(begda);
			isHead.setEndda(endda);
			isHead.setZcrmQslx(zcrmQslx);
			isHead.setVbeln(vbeln);
	        
			//调用WS接口方法
	    	ZFMCRMLGCSD_Service zfmcrmlgcsd_Service = new ZFMCRMLGCSD_Service();
	    	ZFMCRMLGCSD port = zfmcrmlgcsd_Service.getBinding();
	    	BindingProvider bp = (BindingProvider) port;
	        Map<String, Object> context = bp.getRequestContext();
	        context.put(BindingProvider.USERNAME_PROPERTY, Constants.USERNAME);
	        context.put(BindingProvider.PASSWORD_PROPERTY, Constants.PASSWORD);
	        
	        String iFlag = "Q";//查询标识
			ZcrmOutdoT zcrmOutdoT = new ZcrmOutdoT();
			Holder<ZcrmOutdoT> etOutdo = new Holder<ZcrmOutdoT>(zcrmOutdoT);
	        
	        port.zfmCrmLgcsD(iFlag, isHead, null, null, etOutdo);
	        
	        //构建返回值
	        JSONArray jsonArray = new JSONArray();
	        List<ZcrmOutdoS> item = etOutdo.value.getItem();
	        for (ZcrmOutdoS zcrmOutdoS : item) {
	        	String erdat = HhtTools.JavaDateToString(zcrmOutdoS.getErdat());
	        	String jsonString = JSONObject.toJSONString(zcrmOutdoS);
	        	JSONObject parseObject = JSONObject.parseObject(jsonString);
	        	parseObject.put("erdat", erdat);
	        	jsonArray.add(parseObject);
			}
	        
	        retJson.put("data", jsonArray);
	        retJson.put("msg", "（管理员模式）查询物流单成功");
	        retJson.put("code", 0);
	        logger.info("（管理员模式）返回前端参数："+retJson.toString());
	        return retJson.toString();
	        
	     
	 }
}
