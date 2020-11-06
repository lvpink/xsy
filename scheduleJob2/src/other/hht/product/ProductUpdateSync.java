package other.hht.product;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.api.annotations.RequestMethod;
import com.rkhd.platform.sdk.api.annotations.RestApi;
import com.rkhd.platform.sdk.api.annotations.RestBeanParam;
import com.rkhd.platform.sdk.api.annotations.RestMapping;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
/**
 * 同步sap产品信息
 * @author xsy
 *
 */
@RestApi(baseUrl = "/xsy")
public class ProductUpdateSync{

private static final Logger logger = LoggerFactory.getLogger();

	
	@RestMapping(value = "updateProductInfo", method = RequestMethod.POST)
	public String updateProductInfo(@RestBeanParam(name = "data") JSONObject data) {
		 
		logger.info("同步sap产品信息-->start");
		String retStr = ProductWs.webservice();
		logger.info("同步sap产品结果：：-->"+retStr);
		return retStr;
	}


}
