package ReusableMethods;

import java.io.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class MethodsToReuse {
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest logger;
	static WebDriver driver;
	public static final String propertyPath="C:\\Users\\prade\\eclipse-workspace\\SalesforceAutomation\\src\\test\\resources\\DataFiles\\configuration.properties";
	/*Methodname: Enter text
	 * obj--->Enter the webelementname
	 * textval----->Enter the text for the textfield
	 * objname----> Enter the textname
	 * Created by:Automation team 
	 * Created on :oct 9 2018
	 * 
	 */

	public static void enterText(WebElement obj,String textVal,String objName)
	{
		if(obj.isDisplayed())
		{
			obj.sendKeys(textVal);
			//System.out.println("PASS: "+objName+ " is entered in the field");
			logger.log(Status.PASS, MarkupHelper.createLabel("PASS: "+objName+" is entered in the field",ExtentColor.GREEN));
		}
		else
			//System.out.println("FAIL: "+objName+" doesnot exist.please check with your application");
			logger.log(Status.FAIL, MarkupHelper.createLabel("FAIL: "+objName+" doesnot exist.please check with your application",ExtentColor.RED));
	}
	/*Methodname: Click operation
	 * obj--->Enter the webelement name
	 * objname----> Enter the name of the object
	 * Created by:Automation team 
	 * Created on :oct 9 2018
	 * Updated on oct 9 2018
	 */

  public static void click(WebElement obj,String objName)
  {
	 if(obj.isDisplayed())
	 {
		 obj.click();
		 logger.log(Status.PASS, MarkupHelper.createLabel("PASS: "+objName+ " is clicked in the field",ExtentColor.GREEN));
		//System.out.println("PASS: "+objName+ " is clicked in the field");
	 }
	 else
		 logger.log(Status.FAIL, MarkupHelper.createLabel("FAIL: "+objName+ " doesnot exists",ExtentColor.RED));
		 //System.out.println("FAIL: "+objName+ " doesnot exists"); 
  }
  /*Methodname: Validate
	 * Actualerror--->Actual error 
	 * Ecxpectederror----> Enter the name of the object
	 * Created by:Automation team 
	 * Created on :oct 9 2018
	 * Updated on oct 9 2018
	 */
	
  public static void validateError_Msg(String Actualerror, String expectedError) 
  {
	  if(Actualerror.equals(expectedError))
		  //System.out.println("PASS:Same Error exists " +Actualerror+ " as Expected");
		  logger.log(Status.PASS, MarkupHelper.createLabel("PASS:Same Error exists " +Actualerror+" as Expected", ExtentColor.GREEN));
	  else
		  //System.out.println("FAIL"+Actualerror +" is displayed");
		  logger.log(Status.FAIL,MarkupHelper.createLabel("FAIL "+Actualerror +" is displayed", ExtentColor.RED));
  }
  /*Methodname: Extent Report
	 * ReportName-->Name of the testcase 
	 * Created by:Automation team 
	 * Created on :oct 10 2018
	 * Updated on oct 10 2018
	 */

  public static void ExtentReport(String reportName)
  {
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String timeNow = dtf.format(now);
		timeNow = timeNow.replace(":", "_");
		timeNow = timeNow.replace(" ", "_");
		timeNow = timeNow.replace("/", "_");
		
		
		System.out.println(reportName+"_"+timeNow+".html");
		String path=System.getProperty("user.dir");
		htmlReporter = new ExtentHtmlReporter(path+".\\ExtentReports\\"+ reportName+"_"+timeNow+".html");
		
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
  }
  /*Methodname: launch application
	 * browser name--->enter the browser
	 *
	 * Created by:Automation team 
	 * Created on :oct 15 2018
	 * Updated on oct 15 2018
	 */
	
  public static void launchApplication(String browserName)
  {	
	  if(browserName.equalsIgnoreCase("firefox")) 
	  {
		  System.setProperty("webdriver.gecko.driver","./src/test/resources/Utility/geckodriver.exe");
		  driver=new FirefoxDriver();
	  } 
	  else if(browserName.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","./src/test/resources/Utility/chromedriver.exe");
		  driver=new ChromeDriver();	 
	  }			
//	  System.setProperty("webdriver.gecko.driver","./src/Utility/geckodriver.exe");
//		driver=new FirefoxDriver();		
 		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com");			
  }	
  

  public static void selectByVisibleText(WebElement obj,String text)
  {
	 Select s=new Select(obj);
	 s.selectByVisibleText(text);
  }
	
  public static void Oppurtunity()
  {
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("pradeepajul11@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("p*6194329354");
	driver.findElement(By.xpath("//input[@id='Login']")).click();
	driver.findElement(By.xpath("//div/nav/ul/li[@id='Opportunity_Tab']")).click();  
  }	
  public static String takeScreenShot(WebDriver driver) throws Exception
  {
	 String reportPath=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	 String curdir=System.getProperty("user.dir");
	 String destination=curdir+"\\ExtentReports\\Screenshots\\"+reportPath+"img.PNG";
	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(src,new File(destination),true);
	 return destination;
  }
  /*Methodname: Read the xl sheet
	 * pathToreadXls-->Xl file path
	 * SheetName--> xl sheet name
	 * Created by:Automation team 
	 * Created on :oct 12 2018
	 * Updated on oct 12 2018
	 */


	
  public static  String[][] readSheet(String pathToreadXls, String SheetName) throws IOException 
  {
		  /*Step 1: Get the XL Path*/
		File xlFile = new File(pathToreadXls);
		/*Step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);
		/*Step3: Access the work book */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(SheetName);
		int iRowCount = sheet.getLastRowNum()+1;
		int iColCount = sheet.getRow(0).getLastCellNum();
		String[][] xlData = new String[iRowCount][iColCount];
		for(int i=0; i<iRowCount; i++){
			for(int j =1; j<iColCount; j++)
			{
				System.out.println("______"+i  +j);
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());				
				xlData[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
			}			
		}wb.close();
		return xlData;		
	}
  /*Methodname: compare dropdowns
	 * choice----->choices are in the array
	 * selectid----> webelement
	 * Created by:Automation team 
	 * Created on :oct 15 2018
	 * Updated on oct 15 2018 
	 */
  public static void CompareDropdown(String[] choice,WebElement selectid )
  { 
	  Select select = new Select(selectid);
	  List<WebElement> element=select.getOptions();
		for(WebElement w:element)			
		{
		for(int i=1;i<element.size();i++)
		{
		if(w.getText().equals(choice[i]))
			{
			System.out.println("equal");
			break;
			}
		}}  
  }
  public static String CredentialsFromProperties(String str) throws Exception
  {
	BufferedReader bf=new BufferedReader(new FileReader(propertyPath));
	Properties pro=new Properties();
	pro.load(bf);
	
	String username = null,password = null;
	if(str.equals(username))
	{
	str=pro.getProperty("Username");
	}
	else if(str.equals(password))
	{
	 str=pro.getProperty("Password");
	}
	bf.close();
	return str;
	 }
  }
	  

   
  

