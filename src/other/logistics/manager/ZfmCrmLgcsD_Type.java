
package other.logistics.manager;

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
 *         &lt;element name="IFlag" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/&gt;
 *         &lt;element name="IsHead" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmOutdiS" minOccurs="0"/&gt;
 *         &lt;element name="ItItem" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmOutdmT" minOccurs="0"/&gt;
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
    "iFlag",
    "isHead",
    "itItem"
})
@XmlRootElement(name = "ZfmCrmLgcsD")
public class ZfmCrmLgcsD_Type {

    @XmlElement(name = "IFlag")
    protected String iFlag;
    @XmlElement(name = "IsHead")
    protected ZcrmOutdiS isHead;
    @XmlElement(name = "ItItem")
    protected ZcrmOutdmT itItem;

    /**
     * 获取iFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIFlag() {
        return iFlag;
    }

    /**
     * 设置iFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIFlag(String value) {
        this.iFlag = value;
    }

    /**
     * 获取isHead属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmOutdiS }
     *     
     */
    public ZcrmOutdiS getIsHead() {
        return isHead;
    }

    /**
     * 设置isHead属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmOutdiS }
     *     
     */
    public void setIsHead(ZcrmOutdiS value) {
        this.isHead = value;
    }

    /**
     * 获取itItem属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmOutdmT }
     *     
     */
    public ZcrmOutdmT getItItem() {
        return itItem;
    }

    /**
     * 设置itItem属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmOutdmT }
     *     
     */
    public void setItItem(ZcrmOutdmT value) {
        this.itItem = value;
    }

}
