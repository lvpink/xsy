package other.hht.matnr;

import java.math.BigDecimal;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.data.model.Product;
/**
 * 套件组合实体类
 * @author xsy
 *
 */
public class MatnrEntity {
	private String zbh;
    private String zhcpmc;
    private String zhcpxhgg;
    private String cpbm;
    private BigDecimal slbl;
    private String jgxz;
    private String flag;
    private String flag1;
    private String jsonProduct;
    /*private String xSZZ__c;//销售组织
    private String xSFZ__c;//销售分支
    private String productName;//产品编码
    private String description;//产品描述
    private String tJBS__c;//套件标识
    private String zHBS__c;// 组合标识
*///    虚拟物料标识
	public String getZbh() {
		return zbh;
	}
	public void setZbh(String zbh) {
		this.zbh = zbh;
	}
	public String getZhcpmc() {
		return zhcpmc;
	}
	public void setZhcpmc(String zhcpmc) {
		this.zhcpmc = zhcpmc;
	}
	public String getZhcpxhgg() {
		return zhcpxhgg;
	}
	public void setZhcpxhgg(String zhcpxhgg) {
		this.zhcpxhgg = zhcpxhgg;
	}
	public String getCpbm() {
		return cpbm;
	}
	public void setCpbm(String cpbm) {
		this.cpbm = cpbm;
	}
	public BigDecimal getSlbl() {
		return slbl;
	}
	public void setSlbl(BigDecimal bigDecimal) {
		this.slbl = bigDecimal;
	}
	public String getJgxz() {
		return jgxz;
	}
	public void setJgxz(String jgxz) {
		this.jgxz = jgxz;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getFlag1() {
		return flag1;
	}
	public void setFlag1(String flag1) {
		this.flag1 = flag1;
	}
	public String getJsonProduct() {
		return jsonProduct;
	}
	public void setJsonProduct(Product product) {
		String jsonString = JSONObject.toJSONString(product);
		JSONObject parseObject = JSONObject.parseObject(jsonString);
//		parseObject.remove("id");
		parseObject.remove("apiKey");
		parseObject.remove("_updateProperties");
		parseObject.remove("_properties");
		parseObject.remove("attributeNames");
		this.jsonProduct = parseObject.toJSONString();
	}
	
}
