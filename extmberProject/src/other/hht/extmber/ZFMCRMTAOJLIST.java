package other.hht.extmber;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.14
 * 2020-10-23T18:44:14.463+08:00
 * Generated source version: 3.2.14
 *
 */
@WebService(targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style", name = "ZFM_CRM_TAOJLIST")
@XmlSeeAlso({ObjectFactory.class})
public interface ZFMCRMTAOJLIST {

    @WebMethod(operationName = "ZfmCrmTaojlist")
    @RequestWrapper(localName = "ZfmCrmTaojlist", targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style", className = "other.hht.extmber.ZfmCrmTaojlist_Type")
    @ResponseWrapper(localName = "ZfmCrmTaojlistResponse", targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style", className = "other.hht.extmber.ZfmCrmTaojlistResponse")
    @WebResult(name = "EtMatnr", targetNamespace = "")
    public other.hht.extmber.ZcrmIdnrkT zfmCrmTaojlist(
        @WebParam(name = "IMatnr", targetNamespace = "")
        java.lang.String iMatnr
    );
}
