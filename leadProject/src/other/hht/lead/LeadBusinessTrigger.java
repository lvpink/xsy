package other.hht.lead;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rkhd.platform.sdk.data.model.Lead;
import com.rkhd.platform.sdk.exception.ScriptBusinessException;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.XObject;
import com.rkhd.platform.sdk.trigger.DataResult;
import com.rkhd.platform.sdk.trigger.Trigger;
import com.rkhd.platform.sdk.trigger.TriggerRequest;
import com.rkhd.platform.sdk.trigger.TriggerResponse;
/**
 * 
 * @author XSY
 *
 */
public class LeadBusinessTrigger implements Trigger {
	private static final Logger logger = LoggerFactory.getLogger();

	@Override
	public TriggerResponse execute(TriggerRequest request) throws ScriptBusinessException {
		logger.info("-----触发线索-----");
//		在线索创建和修改时 （lead >> add or update >>after)  保存业务类型到 自定义字段 类型 BType__c
		//入参
		List<XObject> dataList = request.getDataList();
		//返回数据
		List<DataResult> dataResults = new ArrayList<DataResult>();
		DataResult dataResult = new DataResult();
		
		//获取业务类型
//		Long entityTypeId = PassUtils.getEntityTypeId("lead");
//		logger.info("线索业务类型->"+entityTypeId);
		if(null!=dataList&&dataList.size()==1){
			XObject xObject = dataList.get(0);
			Long id = xObject.getAttribute("id");
			Long entityType = xObject.getAttribute("entityType");
			Lead lead = new Lead();
			Map<Long, String> map = PassUtils.getAllEntityTypeId();
			String des = map.get(entityType);
			logger.info("业务类型："+des);
			if(null!=des){
				lead.setId(id);
				if(des.contains("教育")){
					lead.setBType__c(1);
				}else if(des.contains("教育")){
					lead.setBType__c(2);
				}else{
					//无操作
				}
				boolean flag = PassUtils.updateTypeByID(lead);
				if(flag){
					logger.info("-----修改线索类型成功-----");
					dataResult.setSuccess(true);
					dataResult.setMsg("修改线索类型成功");
					dataResult.setxObject(xObject);
					dataResults.add(dataResult);
					return new TriggerResponse(true,null,dataResults);
				}
				
				logger.info("-----修改线索类型失败-----");
				dataResult.setSuccess(false);
				dataResult.setMsg("修改线索类型失败");
				dataResult.setxObject(xObject);
				dataResults.add(dataResult);
				return new TriggerResponse(false,null,dataResults);
			}
		}
		logger.info("-----无需修改线索类型-----");
		dataResult.setSuccess(true);
		dataResult.setMsg("无需修改线索类型。");
		dataResult.setxObject(dataList.get(0));
		dataResults.add(dataResult);
		return new TriggerResponse(true,null,dataResults);
	}
}
