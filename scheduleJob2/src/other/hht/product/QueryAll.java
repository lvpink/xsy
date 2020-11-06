package other.hht.product;

import java.io.IOException;


import com.alibaba.fastjson.JSONArray;
import com.rkhd.platform.sdk.api.ApiSupport;
import com.rkhd.platform.sdk.http.Request;
import com.rkhd.platform.sdk.http.RkhdHttpClient;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;

public class QueryAll implements ApiSupport {
	private static final Logger logger = LoggerFactory.getLogger();

	@Override
	public String execute(Request arg0, Long arg1, Long arg2) {
		// TODO Auto-generated method stub
		String sql = String.valueOf(arg0.getParameter("sql"));
		RkhdHttpClient rkhdHttpClient = null;
		try {
			rkhdHttpClient = new RkhdHttpClient();
			JSONArray array = PassUtils.doQuery(rkhdHttpClient, sql);
			logger.info(array.toJSONString());
			return array.toJSONString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
