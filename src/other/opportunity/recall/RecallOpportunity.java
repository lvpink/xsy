package other.opportunity.recall;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.ScheduleJob;
import com.rkhd.platform.sdk.data.model.Opportunity;
import com.rkhd.platform.sdk.data.model.User;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.http.RkhdHttpClient;
import com.rkhd.platform.sdk.http.RkhdHttpData;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.QueryResult;
import com.rkhd.platform.sdk.param.ScheduleJobParam;
import com.rkhd.platform.sdk.service.XObjectService;
import org.apache.commons.collections.CollectionUtils;

import java.io.IOException;
import java.util.Calendar;

public class RecallOpportunity implements ScheduleJob{
    private Logger logger = LoggerFactory.getLogger();

    @Override
    public void execute(ScheduleJobParam scheduleJobParam) {
        XObjectService xObjectService=XObjectService.instance();
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.YEAR,-1);
        Long createDateLong=calendar.getTimeInMillis();
        calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-7);
//        calendar.add(Calendar.DAY_OF_MONTH,2);
        Long lastUpdateDateLong=calendar.getTimeInMillis();
        String sql="select id,opportunityName,ownerId from Opportunity where status=1 and createdAt>"+createDateLong+" and updatedAt<"+lastUpdateDateLong;
        logger.info("查询待唤醒记录:"+sql);
        try {
           QueryResult<Opportunity> recallCallResult=xObjectService.query(sql,true);
           if(recallCallResult.getSuccess()){
        	   if(recallCallResult.getRecords().size()>0){
        		   logger.info("待唤醒记录个数:"+recallCallResult.getRecords().size());
        		   recallCallResult.getRecords().stream().forEach(opportunity -> {
        			   try {
        				   doRecall(opportunity.getOpportunityName(),opportunity.getOwnerId(),scheduleJobParam.getUserId());
        				   Long manageId=queryManagerId(opportunity.getOwnerId());
        				   if(manageId!=null){
        					   doRecall(opportunity.getOpportunityName(),manageId,scheduleJobParam.getUserId());
        				   }
        			   } catch (Exception e) {
        				   logger.error("推送通知失败："+e.getMessage(),e);
        			   }
        		   });
        	   }else{
        		   logger.info("无待唤醒商机");
        	   }
           }
        } catch (ApiEntityServiceException e) {
            logger.error("查询待唤醒商机失败："+e.getMessage(),e);
        }
    }

    private void  doRecall(String name,Long targetId,Long currentUser) throws IOException {
        logger.info("推送:"+name+targetId+":"+currentUser);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("sourceUserId",currentUser);
        jsonObject.put("targetUserId",targetId);
        jsonObject.put("content","请及时跟进商机--"+name);
        RkhdHttpClient rkhdHttpClient=RkhdHttpClient.instance();
        RkhdHttpData rkhdHttpData= RkhdHttpData.newBuilder().build();
        rkhdHttpData.setCall_type("POST");
        rkhdHttpData.setBody(jsonObject.toJSONString());
        rkhdHttpData.setCallString("/data/v1/notice/notify/send");
        rkhdHttpClient.performRequest(rkhdHttpData);
    }
    private Long queryManagerId(Long userId){
        Long managId=null;
        String sql="select id,managerId from user where id="+userId;
        logger.info("查询managId:"+sql);
       XObjectService xObjectService=XObjectService.instance();
        try {
           QueryResult<User> queryResult=xObjectService.query(sql,true);
           if(queryResult.getSuccess()&& CollectionUtils.isNotEmpty(queryResult.getRecords())){
               managId=queryResult.getRecords().get(0).getManagerId();
           }else{
               logger.info("没有上级");
           }
        } catch (ApiEntityServiceException e) {
            logger.error("查询用户信息发生异常"+e.getMessage(),e);
        }
        return  managId;
    }
}