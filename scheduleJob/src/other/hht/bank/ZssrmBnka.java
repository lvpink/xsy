
package other.hht.bank;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ZssrmBnka complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZssrmBnka"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Banks" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="Bankl" type="{urn:sap-com:document:sap:rfc:functions}char15"/&gt;
 *         &lt;element name="Banka" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *         &lt;element name="Landx" type="{urn:sap-com:document:sap:soap:functions:mc-style}char15"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZssrmBnka", propOrder = {
    "banks",
    "bankl",
    "banka",
    "landx"
})
public class ZssrmBnka {

    @XmlElement(name = "Banks", required = true)
    protected String banks;
    @XmlElement(name = "Bankl", required = true)
    protected String bankl;
    @XmlElement(name = "Banka", required = true)
    protected String banka;
    @XmlElement(name = "Landx", required = true)
    protected String landx;

    /**
     * 获取banks属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBanks() {
        return banks;
    }

    /**
     * 设置banks属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBanks(String value) {
        this.banks = value;
    }

    /**
     * 获取bankl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankl() {
        return bankl;
    }

    /**
     * 设置bankl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankl(String value) {
        this.bankl = value;
    }

    /**
     * 获取banka属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBanka() {
        return banka;
    }

    /**
     * 设置banka属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBanka(String value) {
        this.banka = value;
    }

    /**
     * 获取landx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandx() {
        return landx;
    }

    /**
     * 设置landx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandx(String value) {
        this.landx = value;
    }

}
