
package other.hht.matnr;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ZcrmMatnrTjS1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZcrmMatnrTjS1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Zbh" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="Zhcpmc" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="Zhcpxhgg" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="Cpbm" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="Slbl" type="{urn:sap-com:document:sap:rfc:functions}quantum2.0"/&gt;
 *         &lt;element name="Jgxz" type="{urn:sap-com:document:sap:rfc:functions}char15"/&gt;
 *         &lt;element name="Flag" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="Flag1" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZcrmMatnrTjS1", propOrder = {
    "zbh",
    "zhcpmc",
    "zhcpxhgg",
    "cpbm",
    "slbl",
    "jgxz",
    "flag",
    "flag1"
})
public class ZcrmMatnrTjS1 {

    @XmlElement(name = "Zbh", required = true)
    protected String zbh;
    @XmlElement(name = "Zhcpmc", required = true)
    protected String zhcpmc;
    @XmlElement(name = "Zhcpxhgg", required = true)
    protected String zhcpxhgg;
    @XmlElement(name = "Cpbm", required = true)
    protected String cpbm;
    @XmlElement(name = "Slbl", required = true)
    protected BigDecimal slbl;
    @XmlElement(name = "Jgxz", required = true)
    protected String jgxz;
    @XmlElement(name = "Flag", required = true)
    protected String flag;
    @XmlElement(name = "Flag1", required = true)
    protected String flag1;

    /**
     * 获取zbh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZbh() {
        return zbh;
    }

    /**
     * 设置zbh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZbh(String value) {
        this.zbh = value;
    }

    /**
     * 获取zhcpmc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZhcpmc() {
        return zhcpmc;
    }

    /**
     * 设置zhcpmc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZhcpmc(String value) {
        this.zhcpmc = value;
    }

    /**
     * 获取zhcpxhgg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZhcpxhgg() {
        return zhcpxhgg;
    }

    /**
     * 设置zhcpxhgg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZhcpxhgg(String value) {
        this.zhcpxhgg = value;
    }

    /**
     * 获取cpbm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpbm() {
        return cpbm;
    }

    /**
     * 设置cpbm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpbm(String value) {
        this.cpbm = value;
    }

    /**
     * 获取slbl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSlbl() {
        return slbl;
    }

    /**
     * 设置slbl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSlbl(BigDecimal value) {
        this.slbl = value;
    }

    /**
     * 获取jgxz属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJgxz() {
        return jgxz;
    }

    /**
     * 设置jgxz属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJgxz(String value) {
        this.jgxz = value;
    }

    /**
     * 获取flag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置flag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag(String value) {
        this.flag = value;
    }

    /**
     * 获取flag1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag1() {
        return flag1;
    }

    /**
     * 设置flag1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag1(String value) {
        this.flag1 = value;
    }

}
