
package other.hht.logistics;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>ZcrmOutpo4S complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZcrmOutpo4S"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZcrmVbelnWl" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="ZcrmOutbStus" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="ZcrmOutbSjdat" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="ZcrmOutbQsr" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZcrmOutpo4S", propOrder = {
    "zcrmVbelnWl",
    "zcrmOutbStus",
    "zcrmOutbSjdat",
    "zcrmOutbQsr"
})
public class ZcrmOutpo4S {

    @XmlElement(name = "ZcrmVbelnWl", required = true)
    protected String zcrmVbelnWl;
    @XmlElement(name = "ZcrmOutbStus", required = true)
    protected String zcrmOutbStus;
    @XmlElement(name = "ZcrmOutbSjdat", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date zcrmOutbSjdat;
    @XmlElement(name = "ZcrmOutbQsr", required = true)
    protected String zcrmOutbQsr;

    /**
     * 获取zcrmVbelnWl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmVbelnWl() {
        return zcrmVbelnWl;
    }

    /**
     * 设置zcrmVbelnWl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmVbelnWl(String value) {
        this.zcrmVbelnWl = value;
    }

    /**
     * 获取zcrmOutbStus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmOutbStus() {
        return zcrmOutbStus;
    }

    /**
     * 设置zcrmOutbStus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmOutbStus(String value) {
        this.zcrmOutbStus = value;
    }

    /**
     * 获取zcrmOutbSjdat属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getZcrmOutbSjdat() {
        return zcrmOutbSjdat;
    }

    /**
     * 设置zcrmOutbSjdat属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmOutbSjdat(Date value) {
        this.zcrmOutbSjdat = value;
    }

    /**
     * 获取zcrmOutbQsr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmOutbQsr() {
        return zcrmOutbQsr;
    }

    /**
     * 设置zcrmOutbQsr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmOutbQsr(String value) {
        this.zcrmOutbQsr = value;
    }

}
