
package other.hht.product;

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
 *         &lt;element name="EtMatnr" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZfgCrmMatnrS"/&gt;
 *         &lt;element name="IFlag" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/&gt;
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
    "etMatnr",
    "iFlag"
})
@XmlRootElement(name = "ZfmCrmCpbm")
public class ZfmCrmCpbm_Type {

    @XmlElement(name = "EtMatnr", required = true)
    protected TableOfZfgCrmMatnrS etMatnr;
    @XmlElement(name = "IFlag")
    protected String iFlag;

    /**
     * 获取etMatnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TableOfZfgCrmMatnrS }
     *     
     */
    public TableOfZfgCrmMatnrS getEtMatnr() {
        return etMatnr;
    }

    /**
     * 设置etMatnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZfgCrmMatnrS }
     *     
     */
    public void setEtMatnr(TableOfZfgCrmMatnrS value) {
        this.etMatnr = value;
    }

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

}
