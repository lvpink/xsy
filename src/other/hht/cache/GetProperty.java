package other.hht.cache;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.api.ApiSupport;
import com.rkhd.platform.sdk.exception.CacheException;
import com.rkhd.platform.sdk.http.Request;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.service.CacheService;

public class GetProperty implements ApiSupport{
	private static final Logger logger = LoggerFactory.getLogger();

	/*2 获取数据接口， 参数 ：缓存id ，返回保存的value给前端*/
	@Override
	public String execute(Request arg0, Long arg1, Long arg2) {
		logger.info("获取缓存属性-->start");
		logger.info(JSONObject.toJSONString(arg0));
		JSONObject retJson = new JSONObject();
		JSONObject idJson = new JSONObject();
		retJson.put("msg", "获取缓存失败");
		retJson.put("code", -1);
		
		String  req = arg0.getReader().toString();
		JSONObject Jsonreq = JSONObject.parseObject(req);
		if(null==Jsonreq||Jsonreq.toString().equals("")){
			retJson.put("msg", "上送参数为空");
			return retJson.toString();
		}
		
		logger.info("获取缓存属性上送参数："+Jsonreq.toString());
		
		String id = Jsonreq.getString("id");
		if(null==id||id.equals("")){
			retJson.put("msg", "id不存在");
			return retJson.toString();
		}
		try {
            if(null!= CacheService.instance().get(id)){
            	idJson.put("value", CacheService.instance().get(id));
            	retJson.put("msg", "获取缓存成功");
            	retJson.put("code", 0);
            }
        } catch (CacheException e) {
            logger.error("获取"+id+"缓存出错，"+e.getMessage());
        }
		retJson.put("data", idJson);
		
		logger.info("返回前端数据:"+retJson.toString());
		return retJson.toString();
	}
}
