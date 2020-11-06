package other.hht.logistics;

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
public class LogisticWServiceG implements ApiSupport{
	private static final Logger logger = LoggerFactory.getLogger();
	
	@Override
	public String execute(Request paramRequest, Long paramLong1, Long paramLong2) {
		logger.info("查询订单追踪信息-->start");
		logger.info(JSONObject.toJSONString(paramRequest));
		String wsResult = webservice(paramRequest);
		logger.info("查询订单追踪信息："+wsResult);
		
		return wsResult;
	}

	/**
	 * 查询物流单webService请求接口
	 * @param isHead
	 * @return
	 */
	 public static String webservice(Request paramRequest) {
		 	JSONObject retJson = new JSONObject();
			retJson.put("code", -1);
			
			String  req = paramRequest.getReader().toString();
			logger.info(req);
			JSONObject Jsonreq = JSONObject.parseObject(req);
			if(null==Jsonreq||Jsonreq.toString().equals("")){
				retJson.put("msg", "查询物流单上送参数为空");
				return retJson.toString();
			}
			String vbelnVl = Jsonreq.getString("vbelnVl");
	        if(null==vbelnVl||vbelnVl.equals("")){
				retJson.put("msg", "交货单号不存在");
				return retJson.toString();
			}
			String zcrmVbelnJh = Jsonreq.getString("zcrmVbelnJh");
			 if(null==zcrmVbelnJh||zcrmVbelnJh.equals("")){
				retJson.put("msg", "CRM交货单号不存在");
				return retJson.toString();
			}
	    	logger.info("查询查询订单追踪上送参数：vbelnVl->"+vbelnVl+",zcrmVbelnJh->"+zcrmVbelnJh);
	    	ZFMCRMLGCSP_Service zfmcrmlgcsp_Service = new ZFMCRMLGCSP_Service();
	    	ZFMCRMLGCSP port = zfmcrmlgcsp_Service.getBinding();
	    	BindingProvider bp = (BindingProvider) port;
	        Map<String, Object> context = bp.getRequestContext();
	        context.put(BindingProvider.USERNAME_PROPERTY, Constants.USERNAME);
	        context.put(BindingProvider.PASSWORD_PROPERTY, Constants.PASSWORD);
	        String iFlag = "G";
	        ZcrmOutpo2T zcrmOutpo2T = new ZcrmOutpo2T();
	        Holder<ZcrmOutpo2T> etOutpo2 = new Holder<ZcrmOutpo2T>(zcrmOutpo2T);
	        ZcrmOutpi2S zcrmOutpi2S = new ZcrmOutpi2S();
	        zcrmOutpi2S.setVbelnVl(vbelnVl);
	        zcrmOutpi2S.setZcrmVbelnJh(zcrmVbelnJh);
			ZcrmOutpi2T itGuiji = new ZcrmOutpi2T();
			itGuiji.getItem().add(zcrmOutpi2S);
			logger.info("上送ws参数："+JSONObject.toJSONString(itGuiji));
			//执行webservice 方法
	        port.zfmCrmLgcsP(iFlag, null, null, itGuiji, null, null, etOutpo2, null, null);
	        JSONArray jsonArray = new JSONArray();
			//获取返回值
	       List<ZcrmOutpo2S> item = etOutpo2.value.getItem();
	       for (ZcrmOutpo2S zcrmOutpo2S : item) {
	    	   String outpoStr = JSONObject.toJSONString(zcrmOutpo2S);
	           JSONObject jsonObj = JSONObject.parseObject(outpoStr);
	    	   
	    	   jsonObj.put("datumJp", HhtTools.JavaDateToString(zcrmOutpo2S.getDatumJp()));
	    	   
	    	   jsonObj.put("datumVl", HhtTools.JavaDateToString(zcrmOutpo2S.getDatumVl()));
	    	   
	    	   jsonObj.put("zcrmNewDatum", HhtTools.JavaDateToString(zcrmOutpo2S.getZcrmNewDatum()));
	    	   
	    	   jsonObj.put("zcrmOutbDatum", HhtTools.JavaDateToString(zcrmOutpo2S.getZcrmOutbDatum()));
	    	   
	    	   jsonObj.put("zcrmWldDatum", HhtTools.JavaDateToString(zcrmOutpo2S.getZcrmWldDatum()));
	    	   
	    	   jsonObj.put("uzeitJp", zcrmOutpo2S.getUzeitJp().toString());
	    	   
	    	   jsonObj.put("uzeitVl", zcrmOutpo2S.getUzeitVl().toString());
	    	   
	    	   jsonObj.put("zcrmNewUzeit", zcrmOutpo2S.getZcrmNewUzeit().toString());
	    	   
	    	   jsonObj.put("zcrmOutbUzeit", zcrmOutpo2S.getZcrmOutbUzeit().toString());
	    	   
	    	   jsonObj.put("zcrmWldUzeit", zcrmOutpo2S.getZcrmWldUzeit().toString());
	    	   
	    	   jsonArray.add(jsonObj);
		}
	       	retJson.put("data", jsonArray);
	        retJson.put("msg", "查询订单追踪信息成功");
	        retJson.put("code", 0);
	       return retJson.toString();
	 }
	 
	 public static void main(String[] args) {
		  /*{
			"vbelnVl": "0660094119",
			"zcrmVbelnJh": "D410065526"
		}*/
//		webservice("0660094119","D410065526");
	}
		

}
