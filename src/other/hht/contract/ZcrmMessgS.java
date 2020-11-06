
package other.hht.contract;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ZcrmMessgS complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZcrmMessgS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Type" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="Mesg" type="{urn:sap-com:document:sap:rfc:functions}char220"/&gt;
 *         &lt;element name="Belnr" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Gjahr" type="{urn:sap-com:document:sap:rfc:functions}numeric4"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZcrmMessgS", propOrder = {
    "type",
    "mesg",
    "belnr",
    "gjahr"
})
public class ZcrmMessgS {

    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "Mesg", required = true)
    protected String mesg;
    @XmlElement(name = "Belnr", required = true)
    protected String belnr;
    @XmlElement(name = "Gjahr", required = true)
    protected String gjahr;

    /**
     * 获取type属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * 设置type属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * 获取mesg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesg() {
        return mesg;
    }

    /**
     * 设置mesg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesg(String value) {
        this.mesg = value;
    }

    /**
     * 获取belnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBelnr() {
        return belnr;
    }

    /**
     * 设置belnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBelnr(String value) {
        this.belnr = value;
    }

    /**
     * 获取gjahr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGjahr() {
        return gjahr;
    }

    /**
     * 设置gjahr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGjahr(String value) {
        this.gjahr = value;
    }

}
