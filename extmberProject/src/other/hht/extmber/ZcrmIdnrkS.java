
package other.hht.extmber;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ZcrmIdnrkS complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZcrmIdnrkS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZcrmTjlx" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="ZcrmCpbm" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="ZcrmIdnrk" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="Menge" type="{urn:sap-com:document:sap:rfc:functions}quantum13.3"/&gt;
 *         &lt;element name="Price" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/&gt;
 *         &lt;element name="NoCheck" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZcrmIdnrkS", propOrder = {
    "zcrmTjlx",
    "zcrmCpbm",
    "zcrmIdnrk",
    "menge",
    "price",
    "noCheck"
})
public class ZcrmIdnrkS {

    @XmlElement(name = "ZcrmTjlx", required = true)
    protected String zcrmTjlx;
    @XmlElement(name = "ZcrmCpbm", required = true)
    protected String zcrmCpbm;
    @XmlElement(name = "ZcrmIdnrk", required = true)
    protected String zcrmIdnrk;
    @XmlElement(name = "Menge", required = true)
    protected BigDecimal menge;
    @XmlElement(name = "Price", required = true)
    protected BigDecimal price;
    @XmlElement(name = "NoCheck", required = true)
    protected String noCheck;

    /**
     * 获取zcrmTjlx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmTjlx() {
        return zcrmTjlx;
    }

    /**
     * 设置zcrmTjlx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmTjlx(String value) {
        this.zcrmTjlx = value;
    }

    /**
     * 获取zcrmCpbm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmCpbm() {
        return zcrmCpbm;
    }

    /**
     * 设置zcrmCpbm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmCpbm(String value) {
        this.zcrmCpbm = value;
    }

    /**
     * 获取zcrmIdnrk属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmIdnrk() {
        return zcrmIdnrk;
    }

    /**
     * 设置zcrmIdnrk属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmIdnrk(String value) {
        this.zcrmIdnrk = value;
    }

    /**
     * 获取menge属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMenge() {
        return menge;
    }

    /**
     * 设置menge属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMenge(BigDecimal value) {
        this.menge = value;
    }

    /**
     * 获取price属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置price属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * 获取noCheck属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoCheck() {
        return noCheck;
    }

    /**
     * 设置noCheck属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoCheck(String value) {
        this.noCheck = value;
    }

}
