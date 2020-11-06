
package other.logistics.manager;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>ZcrmOutdmS complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZcrmOutdmS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Vbeln" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="ZcrmVbelnWl" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="ZcrmNewZtd" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *         &lt;element name="ZcrmOutbStus" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="ZcrmOutbCzr" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="ZcrmOutbSjdat" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="ZcrmOutbQsr" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="ZcrmOutbHdbs" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZcrmOutdmS", propOrder = {
    "vbeln",
    "zcrmVbelnWl",
    "zcrmNewZtd",
    "zcrmOutbStus",
    "zcrmOutbCzr",
    "zcrmOutbSjdat",
    "zcrmOutbQsr",
    "zcrmOutbHdbs"
})
public class ZcrmOutdmS {

    @XmlElement(name = "Vbeln", required = true)
    protected String vbeln;
    @XmlElement(name = "ZcrmVbelnWl", required = true)
    protected String zcrmVbelnWl;
    @XmlElement(name = "ZcrmNewZtd", required = true)
    protected String zcrmNewZtd;
    @XmlElement(name = "ZcrmOutbStus", required = true)
    protected String zcrmOutbStus;
    @XmlElement(name = "ZcrmOutbCzr", required = true)
    protected String zcrmOutbCzr;
    @XmlElement(name = "ZcrmOutbSjdat", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date zcrmOutbSjdat;
    @XmlElement(name = "ZcrmOutbQsr", required = true)
    protected String zcrmOutbQsr;
    @XmlElement(name = "ZcrmOutbHdbs", required = true)
    protected String zcrmOutbHdbs;

    /**
     * 获取vbeln属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVbeln() {
        return vbeln;
    }

    /**
     * 设置vbeln属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVbeln(String value) {
        this.vbeln = value;
    }

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
     * 获取zcrmNewZtd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmNewZtd() {
        return zcrmNewZtd;
    }

    /**
     * 设置zcrmNewZtd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmNewZtd(String value) {
        this.zcrmNewZtd = value;
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
     * 获取zcrmOutbCzr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmOutbCzr() {
        return zcrmOutbCzr;
    }

    /**
     * 设置zcrmOutbCzr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmOutbCzr(String value) {
        this.zcrmOutbCzr = value;
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

    /**
     * 获取zcrmOutbHdbs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmOutbHdbs() {
        return zcrmOutbHdbs;
    }

    /**
     * 设置zcrmOutbHdbs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmOutbHdbs(String value) {
        this.zcrmOutbHdbs = value;
    }

}
