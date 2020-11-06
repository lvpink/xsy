package other.quote.approve;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.creekflow.approvalchooser.ApprovalChooser;
import com.rkhd.platform.sdk.creekflow.approvalchooser.ApprovalChooserRequest;
import com.rkhd.platform.sdk.creekflow.approvalchooser.ApprovalChooserResponse;
import com.rkhd.platform.sdk.data.model.User;
import com.rkhd.platform.sdk.exception.ScriptBusinessException;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
/**
 * 审批流动态选人--大区经理
 * @author XSY
 *
 */
public class AproveChoseDQJLImpl implements ApprovalChooser{

	private static final Logger logger = LoggerFactory.getLogger();
	@Override
	public ApprovalChooserResponse execute(ApprovalChooserRequest request) throws ScriptBusinessException {
		 logger.info("----大区经理----AproveChoseDQJLImpl start-------");
		 logger.info("上送参数："+JSONObject.toJSONString(request));
		//构建返回数据
		ApprovalChooserResponse response=new ApprovalChooserResponse();
		 if(null==request){
			response.setSuccess(false);
			response.setMsg("上送参数不存在");
			logger.error("上送参数不存在");
			return response;
		}
		//1.根据dataId（报价单id） 在 quote 表，查询ownerID
		Long ownerId = PassUtils.getOwnerByApproveId(request.getDataId());
		if(null==ownerId){
			response.setSuccess(false);
			response.setMsg("报价单所有人ID不存在。");
			logger.error("报价单所有人ID不存在。");
			return response;
		}
		//2.所有人ownerId在用户表，查询对应的大区经理DQJLYGBH__c
		User user = PassUtils.getCodeByOwner(ownerId);
		String dqjlygbh__c = user.getDQJLYGBH__c();
		if(null==user||null==dqjlygbh__c||dqjlygbh__c.equals("")){
			response.setSuccess(false);
			response.setMsg("大区经理编号不存在。");
			logger.error("大区经理编号不存在。");
			return response;
		}
		//3.根据用户编号，查询用户id
		Long dqjlygbhId = PassUtils.getUserIdByCode(dqjlygbh__c);
		if(null==dqjlygbhId){
			response.setSuccess(false);
			response.setMsg("大区经理用户id不存在。");
			logger.error("大区经理用户id不存在。");
			return response;
		}
		List<Long> userIds=new ArrayList<Long>();
		userIds.add(dqjlygbhId);
		response.setData(userIds);
		response.setSuccess(true);
		response.setMsg("success");
		return response;
	}
	
}
