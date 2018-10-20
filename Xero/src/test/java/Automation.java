import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Automation extends MethodsToReuse
{ 
static String PropPath="C:\\Users\\prade\\eclipse-workspace\\Xerox\\src\\test\\resources\\DataFiles\\Configuration.properties";
static String ObjRepoPath="C:\\Users\\prade\\eclipse-workspace\\Xerox\\src\\test\\resources\\ObjectRepository\\ObjRepo.properties";
public static void NavigateToZero() throws Exception
{
	logger=extent.createTest("NavigateToZero");
	Browser("chrome");
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("Url"));
	logger.log(Status.PASS,MarkupHelper.createLabel("Xerox Application is opened",ExtentColor.GREEN));
	Properties ObjRep=loadproperty(ObjRepoPath);
	WebElement user=driver.findElement(getLocator("Xerox.user.textbox",ObjRep));
	String u=pro.getProperty("UserName");
	enterText(user,u,"UserNameForXerox");
	WebElement pwd=driver.findElement(getLocator("Xerox.password.textbox",ObjRep));
	String p=pro.getProperty("Password");
	enterText(pwd,p,"PasswordForXerox");
	WebElement login=driver.findElement(getLocator("Xerox.login.button",ObjRep));
	click(login,"Loginbutton");	
	driver.close();
}
public static void IncorrectPassword() throws Exception
{
	logger=extent.createTest("IncorrectPassword");
	Browser("firefox");
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("Url"));
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Properties ObjRep=loadproperty(ObjRepoPath);
	Thread.sleep(3000);
	WebElement user=driver.findElement(getLocator("Xerox.user.textbox",ObjRep));
	String u=pro.getProperty("IncorrectUser");
	enterText(user,u,"UserNameForXerox");
	WebElement pwd=driver.findElement(getLocator("Xerox.password.textbox",ObjRep));
	String p=pro.getProperty("Password");
	enterText(pwd,p,"PasswordForXerox");
	Thread.sleep(1000);
	String img=ScreenShot(driver);
	logger.addScreenCaptureFromPath(img);
	WebElement login=driver.findElement(getLocator("Xerox.login.button",ObjRep));
	click(login,"Loginbutton");	
	String Expected="Your Email or Password is incorrect";
	WebElement error=driver.findElement(getLocator("Xerox.errormsg1.textbox",ObjRep));
	String actual=error.getText();
	Thread.sleep(1000);
	compareError(actual,Expected);
	driver.close();
}

public static void IncorrectEmail() throws Exception
{
	logger=extent.createTest("IncorrectEmail");
	Browser("chrome");
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("Url"));
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Properties ObjRep=loadproperty(ObjRepoPath);
	WebElement user=driver.findElement(getLocator("Xerox.user.textbox",ObjRep));
	String u=pro.getProperty("UserName");
	enterText(user,u,"UserNameForXerox");
	WebElement IncorrectPassword=driver.findElement(getLocator("Xerox.incorrectpwd.textbox",ObjRep));
	String p=pro.getProperty("IncorrectPassword");
	enterText(IncorrectPassword,p,"IncorrectPwd");
	String img=ScreenShot(driver);
	logger.addScreenCaptureFromPath(img);
	WebElement login=driver.findElement(getLocator("Xerox.login.button",ObjRep));
	click(login,"Loginbutton");	
	String Expected="Your Email or Password is incorrect";
	WebElement error=driver.findElement(getLocator("Xerox.errormsg1.textbox",ObjRep));
	String actual=error.getText();
	Thread.sleep(1000);
	compareError(actual,Expected);
	driver.close();	
}
public static void NavigatetoXERO() throws Exception
{
	logger=extent.createTest("NavigatetoXERO");
	Browser("chrome");
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("Url"));
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Properties ObjRep=loadproperty(ObjRepoPath);
	WebElement forgot=driver.findElement(getLocator("Xerox.forgot.textbox",ObjRep));
	click(forgot,"forgotpassword");
	WebElement user=driver.findElement(getLocator("Xerox.forgot.user.textbox",ObjRep));
	String u=pro.getProperty("UserName");
	enterText(user,u,"UserNameInForgotPwd");
	WebElement sendlink=driver.findElement(getLocator("Xerox.forgot.sendlink.button",ObjRep));
	click(sendlink,"SendLinkButton");
	driver.close();
}
public static void SignUpToXDC() throws Exception
{
	logger=extent.createTest("SignUpToXDC");
	Browser("firefox");
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("TrialUrl"));	
	Properties ObjRep=loadproperty(ObjRepoPath);
	WebElement freetrail=driver.findElement(getLocator("Xerox.freetrail.button",ObjRep));
	click(freetrail,"freetrail");
	WebElement firstname=driver.findElement(getLocator("Xerox.freetrail.firstname.textbox",ObjRep));
	String f=pro.getProperty("FirstName");
	enterText(firstname,f,"firstnameintrial");
	
	WebElement lastname=driver.findElement(getLocator("Xerox.freetrail.lastname.textbox",ObjRep));
	String l=pro.getProperty("LastName");
	enterText(lastname,l,"lastnameintrial");
	
	WebElement email=driver.findElement(getLocator("Xerox.freetrail.email.textbox",ObjRep));
	String e=pro.getProperty("Email");
	enterText(email,e,"emailintrial");
	
	WebElement phone=driver.findElement(getLocator("Xerox.freetrail.phoneno.textbox",ObjRep));
	String p=pro.getProperty("Phone");
	enterText(phone,p,"firstnameintrial");
	Thread.sleep(1000);
	WebElement country=driver.findElement(getLocator("Xerox.freetrail.county.dropdown",ObjRep));
	selectByText(country,"United States");
	WebElement checkbox=driver.findElement(getLocator("Xerox.freetrail.checkbox",ObjRep));
	click(checkbox,"CheckboxinTrail");
	WebDriverWait wait=new WebDriverWait(driver,40);
	wait.until(ExpectedConditions.elementToBeSelected(checkbox));
	WebElement submit=driver.findElement(getLocator("Xerox.freetrail.submit.button",ObjRep));
	click(submit,"submitbutton");
	driver.close();
}
public static void SignUpToXdc2() throws Exception
{
	logger=extent.createTest("SignUpToXDC2");
	Browser("firefox");
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("TrialUrl"));	
	Properties ObjRep=loadproperty(ObjRepoPath);
	WebElement freetrail=driver.findElement(getLocator("Xerox.freetrail.button",ObjRep));
	click(freetrail,"freetrail");
	WebElement submit=driver.findElement(getLocator("Xerox.freetrail.submit.button",ObjRep));
	click(submit,"submitbutton");
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	String Expected1="First name can't be empty";
	String Expected2="Last name can't be empty";
	String Expected3="Email address can't be empty";
	String Expected4="Phone number can't be empty";
	
//	String[] actual=new String[5];
//	
//	for(int i=0;i<actual.length;i++)
//	{
//		driver.findElement(getLocator("Xerox.freetrail.error",ObjRep)).getText();
//	}
	String actual1=driver.findElement(getLocator("Xerox.freetrail.error1",ObjRep)).getText();
	String actual2=driver.findElement(getLocator("Xerox.freetrail.error2",ObjRep)).getText();
	String actual3=driver.findElement(getLocator("Xerox.freetrail.error3",ObjRep)).getText();
	String actual4=driver.findElement(getLocator("Xerox.freetrail.error4",ObjRep)).getText();
	
	compareError(actual1,Expected1);
	compareError(actual1,Expected2);
	compareError(actual1,Expected3);
	compareError(actual1,Expected4);
	WebElement firstname=driver.findElement(getLocator("Xerox.freetrail.firstname.textbox",ObjRep));
	String f=pro.getProperty("FirstName");
	enterText(firstname,f,"firstnameintrial");
	
	WebElement lastname=driver.findElement(getLocator("Xerox.freetrail.lastname.textbox",ObjRep));
	String l=pro.getProperty("LastName");
	enterText(lastname,l,"lastnameintrial");
	
	WebElement email=driver.findElement(getLocator("Xerox.freetrail.email.textbox",ObjRep));
	String e=pro.getProperty("WrongEmail");
	enterText(email,e,"Wrongemail");
	Thread.sleep(1000);
	WebElement phone=driver.findElement(getLocator("Xerox.freetrail.phoneno.textbox",ObjRep));
	String p=pro.getProperty("Phone");
	enterText(phone,p,"Phonenointrial");
	Thread.sleep(3000);
	WebElement termsaccepted=driver.findElement(getLocator("Xerox.freetrial.termsaccepted",ObjRep));
	click(termsaccepted,"TermsAccepted");
	String Expected="Email address is invalid";
	Thread.sleep(2000);
	System.out.println("hi");
	System.out.println("Barcode cannot be checked");
	
//	String actual=driver.findElement(getLocator("Xerox.freetrail.error1",ObjRep)).getText();
//	System.out.println(actual);
//	System.out.println("out");
//	compareError(actual,Expected);
//	Thread.sleep(4000);
	driver.close();	
}
public static void SignUpToXdc3() throws Exception
{
	logger=extent.createTest("SignUpToXDC3");
	Browser("firefox");
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("TrialUrl"));	
	Properties ObjRep=loadproperty(ObjRepoPath);
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	WebElement freetrail=driver.findElement(getLocator("Xerox.freetrail.button",ObjRep));
	click(freetrail,"freetrail");
	String mainwindow=driver.getWindowHandle();
	System.out.println(mainwindow);
	WebElement termsofuse=driver.findElement(getLocator("Xerox.freetrial.termsofuse",ObjRep));
	click(termsofuse,"TermsOfUse");
	String currentwindow=driver.getWindowHandle();
	windowHandle(mainwindow,currentwindow);
//	Set<String> allwindows=driver.getWindowHandles();
//	Iterator it=allwindows.iterator();
//	while(it.hasNext())
//	{
//		currentwindow=it.next().toString();
//		if(!currentwindow.equals(mainwindow))
//		{
//			driver.switchTo().window(currentwindow);
//			Thread.sleep(1000);
//			driver.close();
//		}
//	}
	
	driver.switchTo().window(mainwindow);
	logger.log(Status.PASS, MarkupHelper.createLabel("Comes back to Parentwindow",ExtentColor.GREEN));
	WebElement privacy=driver.findElement(getLocator("Xerox.freetrial.privacy",ObjRep));
	click(privacy,"Privacy");	
	Thread.sleep(2000);
	String currentwindow2=driver.getWindowHandle();
	windowHandle(mainwindow,currentwindow2);
	driver.quit();
}
public static void SignUpToXdc4() throws Exception
{
	logger=extent.createTest("SignUpToXDC3");
	Browser("firefox");
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("TrialUrl"));	
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	Properties ObjRep=loadproperty(ObjRepoPath);
	WebElement freetrail=driver.findElement(getLocator("Xerox.freetrail.button",ObjRep));
	click(freetrail,"freetrail");
	WebElement offer=driver.findElement(getLocator("Xerox.freetrial.offer",ObjRep));
	click(offer,"offerlink");
	driver.quit();
}
public static void SignUpToXdc5() throws Exception
{
	logger=extent.createTest("SignUpToXDC3");
	Browser("firefox");
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("TrialUrl"));	
	Properties ObjRep=loadproperty(ObjRepoPath);
	WebElement freetrail=driver.findElement(getLocator("Xerox.freetrail.button",ObjRep));
	click(freetrail,"freetrail");
	WebElement accbk=driver.findElement(getLocator("Xerox.freetrial.accorbkkpr",ObjRep));
	click(accbk,"AccBkKprlink");
	Thread.sleep(1000);
	driver.quit();
}
public static void TestAllTabsPage() throws Exception
{
	logger=extent.createTest("TestAllTabsPage");
	Browser("chrome");
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("Url"));
	logger.log(Status.PASS,MarkupHelper.createLabel("Xerox Application is opened",ExtentColor.GREEN));
	Properties ObjRep=loadproperty(ObjRepoPath);
	WebElement user=driver.findElement(getLocator("Xerox.user.textbox",ObjRep));
	String u=pro.getProperty("UserName");
	enterText(user,u,"UserNameForXerox");
	WebElement pwd=driver.findElement(getLocator("Xerox.password.textbox",ObjRep));
	String p=pro.getProperty("Password");
	enterText(pwd,p,"PasswordForXerox");
	WebElement login=driver.findElement(getLocator("Xerox.login.button",ObjRep));
	click(login,"Loginbutton");	
	String Expected="You are currently using a trial account.";
	WebElement trialmsg=driver.findElement(getLocator("Xerox.home.trialmsg",ObjRep));
	String actual=trialmsg.getText();
	compareError(actual,Expected);
	WebElement dashboard=driver.findElement(getLocator("Xerox.home.dashboard",ObjRep));
	click(dashboard,"Dashboard");
	Thread.sleep(2000);
	WebElement accounts=driver.findElement(getLocator("Xerox.home.accounts",ObjRep));
	click(accounts,"AccountsTab");
	Thread.sleep(2000);
	WebElement reports=driver.findElement(getLocator("Xerox.home.reports",ObjRep));
	click(reports,"ReportsTab");
	Thread.sleep(1000);
	WebElement contacts=driver.findElement(getLocator("Xerox.home.contacts",ObjRep));
	click(contacts,"contactsTab");
	WebElement settings=driver.findElement(getLocator("Xerox.home.settings",ObjRep));
	click(settings,"SettingsTab");
	WebElement plus=driver.findElement(getLocator("Xerox.home.plus",ObjRep));
	click(plus,"PlusTab");
	WebElement files=driver.findElement(getLocator("Xerox.home.files",ObjRep));
	click(files,"FilesTab");
	Thread.sleep(1000);
	driver.navigate().back();
	System.out.println("1000");
	WebElement noti=driver.findElement(getLocator("Xerox.home.notifications",ObjRep));
	click(noti,"notiTab");
	logger.log(Status.PASS,MarkupHelper.createLabel("All tabs are checked",ExtentColor.GREEN));
		
}
public static void TestLogoutFunctionality() throws Exception
{
	logger=extent.createTest("TestLogoutFunctionality");
	Browser("chrome");
	WebDriverWait wait=new WebDriverWait(driver,50);
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("Url"));
	logger.log(Status.PASS,MarkupHelper.createLabel("Xerox Application is opened",ExtentColor.GREEN));
	Properties ObjRep=loadproperty(ObjRepoPath);
	WebElement user=driver.findElement(getLocator("Xerox.user.textbox",ObjRep));
	String u=pro.getProperty("UserName");
	enterText(user,u,"UserNameForXerox");
	WebElement pwd=driver.findElement(getLocator("Xerox.password.textbox",ObjRep));
	String p=pro.getProperty("Password");
	enterText(pwd,p,"PasswordForXerox");
	WebElement login=driver.findElement(getLocator("Xerox.login.button",ObjRep));
	click(login,"Loginbutton");		
	WebElement homepgname=driver.findElement(getLocator("Xerox.home.homepgname",ObjRep));
	click(homepgname,"HomePageName");
	WebElement logout=driver.findElement(getLocator("Xerox.home.logout",ObjRep));
	wait.until(ExpectedConditions.elementToBeClickable(logout));
	click(logout,"Logoutbutton");
	logger.log(Status.PASS,MarkupHelper.createLabel("Xerox loggedout Succesfully",ExtentColor.GREEN));
	WebElement usernameafter=driver.findElement(getLocator("Xerox.user.textbox",ObjRep));
	String name=usernameafter.getText();
	System.out.println(name);
	String Expected=pro.getProperty("UserName");
	compareError(name,Expected);
	Thread.sleep(1000);
	driver.close();	
}
public static void TestUploadProfileImg() throws Exception
{
	logger=extent.createTest("TestUploadProfileImg");
	Browser("firefox");
	WebDriverWait wait=new WebDriverWait(driver,50);
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("Url"));
	logger.log(Status.PASS,MarkupHelper.createLabel("Xerox Application is opened",ExtentColor.GREEN));
	Properties ObjRep=loadproperty(ObjRepoPath);
	WebElement user=driver.findElement(getLocator("Xerox.user.textbox",ObjRep));
	String u=pro.getProperty("UserName");
	enterText(user,u,"UserNameForXerox");
	WebElement pwd=driver.findElement(getLocator("Xerox.password.textbox",ObjRep));
	String p=pro.getProperty("Password");
	enterText(pwd,p,"PasswordForXerox");
	WebElement login=driver.findElement(getLocator("Xerox.login.button",ObjRep));
	click(login,"Loginbutton");		
	WebElement homepgname=driver.findElement(getLocator("Xerox.home.homepgname",ObjRep));
	click(homepgname,"HomePageName");
	WebElement profl=driver.findElement(getLocator("Xerox.home.profile",ObjRep));
	Thread.sleep(1000);
	click(profl,"profile");
	WebElement upload=driver.findElement(getLocator("Xerox.profile.upload",ObjRep));
	
	wait.until(ExpectedConditions.elementToBeClickable(upload));
	click(upload,"UploadProfile");
	WebElement browse=driver.findElement(getLocator("Xerox.profile.browse",ObjRep));
	Thread.sleep(2000);
	String img=ScreenShot(driver);
	logger.addScreenCaptureFromPath(img);
	
//	wait.until(ExpectedConditions.elementToBeClickable(browse));
//	click(browse,"browse");
//	Thread.sleep(4000);
//	browse.sendKeys("img.png");
//	Thread.sleep(1000);
	driver.quit();
}
public static void AddAnotherOrganization() throws Exception
{
	logger=extent.createTest("AddAnotherOrganization");
	Browser("firefox");
	WebDriverWait wait=new WebDriverWait(driver,50);
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("Url"));
	logger.log(Status.PASS,MarkupHelper.createLabel("Xerox Application is opened",ExtentColor.GREEN));
	Properties ObjRep=loadproperty(ObjRepoPath);
	WebElement newuser=driver.findElement(getLocator("Xerox.user.textbox",ObjRep));
	String u=pro.getProperty("NewUserName");
	enterText(newuser,u,"NewUserNameForXerox");
	WebElement newpwd=driver.findElement(getLocator("Xerox.password.textbox",ObjRep));
	String p=pro.getProperty("NewUserPwd");
	enterText(newpwd,p,"PasswordForXerox");
	WebElement login=driver.findElement(getLocator("Xerox.login.button",ObjRep));
	click(login,"Loginbutton");	
	WebElement self=driver.findElement(getLocator("Xerox.newuser.self",ObjRep));
	click(self,"Self");
	WebElement myzero=driver.findElement(getLocator("Xerox.newuser.myzero",ObjRep));
	click(myzero,"MyZero");
	WebElement addorg=driver.findElement(getLocator("Xerox.newuser.addorg",ObjRep));
	click(addorg,"addorg");
	Thread.sleep(2000);
	WebElement orgname=driver.findElement(getLocator("Xerox.newuser.orgname.textbox",ObjRep));
	String orgn=pro.getProperty("OrganizationName");
	enterText(orgname,orgn,"Organization name");
	WebElement timezndropdown=driver.findElement(getLocator("Xerox.newuser.orgtimedropdwn",ObjRep));
	click(timezndropdown,"Timezonedropdown");
	driver.findElement(getLocator("Xerox.newuser.valueindropdown",ObjRep)).click();
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	Thread.sleep(1000);
	//wait.until(ExpectedConditions.elementToBeSelected(locator))
	WebElement org=driver.findElement(getLocator("Xerox.newuser.org",ObjRep));
	org.sendKeys("Accounting Services");
	wait.until(ExpectedConditions.elementToBeClickable(org));	
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	Thread.sleep(1000);
	WebElement accsw=driver.findElement(getLocator("Xerox.newuser.accsw",ObjRep));
	click(accsw,"accsw");
	System.out.println("dhf");
	//selectByText(accsw,"Wave");	
	System.out.println("bhsab");
	//wait.until(ExpectedConditions.elementToBeClickable(accsw));
	Thread.sleep(1000);
	WebElement waveoption=driver.findElement(getLocator("Xerox.newuser.optionwave",ObjRep));
	//click(waveoption,"waveoption");
	wait.until(ExpectedConditions.elementToBeClickable(waveoption));
	//selectByText(waveoption,"Wave");	
	WebElement starttrial=driver.findElement(getLocator("Xerox.user.starttrial",ObjRep));
	Thread.sleep(1000);
	click(starttrial,"StartTrialButton");
	driver.close();
	}
public static void AddOrgPaidVersion() throws Exception
{logger=extent.createTest("AddOrgPaidVerion");
Browser("chrome");
WebDriverWait wait=new WebDriverWait(driver,70);
logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
Properties pro=loadproperty(PropPath);
driver.get(pro.getProperty("Url"));
logger.log(Status.PASS,MarkupHelper.createLabel("Xerox Application is opened",ExtentColor.GREEN));
Properties ObjRep=loadproperty(ObjRepoPath);
WebElement newuser=driver.findElement(getLocator("Xerox.user.textbox",ObjRep));
String u=pro.getProperty("NewUserName");
enterText(newuser,u,"NewUserNameForXerox");
WebElement newpwd=driver.findElement(getLocator("Xerox.password.textbox",ObjRep));
String p=pro.getProperty("NewUserPwd");
enterText(newpwd,p,"PasswordForXerox");
WebElement login=driver.findElement(getLocator("Xerox.login.button",ObjRep));
click(login,"Loginbutton");	
WebElement self=driver.findElement(getLocator("Xerox.newuser.self",ObjRep));
click(self,"Self");
WebElement myzero=driver.findElement(getLocator("Xerox.newuser.myzero",ObjRep));
click(myzero,"MyZero");
WebElement addorg=driver.findElement(getLocator("Xerox.newuser.addorg",ObjRep));
click(addorg,"addorg");
Thread.sleep(2000);
WebElement orgname=driver.findElement(getLocator("Xerox.newuser.orgname.textbox",ObjRep));
String orgn=pro.getProperty("OrganizationName");
enterText(orgname,orgn,"Organization name");
WebElement timezndropdown=driver.findElement(getLocator("Xerox.newuser.orgtimedropdwn",ObjRep));
click(timezndropdown,"Timezonedropdown");
driver.findElement(getLocator("Xerox.newuser.valueindropdown",ObjRep)).click();
Robot r=new Robot();
r.keyPress(KeyEvent.VK_TAB);
r.keyRelease(KeyEvent.VK_TAB);
Thread.sleep(1000);
//wait.until(ExpectedConditions.elementToBeSelected(locator))
WebElement org=driver.findElement(getLocator("Xerox.newuser.org",ObjRep));
org.sendKeys("Accounting Services");
wait.until(ExpectedConditions.elementToBeClickable(org));	
r.keyPress(KeyEvent.VK_TAB);
r.keyRelease(KeyEvent.VK_TAB);
Thread.sleep(1000);
WebElement accsw=driver.findElement(getLocator("Xerox.newuser.accsw",ObjRep));
click(accsw,"accsw");
System.out.println("dhf");
//selectByText(accsw,"Wave");	
System.out.println("bhsab");
//wait.until(ExpectedConditions.elementToBeClickable(accsw));
Thread.sleep(1000);
WebElement waveoption=driver.findElement(getLocator("Xerox.newuser.optionwave",ObjRep));
//click(waveoption,"waveoption");
System.out.println("Entering");
//selectByText(waveoption,"Wave");	
wait.until(ExpectedConditions.elementToBeClickable(waveoption));

WebElement buynow=driver.findElement(getLocator("Xerox.user.buynow",ObjRep));
Thread.sleep(1000);
click(buynow,"buynow");
wait.until(ExpectedConditions.elementToBeClickable(buynow));
Thread.sleep(1000);
driver.close();	
}
public static void AddOrgStarterPlan() throws Exception
{
	logger=extent.createTest("AddOrgStarterPlan");
	Browser("chrome");
	WebDriverWait wait=new WebDriverWait(driver,70);
	logger.log(Status.PASS,MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Properties pro=loadproperty(PropPath);
	driver.get(pro.getProperty("Url"));
	logger.log(Status.PASS,MarkupHelper.createLabel("Xerox Application is opened",ExtentColor.GREEN));
	Properties ObjRep=loadproperty(ObjRepoPath);
	WebElement newuser=driver.findElement(getLocator("Xerox.user.textbox",ObjRep));
	String u=pro.getProperty("NewUserName");
	enterText(newuser,u,"NewUserNameForXerox");
	WebElement newpwd=driver.findElement(getLocator("Xerox.password.textbox",ObjRep));
	String p=pro.getProperty("NewUserPwd");
	enterText(newpwd,p,"PasswordForXerox");
	WebElement login=driver.findElement(getLocator("Xerox.login.button",ObjRep));
	click(login,"Loginbutton");	
	WebElement self=driver.findElement(getLocator("Xerox.newuser.self",ObjRep));
	click(self,"Self");
	WebElement myzero=driver.findElement(getLocator("Xerox.newuser.myzero",ObjRep));
	click(myzero,"MyZero");
	WebElement addorg=driver.findElement(getLocator("Xerox.newuser.addorg",ObjRep));
	click(addorg,"addorg");
	Thread.sleep(2000);
	WebElement orgname=driver.findElement(getLocator("Xerox.newuser.orgname.textbox",ObjRep));
	String orgn=pro.getProperty("OrganizationName");
	enterText(orgname,orgn,"Organization name");
	WebElement timezndropdown=driver.findElement(getLocator("Xerox.newuser.orgtimedropdwn",ObjRep));
	click(timezndropdown,"Timezonedropdown");
	driver.findElement(getLocator("Xerox.newuser.valueindropdown",ObjRep)).click();
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	Thread.sleep(1000);
	//wait.until(ExpectedConditions.elementToBeSelected(locator))
	WebElement org=driver.findElement(getLocator("Xerox.newuser.org",ObjRep));
	org.sendKeys("Accounting Services");
	wait.until(ExpectedConditions.elementToBeClickable(org));	
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	Thread.sleep(1000);
	WebElement accsw=driver.findElement(getLocator("Xerox.newuser.accsw",ObjRep));
	click(accsw,"accsw");
	System.out.println("dhf");
	//selectByText(accsw,"Wave");	
	System.out.println("bhsab");
	//wait.until(ExpectedConditions.elementToBeClickable(accsw));
	Thread.sleep(1000);
	WebElement waveoption=driver.findElement(getLocator("Xerox.newuser.optionwave",ObjRep));
	//click(waveoption,"waveoption");
	System.out.println("Entering");
	//selectByText(waveoption,"Wave");	
	wait.until(ExpectedConditions.elementToBeClickable(waveoption));

	WebElement buynow=driver.findElement(getLocator("Xerox.user.buynow",ObjRep));
	Thread.sleep(1000);
	click(buynow,"buynow");
	wait.until(ExpectedConditions.elementToBeClickable(buynow));
	Thread.sleep(1000);
	if(driver.findElement(By.xpath("//input[@class='xui-styledcheckboxradio--input']")).getAttribute("value").matches("on"))
	{System.out.println("hudkj");
	Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@text='Starter']")).click();
	}
	else
		System.out.println("not found");
//	WebElement starterradio=driver.findElement(getLocator("Xerox.newuser.starterradio",ObjRep));
//	click(starterradio,"StarterOption");
//	wait.until(ExpectedConditions.elementToBeClickable(starterradio));
//	WebElement contbilling=driver.findElement(getLocator("Xerox.newuser.contbilling",ObjRep));
//	click(contbilling,"ContinueBilling");
driver.close();
}
}