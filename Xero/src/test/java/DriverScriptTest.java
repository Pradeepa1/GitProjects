import java.lang.reflect.Method;
import org.testng.annotations.Test;
public class DriverScriptTest extends Automation
{@Test
	public static void main() throws Exception
	{
		System.out.println("Helloworld");
		String pathToReadXls="C:\\Users\\prade\\git\\repository3\\GitProjects\\Xero\\src\\test\\resources\\Utility\\TestSuit.xls";
		Extent("sprint");
		String[][] recData=MethodsToReuse.readSheet(pathToReadXls,"Sheet1");	
		String flag=null;
		String testCase=recData[0][1];
		for(int i=0;i<recData.length;i++)
		{
			flag=recData[i][1];
			if(flag.equalsIgnoreCase("Y"))
			{
				testCase = recData[i][2];					
					/*Java Reflection */
				Method testScript = Automation.class.getMethod(testCase);
					
				testScript.invoke(testScript);
					
			}else
			{
			System.out.println("**********Row  number "+ i+" test case Name "+ recData[i][2]+" is not Executed*********");
			}
		}	
		
		
		extent.flush();
		
	}
}
