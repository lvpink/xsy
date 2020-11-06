package other.hht.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.Product;
import com.rkhd.platform.sdk.data.model.User;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.exception.CacheException;
import com.rkhd.platform.sdk.exception.XsyHttpException;
import com.rkhd.platform.sdk.http.RkhdHttpClient;
import com.rkhd.platform.sdk.http.RkhdHttpData;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.QueryResult;
import com.rkhd.platform.sdk.service.CacheService;
import com.rkhd.platform.sdk.service.XObjectService;

public class  PassUtils {
	private static final Logger logger = LoggerFactory.getLogger();
	public static final List<User> allUser = getAllUser();
	public static final List<Product> allProduct = getAllProduct();
	
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
    
	/*查询所有产品
	 */
	public  static  List<Product> getAllProduct(){
		logger.info("----查询所有产品----");
		String sql ="select id,productName,fscProductModel,fscProductSpec from product limit 0,1000";  
		try {
			logger.info("Product查询sql :"+sql);
			QueryResult<Product> result = XObjectService.instance().query(sql);
			logger.info(result.getErrorMessage()+"=="+result.getTotalCount());
			if(result.getSuccess()){
				List<Product> records = result.getRecords();
				if(null!=records&&records.size()>0){
					logger.info("产品总量size:"+records.size());
					return records;
				}
			}
		} catch (ApiEntityServiceException e) {
			// TODO Auto-generated catch block
			logger.error("查询产品List报错: "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	/*查询所有用户
     */
    public  static  List<User> getAllUser(){
    	logger.info("----查询所有用户----");
    	String sql ="select id,employeeCode from user ";  
    	try {
    		logger.info("allUser查询sql :"+sql);
    		QueryResult<User> result = XObjectService.instance().query(sql);
    		if(result.getSuccess()){
    			List<User> records = result.getRecords();
    			if(null!=records&&records.size()>0){
    				logger.info("用户总量size:"+records.size());
    				return records;
    			}
    		}
    	} catch (ApiEntityServiceException e) {
    		// TODO Auto-generated catch block
    		logger.error("查询用户List报错: "+e.getMessage());
    		e.printStackTrace();
    	}
    	return null;
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
    
    public static JSONArray doQuery(RkhdHttpClient rkhdHttpClient,String sql){
    	JSONArray jsonArray = new JSONArray();
    	getAllData(rkhdHttpClient,sql,jsonArray,0);
		return jsonArray;
    	
    }

	private static void getAllData(RkhdHttpClient rkhdHttpClient, String sql, JSONArray datas, int num) {
		// TODO Auto-generated method stub
		RkhdHttpData business = new RkhdHttpData();
		business.setCall_type("POST");
		
		StringBuilder sqlBuilder = new StringBuilder(sql);
		sqlBuilder.append(" limit ");
		sqlBuilder.append(num);
		sqlBuilder.append(",");
		sqlBuilder.append(10);
		business.setCallString("/data/v1/query");
		business.putFormData("q", sqlBuilder.toString());
		
		try {
			String response = rkhdHttpClient.performRequest(business);
			JSONObject json = JSONObject.parseObject(response);
			Integer totalSize = json.getInteger("totalSize");
			if(0<json.getInteger(("count"))){
				datas.add(json.getJSONArray("records"));
			}
			if(totalSize>num+10){
				getAllData(rkhdHttpClient, sql, datas, num+10);
			}
		} catch (IOException e) {
			return;
		}
	}
}
