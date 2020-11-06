package other.hht.extmber;

import java.math.BigDecimal;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.Product;

/**
 * 套件组合实体类
 * @author xsy
 *
 */
public class ExtmberEntity {
	private String zcrmTjlx;
    private String zcrmCpbm;
    private String zcrmIdnrk;
    private BigDecimal menge;
    private BigDecimal price;
    private String noCheck;
    private String jsonProduct;
    
//    虚拟物料标识
	public String getZcrmTjlx() {
		return zcrmTjlx;
	}
	public void setZcrmTjlx(String zcrmTjlx) {
		this.zcrmTjlx = zcrmTjlx;
	}
	public String getZcrmCpbm() {
		return zcrmCpbm;
	}
	public void setZcrmCpbm(String zcrmCpbm) {
		this.zcrmCpbm = zcrmCpbm;
	}
	public String getZcrmIdnrk() {
		return zcrmIdnrk;
	}
	public void setZcrmIdnrk(String zcrmIdnrk) {
		this.zcrmIdnrk = zcrmIdnrk;
	}
	public BigDecimal getMenge() {
		return menge;
	}
	public void setMenge(BigDecimal menge) {
		this.menge = menge;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getNoCheck() {
		return noCheck;
	}
	public void setNoCheck(String noCheck) {
		this.noCheck = noCheck;
	}
	public String getJsonProduct() {
		return jsonProduct;
	}
	public void setJsonProduct(Product product) {
		String jsonString = JSONObject.toJSONString(product);
		JSONObject parseObject = JSONObject.parseObject(jsonString);
		parseObject.remove("apiKey");
		parseObject.remove("_updateProperties");
		parseObject.remove("_properties");
		parseObject.remove("attributeNames");
		this.jsonProduct = parseObject.toJSONString();
	}
}
