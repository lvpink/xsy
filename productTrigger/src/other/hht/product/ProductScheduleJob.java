package other.hht.product;

import com.rkhd.platform.sdk.ScheduleJob;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.param.ScheduleJobParam;
import com.rkhd.platform.sdk.test.tool.TestScheduleJobTool;

public class ProductScheduleJob implements ScheduleJob {

	private static final Logger logger= LoggerFactory.getLogger();

    public static void main(String[] args) {
        TestScheduleJobTool tool=new TestScheduleJobTool();
        tool.test(new ProductScheduleJob());
    }


    @Override
    public void execute(ScheduleJobParam scheduleJobParam) {
    	logger.info("定时任务同步产品信息-->start");
    	String result = ProductWs.webservice();
    	logger.info("定时任务同步产品信息-->完成||msg->"+result);
    }

}
