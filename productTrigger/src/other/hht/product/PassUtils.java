package other.hht.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.Product;
import com.rkhd.platform.sdk.data.model.User;
import com.rkhd.platform.sdk.exception.CacheException;
import com.rkhd.platform.sdk.exception.XsyHttpException;
import com.rkhd.platform.sdk.http.RkhdHttpClient;
import com.rkhd.platform.sdk.http.RkhdHttpData;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.service.CacheService;

public class  PassUtils {
	private static final Logger logger = LoggerFactory.getLogger();
	public static final List<User> allUser = doQueryUser();
	
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
    /*根据sap产品的用户编号uname，查询用户id
     */
    public static Long getUserId(String sapUname){
    	List<User> allUser = PassUtils.allUser;
    	if(null!=allUser){
			for (User user : allUser) {
				if(null!=user.getEmployeeCode()){
					if(user.getEmployeeCode().equals(sapUname)){
						return user.getId();
					}
				}
			}
    	}
		return null;
    }
    /*查询产品目录 id
     */
    @SuppressWarnings("all")
    public static Long getProductParentId(){
    	RkhdHttpData rkhdHttpData = new RkhdHttpData();
        rkhdHttpData.setCallString("/data/v1/objects/product/directoryList");
        rkhdHttpData.setCall_type("get");
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("xsy-criteria","10");
        rkhdHttpData.setHeaderMap( headerMap);
        try {
            JSONObject jsonObject = null;
            jsonObject = (JSONObject) RkhdHttpClient.instance().execute(rkhdHttpData, JSON::parseObject );
            if(null!=jsonObject&&jsonObject.getString("count").equals("1")){
                JSONArray jsonArray = jsonObject.getJSONArray("records");
                String recordStr = jsonArray.get(0).toString();
                JSONObject parseObject = jsonObject.parseObject(recordStr);
                Long id = Long.valueOf(parseObject.getString("id"));
                return id;
            }
        }catch (XsyHttpException e) {
            logger.error("查询产品目录 id出错: "+e.getMessage());
        }catch (IOException e){
            logger.error("查询产品目录 id出错: "+e.getMessage());
        }
    	return null;
    }

    /**
     * 查询所有用户
     * @param rkhdHttpClient
     * @param sql
     * @return
     */
    public static List<User> doQueryUser(){
    	logger.info("------递归查询所有用户------");
    	try {
			RkhdHttpClient rkhdHttpClient = new RkhdHttpClient();
			String sql ="select id,employeeCode from user "; 
			JSONArray jsonArray = new JSONArray();
			getAllData(rkhdHttpClient,sql,jsonArray,0);
			List<User> allproduct = new ArrayList<User>();
			for (Object object : jsonArray) {
				List<User> parseArray = JSONObject.parseArray(object.toString(), User.class);
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
     * @return
     */
    public static List<Product> doQueryProduct(){
    	logger.info("------递归查询所有产品------");
    	try {
			RkhdHttpClient rkhdHttpClient = new RkhdHttpClient();
			String proSql ="select id,productName,CPX__c,XSZZ__c,XSFZ__c from product"; 
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
     * 递归查询
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
	/**
	 * 根据用户编码查询用户id
	 * @param code --用户编码
	 * @return
	 */
	public static Long getUserIdByCode(String code){
		List<User> users = allUser;
		for (User user : users) {
			if(user.getEmployeeCode().equals(code)){
				return user.getId();
			}
		}
		return null;
	}
	
	
}
