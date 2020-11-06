package other.quote.team;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.User;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.exception.XsyHttpException;
import com.rkhd.platform.sdk.http.RkhdHttpClient;
import com.rkhd.platform.sdk.http.RkhdHttpData;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.QueryResult;
import com.rkhd.platform.sdk.service.XObjectService;

public class  PassUtils {
	private static final Logger logger = LoggerFactory.getLogger();

//	销售员userId，事业部商务SYBSWYGBH__c、大区经理DQJLYGBH__c、事业部经理SYBZJLYGBH__c
	/**
	 * 根据报价单的所有人id 查询用户信息
	 * @param xsy_c ownerID
	 * @return
	 */
	public static User queryUserByOwner(Long ownerId) {
		String sql ="select id,SYBSW__c,SYBSWYGBH__c,DQJL__c,DQJLYGBH__c,SYBZJL__c,SYBZJLYGBH__c from user where id = '"+ownerId+"'";  
    	try {
    		logger.info("根据报价单的所有人id 查询用户sql :"+sql);
    		QueryResult<User> result = XObjectService.instance().query(sql);
    		logger.info("查询结果："+result.getErrorMessage());
    		if(result.getSuccess()){
    			List<User> records = result.getRecords();
    			logger.info("查询数据size："+records.size());
    			return records.get(0);
    		}
    	} catch (ApiEntityServiceException e) {
    		logger.error("根据报价单的所有人id 查询用户失败： "+e.getMessage());
    		e.printStackTrace();
    	}
    	return null;
	}
	
    /**
     * 根据对象名称，查询对象ID
     * @param authorApply__c 实体对象
     * @return
     */
	public static Long queryBelongId(String authorApply__c) {
		RkhdHttpData rkhdHttpData = new RkhdHttpData();
//		https://api.xiaoshouyi.com/data/v1/picks/dimension/belongs
		
		String restUrl = "/data/v1/picks/dimension/belongs";
		logger.info("restUrl:"+restUrl);
        rkhdHttpData.setCallString(restUrl);
        rkhdHttpData.setCall_type("get");
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("xsy-criteria","10");
        rkhdHttpData.setHeaderMap(headerMap);

        try {
            JSONObject belongJson = null;
            belongJson = (JSONObject) RkhdHttpClient.instance().execute(rkhdHttpData, JSON::parseObject);
            if(null!=belongJson){
            	JSONArray record = belongJson.getJSONArray("records");
            	for (Object object : record) {
					JSONObject elem = JSONObject.parseObject(object.toString());
					if(elem.getString("name").equals(authorApply__c)){
						Long belongId = elem.getLong("belongId");
						return belongId;
					}
				}
            }
        }catch (XsyHttpException e) {
            logger.error("查询对象ID报错: "+e.getMessage());
        }catch (IOException e){
            logger.error("查询对象ID报错: "+e.getMessage());
        }
		return null;
	}
	/**
	 * 新建团队成员
	 * @param userId 用户id   
	 * @param ownerFlag 是否有编辑权限
	 * @param recordFrom  实体ID --belongId
	 * @param recordId  实体数据ID    --recordId
	 * @return 
	 */
	public static boolean addTeamUser(Long userId, Integer ownerFlag, Long recordFrom, Long recordFrom_data) {
		RkhdHttpData rkhdHttpData = new RkhdHttpData();
		String restUrl = "rest/data/v2.0/xobjects/teamMember";
		logger.info("restUrl:"+restUrl);
        rkhdHttpData.setCallString(restUrl);
        rkhdHttpData.setCall_type("post");
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("xsy-criteria","10");
        rkhdHttpData.setHeaderMap(headerMap);
        JSONObject params = new JSONObject();
        JSONObject param = new JSONObject();
        param.put("userId", userId);
        param.put("ownerFlag", ownerFlag);
        param.put("recordFrom", recordFrom);
        param.put("recordFrom_data", recordFrom_data);
        logger.info("{\"data\":" + param + "}");
        params.put("data", param);
        rkhdHttpData.setBody(params.toString());
        logger.info("新增团队成员参数：->"+params.toString());

        try {
        	RkhdHttpClient rkhdHttpClient = new RkhdHttpClient();
            JSONObject teamJson = rkhdHttpClient.execute(rkhdHttpData, JSON::parseObject);
//            {"msg":"OK","code":"200","data":{"id":1462412560220909}}
            logger.info("新增团队成员返回结果：:"+teamJson.toString());
            if(teamJson.getString("code").equals("200")){
            	logger.info("-----新增团队成员成功-----");
            	return true;
            }
        }catch (Exception e) {
        	 logger.error("新增团队成员报错: "+e.getMessage());
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/**
	 * 根据用户编码查询用户id
	 * @param code 用户编码
	 * @return
	 */
	public static Long queryUserIdBycode(String code) {
		String sql  = "select id,name from user where employeeCode = '"+code+"'";
		try {
    		logger.info("查询用户编号sql :"+sql);
    		QueryResult<User> result = XObjectService.instance().query(sql);
    		if(result.getSuccess()){
    			User user = result.getRecords().get(0);
    			return user.getId();
    		}
    	} catch (ApiEntityServiceException e) {
    		logger.error("查询用户编号失败： "+e.getMessage());
    		e.printStackTrace();
    		return null;
    	}
		return null;
	}
	
	public static void main(String[] args) {
		/*{
	    "data": {
	        "recordFrom_data": 1460190026433167, ---授权申请中的数据  id
	        "ownerFlag": 1,
	        "recordFrom": 1451600179806957, ---对象 id
	        "userId": 1453000750105323 ---授权申请中的   XSY__c
		    }
		}*/
//		(Long userId, Integer ownerFlag, Long recordFrom, Long recordFrom_data)
//		addTeamUser(1453000750105323l,1,1451600179806957l,1460190026433167l);
	}

}
