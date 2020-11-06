package other.honghe.com;

import java.io.IOException;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import com.rkhd.platform.sdk.ScriptTrigger;
import com.rkhd.platform.sdk.exception.ScriptBusinessException;
import com.rkhd.platform.sdk.http.RkhdHttpClient;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.DataModel;
import com.rkhd.platform.sdk.param.ScriptTriggerParam;
import com.rkhd.platform.sdk.param.ScriptTriggerResult;


/**
 * 商机赢率到达50%及以上时，需要检查是否维护商机明细，没有维护不允许升迁
 * @author cx
 *
 */
public class OpportunityUpdateBeforeTrigger implements ScriptTrigger{
	private static final Logger logger = LoggerFactory.getLogger();

	@Override
	public ScriptTriggerResult execute(ScriptTriggerParam param) throws ScriptBusinessException {
		if(param==null){
			logger.error("=========数据模型内容为空");
			return null;
		}
		List<DataModel> modelList = param.getDataModelList();
		if(modelList!=null && modelList.size()>0){
			RkhdHttpClient rkhdHttpClient = null;
			try{
				rkhdHttpClient = RkhdHttpClient.instance();
			}catch(IOException e){
				logger.error("创建调用销售易接口链接失败：" + e);
				return null;
			}
			logger.info("param:"+param);
			DataModel dataModel = modelList.get(0);
			Long id = dataModel.getLong("id");//ID
			Long winRate = dataModel.getLong("winRate");//赢单率
			String sql_win="select id,winRate from opportunity where id='"+id+"'";
			JSONArray array_win = PaasUtils.doQueryAll(rkhdHttpClient, sql_win, "V2");
			if(array_win.size()>0) {
				logger.info("当前销售机会原来的赢率是="+array_win.toString());
				Long old_winRate=array_win.getJSONObject(0).getLong("winRate");
				
				if(old_winRate != null && old_winRate>=100) {
					Integer TBJG__c = dataModel.getInteger("TBJG__c");//投标结果
					if(TBJG__c != null) {
						//查询是否有中标代理上[合作伙伴customEntity9__c]
						String sql_Entity9="select id,XSJH__c,SFZB__c from customEntity9__c where XSJH__c='"+id+"'";
						JSONArray array_Entity9 = PaasUtils.doQueryAll(rkhdHttpClient, sql_Entity9, "V2");
						if(array_Entity9.size()>0) {
							logger.info("[合作伙伴]对象的“是否中标”字段有值2="+array_Entity9.toString());
							Integer SFZB__c = array_Entity9.getJSONObject(0).getInteger("SFZB__c");//是否中标1--是
							if(SFZB__c != null) {
								logger.info("[合作伙伴]对象的“是否中标”字段有值SFZB__c="+SFZB__c);
							}else {
								logger.info("[合作伙伴]对象的“是否中标”字段没有值");
								throw new ScriptBusinessException("设置赢单前请先维护中标代理商及投标结果!");
							}
						}else {
							logger.info("[合作伙伴]对象的“是否中标”字段没有值="+array_Entity9.toString());
							throw new ScriptBusinessException("设置赢单前请先维护中标代理商及投标结果!");
						}
					}else {
						logger.info("投标结果为空!");
						throw new ScriptBusinessException("设置赢单前请先维护中标代理商及投标结果!");
					}
					
				}else if(old_winRate != null && old_winRate>=50) {
					Long saleStageId = dataModel.getLong("saleStageId");//销售阶段
					String sql ="select id,opportunityId from opportunityProduct where opportunityId='"+id+"'";
					JSONArray array = PaasUtils.doQueryAll(rkhdHttpClient, sql, "V2");
					logger.info("saleStageId"+saleStageId);
					if(array.size()>0) {//当前销售机会有商机明细
						logger.info("当前销售机会是有商机明细1="+array.toString());
						
					}else {
						logger.info("当前销售机会是是否有商机明细2="+array.toString());
						throw new ScriptBusinessException("赢率超过50%， 请维护商机明细！");
					}
				}else {
					logger.info("赢率为:"+winRate+",不触发代码!!");
				}
			}
		}
		return new ScriptTriggerResult(param.getDataModelList());
	}
}


