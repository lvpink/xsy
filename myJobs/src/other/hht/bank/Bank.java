package other.hht.bank;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rkhd.platform.sdk.ScheduleJob;
//import com.rkhd.platform.sdk.data.model.BankList__c;
import com.rkhd.platform.sdk.exception.ApiEntityServiceException;
import com.rkhd.platform.sdk.exception.CacheException;
import com.rkhd.platform.sdk.exception.XsyHttpException;
import com.rkhd.platform.sdk.http.RkhdHttpClient;
import com.rkhd.platform.sdk.http.RkhdHttpData;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.model.QueryResult;
import com.rkhd.platform.sdk.model.XObject;
import com.rkhd.platform.sdk.param.ScheduleJobParam;
import com.rkhd.platform.sdk.service.CacheService;
import com.rkhd.platform.sdk.service.XObjectService;
import com.rkhd.platform.sdk.test.tool.TestScheduleJobTool;

import javax.xml.ws.BindingProvider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank implements ScheduleJob {
    private static final Logger logger= LoggerFactory.getLogger();

    public static void main(String[] args) {
        TestScheduleJobTool tool=new TestScheduleJobTool();
        tool.test(new Bank());
    }

    /*返回自定义消息类型的默认业务类型ID
     */
    private  static  Long getEntityTypeId()  {

        String defaultBusiTypeID="defaultBusiTypeID";

        try {
            if(null!= CacheService.instance().get(defaultBusiTypeID)){
                return  Long.parseLong(CacheService.instance().get(defaultBusiTypeID) );
            }
        } catch (CacheException e) {
            logger.error("获取EntityTypeId缓存出错，"+e.getMessage());
        }

        RkhdHttpData rkhdHttpData = new RkhdHttpData();
        rkhdHttpData.setCallString("/rest/data/v2.0/xobjects/bankList__c/busiType");
        rkhdHttpData.setCall_type("get");
        Map<String, String> headerMap = new HashMap();
        headerMap.put("xsy-criteria","10");
        rkhdHttpData.setHeaderMap( headerMap);

        try {

            JSONObject jsonObject = null;
            jsonObject = (JSONObject) RkhdHttpClient.instance().execute(rkhdHttpData, JSON::parseObject );
            if(null!=jsonObject){

                JSONObject resultJsonObject = jsonObject.getJSONObject("data");
                JSONArray array=resultJsonObject.getJSONArray("records");

                if(0==array.size()){
                    logger.error("自定义消息类型获得0条数据，程序异常");
                    return 0L ;
                }else {
                    for (Object index:array
                    ) {
                        JSONObject mailBusType=JSONObject.parseObject(index.toString());
                        //获取默认业务类型ID 即可返回
                        if(mailBusType.get("apiKey").toString().equalsIgnoreCase("defaultBusiType")){
                            //System.out.println("entityType id:"+mailBusType.get("id"));
                            try {
                                CacheService.instance().set(defaultBusiTypeID,mailBusType.get("id").toString());
                            } catch (CacheException e) {
                                logger.error("设置EntityTypeId缓存出错，"+e.getMessage());
                            }
                            return  Long.parseLong(mailBusType.get("id").toString()) ;
                        }

                    }
                }

            }
        }catch (XsyHttpException e) {
            logger.info("获得业务类型出错:"+e.getMessage());
        }catch (IOException e){
            logger.info("获得业务类型出错:"+e.getMessage());
        }
        return 0L;
    }


    private static void webservice() {

        ZFMCRMBNKA_Service zfmcrmbnkaService = new ZFMCRMBNKA_Service();
        ZFMCRMBNKA port = zfmcrmbnkaService.getBinding();
        // 设置访问接口服务器的用户名和密码  需要提取到系统自定义对象保存
        BindingProvider bp = (BindingProvider) port;
        Map<String, Object> context = bp.getRequestContext();
        context.put(BindingProvider.USERNAME_PROPERTY, Constants.USERNAME);
        context.put(BindingProvider.PASSWORD_PROPERTY, Constants.PASSWORD);
        //上线时生成环境地址需要进行替换  ，如果根据生产wsdl生成代理类  可以不进行替换
       // context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"http://SAPD02.HITEVISION.COM:8090/sap/bc/srt/rfc/sap/zfm_as_0025/300/zfm_as_0025/binding");
        TableOfZsrmBnka tableOfZsrmBnka=new TableOfZsrmBnka();
        javax.xml.ws.Holder<TableOfZsrmBnka> tBnka=new   javax.xml.ws.Holder<TableOfZsrmBnka>(tableOfZsrmBnka);
        port.zfmCrmBnka(tBnka);  //执行webservice 方法
        List<ZsrmBnka> items   = tBnka.value.getItem(); //获取返回值

        List<BankList__c> updateList = new ArrayList<BankList__c>();
        List<BankList__c> insertList = new ArrayList<BankList__c>();
        int i=0;
        for ( ZsrmBnka item :items) {

//        	BANKS	BANKL	BANKA
//        	国家	银行代码	银行名称

           logger.info(++i+" item= "+item.getBanka()+" "+item.getBankl()+" "+item.getBanks());

            BankList__c bank = new BankList__c();
            bank.setEntityType(getEntityTypeId());

            String sql = "select id, bankCountryCode__c, bankCode__c, bankName__c from bankList__c where bankCode__c = '"+item.getBankl()+"' AND bankCountryCode__c = '"+item.getBanks()+"'";
            logger.info(sql);
            try {
                QueryResult<XObject> result = XObjectService.instance().query(sql);
                
                /**查询数据处理*/
                XObject xObject = result.getRecords().get(0);
                Long id=result.getRecords().get(0).getId();
               
                bank.setId(id);
                bank.setBankCode__c(item.getBankl());
                bank.setBankName__c(item.getBanka());
                bank.setBankCountryCode__c(item.getBanks());
               if(result.getTotalCount()>0){
	               logger.error("查询到重复银行代码："+ bank.getBankCode__c()+" 国家代码："+bank.getBankCountryCode__c());
                    updateList.add(bank);
//                    XObjectService.instance().update(xobject);
//                    logger.debug( "更新记录 ："+ bank.getName());
                }else{
                	insertList.add(bank);
//                    XObjectService.instance().insert(bank);
//                    logger.debug( "插入记录 ："+ bank.getName());
                }
            } catch (ApiEntityServiceException e) {
                e.printStackTrace();
            }

        }
        if(null!=updateList&&updateList.size()>0){
//        	 XObjectService.instance().update(updateList);
        }
    }

    @Override
    public void execute(ScheduleJobParam scheduleJobParam) {

        webservice();
    }
}
