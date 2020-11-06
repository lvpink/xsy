package other.honghe.com;

import java.io.IOException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.http.RkhdHttpClient;
import com.rkhd.platform.sdk.http.RkhdHttpData;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
public class PaasUtils {
	private static final Logger logger = LoggerFactory.getLogger();
	/**
	 * 通过sql查询出所有的结果（不受平台30条限制）
	 * @param rkhdClient 调用接口的实体对象
	 * @param sql 查询sql的语句
	 * @return 查询结果
	 * @throws IOException 
	 */
	public static JSONArray doQueryAll(RkhdHttpClient rkhdClient, String sql,String apiVersion){
		JSONArray arrays = new JSONArray();
		getAllDatas(rkhdClient, sql, apiVersion, arrays, 0);
		return arrays;
	}
	private static void getAllDatas(RkhdHttpClient rkhdClient, String sql, String apiVersion, JSONArray datas, int num) {
		RkhdHttpData bussiness = new RkhdHttpData();
		if("V2".equals(apiVersion)){
			//V2查询接口 每次返回100条数据 V2只能order by id 很恶心
	        bussiness.setCall_type("GET");
	        StringBuilder sqlBulder = new StringBuilder(sql);
	        sqlBulder.append(" limit ");
	        sqlBulder.append(num);
	        sqlBulder.append(",");
	        sqlBulder.append(100);
	        bussiness.setCallString("/rest/data/v2/query?q="+sqlBulder.toString().replaceAll("\\s","%20"));
			try {
				String response = rkhdClient.performRequest(bussiness);
				JSONObject json = JSONObject.parseObject(response);
		        JSONObject resultJson = json.getJSONObject("result");
		        Integer totalSize = resultJson.getIntValue("totalSize");
		        if (0 < resultJson.getIntValue("count")) {
		        	datas.addAll(resultJson.getJSONArray("records"));
		        }
		        if (totalSize > num+100) {
		        	getAllDatas(rkhdClient,sql,apiVersion,datas,num+100);
		        }
			} catch (IOException e) {
				logger.error("异常："+e.getMessage());
			}
		}else{
			//V1查询接口 每次返回300条数据
	        bussiness.setCall_type("POST");
	        StringBuilder sqlBulder = new StringBuilder(sql);
	        sqlBulder.append(" limit ");
	        sqlBulder.append(num);
	        sqlBulder.append(",");
	        sqlBulder.append(300);
	        bussiness.setCallString("/data/v1/query");
	        bussiness.putFormData("q", sqlBulder.toString());
			try {
				String response = rkhdClient.performRequest(bussiness);
				JSONObject json = JSONObject.parseObject(response);
		        Integer totalSize = json.getIntValue("totalSize");
		        if (0 < json.getIntValue("count")) {
		        	datas.addAll(json.getJSONArray("records"));
		        }
		        if (totalSize > num+300) {
		        	getAllDatas(rkhdClient,sql,apiVersion,datas,num+300);
		        }
			} catch (IOException e) {
				logger.error("异常："+e.getMessage());
			}
		}
	}
}
