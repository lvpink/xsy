
package other.hht.logistics;

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
 *         &lt;element name="IsHead" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmOutpi1S" minOccurs="0"/&gt;
 *         &lt;element name="ItGoods" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmOutpi3T" minOccurs="0"/&gt;
 *         &lt;element name="ItGuiji" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmOutpi2T" minOccurs="0"/&gt;
 *         &lt;element name="ItXgwld" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmOutpi4T" minOccurs="0"/&gt;
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
    "itGoods",
    "itGuiji",
    "itXgwld"
})
@XmlRootElement(name = "ZfmCrmLgcsP")
public class ZfmCrmLgcsP_Type {

    @XmlElement(name = "IFlag")
    protected String iFlag;
    @XmlElement(name = "IsHead")
    protected ZcrmOutpi1S isHead;
    @XmlElement(name = "ItGoods")
    protected ZcrmOutpi3T itGoods;
    @XmlElement(name = "ItGuiji")
    protected ZcrmOutpi2T itGuiji;
    @XmlElement(name = "ItXgwld")
    protected ZcrmOutpi4T itXgwld;

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
     *     {@link ZcrmOutpi1S }
     *     
     */
    public ZcrmOutpi1S getIsHead() {
        return isHead;
    }

    /**
     * 设置isHead属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmOutpi1S }
     *     
     */
    public void setIsHead(ZcrmOutpi1S value) {
        this.isHead = value;
    }

    /**
     * 获取itGoods属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmOutpi3T }
     *     
     */
    public ZcrmOutpi3T getItGoods() {
        return itGoods;
    }

    /**
     * 设置itGoods属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmOutpi3T }
     *     
     */
    public void setItGoods(ZcrmOutpi3T value) {
        this.itGoods = value;
    }

    /**
     * 获取itGuiji属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmOutpi2T }
     *     
     */
    public ZcrmOutpi2T getItGuiji() {
        return itGuiji;
    }

    /**
     * 设置itGuiji属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmOutpi2T }
     *     
     */
    public void setItGuiji(ZcrmOutpi2T value) {
        this.itGuiji = value;
    }

    /**
     * 获取itXgwld属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmOutpi4T }
     *     
     */
    public ZcrmOutpi4T getItXgwld() {
        return itXgwld;
    }

    /**
     * 设置itXgwld属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmOutpi4T }
     *     
     */
    public void setItXgwld(ZcrmOutpi4T value) {
        this.itXgwld = value;
    }

}
