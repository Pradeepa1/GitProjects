import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MethodsToReuse 
{
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest logger;
	static WebDriver driver=null;
public static void Extent(String ReportName)
{
	String reportPath=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	
	System.out.println(reportPath+" "+ReportName+".html");
	String path=System.getProperty("user.dir");
	htmlReporter=new ExtentHtmlReporter(path+".\\ExtentReport\\"+reportPath+"_"+ReportName+".html");
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);	
}
public static void Browser(String browserName)
{
	if(browserName.equalsIgnoreCase("Firefox"))

	{
		System.setProperty("webdriver.gecko.driver","./src/test/resources/Utility/geckodriver.exe");
		driver=new FirefoxDriver();
		
	}
	else if(browserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/Utility/chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	else if(browserName.equalsIgnoreCase("ie"))
	{
		System.setProperty("webdriver.ie.driver","./src/test/resources/Utility/IEDriverServer.exe");
		driver=new InternetExplorerDriver();		
	}
			
	}

public static Properties loadproperty(String path) throws Exception
{	
	Properties pro=new Properties();
	BufferedReader bf=new BufferedReader(new FileReader(path));
	pro.load(bf);
	bf.close();
	return pro;
}

public static By getLocator(String strelement,Properties p) throws Exception
{	
	String Locator=p.getProperty(strelement);
	
	String LocatorType=Locator.split(":")[0];
	String LocatorValue = Locator.split(":")[1];
	
	System.out.println("Element have"+LocatorType+" and "+LocatorValue);
	
	if(LocatorType.toLowerCase().equals("xpath"))
		return By.xpath(LocatorValue);
	if(LocatorType.toLowerCase().equals("id"))
		return By.id(LocatorValue);
	else if((LocatorType.toLowerCase().equals("linktext")) || (LocatorType.toLowerCase().equals("link")))
        return By.linkText(LocatorValue);
	if((LocatorType.toLowerCase().equals("cssSelector"))||(LocatorType.toLowerCase().equals("css")))
		return By.cssSelector(LocatorValue);
	if((LocatorType.toLowerCase().equals("class"))||(LocatorType.toLowerCase().equals("classname")))
		return By.className(LocatorValue);
	if((LocatorType.toLowerCase().equals("tag"))||(LocatorType.toLowerCase().equals("tagname")))
		return By.tagName(LocatorValue);
	if(LocatorType.toLowerCase().equals("partiallinktext"))
		return By.partialLinkText(LocatorValue);
	if(LocatorType.toLowerCase().equals("name"))
		return By.name(LocatorValue);
	else 
		throw new Exception("Unknown locator type " + LocatorType + "'");
	}

public static void enterText(WebElement obj, String txtValue, String objName) 
{
if(obj.isDisplayed())
{
	obj.sendKeys(txtValue);
	logger.log(Status.PASS,MarkupHelper.createLabel("PASS: "+objName+" is entered in the field", ExtentColor.GREEN));
}
else
	logger.log(Status.FAIL,MarkupHelper.createLabel("FAIL"+objName +" doesnot exist",ExtentColor.RED));	
}

public static void click(WebElement obj, String objName)
{
	if(obj.isDisplayed())
	{
		obj.click();
		logger.log(Status.PASS, MarkupHelper.createLabel("PASS "+objName+" is clicked",ExtentColor.GREEN));
	}
	else
		logger.log(Status.FAIL, MarkupHelper.createLabel("FAIL "+objName+ " doesnot Exists", ExtentColor.RED));	
}
public static String[][] readSheet(String pathToReadXls,String sheetName) throws Exception
{

	  /*Step 1: Get the XL Path*/
			File xlFile = new File(pathToReadXls);
			/*Step2: Access the Xl File*/
			FileInputStream xlDoc = new FileInputStream(xlFile);
			/*Step3: Access the work book */
			HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
			/*Step4: Access the Sheet */			
	HSSFSheet sheet = wb.getSheet(sheetName);
	int iRowCount = sheet.getLastRowNum()+1;
	int iColCount = sheet.getRow(0).getLastCellNum();
	String[][] xlData = new String[iRowCount][iColCount];
	for(int i=0; i<iRowCount; i++){
		for(int j =1; j<iColCount; j++)
		{
//			System.out.println("______"+i  +j);
//			System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());				
			xlData[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
		}			
	}
	wb.close();
	return xlData;		
}
public static void compareError(String actual,String Expected)
{
	if(actual.equals(Expected))
	{System.out.println("Equal");
	logger.log(Status.PASS, MarkupHelper.createLabel("PASS"+actual+" error is same as we expected",ExtentColor.GREEN));
	}
	else
	{
	logger.log(Status.FAIL, MarkupHelper.createLabel(Expected+" doesnot exists", ExtentColor.RED));	
	System.out.println("Not equal");
	}
}
public static String ScreenShot(WebDriver driver) throws Exception
{
	String path=System.getProperty("user.dir");
	String destpath=path+"./ExtentReport/Screenshots/img.PNG";
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src,new File(destpath),true);
	return destpath;		
}
public static void selectByText(WebElement obj,String option)
{
	Select s=new Select(obj);
	s.selectByVisibleText(option);
}
public static void windowHandle(String mainwindow,String currentwindow) throws Exception
{
	Set<String> allwindows=driver.getWindowHandles();
	Iterator it=allwindows.iterator();
	while(it.hasNext())
	{
		currentwindow=it.next().toString();
		if(!currentwindow.equals(mainwindow))
		{
			driver.switchTo().window(currentwindow);
			Thread.sleep(3000);
			driver.close();
		}
	}
}
public static void selectDropDownByid(WebElement obj,String id)
{
	Select s=new Select(obj);
	s.selectByValue(id);
}
public static void radioButton(WebElement obj,String li[])
{
	
}
}


