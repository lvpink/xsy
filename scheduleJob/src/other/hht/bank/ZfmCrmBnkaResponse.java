
package other.hht.bank;

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
 *         &lt;element name="TBnka" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZssrmBnka"/&gt;
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
    "tBnka"
})
@XmlRootElement(name = "ZfmCrmBnkaResponse")
public class ZfmCrmBnkaResponse {

    @XmlElement(name = "TBnka", required = true)
    protected TableOfZssrmBnka tBnka;

    /**
     * 获取tBnka属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TableOfZssrmBnka }
     *     
     */
    public TableOfZssrmBnka getTBnka() {
        return tBnka;
    }

    /**
     * 设置tBnka属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZssrmBnka }
     *     
     */
    public void setTBnka(TableOfZssrmBnka value) {
        this.tBnka = value;
    }

}
