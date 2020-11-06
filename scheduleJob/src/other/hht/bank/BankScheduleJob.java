package other.hht.bank;
import com.rkhd.platform.sdk.ScheduleJob;
import com.rkhd.platform.sdk.log.Logger;
import com.rkhd.platform.sdk.log.LoggerFactory;
import com.rkhd.platform.sdk.param.ScheduleJobParam;
import com.rkhd.platform.sdk.test.tool.TestScheduleJobTool;
/**
 * 同步银行信息异步任务
 * @author xsy
 *
 */
public class BankScheduleJob implements ScheduleJob {
    private static final Logger logger= LoggerFactory.getLogger();

    public static void main(String[] args) {
        TestScheduleJobTool tool=new TestScheduleJobTool();
        tool.test(new BankScheduleJob());
    }


    @Override
    public void execute(ScheduleJobParam scheduleJobParam) {
    	logger.info("定时任务同步银行信息-->start");
    	String result = BankWs.webservice();
    	logger.info("定时任务同步银行信息-->完成||msg->"+result);
    }
}