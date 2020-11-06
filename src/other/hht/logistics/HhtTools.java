package other.hht.logistics;

import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HhtTools {
    private static final Logger logger= LoggerFactory.getLogger();


    public static XMLGregorianCalendar getXMLGregorianCalendar(String date)  {
        XMLGregorianCalendar xmlCalender=null;
        GregorianCalendar calender = new GregorianCalendar();
        calender.setTime(stringToJavaDate(date));
        try {
            xmlCalender = DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);


            logger.debug("calender = " + calender.toString());
            xmlCalender.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
            logger.debug("calender = " + calender.toString());
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return xmlCalender;
    }
    public static Date getStrFromCalendar(XMLGregorianCalendar xmlCalender)  {

    	GregorianCalendar calendar = xmlCalender.toGregorianCalendar();
    	Date time = calendar.getTime();
		return time;
    }

    public static Date  stringToJavaDate(String sDate)  {
        Date date=null;
        //date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(sDate);
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static  String JavaDateToString(Date sDate){
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sDate);
      //获取年
       int year = calendar.get(Calendar.YEAR);
       if(year<1970){
    	   return "0000-00-00";
       }
        String str = sdf.format(sDate);
        return  str;
    }
  
    @SuppressWarnings("all")
    public static Time strToTime(String strDate) {
        String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Time time = new Time(d.getTime());
        return time.valueOf(str);
    }
    public static String timeToStr(Time time) {
        return String.valueOf(time.getTime());
    }
}
