
package other.hht.logistics;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>ZcrmOutpo2S complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZcrmOutpo2S"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZcrmVbelnJh" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="VbelnVl" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="DatumVl" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="UzeitVl" type="{urn:sap-com:document:sap:rfc:functions}time"/&gt;
 *         &lt;element name="Mblnr" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="DatumJp" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="UzeitJp" type="{urn:sap-com:document:sap:rfc:functions}time"/&gt;
 *         &lt;element name="ZcrmVbelnWl" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="ZcrmWldDatum" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="ZcrmWldUzeit" type="{urn:sap-com:document:sap:rfc:functions}time"/&gt;
 *         &lt;element name="ZcrmNewZtd" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *         &lt;element name="ZcrmNewDatum" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="ZcrmNewUzeit" type="{urn:sap-com:document:sap:rfc:functions}time"/&gt;
 *         &lt;element name="ZcrmOutbQsr" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="ZcrmOutbDatum" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="ZcrmOutbUzeit" type="{urn:sap-com:document:sap:rfc:functions}time"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZcrmOutpo2S", propOrder = {
    "zcrmVbelnJh",
    "vbelnVl",
    "datumVl",
    "uzeitVl",
    "mblnr",
    "datumJp",
    "uzeitJp",
    "zcrmVbelnWl",
    "zcrmWldDatum",
    "zcrmWldUzeit",
    "zcrmNewZtd",
    "zcrmNewDatum",
    "zcrmNewUzeit",
    "zcrmOutbQsr",
    "zcrmOutbDatum",
    "zcrmOutbUzeit"
})
public class ZcrmOutpo2S {

    @XmlElement(name = "ZcrmVbelnJh", required = true)
    protected String zcrmVbelnJh;
    @XmlElement(name = "VbelnVl", required = true)
    protected String vbelnVl;
    @XmlElement(name = "DatumVl", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date datumVl;
    @XmlElement(name = "UzeitVl", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar uzeitVl;
    @XmlElement(name = "Mblnr", required = true)
    protected String mblnr;
    @XmlElement(name = "DatumJp", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date datumJp;
    @XmlElement(name = "UzeitJp", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar uzeitJp;
    @XmlElement(name = "ZcrmVbelnWl", required = true)
    protected String zcrmVbelnWl;
    @XmlElement(name = "ZcrmWldDatum", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date zcrmWldDatum;
    @XmlElement(name = "ZcrmWldUzeit", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar zcrmWldUzeit;
    @XmlElement(name = "ZcrmNewZtd", required = true)
    protected String zcrmNewZtd;
    @XmlElement(name = "ZcrmNewDatum", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date zcrmNewDatum;
    @XmlElement(name = "ZcrmNewUzeit", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar zcrmNewUzeit;
    @XmlElement(name = "ZcrmOutbQsr", required = true)
    protected String zcrmOutbQsr;
    @XmlElement(name = "ZcrmOutbDatum", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date zcrmOutbDatum;
    @XmlElement(name = "ZcrmOutbUzeit", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar zcrmOutbUzeit;

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
     * 获取datumVl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getDatumVl() {
        return datumVl;
    }

    /**
     * 设置datumVl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumVl(Date value) {
        this.datumVl = value;
    }

    /**
     * 获取uzeitVl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUzeitVl() {
        return uzeitVl;
    }

    /**
     * 设置uzeitVl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUzeitVl(XMLGregorianCalendar value) {
        this.uzeitVl = value;
    }

    /**
     * 获取mblnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMblnr() {
        return mblnr;
    }

    /**
     * 设置mblnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMblnr(String value) {
        this.mblnr = value;
    }

    /**
     * 获取datumJp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getDatumJp() {
        return datumJp;
    }

    /**
     * 设置datumJp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumJp(Date value) {
        this.datumJp = value;
    }

    /**
     * 获取uzeitJp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUzeitJp() {
        return uzeitJp;
    }

    /**
     * 设置uzeitJp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUzeitJp(XMLGregorianCalendar value) {
        this.uzeitJp = value;
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
     * 获取zcrmWldDatum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getZcrmWldDatum() {
        return zcrmWldDatum;
    }

    /**
     * 设置zcrmWldDatum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmWldDatum(Date value) {
        this.zcrmWldDatum = value;
    }

    /**
     * 获取zcrmWldUzeit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getZcrmWldUzeit() {
        return zcrmWldUzeit;
    }

    /**
     * 设置zcrmWldUzeit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setZcrmWldUzeit(XMLGregorianCalendar value) {
        this.zcrmWldUzeit = value;
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
     * 获取zcrmNewDatum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getZcrmNewDatum() {
        return zcrmNewDatum;
    }

    /**
     * 设置zcrmNewDatum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmNewDatum(Date value) {
        this.zcrmNewDatum = value;
    }

    /**
     * 获取zcrmNewUzeit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getZcrmNewUzeit() {
        return zcrmNewUzeit;
    }

    /**
     * 设置zcrmNewUzeit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setZcrmNewUzeit(XMLGregorianCalendar value) {
        this.zcrmNewUzeit = value;
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
     * 获取zcrmOutbDatum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getZcrmOutbDatum() {
        return zcrmOutbDatum;
    }

    /**
     * 设置zcrmOutbDatum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmOutbDatum(Date value) {
        this.zcrmOutbDatum = value;
    }

    /**
     * 获取zcrmOutbUzeit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getZcrmOutbUzeit() {
        return zcrmOutbUzeit;
    }

    /**
     * 设置zcrmOutbUzeit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setZcrmOutbUzeit(XMLGregorianCalendar value) {
        this.zcrmOutbUzeit = value;
    }

}
