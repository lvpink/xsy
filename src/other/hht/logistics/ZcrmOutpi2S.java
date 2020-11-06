
package other.hht.logistics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ZcrmOutpi2S complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZcrmOutpi2S"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZcrmVbelnJh" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="VbelnVl" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZcrmOutpi2S", propOrder = {
    "zcrmVbelnJh",
    "vbelnVl"
})
public class ZcrmOutpi2S {

    @XmlElement(name = "ZcrmVbelnJh", required = true)
    protected String zcrmVbelnJh;
    @XmlElement(name = "VbelnVl", required = true)
    protected String vbelnVl;

    /**
     * 获取zcrmVbelnJh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmVbelnJh() {
        return zcrmVbelnJh;
    }

    /**
     * 设置zcrmVbelnJh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmVbelnJh(String value) {
        this.zcrmVbelnJh = value;
    }

    /**
     * 获取vbelnVl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVbelnVl() {
        return vbelnVl;
    }

    /**
     * 设置vbelnVl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVbelnVl(String value) {
        this.vbelnVl = value;
    }

}
