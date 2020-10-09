package other.xsy.sample;

import com.rkhd.platform.sdk.ScriptTrigger;
import com.rkhd.platform.sdk.exception.ScriptBusinessException;
import com.rkhd.platform.sdk.param.ScriptTriggerParam;
import com.rkhd.platform.sdk.param.ScriptTriggerResult;

public class ScriptTriggerImpl implements ScriptTrigger {

	@Override
	public ScriptTriggerResult execute(ScriptTriggerParam arg0) throws ScriptBusinessException {
		// TODO Auto-generated method stub
		System.out.println("HELLO SXY !");
		return null;
	}

}
