package other.xsy.cn;

import com.rkhd.platform.sdk.test.tool.TestTriggerTool;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestTriggerTool triggerTool = new TestTriggerTool();
		triggerTool.test("C:\\My_Project_file\\workspaces\\xiaoshouyi02\\lvywCustomerDemo\\src\\scriptTrigger.xml", new CustomerAddTrigger());

	}

}
