package other.logistics.manager;

import java.util.Arrays;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.User;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.QueryResult;
import com.rkhd.platform.sdk.service.XObjectService;

public class PaasUtils {

	private static final Logger logger = LoggerFactory.getLogger();
	public static final List<String> arr =  Arrays.asList("A", "B", "C");

	public static String queryCodeByUserId(String userId) {
		String sql ="select employeeCode from user where id = '"+userId+"'"; 
    	try {
    		QueryResult<User> result = XObjectService.instance().query(sql);
    		logger.info("查询用户ID返回结果："+JSONObject.toJSONString(result));
    		if(result.getSuccess()){
    			List<User> records = result.getRecords();
    			return records.get(0).getEmployeeCode();
    		}
    	} catch (ApiEntityServiceException e) {
    		logger.error("查询用户id失败： "+e.getMessage());
    		e.printStackTrace();
    	}
    	return null;
	}
}
