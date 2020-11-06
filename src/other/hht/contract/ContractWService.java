package other.hht.contract;

import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;



public class ContractWService {
	private static final Logger logger = LoggerFactory.getLogger();
	
	 public static void webservice() {
	    	
	    	ZFMCRMCONTRACTM_Service zfmcrmcontractm_Service = new ZFMCRMCONTRACTM_Service();
	    	ZFMCRMCONTRACTM port = zfmcrmcontractm_Service.getBinding();
	    	BindingProvider bp = (BindingProvider) port;
	        Map<String, Object> context = bp.getRequestContext();
	        context.put(BindingProvider.USERNAME_PROPERTY, Constants.USERNAME);
	        context.put(BindingProvider.PASSWORD_PROPERTY, Constants.PASSWORD);
	        String iFlag = "Q";
	       
	        
	        /*<ZcrmVbelnHt></ZcrmVbelnHt>
            <Lifnr>3000575</Lifnr>
            <Begda>2020-07-01</Begda>
            <Endda>2020-07-30</Endda>*/
	        XMLGregorianCalendarImpl startDay = new XMLGregorianCalendarImpl();
	        startDay.setYear(2020);
	        startDay.setMonth(7);
	        startDay.setDay(1);
	        XMLGregorianCalendarImpl endDay = new XMLGregorianCalendarImpl();
	        endDay.setYear(2020);
	        endDay.setMonth(7);
	        endDay.setDay(30);
			ZcrmContractIs isContract = new ZcrmContractIs();
			isContract.setLifnr("3000575");
			isContract.setBegda(startDay);
			isContract.setEndda(endDay);
			ZcrmContractOt zcrmContractOt = new ZcrmContractOt();
			Holder<ZcrmContractOt> itContract = new Holder<ZcrmContractOt>(zcrmContractOt);
			ZcrmMessgS zcrmMessgS = new ZcrmMessgS();
			Holder<ZcrmMessgS> esMessg = new Holder<ZcrmMessgS>(zcrmMessgS);
			logger.info("上送ws参数："+JSONObject.toJSONString(isContract));
			
			//执行webservice 方法
			port.zfmCrmContractM(iFlag, isContract, itContract, esMessg);
			//获取返回值
	        List<ZcrmContractOs> item = itContract.value.getItem();
	        logger.info("返回ws参数item："+JSONObject.toJSONString(item));
	 }
	 public static void main(String[] args) {
		webservice();
	}

}
