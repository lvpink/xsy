package other.logistics.manager;

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
 * （管理员）导入物流详情
 * I_FLAG = Q 查询  M 修改
 * @author XSY
 *
 */
public class ImportLogisticWService implements ApiSupport {
	
	private static final Logger logger = LoggerFactory.getLogger();

	@Override
	public String execute(Request paramRequest, Long paramLong1, Long paramLong2) {
		logger.info("（管理员）导入物流详情-->start");
		logger.info(JSONObject.toJSONString(paramRequest));
		String wsResult = webservice(paramRequest);
		logger.info("（管理员）导入物流详情："+wsResult);
		
		return wsResult;
	}

	/**
	 * 导入物流详情webService请求接口--管理员模式
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
			
			JSONArray paramArr = Jsonreq.getJSONArray("param");
	        //设置查询参数
	        String iFlag = "M";//查询标识
			ZcrmOutdmT itItem = new ZcrmOutdmT();
		    ZcrmOutdmS zcrmOutdmS;
		    
			for (Object obj : paramArr) {
				zcrmOutdmS = new ZcrmOutdmS();
				//转换格式
				JSONObject content = JSONObject.parseObject(obj.toString());
				String vbeln = content.getString("vbeln");
		        if(null==vbeln||vbeln.equals("")){
					retJson.put("msg", "交货单号不存在");
					return retJson.toString();
				}
		        String zcrmVbelnWl = content.getString("zcrmVbelnWl");
		        if(null==zcrmVbelnWl||zcrmVbelnWl.equals("")){
		        	retJson.put("msg", "CRM物流单不存在");
		        	return retJson.toString();
		        }
		        String zcrmNewZtd = content.getString("zcrmNewZtd");
		        if(null==zcrmNewZtd||zcrmNewZtd.equals("")){
		        	retJson.put("msg", "最新在途地不存在");
		        	return retJson.toString();
		        }
		        zcrmOutdmS.setZcrmNewZtd(zcrmNewZtd); // 最新在途地
		        zcrmOutdmS.setZcrmVbelnWl(zcrmVbelnWl); //CRM物流单 
		        zcrmOutdmS.setVbeln(vbeln);//交货单号
		        itItem.getItem().add(zcrmOutdmS);
			}
	        if(itItem.getItem().size()==0){
	        	retJson.put("msg", "上送参数为空，请检查");
	        	return retJson.toString();
	        }
	        ZcrmMessgS zcrmMessgS = new ZcrmMessgS();
	        Holder<ZcrmMessgS> esMessg = new Holder<ZcrmMessgS>(zcrmMessgS);
	        
			//调用WS接口方法
	    	ZFMCRMLGCSD_Service zfmcrmlgcsd_Service = new ZFMCRMLGCSD_Service();
	    	ZFMCRMLGCSD port = zfmcrmlgcsd_Service.getBinding();
	    	BindingProvider bp = (BindingProvider) port;
	        Map<String, Object> context = bp.getRequestContext();
	        context.put(BindingProvider.USERNAME_PROPERTY, Constants.USERNAME);
	        context.put(BindingProvider.PASSWORD_PROPERTY, Constants.PASSWORD);
			
			//获取接口返回值
			port.zfmCrmLgcsD(iFlag, null, itItem, esMessg , null);
	        //构建返回值
			String mesg = esMessg.value.getMesg();
			logger.info("ws接口返回值2："+JSONObject.toJSONString(esMessg));
//			{"value":{"belnr":"","gjahr":"0000","mesg":"0660092753客户已签收","type":"E"}}
	        retJson.put("msg", mesg);
	        retJson.put("code", 0);
	        logger.info("（管理员模式）导入物流单详情返回前端参数："+retJson.toString());
	        return retJson.toString();
	 }
}
