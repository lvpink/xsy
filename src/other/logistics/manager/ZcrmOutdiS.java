
package other.logistics.manager;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>ZcrmOutdiS complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZcrmOutdiS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Lifnr" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="Vbeln" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="ZcrmQslx" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
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
@XmlType(name = "ZcrmOutdiS", propOrder = {
    "lifnr",
    "vbeln",
    "zcrmQslx",
    "begda",
    "endda"
})
public class ZcrmOutdiS {

    @XmlElement(name = "Lifnr", required = true)
    protected String lifnr;
    @XmlElement(name = "Vbeln", required = true)
    protected String vbeln;
    @XmlElement(name = "ZcrmQslx", required = true)
    protected String zcrmQslx;
    @XmlElement(name = "Begda", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date begda;
    @XmlElement(name = "Endda", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date endda;

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
     * 获取zcrmQslx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZcrmQslx() {
        return zcrmQslx;
    }

    /**
     * 设置zcrmQslx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZcrmQslx(String value) {
        this.zcrmQslx = value;
    }

    /**
     * 获取begda属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getBegda() {
        return begda;
    }

    /**
     * 设置begda属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBegda(Date value) {
        this.begda = value;
    }

    /**
     * 获取endda属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getEndda() {
        return endda;
    }

    /**
     * 设置endda属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndda(Date value) {
        this.endda = value;
    }

}
