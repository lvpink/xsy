package other.hht.quote;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.Product;
import com.rkhd.platform.sdk.data.model.Quote;
import com.rkhd.platform.sdk.data.model.QuoteLine;
import com.rkhd.platform.sdk.data.model.User;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.QueryResult;
import com.rkhd.platform.sdk.service.XObjectService;

public class  PassUtils {
	private static final Logger logger = LoggerFactory.getLogger();
	
	/**
	 * 根据报价单id，查询报价单编码
	 * @param quoteId
	 * @return
	 */
	public static String queryQuoteCode(Long quoteId) {
		String sql ="select name from quote where id = '"+quoteId+"'";
		try {
			QueryResult<Quote> query = XObjectService.instance().query(sql);
			String jsonString = JSONObject.toJSONString(query);
			logger.info(""+jsonString);
			if(query.getSuccess()){
				Quote quote = query.getRecords().get(0);
				return quote.getName();
			}
		} catch (Exception e) {
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
			String jsonString = JSONObject.toJSONString(query);
			logger.info("查询产品id返回结果："+jsonString);
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
			String jsonString = JSONObject.toJSONString(query);
			logger.info(""+jsonString);
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
			String jsonString = JSONObject.toJSONString(query);
			logger.info(""+jsonString);
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
	public static void main(String[] args) {
		List<Long> queryProductId = queryProductId("1449658270843618");
		logger.info("==="+queryProductId.size());
		List<Long> querySYBJLCode = querySYBJLCode(queryProductId);
		logger.info(JSONObject.toJSONString(querySYBJLCode));
		List<Long> queryUserIds = queryUserIds(querySYBJLCode);
		logger.info(JSONObject.toJSONString(queryUserIds));
	}
}