package other.hht.bank;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.api.annotations.RequestMethod;
import com.rkhd.platform.sdk.api.annotations.RestApi;
import com.rkhd.platform.sdk.api.annotations.RestBeanParam;
import com.rkhd.platform.sdk.api.annotations.RestMapping;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
/**
 * 手动同步银行信息
 * @author xsy
 *
 */
@RestApi(baseUrl = "/xsy")
public class BankUpdateSync {

private static final Logger logger = LoggerFactory.getLogger();

	
	@RestMapping(value = "updateBankInfo", method = RequestMethod.POST)
	public String updateBankInfo(@RestBeanParam(name = "data") JSONObject data) {
		 
		logger.info("手动执行更新银行信息-->start");
    	String result = BankWs.webservice();
    	logger.info("手动同步银行信息-->完成||msg->"+result);
		return result.toString();
		
	}

}
