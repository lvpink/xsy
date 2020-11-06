
package other.hht.logistics;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Date>
{


    public Date unmarshal(String value) {
        return (HhtTools.stringToJavaDate(value));
    }

    public String marshal(Date value) {
        return (HhtTools.JavaDateToString(value));
    }

}
