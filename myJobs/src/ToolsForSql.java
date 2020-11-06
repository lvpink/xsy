import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.User;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.QueryResult;
import com.rkhd.platform.sdk.model.XObject;
import com.rkhd.platform.sdk.service.XObjectService;

public class ToolsForSql {
	private static final Logger logger = LoggerFactory.getLogger();
	public static void main(String[] args) {
		String sql = "select id,employeeCode from user where employeeCode = 8004602";
		try {
			QueryResult<User> qResult = XObjectService.instance().query(sql);
			String jsonResult = JSONObject.toJSONString(qResult);
			logger.info("查询返回结果："+jsonResult);
		} catch (ApiEntityServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}



