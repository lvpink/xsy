package other.hht.member;

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

public class AuthorUpdateAfterTrigger implements Trigger{
	private static final Logger logger = LoggerFactory.getLogger();

	@Override
	public TriggerResponse execute(TriggerRequest request) throws ScriptBusinessException {
		  logger.info("--------AuthorUpdateAfterTrigger start-------");
		  	//获取请求参数
	        List<XObject> authorApply = request.getDataList();
	        logger.info("授权申请添加团队成员arg0:"+JSONObject.toJSONString(authorApply));
	        //构建返回数据
	        List<DataResult> dataResults = new ArrayList<DataResult>();
	        DataResult dataResult = new DataResult();
	        
	        if (authorApply != null && authorApply.size() > 0) {
	        	XObject xObject = authorApply.get(0);
	        	
	        	dataResult.setSuccess(false);
    			dataResult.setxObject(xObject);
    			dataResults.add(dataResult);
    			
	        	Long xsy_c = xObject.getAttribute("XSY__c");
	        	Long recordId = xObject.getAttribute("id");
	        	logger.info("实体数据ID："+recordId+",销售员ID："+xsy_c);
        		//2.1,根据授权申请销售员 在用户表查询 对应的字段，销售员，事业部商务、大区经理、事业部经理
        		//事业部商务SYBSWYGBH__c、大区经理DQJLYGBH__c、事业部经理SYBZJLYGBH__c
        		User user = PassUtils.queryUserByXSY(xsy_c);
        		String sybswygbh__c = user.getSYBSWYGBH__c();//事业部商务用户编码
        		String dqjlygbh__c = user.getDQJLYGBH__c();//大区经理用户编码
        		String sybzjlygbh__c = user.getSYBZJLYGBH__c();//事业部经理用户编码
        		//根据员工编码查询 用户id
        		logger.info("事业部商务用户编码："+sybswygbh__c+",大区经理用户编码："+dqjlygbh__c+",事业部经理："+sybzjlygbh__c);
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
	        		/*{
	        	    "data": {
	        	        "recordFrom_data": 1460190026433167, ---授权申请中的数据  id
	        	        "ownerFlag": 1,
	        	        "recordFrom": 1451600179806957, ---对象 id
	        	        "userId": 1453000750105323 ---授权申请中的   XSY__c
	        	    }
	        	}*/
        		//查询实体ID
        		Long recordFrom = PassUtils.queryBelongId("authorApply__c");
        		
        		//新建团队成员
        		boolean xsyFlag = PassUtils.addTeamUser(xsy_c,1,recordFrom,recordId);//销售员 
        		if(!xsyFlag){
        			dataResult.setMsg("销售员 --新增团队成员失败");
        			return new TriggerResponse(false,null,dataResults);
        		}
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
	        return new TriggerResponse(true,null,dataResults);
	}
}
