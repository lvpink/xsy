package other.xsy.cn;

import java.util.List;

import com.rkhd.platform.sdk.ScriptTrigger;
import com.rkhd.platform.sdk.exception.ScriptBusinessException;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.DataModel;
import com.rkhd.platform.sdk.param.ScriptTriggerParam;
import com.rkhd.platform.sdk.param.ScriptTriggerResult;

public class CustomerAddTrigger implements ScriptTrigger {
	private static final Logger logger = LoggerFactory.getLogger();
//	The return object is not ScriptTriggerResult, please check your trigger
	@Override
	public ScriptTriggerResult execute(ScriptTriggerParam arg0) throws ScriptBusinessException {
		// TODO Auto-generated method stub
		try {
			List<DataModel> modelList = arg0.getDataModelList();
			logger.info("客户集合大小： "+modelList.size());
			if(null!=modelList&&modelList.size()>0){
				for (DataModel dataModel : modelList) {
					String comment = dataModel.getAttribute("comment").toString();
					if(comment.contains("add")||comment.contains("delete")){
						logger.error("新建客户失败：包含非法字符add或delete");
						throw new ScriptBusinessException("新建客户失败：包含非法字符add或delete");
					}else{
						return new ScriptTriggerResult(arg0.getDataModelList());
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("获取入口参数失败");
		}
		return null;
	}

}
