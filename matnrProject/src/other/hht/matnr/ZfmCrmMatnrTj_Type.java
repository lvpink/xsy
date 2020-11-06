
package other.hht.matnr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EtItem" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZcrmMatnrTjS1" minOccurs="0"/&gt;
 *         &lt;element name="ICpbm" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "etItem",
    "iCpbm"
})
@XmlRootElement(name = "ZfmCrmMatnrTj")
public class ZfmCrmMatnrTj_Type {

    @XmlElement(name = "EtItem")
    protected TableOfZcrmMatnrTjS1 etItem;
    @XmlElement(name = "ICpbm", required = true)
    protected String iCpbm;

    /**
     * 获取etItem属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TableOfZcrmMatnrTjS1 }
     *     
     */
    public TableOfZcrmMatnrTjS1 getEtItem() {
        return etItem;
    }

    /**
     * 设置etItem属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZcrmMatnrTjS1 }
     *     
     */
    public void setEtItem(TableOfZcrmMatnrTjS1 value) {
        this.etItem = value;
    }

    /**
     * 获取iCpbm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICpbm() {
        return iCpbm;
    }

    /**
     * 设置iCpbm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICpbm(String value) {
        this.iCpbm = value;
    }

}
