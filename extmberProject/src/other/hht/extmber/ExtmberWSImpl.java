package other.hht.extmber;

import java.util.List;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.Product;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;

public class ExtmberWSImpl {
private static final Logger logger = LoggerFactory.getLogger();
    
	/*调用webService接口，查询产品组件*/
    public static String webservice(String iCpbm, String xszz_c, String xsfz_c) {
    	logger.info("查询sapWS套件信息--->start");
    	ZFMCRMTAOJLIST_Service zfmcrmtaojlist_Service = new ZFMCRMTAOJLIST_Service();
    	ZFMCRMTAOJLIST port = zfmcrmtaojlist_Service.getBinding();
    	BindingProvider bp = (BindingProvider) port;
        Map<String, Object> context = bp.getRequestContext();
        context.put(BindingProvider.USERNAME_PROPERTY, Constants.USERNAME);
        context.put(BindingProvider.PASSWORD_PROPERTY, Constants.PASSWORD);
		//执行webservice 方法
        ZcrmIdnrkT zfmCrmTaojlist = port.zfmCrmTaojlist(iCpbm);
        List<ZcrmIdnrkS> item = zfmCrmTaojlist.getItem();
        logger.info("=WS->size="+item.size());
        /**构建返回数据*/
    	JSONObject result = new JSONObject();
    	if(null==item||item.size()==0){
    		result.put("status", -1);
    		result.put("msg", "未查询到套件信息");
    		return result.toString();
    	}
        JSONArray bkProduct = new JSONArray();
//    	根据上送参数{销售组织、销售分支匹配产品} 过滤产品
    	List<Product> allproduct = PassUtils.doQuery(xszz_c, xsfz_c);
    	ExtmberEntity extmberEntity;
    	for (ZcrmIdnrkS zcrmIdnrkS : item) {
    		for (Product product : allproduct) {
    			extmberEntity = new ExtmberEntity();
				if(zcrmIdnrkS.getZcrmIdnrk().equals(product.getProductName())){
		    		//设置套件
					extmberEntity.setZcrmTjlx(zcrmIdnrkS.getZcrmTjlx());
					extmberEntity.setZcrmIdnrk(zcrmIdnrkS.getZcrmIdnrk());
					extmberEntity.setZcrmCpbm(zcrmIdnrkS.getZcrmCpbm());
					extmberEntity.setPrice(zcrmIdnrkS.getPrice());
					extmberEntity.setNoCheck(zcrmIdnrkS.getNoCheck());
					extmberEntity.setMenge(zcrmIdnrkS.getMenge());
					
					//设置产品
					extmberEntity.setJsonProduct(product);
					bkProduct.add(extmberEntity);
				}
			}
		}
    	result.put("status", 0);
		result.put("msg", "查询套件信息成功");
		result.put("records", bkProduct);
		return result.toString();
    }
 /*   public static void main(String[] args) {
		webservice("51303CX0000000C","2800","1100");
	}*/
}
