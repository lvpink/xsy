
package other.hht.product;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>ZfgCrmMatnrS complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZfgCrmMatnrS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Cpbm" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="Vkorg" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="Xslx" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="Vkbur" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="Cpms" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="Hpmc" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="Xhgg" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="Zjbx" type="{urn:sap-com:document:sap:rfc:functions}numeric4"/&gt;
 *         &lt;element name="Hcbx" type="{urn:sap-com:document:sap:rfc:functions}numeric4"/&gt;
 *         &lt;element name="Zcb1f" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/&gt;
 *         &lt;element name="Zcb2f" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/&gt;
 *         &lt;element name="Zcb3f" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/&gt;
 *         &lt;element name="Sname" type="{urn:sap-com:document:sap:rfc:functions}char8"/&gt;
 *         &lt;element name="Fname" type="{urn:sap-com:document:sap:rfc:functions}char8"/&gt;
 *         &lt;element name="Zname" type="{urn:sap-com:document:sap:rfc:functions}char8"/&gt;
 *         &lt;element name="Fzjlsp" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/&gt;
 *         &lt;element name="Dqjlsp" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/&gt;
 *         &lt;element name="Htmsj" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/&gt;
 *         &lt;element name="Sybzsp" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/&gt;
 *         &lt;element name="Yyzsp" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/&gt;
 *         &lt;element name="Jtzcsp" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/&gt;
 *         &lt;element name="Htzdj" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/&gt;
 *         &lt;element name="Htzds" type="{urn:sap-com:document:sap:rfc:functions}quantum13.3"/&gt;
 *         &lt;element name="Waers" type="{urn:sap-com:document:sap:rfc:functions}cuky5"/&gt;
 *         &lt;element name="Taxrate" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="Zfdbs" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="Zzhbs" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="Ztjbs" type="{urn:sap-com:document:sap:soap:functions:mc-style}char1"/&gt;
 *         &lt;element name="Uname" type="{urn:sap-com:document:sap:rfc:functions}char12"/&gt;
 *         &lt;element name="Datum" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="Uzeit" type="{urn:sap-com:document:sap:soap:functions:mc-style}time"/&gt;
 *         &lt;element name="Sneme" type="{urn:sap-com:document:sap:rfc:functions}char12"/&gt;
 *         &lt;element name="Sdatu" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="Suzei" type="{urn:sap-com:document:sap:soap:functions:mc-style}time"/&gt;
 *         &lt;element name="Dflag" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="Zupdated" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZfgCrmMatnrS", propOrder = {
    "cpbm",
    "vkorg",
    "xslx",
    "vkbur",
    "cpms",
    "hpmc",
    "xhgg",
    "zjbx",
    "hcbx",
    "zcb1F",
    "zcb2F",
    "zcb3F",
    "sname",
    "fname",
    "zname",
    "fzjlsp",
    "dqjlsp",
    "htmsj",
    "sybzsp",
    "yyzsp",
    "jtzcsp",
    "htzdj",
    "htzds",
    "waers",
    "taxrate",
    "zfdbs",
    "zzhbs",
    "ztjbs",
    "uname",
    "datum",
    "uzeit",
    "sneme",
    "sdatu",
    "suzei",
    "dflag",
    "zupdated"
})
public class ZfgCrmMatnrS {

    @XmlElement(name = "Cpbm", required = true)
    protected String cpbm;
    @XmlElement(name = "Vkorg", required = true)
    protected String vkorg;
    @XmlElement(name = "Xslx", required = true)
    protected String xslx;
    @XmlElement(name = "Vkbur", required = true)
    protected String vkbur;
    @XmlElement(name = "Cpms", required = true)
    protected String cpms;
    @XmlElement(name = "Hpmc", required = true)
    protected String hpmc;
    @XmlElement(name = "Xhgg", required = true)
    protected String xhgg;
    @XmlElement(name = "Zjbx", required = true)
    protected String zjbx;
    @XmlElement(name = "Hcbx", required = true)
    protected String hcbx;
    @XmlElement(name = "Zcb1f", required = true)
    protected BigDecimal zcb1F;
    @XmlElement(name = "Zcb2f", required = true)
    protected BigDecimal zcb2F;
    @XmlElement(name = "Zcb3f", required = true)
    protected BigDecimal zcb3F;
    @XmlElement(name = "Sname", required = true)
    protected String sname;
    @XmlElement(name = "Fname", required = true)
    protected String fname;
    @XmlElement(name = "Zname", required = true)
    protected String zname;
    @XmlElement(name = "Fzjlsp", required = true)
    protected BigDecimal fzjlsp;
    @XmlElement(name = "Dqjlsp", required = true)
    protected BigDecimal dqjlsp;
    @XmlElement(name = "Htmsj", required = true)
    protected BigDecimal htmsj;
    @XmlElement(name = "Sybzsp", required = true)
    protected BigDecimal sybzsp;
    @XmlElement(name = "Yyzsp", required = true)
    protected BigDecimal yyzsp;
    @XmlElement(name = "Jtzcsp", required = true)
    protected BigDecimal jtzcsp;
    @XmlElement(name = "Htzdj", required = true)
    protected BigDecimal htzdj;
    @XmlElement(name = "Htzds", required = true)
    protected BigDecimal htzds;
    @XmlElement(name = "Waers", required = true)
    protected String waers;
    @XmlElement(name = "Taxrate")
    @XmlSchemaType(name = "unsignedByte")
    protected short taxrate;
    @XmlElement(name = "Zfdbs", required = true)
    protected String zfdbs;
    @XmlElement(name = "Zzhbs", required = true)
    protected String zzhbs;
    @XmlElement(name = "Ztjbs", required = true)
    protected String ztjbs;
    @XmlElement(name = "Uname", required = true)
    protected String uname;
    @XmlElement(name = "Datum", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(name = "Uzeit", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar uzeit;
    @XmlElement(name = "Sneme", required = true)
    protected String sneme;
    @XmlElement(name = "Sdatu", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar sdatu;
    @XmlElement(name = "Suzei", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar suzei;
    @XmlElement(name = "Dflag", required = true)
    protected String dflag;
    @XmlElement(name = "Zupdated", required = true)
    protected String zupdated;

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
     * 获取vkorg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVkorg() {
        return vkorg;
    }

    /**
     * 设置vkorg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVkorg(String value) {
        this.vkorg = value;
    }

    /**
     * 获取xslx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXslx() {
        return xslx;
    }

    /**
     * 设置xslx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXslx(String value) {
        this.xslx = value;
    }

    /**
     * 获取vkbur属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVkbur() {
        return vkbur;
    }

    /**
     * 设置vkbur属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVkbur(String value) {
        this.vkbur = value;
    }

    /**
     * 获取cpms属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpms() {
        return cpms;
    }

    /**
     * 设置cpms属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpms(String value) {
        this.cpms = value;
    }

    /**
     * 获取hpmc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHpmc() {
        return hpmc;
    }

    /**
     * 设置hpmc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHpmc(String value) {
        this.hpmc = value;
    }

    /**
     * 获取xhgg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXhgg() {
        return xhgg;
    }

    /**
     * 设置xhgg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXhgg(String value) {
        this.xhgg = value;
    }

    /**
     * 获取zjbx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZjbx() {
        return zjbx;
    }

    /**
     * 设置zjbx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZjbx(String value) {
        this.zjbx = value;
    }

    /**
     * 获取hcbx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHcbx() {
        return hcbx;
    }

    /**
     * 设置hcbx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHcbx(String value) {
        this.hcbx = value;
    }

    /**
     * 获取zcb1F属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getZcb1F() {
        return zcb1F;
    }

    /**
     * 设置zcb1F属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setZcb1F(BigDecimal value) {
        this.zcb1F = value;
    }

    /**
     * 获取zcb2F属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getZcb2F() {
        return zcb2F;
    }

    /**
     * 设置zcb2F属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setZcb2F(BigDecimal value) {
        this.zcb2F = value;
    }

    /**
     * 获取zcb3F属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getZcb3F() {
        return zcb3F;
    }

    /**
     * 设置zcb3F属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setZcb3F(BigDecimal value) {
        this.zcb3F = value;
    }

    /**
     * 获取sname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSname() {
        return sname;
    }

    /**
     * 设置sname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSname(String value) {
        this.sname = value;
    }

    /**
     * 获取fname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFname() {
        return fname;
    }

    /**
     * 设置fname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFname(String value) {
        this.fname = value;
    }

    /**
     * 获取zname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZname() {
        return zname;
    }

    /**
     * 设置zname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZname(String value) {
        this.zname = value;
    }

    /**
     * 获取fzjlsp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFzjlsp() {
        return fzjlsp;
    }

    /**
     * 设置fzjlsp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFzjlsp(BigDecimal value) {
        this.fzjlsp = value;
    }

    /**
     * 获取dqjlsp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDqjlsp() {
        return dqjlsp;
    }

    /**
     * 设置dqjlsp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDqjlsp(BigDecimal value) {
        this.dqjlsp = value;
    }

    /**
     * 获取htmsj属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHtmsj() {
        return htmsj;
    }

    /**
     * 设置htmsj属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHtmsj(BigDecimal value) {
        this.htmsj = value;
    }

    /**
     * 获取sybzsp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSybzsp() {
        return sybzsp;
    }

    /**
     * 设置sybzsp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSybzsp(BigDecimal value) {
        this.sybzsp = value;
    }

    /**
     * 获取yyzsp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getYyzsp() {
        return yyzsp;
    }

    /**
     * 设置yyzsp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setYyzsp(BigDecimal value) {
        this.yyzsp = value;
    }

    /**
     * 获取jtzcsp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getJtzcsp() {
        return jtzcsp;
    }

    /**
     * 设置jtzcsp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setJtzcsp(BigDecimal value) {
        this.jtzcsp = value;
    }

    /**
     * 获取htzdj属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHtzdj() {
        return htzdj;
    }

    /**
     * 设置htzdj属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHtzdj(BigDecimal value) {
        this.htzdj = value;
    }

    /**
     * 获取htzds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHtzds() {
        return htzds;
    }

    /**
     * 设置htzds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHtzds(BigDecimal value) {
        this.htzds = value;
    }

    /**
     * 获取waers属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaers() {
        return waers;
    }

    /**
     * 设置waers属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaers(String value) {
        this.waers = value;
    }

    /**
     * 获取taxrate属性的值。
     * 
     */
    public short getTaxrate() {
        return taxrate;
    }

    /**
     * 设置taxrate属性的值。
     * 
     */
    public void setTaxrate(short value) {
        this.taxrate = value;
    }

    /**
     * 获取zfdbs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZfdbs() {
        return zfdbs;
    }

    /**
     * 设置zfdbs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZfdbs(String value) {
        this.zfdbs = value;
    }

    /**
     * 获取zzhbs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZzhbs() {
        return zzhbs;
    }

    /**
     * 设置zzhbs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZzhbs(String value) {
        this.zzhbs = value;
    }

    /**
     * 获取ztjbs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZtjbs() {
        return ztjbs;
    }

    /**
     * 设置ztjbs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZtjbs(String value) {
        this.ztjbs = value;
    }

    /**
     * 获取uname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUname() {
        return uname;
    }

    /**
     * 设置uname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUname(String value) {
        this.uname = value;
    }

    /**
     * 获取datum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * 设置datum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * 获取uzeit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUzeit() {
        return uzeit;
    }

    /**
     * 设置uzeit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUzeit(XMLGregorianCalendar value) {
        this.uzeit = value;
    }

    /**
     * 获取sneme属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSneme() {
        return sneme;
    }

    /**
     * 设置sneme属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSneme(String value) {
        this.sneme = value;
    }

    /**
     * 获取sdatu属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSdatu() {
        return sdatu;
    }

    /**
     * 设置sdatu属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSdatu(XMLGregorianCalendar value) {
        this.sdatu = value;
    }

    /**
     * 获取suzei属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSuzei() {
        return suzei;
    }

    /**
     * 设置suzei属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSuzei(XMLGregorianCalendar value) {
        this.suzei = value;
    }

    /**
     * 获取dflag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDflag() {
        return dflag;
    }

    /**
     * 设置dflag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDflag(String value) {
        this.dflag = value;
    }

    /**
     * 获取zupdated属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZupdated() {
        return zupdated;
    }

    /**
     * 设置zupdated属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZupdated(String value) {
        this.zupdated = value;
    }

}
