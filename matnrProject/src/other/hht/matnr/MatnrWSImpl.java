package other.hht.matnr;

import java.util.List;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.Product;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;

public class MatnrWSImpl {
private static final Logger logger = LoggerFactory.getLogger();
    
	/*调用webService接口，查询产品组件*/
    public static String webservice(String iCpbm, String xszz_c, String xsfz_c) {
    	logger.info("查询sapWS产品信息");
    	ZFMCRMMATNRTJ_Service zfmcrmmatnrtj_Service = new ZFMCRMMATNRTJ_Service();
    	ZFMCRMMATNRTJ port = zfmcrmmatnrtj_Service.getBinding();
    	BindingProvider bp = (BindingProvider) port;
        Map<String, Object> context = bp.getRequestContext();
        context.put(BindingProvider.USERNAME_PROPERTY, Constants.USERNAME);
        context.put(BindingProvider.PASSWORD_PROPERTY, Constants.PASSWORD);
        //上线时生成环境地址需要进行替换  ，如果根据生产wsdl生成代理类  可以不进行替换
        // context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"http://SAPD02.HITEVISION.COM:8090/sap/bc/srt/rfc/sap/zfm_as_0025/300/zfm_as_0025/binding");
        TableOfZcrmMatnrTjS1 tableOfZcrmMatnrTjS1 = new  TableOfZcrmMatnrTjS1();
        javax.xml.ws.Holder<TableOfZcrmMatnrTjS1> tZfgCrmMatnrS=new   javax.xml.ws.Holder<TableOfZcrmMatnrTjS1>(tableOfZcrmMatnrTjS1);
		//执行webservice 方法
		port.zfmCrmMatnrTj(tZfgCrmMatnrS, iCpbm);
		//获取返回值
		List<ZcrmMatnrTjS1> item = tZfgCrmMatnrS.value.getItem();
		/**构建返回数据*/
    	JSONObject result = new JSONObject();
    	if(null==item||item.size()==0){
    		result.put("status", -1);
    		result.put("msg", "未查询到组件信息");
    		return result.toString();
    	}
    	JSONArray bkProduct = new JSONArray();
//    	根据上送参数{销售组织、销售分支匹配产品} 过滤产品
    	List<Product> allproduct = PassUtils.doQuery(xszz_c, xsfz_c);
    	MatnrEntity matnrEntity;
    	for (ZcrmMatnrTjS1 zcrmMatnr : item) {
    		for (Product product : allproduct) {
				if(zcrmMatnr.getCpbm().equals(product.getProductName())){
					//根据产品编码
					matnrEntity = new MatnrEntity();
		    		//设置套件
					matnrEntity.setCpbm(zcrmMatnr.getCpbm());
					matnrEntity.setFlag(zcrmMatnr.getFlag());
					matnrEntity.setFlag1(zcrmMatnr.getFlag1());
					matnrEntity.setJgxz(zcrmMatnr.getJgxz());
					matnrEntity.setSlbl(zcrmMatnr.getSlbl());
					matnrEntity.setZbh(zcrmMatnr.getZbh());
					matnrEntity.setZhcpmc(zcrmMatnr.getZhcpmc());
					matnrEntity.setZhcpxhgg(zcrmMatnr.getZhcpxhgg());
					//设置产品
					matnrEntity.setJsonProduct(product);
					bkProduct.add(matnrEntity);
				}
			}
		}
    	result.put("status", 0);
		result.put("msg", "查询组件信息成功");
		result.put("records", bkProduct);
		logger.info(result.toString());
		return result.toString();
    }
/*    public static void main(String[] args) {
    	 webservice("10705LB00PJ1300","2800","1100");
	}*/
}
