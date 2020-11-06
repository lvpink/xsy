
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
 *         &lt;element name="EtOutpo1" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmOutpo1T"/&gt;
 *         &lt;element name="EtOutpo2" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmOutpo2T"/&gt;
 *         &lt;element name="EtOutpo3" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmOutpo3T"/&gt;
 *         &lt;element name="EtOutpo4" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmOutpo4T"/&gt;
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
    "etOutpo1",
    "etOutpo2",
    "etOutpo3",
    "etOutpo4"
})
@XmlRootElement(name = "ZfmCrmLgcsPResponse")
public class ZfmCrmLgcsPResponse {

    @XmlElement(name = "EtOutpo1", required = true)
    protected ZcrmOutpo1T etOutpo1;
    @XmlElement(name = "EtOutpo2", required = true)
    protected ZcrmOutpo2T etOutpo2;
    @XmlElement(name = "EtOutpo3", required = true)
    protected ZcrmOutpo3T etOutpo3;
    @XmlElement(name = "EtOutpo4", required = true)
    protected ZcrmOutpo4T etOutpo4;

    /**
     * 获取etOutpo1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmOutpo1T }
     *     
     */
    public ZcrmOutpo1T getEtOutpo1() {
        return etOutpo1;
    }

    /**
     * 设置etOutpo1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmOutpo1T }
     *     
     */
    public void setEtOutpo1(ZcrmOutpo1T value) {
        this.etOutpo1 = value;
    }

    /**
     * 获取etOutpo2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmOutpo2T }
     *     
     */
    public ZcrmOutpo2T getEtOutpo2() {
        return etOutpo2;
    }

    /**
     * 设置etOutpo2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmOutpo2T }
     *     
     */
    public void setEtOutpo2(ZcrmOutpo2T value) {
        this.etOutpo2 = value;
    }

    /**
     * 获取etOutpo3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmOutpo3T }
     *     
     */
    public ZcrmOutpo3T getEtOutpo3() {
        return etOutpo3;
    }

    /**
     * 设置etOutpo3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmOutpo3T }
     *     
     */
    public void setEtOutpo3(ZcrmOutpo3T value) {
        this.etOutpo3 = value;
    }

    /**
     * 获取etOutpo4属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmOutpo4T }
     *     
     */
    public ZcrmOutpo4T getEtOutpo4() {
        return etOutpo4;
    }

    /**
     * 设置etOutpo4属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmOutpo4T }
     *     
     */
    public void setEtOutpo4(ZcrmOutpo4T value) {
        this.etOutpo4 = value;
    }

}
