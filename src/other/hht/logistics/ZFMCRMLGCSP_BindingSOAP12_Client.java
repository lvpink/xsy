
package other.hht.logistics;

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
 * 2020-11-02T20:17:37.050+08:00
 * Generated source version: 3.2.14
 *
 */
public final class ZFMCRMLGCSP_BindingSOAP12_Client {

    private static final QName SERVICE_NAME = new QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZFM_CRM_LGCS_P");

    private ZFMCRMLGCSP_BindingSOAP12_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ZFMCRMLGCSP_Service.WSDL_LOCATION;
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

        ZFMCRMLGCSP_Service ss = new ZFMCRMLGCSP_Service(wsdlURL, SERVICE_NAME);
        ZFMCRMLGCSP port = ss.getBindingSOAP12();

        {
        System.out.println("Invoking zfmCrmLgcsP...");
        java.lang.String _zfmCrmLgcsP_iFlag = "";
        other.hht.logistics.ZcrmOutpi1S _zfmCrmLgcsP_isHead = null;
        other.hht.logistics.ZcrmOutpi3T _zfmCrmLgcsP_itGoods = null;
        other.hht.logistics.ZcrmOutpi2T _zfmCrmLgcsP_itGuiji = null;
        other.hht.logistics.ZcrmOutpi4T _zfmCrmLgcsP_itXgwld = null;
        javax.xml.ws.Holder<other.hht.logistics.ZcrmOutpo1T> _zfmCrmLgcsP_etOutpo1 = new javax.xml.ws.Holder<other.hht.logistics.ZcrmOutpo1T>();
        javax.xml.ws.Holder<other.hht.logistics.ZcrmOutpo2T> _zfmCrmLgcsP_etOutpo2 = new javax.xml.ws.Holder<other.hht.logistics.ZcrmOutpo2T>();
        javax.xml.ws.Holder<other.hht.logistics.ZcrmOutpo3T> _zfmCrmLgcsP_etOutpo3 = new javax.xml.ws.Holder<other.hht.logistics.ZcrmOutpo3T>();
        javax.xml.ws.Holder<other.hht.logistics.ZcrmOutpo4T> _zfmCrmLgcsP_etOutpo4 = new javax.xml.ws.Holder<other.hht.logistics.ZcrmOutpo4T>();
        port.zfmCrmLgcsP(_zfmCrmLgcsP_iFlag, _zfmCrmLgcsP_isHead, _zfmCrmLgcsP_itGoods, _zfmCrmLgcsP_itGuiji, _zfmCrmLgcsP_itXgwld, _zfmCrmLgcsP_etOutpo1, _zfmCrmLgcsP_etOutpo2, _zfmCrmLgcsP_etOutpo3, _zfmCrmLgcsP_etOutpo4);

        System.out.println("zfmCrmLgcsP._zfmCrmLgcsP_etOutpo1=" + _zfmCrmLgcsP_etOutpo1.value);
        System.out.println("zfmCrmLgcsP._zfmCrmLgcsP_etOutpo2=" + _zfmCrmLgcsP_etOutpo2.value);
        System.out.println("zfmCrmLgcsP._zfmCrmLgcsP_etOutpo3=" + _zfmCrmLgcsP_etOutpo3.value);
        System.out.println("zfmCrmLgcsP._zfmCrmLgcsP_etOutpo4=" + _zfmCrmLgcsP_etOutpo4.value);

        }

        System.exit(0);
    }

}
