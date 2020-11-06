
package other.hht.contract;

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
 *         &lt;element name="ItContract" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmContractOt"/&gt;
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
    "itContract"
})
@XmlRootElement(name = "ZfmCrmContractMResponse")
public class ZfmCrmContractMResponse {

    @XmlElement(name = "EsMessg", required = true)
    protected ZcrmMessgS esMessg;
    @XmlElement(name = "ItContract", required = true)
    protected ZcrmContractOt itContract;

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
     * 获取itContract属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmContractOt }
     *     
     */
    public ZcrmContractOt getItContract() {
        return itContract;
    }

    /**
     * 设置itContract属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmContractOt }
     *     
     */
    public void setItContract(ZcrmContractOt value) {
        this.itContract = value;
    }

}
