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
 * 物流单查询 --Q查询; G货品清单; L货品清单;W相关物流单
 * @author XSY
 */
public class LogisticWServiceL implements ApiSupport{
	private static final Logger logger = LoggerFactory.getLogger();
	
	@Override
	public String execute(Request paramRequest, Long paramLong1, Long paramLong2) {
		logger.info("查询货品清单信息-->start");
		logger.info(JSONObject.toJSONString(paramRequest));
		String wsResult = webservice(paramRequest);
		logger.info("查询货品清单信息："+wsResult);
		
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
	    	logger.info("查询查询货品清单上送参数：vbelnVl->"+vbelnVl+",zcrmVbelnJh->"+zcrmVbelnJh);
	    	ZFMCRMLGCSP_Service zfmcrmlgcsp_Service = new ZFMCRMLGCSP_Service();
	    	ZFMCRMLGCSP port = zfmcrmlgcsp_Service.getBinding();
	    	BindingProvider bp = (BindingProvider) port;
	        Map<String, Object> context = bp.getRequestContext();
	        context.put(BindingProvider.USERNAME_PROPERTY, Constants.USERNAME);
	        context.put(BindingProvider.PASSWORD_PROPERTY, Constants.PASSWORD);
	        String iFlag = "L";
	        ZcrmOutpo3T zcrmOutpo3T = new ZcrmOutpo3T();
	        Holder<ZcrmOutpo3T> etOutpo3 = new Holder<ZcrmOutpo3T>(zcrmOutpo3T);
	        
	         ZcrmOutpi2S zcrmOutpi2S = new ZcrmOutpi2S();
	         zcrmOutpi2S.setVbelnVl(vbelnVl);
	         zcrmOutpi2S.setZcrmVbelnJh(zcrmVbelnJh);
	        
			ZcrmOutpi3T itGoods = new ZcrmOutpi3T();
			itGoods.getItem().add(zcrmOutpi2S);
			logger.info("上送ws参数："+JSONObject.toJSONString(itGoods));
			//执行webservice 方法
			port.zfmCrmLgcsP(iFlag, null, itGoods, null, null, null, null, etOutpo3, null);
			//获取返回值
	       List<ZcrmOutpo3S> item = etOutpo3.value.getItem();
	       	retJson.put("data", JSONArray.parseArray(JSONObject.toJSONString(item)));
	        retJson.put("msg", "查询货品清单成功");
	        retJson.put("code", 0);
	        return retJson.toString();
	 }
}
