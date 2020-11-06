package other.hht.lead;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.Lead;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.exception.XsyHttpException;
import com.rkhd.platform.sdk.http.RkhdHttpClient;
import com.rkhd.platform.sdk.http.RkhdHttpData;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.OperateResult;
import com.rkhd.platform.sdk.model.QueryResult;
import com.rkhd.platform.sdk.model.XObject;
import com.rkhd.platform.sdk.service.XObjectService;

public class  PassUtils {
	private static final Logger logger = LoggerFactory.getLogger();
//	private static final Map<Long, String> allTypeMap = getAllEntityTypeId();
	
	/*根据不同对象获取默认业务类型ID
     */
	public static Map<Long, String>  getAllEntityTypeId()  {

        RkhdHttpData rkhdHttpData = new RkhdHttpData();
        rkhdHttpData.setCallString("/rest/data/v2.0/xobjects/lead/busiType");
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
                    return null;
                }else {
                	Map<Long, String> typeMap = new HashMap<Long, String>();
                    for (Object index:array) {
                        JSONObject mailBusType=JSONObject.parseObject(index.toString());
                        //获取默认业务类型ID 即可返回
                    	Long id = (Long) mailBusType.get("id");
                    	String description = mailBusType.getString("label");
                    	logger.info("id:"+id+"===description"+description);
                    	typeMap.put(id, description);
                    }
                    return typeMap;
                }
            }
        }catch (XsyHttpException e) {
            logger.error("获得业务类型出错: "+e.getMessage());
        }catch (IOException e){
            logger.error("获得业务类型出错: "+e.getMessage());
        }
        return null;
    }

	/**修改线索类型*/
	public static boolean updateTypeByID(Lead lead) {
		try {
			logger.info("-----执行更新-----");
			OperateResult operateResult = XObjectService.instance().update(lead);
			if(operateResult.getSuccess()){
				logger.info(operateResult.getErrorMessage());
				return true;
			}
			logger.error(operateResult.getErrorMessage());
		} catch (ApiEntityServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public static void main(String[] args) {
		String sql ="select id, entityType,name,BType__c from lead";
		try {
			QueryResult<XObject> query = XObjectService.instance().query(sql);
			if(query.getSuccess()){
				List<XObject> records = query.getRecords();
				logger.info("========"+records.size());
			}
		} catch (ApiEntityServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
