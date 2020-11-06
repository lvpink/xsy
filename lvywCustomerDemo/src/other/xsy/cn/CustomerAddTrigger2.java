package other.xsy.cn;

import java.util.List;

import com.rkhd.platform.sdk.ScriptTrigger;
import com.rkhd.platform.sdk.exception.ScriptBusinessException;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.DataModel;
import com.rkhd.platform.sdk.param.ScriptTriggerParam;
import com.rkhd.platform.sdk.param.ScriptTriggerResult;

public class CustomerAddTrigger2 implements ScriptTrigger {
	private static final Logger logger = LoggerFactory.getLogger();
//	The return object is not ScriptTriggerResult, please check your trigger
	@Override
	public ScriptTriggerResult execute(ScriptTriggerParam arg0) throws ScriptBusinessException {
		// TODO Auto-generated method stub
		if(arg0!=null){
			List<DataModel> modelList = arg0.getDataModelList();
			logger.info("客户机和容量： "+modelList.size());
			for (DataModel dataModel : modelList) {
				Object comment = dataModel.getAttribute("comment");
				if(comment.equals("add")){
					logger.error("输入参数add非法，请修改");
					throw new ScriptBusinessException("输入参数add非法，请修改");
				}else{
					return new ScriptTriggerResult(arg0.getDataModelList());
				}
			}
		}else{
			logger.error("获取入口参数失败");
			throw new ScriptBusinessException("获取入口参数失败");
		}
		return null;
	}

}
