package other.hht.matnr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.Product;
import com.rkhd.platform.sdk.http.RkhdHttpClient;
import com.rkhd.platform.sdk.http.RkhdHttpData;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;

public class  PassUtils {
	private static final Logger logger = LoggerFactory.getLogger();
    /**
     * 查询所有产品
     * @param rkhdHttpClient
     * @param sql
     * @return
     */
    public static List<Product> doQuery(String xszz,String xsfz){
    	logger.info("------递归查询所有产品------");
    	try {
			RkhdHttpClient rkhdHttpClient = new RkhdHttpClient();
//			销售组织 销售分支  产品编码 产品描述  套件标识 组合标识 虚拟物料标识 FDBS__c,
			String proSql ="select id,BZ__c,SL__c,HPMC__c,XSZZ__c, XSFZ__c,CPX__c,ZJBX__c,HCBX__c,CB1NFY__c,CB2NFY__c,CB3NFY__c,SYBJL__c,FHJL__c,ZCJL__c"
					+ ",FZJLSPJ__c,DQJLSPJ__c,SYBJLSPJ__c,SYBZJLSPJ__c,YYBGZJL__c,JYJTZCSPJ__c,HTZDJ__c,HTZDS__c,ZHBS__c,TJBS__c"
					+ ",productName,description,entityType,dimDepart,fscProductModel,fscProductSpec,fscProductType from product where XSZZ__c = '"+xszz+"' and XSFZ__c = '"+xsfz+"'"; 
			JSONArray jsonArray = new JSONArray();
			getAllData(rkhdHttpClient,proSql,jsonArray,0);
			List<Product> allproduct = new ArrayList<Product>();
			for (Object object : jsonArray) {
				List<Product> parseArray = JSONObject.parseArray(object.toString(), Product.class);
				allproduct.addAll(parseArray);
			}
			return allproduct;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    	
    }

    /**
     * 查询所有产品
     * @param rkhdHttpClient
     * @param sql
     * @param datas
     * @param num
     */
	private static void getAllData(RkhdHttpClient rkhdHttpClient, String sql, JSONArray datas, int num) {
		// TODO Auto-generated method stub
		RkhdHttpData business = new RkhdHttpData();
		business.setCall_type("POST");
		StringBuilder sqlBuilder = new StringBuilder(sql);
		sqlBuilder.append(" limit ");
		sqlBuilder.append(num);
		sqlBuilder.append(",");
		sqlBuilder.append(300);
		business.setCallString("/data/v1/query");
		business.putFormData("q", sqlBuilder.toString());
		
		try {
			String response = rkhdHttpClient.performRequest(business);
			JSONObject json = JSONObject.parseObject(response);
			Integer totalSize = json.getInteger("totalSize");
			if(0<json.getInteger(("count"))){
				datas.add(json.getJSONArray("records"));
			}
			if(totalSize>num+300){
				getAllData(rkhdHttpClient, sql, datas, num+300);
			}
		} catch (IOException e) {
			return;
		}
	}
}
