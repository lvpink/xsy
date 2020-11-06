
package other.hht.contract;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>ZcrmContractIs complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZcrmContractIs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZcrmVbelnHt" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Lifnr" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Begda" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *         &lt;element name="Endda" type="{urn:sap-com:document:sap:rfc:functions}date"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZcrmContractIs", propOrder = {
    "zcrmVbelnHt",
    "lifnr",
    "begda",
    "endda"
})
public class ZcrmContractIs {

    @XmlElement(name = "ZcrmVbelnHt", required = true)
    protected String zcrmVbelnHt;
    @XmlElement(name = "Lifnr", required = true)
    protected String lifnr;
    @XmlElement(name = "Begda", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar begda;
    @XmlElement(name = "Endda", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endda;

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
     * 获取begda属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBegda() {
        return begda;
    }

    /**
     * 设置begda属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBegda(XMLGregorianCalendar value) {
        this.begda = value;
    }

    /**
     * 获取endda属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndda() {
        return endda;
    }

    /**
     * 设置endda属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndda(XMLGregorianCalendar value) {
        this.endda = value;
    }

}
