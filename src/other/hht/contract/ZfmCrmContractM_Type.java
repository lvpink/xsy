
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
 *         &lt;element name="IFlag" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="IsContract" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZcrmContractIs" minOccurs="0"/&gt;
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
    "iFlag",
    "isContract",
    "itContract"
})
@XmlRootElement(name = "ZfmCrmContractM")
public class ZfmCrmContractM_Type {

    @XmlElement(name = "IFlag", required = true)
    protected String iFlag;
    @XmlElement(name = "IsContract")
    protected ZcrmContractIs isContract;
    @XmlElement(name = "ItContract", required = true)
    protected ZcrmContractOt itContract;

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
     * 获取isContract属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZcrmContractIs }
     *     
     */
    public ZcrmContractIs getIsContract() {
        return isContract;
    }

    /**
     * 设置isContract属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZcrmContractIs }
     *     
     */
    public void setIsContract(ZcrmContractIs value) {
        this.isContract = value;
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
