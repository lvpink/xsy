package other.hht.bank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.YHDM__c;
import com.rkhd.platform.sdk.exception.CacheException;
import com.rkhd.platform.sdk.exception.XsyHttpException;
import com.rkhd.platform.sdk.http.RkhdHttpClient;
import com.rkhd.platform.sdk.http.RkhdHttpData;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.service.CacheService;

public class  PassUtils {
	private static final Logger logger = LoggerFactory.getLogger();
	
	/*根据不同对象获取默认业务类型ID
     */
	public static Long getEntityTypeId(String type)  {

        String defaultBusiTypeID="defaultBusiTypeID"+type;
        try {
            if(null!= CacheService.instance().get(defaultBusiTypeID)){
                return  Long.parseLong(CacheService.instance().get(defaultBusiTypeID) );
            }
        } catch (CacheException e) {
            logger.error("获取EntityTypeId缓存出错，"+e.getMessage());
        }
        RkhdHttpData rkhdHttpData = new RkhdHttpData();
        rkhdHttpData.setCallString("/rest/data/v2.0/xobjects/"+type+"/busiType");
        rkhdHttpData.setCall_type("get");
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("xsy-criteria","10");
        rkhdHttpData.setHeaderMap( headerMap);

        try {
            JSONObject jsonObject = null;
            jsonObject = (JSONObject) RkhdHttpClient.instance().execute(rkhdHttpData, JSON::parseObject );
            if(null!=jsonObject){
                JSONObject resultJsonObject = jsonObject.getJSONObject("data");
                JSONArray array=resultJsonObject.getJSONArray("records");
                if(0==array.size()){
                    logger.error("自定义消息类型获得0条数据，程序异常");
                    return 0L;
                }else {
                    for (Object index:array
                    ) {
                        JSONObject mailBusType=JSONObject.parseObject(index.toString());
                        //获取默认业务类型ID 即可返回
                        if(mailBusType.get("apiKey").toString().equalsIgnoreCase("defaultBusiType")){
                            //System.out.println("entityType id:"+mailBusType.get("id"));
                            try {
                                CacheService.instance().set(defaultBusiTypeID,mailBusType.get("id").toString());
                            } catch (CacheException e) {
                                logger.error("设置EntityTypeId缓存出错，"+e.getMessage());
                            }
                            return  Long.parseLong(mailBusType.get("id").toString()) ;
                        }
                    }
                }
            }
        }catch (XsyHttpException e) {
            logger.error("获得业务类型出错: "+e.getMessage());
        }catch (IOException e){
            logger.error("获得业务类型出错: "+e.getMessage());
        }
        return 0L;
    }

    /**
     * 查询所有银行信息
     * @param rkhdHttpClient
     * @param sql
     * @return
     */
    public static List<YHDM__c> doQuery(RkhdHttpClient rkhdHttpClient){
    	String sql = "select id,name,bankCountryCode__c,bankName__c from YHDM__c ";
    	JSONArray jsonArray = new JSONArray();
    	List<YHDM__c> list = new ArrayList<YHDM__c>();
    	//递归查询
    	getAllData(rkhdHttpClient,sql,jsonArray,0);
    	for (Object object : jsonArray) {
			List<YHDM__c> parseArray = JSONObject.parseArray(object.toString(), YHDM__c.class);
			list.addAll(parseArray);
			
		}
		return list;
    	
    }

    /**
     * 查询所有银行信息
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
		sqlBuilder.append(200);
		business.setCallString("/data/v1/query");
		business.putFormData("q", sqlBuilder.toString());
		
		try {
			String response = rkhdHttpClient.performRequest(business);
			JSONObject json = JSONObject.parseObject(response);
			Integer totalSize = json.getInteger("totalSize");
			if(0<json.getInteger(("count"))){
				datas.add(json.getJSONArray("records"));
			}
			if(totalSize>num+200){
				getAllData(rkhdHttpClient, sql, datas, num+200);
			}
		} catch (IOException e) {
			return;
		}
	}
}
