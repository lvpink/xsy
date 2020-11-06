
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
 *         &lt;element name="EsMessg" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmMessgS"/&gt;
 *         &lt;element name="EtOutdo" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmOutdoT"/&gt;
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
    "esMessg",
    "etOutdo"
})
@XmlRootElement(name = "ZfmCrmLgcsDResponse")
public class ZfmCrmLgcsDResponse {

    @XmlElement(name = "EsMessg", required = true)
    protected ZcrmMessgS esMessg;
    @XmlElement(name = "EtOutdo", required = true)
    protected ZcrmOutdoT etOutdo;

    /**
     * 获取esMessg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmMessgS }
     *     
     */
    public ZcrmMessgS getEsMessg() {
        return esMessg;
    }

    /**
     * 设置esMessg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmMessgS }
     *     
     */
    public void setEsMessg(ZcrmMessgS value) {
        this.esMessg = value;
    }

    /**
     * 获取etOutdo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmOutdoT }
     *     
     */
    public ZcrmOutdoT getEtOutdo() {
        return etOutdo;
    }

    /**
     * 设置etOutdo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmOutdoT }
     *     
     */
    public void setEtOutdo(ZcrmOutdoT value) {
        this.etOutdo = value;
    }

}
