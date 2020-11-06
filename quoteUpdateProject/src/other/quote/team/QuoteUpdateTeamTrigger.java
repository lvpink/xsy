package other.quote.team;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.User;
import com.rkhd.platform.sdk.exception.ScriptBusinessException;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.XObject;
import com.rkhd.platform.sdk.trigger.DataResult;
import com.rkhd.platform.sdk.trigger.Trigger;
import com.rkhd.platform.sdk.trigger.TriggerRequest;
import com.rkhd.platform.sdk.trigger.TriggerResponse;

/**
 * 报价更新时，增加团队成员
 * @author XSY
 *
 */
public class QuoteUpdateTeamTrigger implements Trigger {
	private static final Logger logger = LoggerFactory.getLogger();

	@Override
	public TriggerResponse execute(TriggerRequest request) throws ScriptBusinessException {
		  logger.info("--------QuoteUpdateTeamTrigger start-------");
		  	//获取请求参数
	        List<XObject> quoteObj = request.getDataList();
	        logger.info("报价保存添加团队成员arg0:"+JSONObject.toJSONString(quoteObj));
	        //构建返回数据
	        List<DataResult> dataResults = new ArrayList<DataResult>();
	        DataResult dataResult = new DataResult();
	        dataResult.setSuccess(false);
  			dataResult.setxObject(quoteObj.get(0));
  			dataResults.add(dataResult);
	          
	        if (quoteObj != null && quoteObj.size() > 0) {
	        	XObject xObject = quoteObj.get(0);
	        	dataResult.setSuccess(false);
	  			dataResult.setxObject(xObject);
	  			dataResults.add(dataResult);
  			
	        	Long ownerId = xObject.getAttribute("ownerId");
	        	Long recordId = xObject.getAttribute("id");
	        	logger.info("报价所有人ID："+ownerId+", 报价数据id:"+recordId);
	      		//2.1,根据报价ownerid 在用户表查询 对应的字段，事业部商务、大区经理、事业部经理，
	      		//事业部商务SYBSWYGBH__c、大区经理DQJLYGBH__c、事业部经理SYBZJLYGBH__c
	      		User user = PassUtils.queryUserByOwner(ownerId);
	      		logger.info("根据ownerID查询到的user:"+JSONObject.toJSONString(user));
	      		String sybswygbh__c = user.getSYBSWYGBH__c();//事业部商务用户编码
	      		logger.info("事业部商务用户编码："+user.getSYBSWYGBH__c()+",大区经理用户编码："+user.getDQJLYGBH__c()+",事业部经理用户编码："+user.getSYBZJLYGBH__c());
	      		if(null==sybswygbh__c){
	      			dataResult.setMsg("事业部商务用户用户编码不存在");
	      			return new TriggerResponse(false,null,dataResults);
	      		}
	      		String dqjlygbh__c = user.getDQJLYGBH__c();//大区经理用户编码
	      		if(null==dqjlygbh__c){
	      			dataResult.setMsg("大区经理用户编码不存在");
	      			return new TriggerResponse(false,null,dataResults);
	      		}
	      		String sybzjlygbh__c = user.getSYBZJLYGBH__c();//事业部经理用户编码
	      		if(null==sybzjlygbh__c){
	      			dataResult.setMsg("事业部经理用户编码不存在");
	      			return new TriggerResponse(false,null,dataResults);
	      		}
	      		//根据员工编码查询 用户id
	      		//获取用户id
	      		Long sybswygbhId = PassUtils.queryUserIdBycode(sybswygbh__c);
	      		if(null==sybswygbhId){
	      			dataResult.setMsg("事业部商务用户id不存在");
	      			return new TriggerResponse(false,null,dataResults);
	      		}
	      		Long dqjlygbhId = PassUtils.queryUserIdBycode(dqjlygbh__c);
	      		if(null==dqjlygbhId){
	      			dataResult.setMsg("大区经理用户id不存在");
	      			return new TriggerResponse(false,null,dataResults);
	      		}
	      		Long sybzjlygbhId = PassUtils.queryUserIdBycode(sybzjlygbh__c);
	      		if(null==sybzjlygbhId){
	      			dataResult.setMsg("事业部经理用户id不存在");
	      			return new TriggerResponse(false,null,dataResults);
	      		}
	      		//查询实体ID
	      		Long recordFrom = PassUtils.queryBelongId("quote");
	      		logger.info("报价实体ID："+recordFrom);
	      		
	      		//新建团队成员
	      		boolean sybswFlag = PassUtils.addTeamUser(sybswygbhId,1,recordFrom,recordId); //商务部经理
	      		if(!sybswFlag){
	      			dataResult.setMsg("商务部经理 --新增团队成员失败");
	      			return new TriggerResponse(false,null,dataResults);
	      		}
	      		boolean dajlFlag = PassUtils.addTeamUser(dqjlygbhId,1,recordFrom,recordId); //大区经理
	      		if(!dajlFlag){
	      			dataResult.setMsg("大区经理 --新增团队成员失败");
	      			return new TriggerResponse(false,null,dataResults);
	      		}
	      		boolean sybjlFlag = PassUtils.addTeamUser(sybzjlygbhId,1,recordFrom,recordId); //事业部经理
	      		if(!sybjlFlag){
	      			dataResult.setMsg("事业部经理 --新增团队成员失败");
	      			return new TriggerResponse(false,null,dataResults);
	      		}
	      		dataResult.setMsg("新增团队成员成功");
	  			dataResult.setSuccess(true);
	        }
	     return new TriggerResponse(false,null,dataResults);
	}
}