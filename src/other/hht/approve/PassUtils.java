package other.hht.approve;

import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.AuthorApply__c;
import com.rkhd.platform.sdk.data.model.User;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.QueryResult;
import com.rkhd.platform.sdk.service.XObjectService;

public class PassUtils {
	private static final Logger logger = LoggerFactory.getLogger();

	 /**
	  * 根据授权审批id查询XYS
	  * @param dataId 授权申请ID
	  * @return
	  */
	public static Long getXSYByApproveId(Long dataId){
    	String sql ="select XSY__c from authorApply__c where id = '"+dataId+"'";  
    	try {
			QueryResult<AuthorApply__c> result = XObjectService.instance().query(sql);
			logger.info("授权申请->查询销售员返回结果："+JSONObject.toJSONString(result));
			if(result.getSuccess()){
				List<AuthorApply__c> records = result.getRecords();
				Long xsy__c = records.get(0).getXSY__c();
				return xsy__c;
			}
		} catch (ApiEntityServiceException e) {
			logger.error("销售员ID，查询失败： "+e.getMessage());
			e.printStackTrace();
		}
    	return null;
    }
    /**
     * 根据销售员查询用户
     * @param xsy__c 销售员（用户id）
     * @return
     */
    public static User getUserByXsy(Long xsy__c){
    	String sql ="select id,DQJLYGBH__c,SYBSWYGBH__c,managerId from user where id = '"+xsy__c+"'";  
    	try {
			QueryResult<User> result = XObjectService.instance().query(sql);
			logger.info("授权申请->查询用户返回结果："+JSONObject.toJSONString(result));
			if(result.getSuccess()){
				List<User> records = result.getRecords();
				return records.get(0);
			}
		} catch (ApiEntityServiceException e) {
			logger.error("查询用户失败： "+e.getMessage());
			e.printStackTrace();
		}
    	return null;
    }
    /**
     * 根据用户编码查询用户id
     * @param code 用户编码
     * @return
     */
    public static Long getUserIdByCode(String code){
    	String sql ="select id from user where employeeCode = '"+code+"'";  
    	try {
    		QueryResult<User> result = XObjectService.instance().query(sql);
    		logger.info("授权申请->查询用户ID返回结果："+JSONObject.toJSONString(result));
    		if(result.getSuccess()){
    			List<User> records = result.getRecords();
    			return records.get(0).getId();
    		}
    	} catch (ApiEntityServiceException e) {
    		logger.error("查询用户编号失败： "+e.getMessage());
    		e.printStackTrace();
    	}
    	return null;
    }
}
