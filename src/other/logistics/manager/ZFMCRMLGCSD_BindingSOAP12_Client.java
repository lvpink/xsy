
package other.logistics.manager;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.14
 * 2020-11-03T18:45:24.013+08:00
 * Generated source version: 3.2.14
 *
 */
public final class ZFMCRMLGCSD_BindingSOAP12_Client {

    private static final QName SERVICE_NAME = new QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZFM_CRM_LGCS_D");

    private ZFMCRMLGCSD_BindingSOAP12_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ZFMCRMLGCSD_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        ZFMCRMLGCSD_Service ss = new ZFMCRMLGCSD_Service(wsdlURL, SERVICE_NAME);
        ZFMCRMLGCSD port = ss.getBindingSOAP12();

        {
        System.out.println("Invoking zfmCrmLgcsD...");
        java.lang.String _zfmCrmLgcsD_iFlag = "";
        other.logistics.manager.ZcrmOutdiS _zfmCrmLgcsD_isHead = null;
        other.logistics.manager.ZcrmOutdmT _zfmCrmLgcsD_itItem = null;
        javax.xml.ws.Holder<other.logistics.manager.ZcrmMessgS> _zfmCrmLgcsD_esMessg = new javax.xml.ws.Holder<other.logistics.manager.ZcrmMessgS>();
        javax.xml.ws.Holder<other.logistics.manager.ZcrmOutdoT> _zfmCrmLgcsD_etOutdo = new javax.xml.ws.Holder<other.logistics.manager.ZcrmOutdoT>();
        port.zfmCrmLgcsD(_zfmCrmLgcsD_iFlag, _zfmCrmLgcsD_isHead, _zfmCrmLgcsD_itItem, _zfmCrmLgcsD_esMessg, _zfmCrmLgcsD_etOutdo);

        System.out.println("zfmCrmLgcsD._zfmCrmLgcsD_esMessg=" + _zfmCrmLgcsD_esMessg.value);
        System.out.println("zfmCrmLgcsD._zfmCrmLgcsD_etOutdo=" + _zfmCrmLgcsD_etOutdo.value);

        }

        System.exit(0);
    }

}
