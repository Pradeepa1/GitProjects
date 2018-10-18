package ReusableMethods;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class DriverScriptsTest extends Automation
{
	@Test
	public static void method() throws Exception 
	{
	String path=System.getProperty("user.dir");
	String pathToreadXls=path+".\\src\\test\\resources\\Utility\\TestSuit.xls";
	String[][] recdata = MethodsToReuse.readSheet(pathToreadXls,"Sheet1");	
	String testCase =recdata[0][1];
	ExtentReport("Sprint1");
		String flag = null;
	
	for(int i = 0; i< recdata.length; i++) {
		
		
			flag = recdata[i][1];
			if(flag.equalsIgnoreCase("Y"))
		{
			testCase = recdata[i][2];
			
				
				/*Java Reflection */
				Method testScript = Automation.class.getMethod(testCase);
				testScript.invoke(testScript);
				
			}else {
				System.out.println("**********Row  number "+ i+" test case Name "+ recdata[i][2]+" is not Executed*********");
			}
		
	}
	extent.flush();
}}
	
			
		
//String testcase = "Validate_Login_Error_Message_5";
//	Method testScript=Automation.class.getMethod(testcase);
//	testScript.invoke(testScript, args);
//	LoginToSFDC();
//	Forgot_Password();
//	Validate_Login_Error_Message_5();
//	Check_RemeberMe_3();		
//	UserMenuDropDown();
//	MySettings();
//	MyProfile();
//	DeveloperConsole();
//	CreateAccountInCreateAccount();
//	CreateNewViewInCreateAccount();
//	EditViewInCreateAccount();
//	MergeAccountsInCreateAccount();
//	CreateNewOptyInCreateOpty();
//	SelectUserMenuinCreateOpty();
	
	