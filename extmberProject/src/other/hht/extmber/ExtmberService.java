package other.hht.extmber;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.api.ApiSupport;
import com.rkhd.platform.sdk.http.Request;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
/**
 * 查询套件信息
 * @author xsy
 *
 */
public class ExtmberService implements ApiSupport {

private static final Logger logger = LoggerFactory.getLogger();


	@Override
	public String execute(Request arg0, Long arg1, Long arg2) {
		logger.info("查询套件产品信息-->start");
		String  req = arg0.getReader().toString();
		JSONObject Jsonreq = JSONObject.parseObject(req);
		logger.info("套件请求参数："+Jsonreq.toString());
		String cpbm_c = Jsonreq.getString("cpbm_c");//产品编码
		String xszz_c = Jsonreq.getString("xszz_c");//销售组织
		String xsfz_c = Jsonreq.getString("xsfz_c");//销售分支
	    logger.info("产品编码：->"+xszz_c+"销售组织：->"+cpbm_c+"销售分支：->"+xsfz_c);
		 /**构建返回数据*/
	   JSONObject result = new JSONObject();
       if (cpbm_c == null || "".equals(cpbm_c)) {
       	result.put("status", -1);
   		result.put("msg", "产品编码为空");
   		return result.toString();
       }
       if (xszz_c == null || "".equals(xszz_c)) {
       	result.put("status", -1);
       	result.put("msg", "销售组织为空");
       	return result.toString();
       }
       if (xsfz_c == null || "".equals(xsfz_c)) {
       	result.put("status", -1);
       	result.put("msg", "销售分支为空");
       	return result.toString();
       }
    	String wsRes = ExtmberWSImpl.webservice(cpbm_c,xszz_c,xsfz_c);
    	logger.info("查询套件信息-->完成||msg->"+JSONObject.parseObject(wsRes).getString("msg"));
		return wsRes.toString();
	}

}
