
package other.hht.contract;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>ZcrmContractOs complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZcrmContractOs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZcrmVbelnHt" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="ZcrmPosnrHt" type="{urn:sap-com:document:sap:rfc:functions}numeric6"/&gt;
 *         &lt;element name="Audat" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="Kunnr" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Kname" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Lifnr" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Cpbm" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="Cpmc" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="ZcrmTjlx" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="ZcrmTjbm" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="ZcrmTjms" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="Zmeng" type="{urn:sap-com:document:sap:rfc:functions}quantum13.3"/&gt;
 *         &lt;element name="Rfmng" type="{urn:sap-com:document:sap:rfc:functions}quantum13.3"/&gt;
 *         &lt;element name="Stats" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZcrmContractOs", propOrder = {
    "zcrmVbelnHt",
    "zcrmPosnrHt",
    "audat",
    "kunnr",
    "kname",
    "lifnr",
    "cpbm",
    "cpmc",
    "zcrmTjlx",
    "zcrmTjbm",
    "zcrmTjms",
    "zmeng",
    "rfmng",
    "stats"
})
public class ZcrmContractOs {

    @XmlElement(name = "ZcrmVbelnHt", required = true)
    protected String zcrmVbelnHt;
    @XmlElement(name = "ZcrmPosnrHt", required = true)
    protected String zcrmPosnrHt;
    @XmlElement(name = "Audat", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar audat;
    @XmlElement(name = "Kunnr", required = true)
    protected String kunnr;
    @XmlElement(name = "Kname", required = true)
    protected String kname;
    @XmlElement(name = "Lifnr", required = true)
    protected String lifnr;
    @XmlElement(name = "Cpbm", required = true)
    protected String cpbm;
    @XmlElement(name = "Cpmc", required = true)
    protected String cpmc;
    @XmlElement(name = "ZcrmTjlx", required = true)
    protected String zcrmTjlx;
    @XmlElement(name = "ZcrmTjbm", required = true)
    protected String zcrmTjbm;
    @XmlElement(name = "ZcrmTjms", required = true)
    protected String zcrmTjms;
    @XmlElement(name = "Zmeng", required = true)
    protected BigDecimal zmeng;
    @XmlElement(name = "Rfmng", required = true)
    protected BigDecimal rfmng;
    @XmlElement(name = "Stats", required = true)
    protected String stats;

    /**
     * 获取zcrmVbelnHt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmVbelnHt() {
        return zcrmVbelnHt;
    }

    /**
     * 设置zcrmVbelnHt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmVbelnHt(String value) {
        this.zcrmVbelnHt = value;
    }

    /**
     * 获取zcrmPosnrHt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmPosnrHt() {
        return zcrmPosnrHt;
    }

    /**
     * 设置zcrmPosnrHt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmPosnrHt(String value) {
        this.zcrmPosnrHt = value;
    }

    /**
     * 获取audat属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAudat() {
        return audat;
    }

    /**
     * 设置audat属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAudat(XMLGregorianCalendar value) {
        this.audat = value;
    }

    /**
     * 获取kunnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKunnr() {
        return kunnr;
    }

    /**
     * 设置kunnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKunnr(String value) {
        this.kunnr = value;
    }

    /**
     * 获取kname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKname() {
        return kname;
    }

    /**
     * 设置kname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKname(String value) {
        this.kname = value;
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
     * 获取cpmc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpmc() {
        return cpmc;
    }

    /**
     * 设置cpmc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpmc(String value) {
        this.cpmc = value;
    }

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
     * 获取zcrmTjbm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmTjbm() {
        return zcrmTjbm;
    }

    /**
     * 设置zcrmTjbm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmTjbm(String value) {
        this.zcrmTjbm = value;
    }

    /**
     * 获取zcrmTjms属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmTjms() {
        return zcrmTjms;
    }

    /**
     * 设置zcrmTjms属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmTjms(String value) {
        this.zcrmTjms = value;
    }

    /**
     * 获取zmeng属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getZmeng() {
        return zmeng;
    }

    /**
     * 设置zmeng属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setZmeng(BigDecimal value) {
        this.zmeng = value;
    }

    /**
     * 获取rfmng属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRfmng() {
        return rfmng;
    }

    /**
     * 设置rfmng属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRfmng(BigDecimal value) {
        this.rfmng = value;
    }

    /**
     * 获取stats属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStats() {
        return stats;
    }

    /**
     * 设置stats属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStats(String value) {
        this.stats = value;
    }

}
