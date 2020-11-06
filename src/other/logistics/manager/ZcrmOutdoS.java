
package other.logistics.manager;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>ZcrmOutdoS complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZcrmOutdoS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Erdat" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="Vbeln" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Sjrxm" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Sjrdh" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Address" type="{urn:sap-com:document:sap:rfc:functions}char100"/&gt;
 *         &lt;element name="Fhfs" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Fkfs" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Tsxq" type="{urn:sap-com:document:sap:rfc:functions}char100"/&gt;
 *         &lt;element name="ZcrmVbelnWl" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="ZcrmOutbStus" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="Lifnr" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
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
@XmlType(name = "ZcrmOutdoS", propOrder = {
    "erdat",
    "vbeln",
    "sjrxm",
    "sjrdh",
    "address",
    "fhfs",
    "fkfs",
    "tsxq",
    "zcrmVbelnWl",
    "zcrmOutbStus",
    "lifnr",
    "zcrmOutbHdbs"
})
public class ZcrmOutdoS {

    @XmlElement(name = "Erdat", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date erdat;
    @XmlElement(name = "Vbeln", required = true)
    protected String vbeln;
    @XmlElement(name = "Sjrxm", required = true)
    protected String sjrxm;
    @XmlElement(name = "Sjrdh", required = true)
    protected String sjrdh;
    @XmlElement(name = "Address", required = true)
    protected String address;
    @XmlElement(name = "Fhfs", required = true)
    protected String fhfs;
    @XmlElement(name = "Fkfs", required = true)
    protected String fkfs;
    @XmlElement(name = "Tsxq", required = true)
    protected String tsxq;
    @XmlElement(name = "ZcrmVbelnWl", required = true)
    protected String zcrmVbelnWl;
    @XmlElement(name = "ZcrmOutbStus", required = true)
    protected String zcrmOutbStus;
    @XmlElement(name = "Lifnr", required = true)
    protected String lifnr;
    @XmlElement(name = "ZcrmOutbHdbs", required = true)
    protected String zcrmOutbHdbs;

    /**
     * 获取erdat属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getErdat() {
        return erdat;
    }

    /**
     * 设置erdat属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErdat(Date value) {
        this.erdat = value;
    }

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
     * 获取sjrxm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSjrxm() {
        return sjrxm;
    }

    /**
     * 设置sjrxm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSjrxm(String value) {
        this.sjrxm = value;
    }

    /**
     * 获取sjrdh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSjrdh() {
        return sjrdh;
    }

    /**
     * 设置sjrdh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSjrdh(String value) {
        this.sjrdh = value;
    }

    /**
     * 获取address属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置address属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * 获取fhfs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFhfs() {
        return fhfs;
    }

    /**
     * 设置fhfs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFhfs(String value) {
        this.fhfs = value;
    }

    /**
     * 获取fkfs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFkfs() {
        return fkfs;
    }

    /**
     * 设置fkfs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFkfs(String value) {
        this.fkfs = value;
    }

    /**
     * 获取tsxq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTsxq() {
        return tsxq;
    }

    /**
     * 设置tsxq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTsxq(String value) {
        this.tsxq = value;
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
     * 获取lifnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLifnr() {
        return lifnr;
    }

    /**
     * 设置lifnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLifnr(String value) {
        this.lifnr = value;
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
