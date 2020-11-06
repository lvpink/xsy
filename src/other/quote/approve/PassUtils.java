package other.quote.approve;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.Product;
import com.rkhd.platform.sdk.data.model.Quote;
import com.rkhd.platform.sdk.data.model.QuoteLine;
import com.rkhd.platform.sdk.data.model.User;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.QueryResult;
import com.rkhd.platform.sdk.service.XObjectService;

public class PassUtils {
	private static final Logger logger = LoggerFactory.getLogger();

	/**
	 * 根据报价单id，查询所有人
	 * @param dataId
	 * @return
	 */
    public static Long getOwnerByApproveId(Long dataId){
    	String sql ="select ownerId from quote where id = '"+dataId+"'";  
    	try {
			QueryResult<Quote> result = XObjectService.instance().query(sql);
			logger.info("查询所有人返回结果："+JSONObject.toJSONString(result));
			if(result.getSuccess()){
				List<Quote> records = result.getRecords();
				return records.get(0).getOwnerId();
			}
		} catch (ApiEntityServiceException e) {
			logger.error("查询所有人id失败： "+e.getMessage());
			e.printStackTrace();
		}
    	return null;
    }
    /**
     * 所有人ownerId在用户表，查询对应的事业部总经理SYBZJL__c/大区经理DQJLYGBH__c
     * @param ownerId
     * @return
     */
    public static User getCodeByOwner(Long ownerId){
    	String sql ="select SYBZJL__c,DQJLYGBH__c from user where id = '"+ownerId+"'";  
    	try {
			QueryResult<User> result = XObjectService.instance().query(sql);
			logger.info("查询用户返回结果："+JSONObject.toJSONString(result));
			if(result.getSuccess()){
				List<User> records = result.getRecords();
				return records.get(0);
			}
		} catch (ApiEntityServiceException e) {
			logger.error("查询用户失败： "+e.getMessage());
			e.printStackTrace();
		}
    	return null;
    }
    /**
     * 根据编码查询用户id
     * @param sybswygbh__c
     * @return
     */
    public static Long getUserIdByCode(String sybswygbh__c){
    	String sql ="select id from user where employeeCode = '"+sybswygbh__c+"'";  
    	try {
    		QueryResult<User> result = XObjectService.instance().query(sql);
    		logger.info("查询用户ID返回结果："+JSONObject.toJSONString(result));
    		if(result.getSuccess()){
    			List<User> records = result.getRecords();
    			return records.get(0).getId();
    		}
    	} catch (ApiEntityServiceException e) {
    		logger.error("查询用户id失败： "+e.getMessage());
    		e.printStackTrace();
    	}
    	return null;
    }
    /**
	 * 根据报价单编码查询产品id
	 * @param code
	 * @return
	 */
	public static List<Long> queryProductId(String code) {
		String sql ="select quotationDetailEntityRelProduct  from  quoteLine where quotationDetailEntityRelQuotationEntity = '"+code+"'";
		List<Long> list = null;
		try {
			QueryResult<QuoteLine> query = XObjectService.instance().query(sql);
			logger.info("查询产品ID返回结果："+JSONObject.toJSONString(query));
			if(query.getSuccess()){
				list = new ArrayList<Long>();
				List<QuoteLine> quoteList = query.getRecords();
				for (QuoteLine quoteLine : quoteList) {
					Long entityRelProduct = quoteLine.getQuotationDetailEntityRelProduct();
					if(null==entityRelProduct){
						continue;
					}
					list.add(entityRelProduct);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 根据产品id，查询用户事业部经理编码
	 * @param queryProductId
	 * @return
	 */
	public static List<Long> querySYBJLCode(List<Long> queryProductId) {
		String sqlParam = getSqlParam(queryProductId);
		
		String sql ="select SYBJL__c from product where id in ("+sqlParam+")";
		List<Long> list = null;
		
		try {
			QueryResult<Product> query = XObjectService.instance().query(sql);
			logger.info("查询事业部经理编码返回结果："+JSONObject.toJSONString(query));
			if(query.getSuccess()){
				List<Product> records = query.getRecords();
				logger.info("去重---------");
				//根据事业部经理 用户编码去重
			/*	ArrayList<Product> distinctPro = records.stream()
		                .collect(
		                        Collectors.collectingAndThen(
		                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Product::getSYBJL__c))),
		                                product -> new ArrayList<>(product)
		                        )
		                );*/
//				logger.info("去重后id:"+JSONObject.toJSONString(distinctPro));
				list = new ArrayList<Long>();
				for (Product product : records) {
					Long sybjl__c = product.getSYBJL__c();
					if(null==sybjl__c){
						continue;
					}
					if(!list.contains(sybjl__c)){
						list.add(sybjl__c);
					}
				}
			}
			logger.info("返回id:"+JSONObject.toJSONString(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据事业部经理用户编码，在用户表查询userid
	 * @param querySYBJLCode
	 * @return
	 */
	public static List<Long> queryUserIds(List<Long> querySYBJLCode) {
		String sqlParam = getSqlParam(querySYBJLCode);
		
		String sql ="select id,employeeCode from user where employeeCode in ("+sqlParam+")";
		logger.info("sql:"+sql);
		List<Long> list =null;
		
		try {
			QueryResult<User> query = XObjectService.instance().query(sql);
			logger.info("查询事业部经理用户ID返回结果："+JSONObject.toJSONString(query));
			if(query.getSuccess()){
				List<User> records = query.getRecords();
				 list = new ArrayList<Long>();
				for (User user : records) {
					list.add(user.getId());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//拼接list元素，用于sql字段in 查询
		private static String getSqlParam(List<Long> list){
			String idParam = "'";
			for (Long id : list) {
				idParam+=id+"','";
			}
			return  idParam.substring(0, idParam.length()-2);
		}
}
