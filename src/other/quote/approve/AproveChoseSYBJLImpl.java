package other.quote.approve;

import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.creekflow.approvalchooser.ApprovalChooser;
import com.rkhd.platform.sdk.creekflow.approvalchooser.ApprovalChooserRequest;
import com.rkhd.platform.sdk.creekflow.approvalchooser.ApprovalChooserResponse;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.exception.ScriptBusinessException;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.QueryResult;
import com.rkhd.platform.sdk.model.XObject;
import com.rkhd.platform.sdk.service.XObjectService;
/**
 * 报价单审批动态选人---事业部经理
 * @author XSY
 *
 */
public class AproveChoseSYBJLImpl implements ApprovalChooser{
	private static final Logger logger = LoggerFactory.getLogger();

	@Override
	public ApprovalChooserResponse execute(ApprovalChooserRequest request) throws ScriptBusinessException {
		logger.info("----事业部经理----AproveChoseSYBJLImpl start-------");
		 logger.info("上送参数："+JSONObject.toJSONString(request));
		//构建返回数据
		ApprovalChooserResponse response=new ApprovalChooserResponse();
		if(null==request){
			response.setSuccess(false);
			response.setMsg("上送参数不存在");
			logger.error("上送参数不存在");
			return response;
		}
		Long quoteId = request.getDataId();
		//1.根据报价单ID，查询报价单明细（quoteLine）中产品名称quotationDetailEntityRelProduct
		//quotationDetailEntityRelQuotationEntity 报价单明细报价单ID
		logger.info("quoteId:"+quoteId);
		//2.根据报价单id，查询报价单编码
		/*String code = PassUtils.queryQuoteCode(quoteId);
		if(null==code){
			response.setSuccess(false);
			response.setMsg("报价单编码不存在");
			logger.error("报价单编码不存在");
			return response;
		}*/
		//3.根据报价单编码查询产品id
		List<Long> productId = PassUtils.queryProductId(quoteId.toString());
		if(null==productId||productId.size()==0){
			response.setSuccess(false);
			response.setMsg("获取产品id失败");
			logger.error("获取产品id失败");
			return response;
		}
		//4.根据产品id，查询用户事业部经理编码
		List<Long> userCodeList = PassUtils.querySYBJLCode(productId);
		if(null==userCodeList||userCodeList.size()==0){
			response.setSuccess(false);
			response.setMsg("获取事业部经理用户编码失败");
			logger.error("获取事业部经理用户编码失败");
			return response;
		}
		//5.根据事业部经理用户编码，在用户表查询userid
		List<Long> UserIds = PassUtils.queryUserIds(userCodeList);
		if(null==UserIds||UserIds.size()==0){
			response.setSuccess(false);
			response.setMsg("获取事业部经理用户id失败");
			logger.error("获取事业部经理用户id失败");
			return response;
		}
		response.setSuccess(true);
		response.setMsg("查询事业部经理用户成功");
		response.setData(UserIds);
		logger.info("查询事业部经理用户id成功");
		return response;
		
	}
	
	public static void main(String[] args) {

		String sql ="select quotationDetailEntityRelProduct  from  quoteLine where id = ";
		try {
//			quoteLine.getProductOptionId()
			QueryResult<XObject> query = XObjectService.instance().query(sql);
			String jsonString = JSONObject.toJSONString(query);
			logger.info(""+jsonString);
		} catch (ApiEntityServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}