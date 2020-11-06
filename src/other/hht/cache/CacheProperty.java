package other.hht.cache;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.api.ApiSupport;
import com.rkhd.platform.sdk.exception.CacheException;
import com.rkhd.platform.sdk.http.Request;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.service.CacheService;

public class CacheProperty implements ApiSupport{
	private static final Logger logger = LoggerFactory.getLogger();


	/*1 保存数据接口，参数 userid，cachetype，value ，后端生成唯一缓存id，缓存id=userid+cachetype+时间戳 ，
	把value（json格式 字符串）进行缓存，保存成功后返回唯一id，*/
	@Override
	public String execute(Request arg0, Long arg1, Long arg2) {
		logger.info("缓存属性-->start");
		logger.info(JSONObject.toJSONString(arg0));
		JSONObject retJson = new JSONObject();
		JSONObject idJson = new JSONObject();
		retJson.put("msg", "设置缓存失败");
		retJson.put("code", -1);
		String  req = arg0.getReader().toString();
		JSONObject Jsonreq = JSONObject.parseObject(req);
		if(null==Jsonreq||Jsonreq.toString().equals("")){
			retJson.put("msg", "上送参数为空");
			return retJson.toString();
		}
		
		logger.info("缓存属性上送参数："+Jsonreq.toString());
		String userid = Jsonreq.getString("userid");
		if(null==userid||userid.equals("")){
			retJson.put("msg", "userid不存在");
			return retJson.toString();
		}
		String cachetype = Jsonreq.getString("cachetype");
		if(null==cachetype||cachetype.equals("")){
			retJson.put("msg", "cachetype不存在");
			return retJson.toString();
		}
		String value = Jsonreq.getString("value");
		if(null==value||value.equals("")){
			retJson.put("msg", "value不存在");
			return retJson.toString();
		}
		String id = userid+cachetype;
//		+System.currentTimeMillis()
		try {
			Boolean flag = CacheService.instance().set(id, value);
			logger.info("第一次设置标识："+flag);
			if(flag){
				if(null!= CacheService.instance().get(id)){
					Boolean flag2 = CacheService.instance().set(id, value);
					logger.info("第二次设置标识："+flag2);
	            	if(flag2){
	            		idJson.put("id", id);
	    				retJson.put("code", 0);
	    				retJson.put("msg", "设置缓存成功");
	            	}
	            }
			}
		} catch (CacheException e) {
			 logger.error("设置属性缓存出错，"+e.getMessage());
		}
		
		retJson.put("data", idJson);
		logger.info("设置缓存返回结果:"+retJson.toString());
		return retJson.toString();
	}

}
