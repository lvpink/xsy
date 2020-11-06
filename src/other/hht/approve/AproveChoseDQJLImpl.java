package other.hht.approve;

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
		//1.根据dataId（授权申请id） 在 AuthorApply__c 表，查询授权数据的的销售员 XSY__c
		Long xsy__c = PassUtils.getXSYByApproveId(request.getDataId());
		if(null==xsy__c){
			response.setSuccess(false);
			response.setMsg("销售员ID不存在。");
			logger.error("销售员ID不存在。");
			return response;
		}
		//2.根据销售员ID，在用户表，查询大区经理DQJLYGBH__c 编码
		User user = PassUtils.getUserByXsy(xsy__c);
		String dqjlygbh__c = user.getDQJLYGBH__c();
		if(null==user||dqjlygbh__c==null||dqjlygbh__c.equals("")){
			response.setSuccess(false);
			response.setMsg("大区经理不存在。");
			logger.error("大区经理不存在。");
			return response;
		}
		//3.根据用户编码查询用户ID
		Long userId = PassUtils.getUserIdByCode(dqjlygbh__c);
		if(null==userId){
			response.setSuccess(false);
			response.setMsg("大区经理用户不存在。");
			logger.error("大区经理用户不存在。");
			return response;
		}
		List<Long> userIds=new ArrayList<Long>();
		userIds.add(userId);
		response.setData(userIds);
		response.setSuccess(true);
		response.setMsg("success");
		return response;
	}
//	审批动态选人:AproveChoseDS->start{"dataId":1459634304385695,"entityApiKey":"authorApply__c",
//	"procdefId":1463984600957690,"taskDefKey":"n-5320-eghb","taskDefName":"授权申请1"}
}
