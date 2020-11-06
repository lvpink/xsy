
package other.hht.logistics;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>ZcrmOutpo1S complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZcrmOutpo1S"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZcrmVbelnJh" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="VbelnVl" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Budat" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="Lifnr" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Sjrxm" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Sjrdh" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Address" type="{urn:sap-com:document:sap:rfc:functions}char100"/&gt;
 *         &lt;element name="Fhfs" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Fkfs" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Tsxx" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="ZcrmVbelnWl" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="ZcrmOutbStus" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZcrmOutpo1S", propOrder = {
    "zcrmVbelnJh",
    "vbelnVl",
    "budat",
    "lifnr",
    "sjrxm",
    "sjrdh",
    "address",
    "fhfs",
    "fkfs",
    "tsxx",
    "zcrmVbelnWl",
    "zcrmOutbStus"
})
public class ZcrmOutpo1S {

    @XmlElement(name = "ZcrmVbelnJh", required = true)
    protected String zcrmVbelnJh;
    @XmlElement(name = "VbelnVl", required = true)
    protected String vbelnVl;
    @XmlElement(name = "Budat", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date budat;
    @XmlElement(name = "Lifnr", required = true)
    protected String lifnr;
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
    @XmlElement(name = "Tsxx", required = true)
    protected String tsxx;
    @XmlElement(name = "ZcrmVbelnWl", required = true)
    protected String zcrmVbelnWl;
    @XmlElement(name = "ZcrmOutbStus", required = true)
    protected String zcrmOutbStus;

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

    /**
     * 获取budat属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getBudat() {
        return budat;
    }

    /**
     * 设置budat属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBudat(Date value) {
        this.budat = value;
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
     * 获取tsxx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTsxx() {
        return tsxx;
    }

    /**
     * 设置tsxx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTsxx(String value) {
        this.tsxx = value;
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

}
