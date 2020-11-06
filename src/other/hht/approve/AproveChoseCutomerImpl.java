package other.hht.approve;

import java.util.ArrayList;
import java.util.List;
import com.rkhd.platform.sdk.creekflow.approvalchooser.ApprovalChooser;
import com.rkhd.platform.sdk.creekflow.approvalchooser.ApprovalChooserRequest;
import com.rkhd.platform.sdk.creekflow.approvalchooser.ApprovalChooserResponse;
import com.rkhd.platform.sdk.data.model.Account;
import com.rkhd.platform.sdk.data.model.User;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.exception.ScriptBusinessException;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.QueryResult;
import com.rkhd.platform.sdk.service.XObjectService;

public class AproveChoseCutomerImpl implements ApprovalChooser{

	private static final Logger logger = LoggerFactory.getLogger();
	@Override
	public ApprovalChooserResponse execute(ApprovalChooserRequest request) throws ScriptBusinessException {
		// TODO Auto-generated method stub
		if(null==request){
			logger.error("审批流动态选人请求参数不存在。");
			return null;
		}
		logger.info("审批动态选人:AproveChoseDS->start");
		logger.info("ObjectApiKey:"+request.getEntityApiKey()+",客户id:->DataId:"+request.getDataId()+",UserTaskLogId:"+request.getUsertaskLogId());
		//构建返回数据
		ApprovalChooserResponse response=new ApprovalChooserResponse();
		//1.根据dataId（客户id） 在account表，查询审批流客户的所有人ownerId
		Long ownerId = getAccountInfo(request.getDataId());
		if(null==ownerId){
			response.setSuccess(false);
			response.setMsg("客户所有人ID不存在。");
			logger.error("客户所有人ID不存在。");
			return response;
		}
		//2.所有人ownerId在用户表，查询对应的分支商务(用户编号)FZSW__c
		String fzsw__c = getUserFzbm(ownerId);
		if(null==fzsw__c){
			response.setSuccess(false);
			response.setMsg("分支商务不存在。");
			logger.error("分支商务不存在。");
			return response;
		}
		//3.根据分支财商查询用户表的用户编号
		Long userCode = Long.valueOf(getUserCode(fzsw__c));
		if(null==userCode){
			response.setSuccess(false);
			response.setMsg("用户编号不存在。");
			logger.error("用户编号不存在。");
			return response;
		}
		logger.info("response用户编码："+userCode);
		List<Long> userIds=new ArrayList<Long>();
		userIds.add(userCode);
		response.setData(userIds);
		response.setSuccess(true);
		response.setMsg("success");
		return response;
	}
	
	 /*根据客户id查询客户所有人ownerId*/
    private static Long getAccountInfo(Long dataId){
    	String sql ="select id,ownerId,accountName from account where id = '"+dataId+"'";  
    	try {
    		logger.info("ownerID,查询sql : "+sql);
			QueryResult<Account> result = XObjectService.instance().query(sql);
			if(result.getSuccess()){
				List<Account> records = result.getRecords();
				logger.info("查询数据size："+records.size());
				Long ownerId = records.get(0).getOwnerId();
				return ownerId;
			}
		} catch (ApiEntityServiceException e) {
			logger.error("查询客户所有人id失败： "+e.getMessage());
			e.printStackTrace();
		}
    	return null;
    }
    /*根据归属用户id,查询分支财商*/
    private static String getUserFzbm(Long ownerId){
    	String sql ="select id,FZSW__c from user where id = '"+ownerId+"'";  
    	try {
    		logger.info("查询分支财商sql :"+sql);
			QueryResult<User> result = XObjectService.instance().query(sql);
			if(result.getSuccess()){
				List<User> records = result.getRecords();
				logger.info("查询数据size："+records.size());
				String fzsw__c = records.get(0).getFZSW__c();
				return fzsw__c;
			}
		} catch (ApiEntityServiceException e) {
			logger.error("查询分支财商失败： "+e.getMessage());
			e.printStackTrace();
		}
    	return null;
    }
    /*根据分支财商编号查询用户编号*/
    private static String getUserCode(String fzsw__c){
    	String sql ="select id,employeeCode from user where FZSW__c = '"+fzsw__c+"'";  
    	try {
    		logger.info("查询用户编号sql :"+sql);
    		QueryResult<User> result = XObjectService.instance().query(sql);
    		if(result.getSuccess()){
    			List<User> records = result.getRecords();
    			logger.info("查询数据size："+records.size());
    			String employeeCode = records.get(0).getEmployeeCode();
    			return employeeCode;
    		}
    	} catch (ApiEntityServiceException e) {
    		logger.error("查询用户编号失败： "+e.getMessage());
    		e.printStackTrace();
    	}
    	return null;
    }
}
