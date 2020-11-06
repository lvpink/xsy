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
 * 审批流动态选人--事业部总经理
 * @author XSY
 *
 */
public class AproveChoseSYBZJLImpl implements ApprovalChooser{

	private static final Logger logger = LoggerFactory.getLogger();
	@Override
	public ApprovalChooserResponse execute(ApprovalChooserRequest request) throws ScriptBusinessException {
		 logger.info("----事业部总经理----AproveChoseSYBZJLImpl start-------");
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
			String sybzjlygbh__c = user.getSYBZJLYGBH__c();
			if(null==user||null==sybzjlygbh__c||sybzjlygbh__c.equals("")){
				response.setSuccess(false);
				response.setMsg("事业部总经理编号不存在。");
				logger.error("事业部总经理编号不存在。");
				return response;
			}
			//3.根据用户编号，查询用户id
			Long sybzjlygbhId = PassUtils.getUserIdByCode(sybzjlygbh__c);
			if(null==sybzjlygbhId){
				response.setSuccess(false);
				response.setMsg("事业部总经理用户id不存在。");
				logger.error("事业部总经理用户id不存在。");
				return response;
			}
			List<Long> userIds=new ArrayList<Long>();
			userIds.add(sybzjlygbhId);
			response.setData(userIds);
			response.setSuccess(true);
			response.setMsg("success");
			return response;
		}
}
