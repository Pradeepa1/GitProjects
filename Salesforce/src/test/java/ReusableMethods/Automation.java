package ReusableMethods;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Automation extends MethodsToReuse {

	static String Propertypath="C:\\Users\\prade\\git\\repository3\\GitProjects\\Salesforce\\src\\test\\resources\\DataFiles\\configuration.properties";
	   static String ObjRepoPath="C:\\Users\\prade\\git\\repository3\\GitProjects\\Salesforce\\src\\test\\resources\\ObjectRepositories\\ObjRep.properties";
		public static void LoginToSFDC() throws Exception
		{
			logger = extent.createTest("loginToSFDC");
			Properties pro=loadpropertyfile(Propertypath);
				
			System.setProperty("webdriver.gecko.driver","./src/Utility/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get(pro.getProperty("Url"));
			logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			Properties ObjRepo=loadpropertyfile(ObjRepoPath);
			//System.out.println("Entering the ObjRepo");
			//System.out.println(ObjRepo.getProperty("Salesforce.username.textbox"));
			WebElement username=driver.findElement(getLocator("Salesforce.username.textbox",ObjRepo));		
			//CredentialsFromProperties(username);
			//enterText(username,"pradeepajul11@gmail.com","Username");
			Thread.sleep(1000);
			String u=pro.getProperty("Username");
			enterText(username,u,"Username");
			
			Thread.sleep(1000);
			WebElement password=driver.findElement(getLocator("Salesforce.password.textbox",ObjRepo));
			//CredentialsFromProperties("password");
			String p=pro.getProperty("Password");
			enterText(password,p,"password");
			
			WebElement loginButton=driver.findElement(getLocator("Salesforce.login.button",ObjRepo));
			click(loginButton,"LoginButton");	
			driver.quit();
		logger.log(Status.PASS,MarkupHelper.createLabel("Firefox is closed",ExtentColor.GREEN));
		
		}	

		public static void Validate_Login_Error_Message_5() throws Exception 
		{
		logger=extent.createTest("Validate Error Message 5");
		Properties pro=loadpropertyfile(Propertypath);
		Properties ObjRepo=loadpropertyfile(ObjRepoPath);
		launchApplication("firefox");
		logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		WebElement userName=driver.findElement(getLocator("Salesforce.username.textbox",ObjRepo));
	enterText(userName,"123@gmail.com","Username");

		WebElement Password=driver.findElement(getLocator("Salesforce.password.textbox",ObjRepo));
	enterText(Password,"22321","password");
		
		WebElement loginButton=driver.findElement(getLocator("Salesforce.login.button",ObjRepo));

	click(loginButton,"LoginButton");
		
		String ErrorMsg=driver.findElement(getLocator("Salesforce.errormsg",ObjRepo)).getText();
		
		String ExpectedError="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	validateError_Msg(ErrorMsg, ExpectedError);	
	driver.quit();
	logger.log(Status.PASS,MarkupHelper.createLabel("Firefox is closed",ExtentColor.GREEN));
	}
		

		public static void Check_RemeberMe_3()throws Exception
		{
		logger=extent.createTest("Check RememberMe 3");
		Properties pro=loadpropertyfile(Propertypath);
		Properties ObjRepo=loadpropertyfile(ObjRepoPath);
		launchApplication("firefox");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		WebElement username=driver.findElement(getLocator("Salesforce.username.textbox",ObjRepo));		
		String u=pro.getProperty("Username");
		enterText(username,u,"Username");
		
		Thread.sleep(1000);
		WebElement password=driver.findElement(getLocator("Salesforce.password.textbox",ObjRepo));
		String p=pro.getProperty("Password");
		enterText(password,p,"password");
		
		WebElement Remember=driver.findElement(getLocator("Salesforce.Remember.checkbox",ObjRepo));
	    click(Remember,"RememberBox");
		Thread.sleep(1000);
		WebElement logout=driver.findElement(getLocator("Salesforce.logout.button",ObjRepo));
		Thread.sleep(3000);
		click(logout,"LogoutButton");
		driver.quit();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox is closed",ExtentColor.GREEN));
		}
	public static void Forgot_Password() throws Exception
	{
		logger=extent.createTest("Forgot Password");
		
		launchApplication("chrome");
		logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement ForgotPass=driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
click(ForgotPass,"Forgot password button");
		WebElement UserName=driver.findElement(By.xpath("//input[@id='un']"));
enterText(UserName,"pradeepajul11@gmail.com","Username");
		WebElement Continue_Button=driver.findElement(By.xpath("//input[@id='continue']"));

click(Continue_Button,"Continue button");
driver.quit();
logger.log(Status.PASS, MarkupHelper.createLabel("Firefox is closed",ExtentColor.GREEN));
		
	}
    
	public static void UserMenuDropDown() throws Exception
	{	logger=extent.createTest("UserMenuDropDown");
	
	launchApplication("firefox");
	logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
	enterText(userName,"pradeepajul11@gmail.com","Username");
		Thread.sleep(1000);
		WebElement Password=driver.findElement(By.xpath("//input[@id='password']"));
	enterText(Password,"p*6194329354","password");
		Thread.sleep(1000);
		WebElement loginButton=driver.findElement(By.xpath("//input[@id='Login']"));
	click(loginButton,"LoginButton");
		Thread.sleep(3000);	
		WebElement UserMenu = driver.findElement((By.xpath("//*[@id=\"userNav-arrow\"]")));
	//visibilityOfElementWait(UserMenu);	
	click(UserMenu,"UserMenu");
	driver.quit();
	logger.log(Status.PASS, MarkupHelper.createLabel("Firefox is closed",ExtentColor.GREEN));
	}
     
	public static void MySettings() throws Exception
	{logger=extent.createTest("MY SETTINGS TAB");
	
	launchApplication("firefox");
	logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
	enterText(userName,"pradeepajul11@gmail.com","Username");
		Thread.sleep(1000);
		WebElement Password=driver.findElement(By.xpath("//input[@id='password']"));
	enterText(Password,"p*6194329354","password");
		Thread.sleep(1000);
		WebElement loginButton=driver.findElement(By.xpath("//input[@id='Login']"));
	click(loginButton,"LoginButton");
		Thread.sleep(3000);	
		WebElement UserMenu = driver.findElement((By.xpath("//*[@id=\"userNav-arrow\"]")));
	//visibilityOfElementWait(UserMenu);	
	click(UserMenu,"UserMenu");
		WebElement Settings=driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[2]"));
		Thread.sleep(1000);	
		click(Settings,"Settings");
		WebElement personalinfo=driver.findElement(By.xpath("//span[@id='PersonalInfo_font']"));
		click(personalinfo,"Personalinfo");
		WebElement LoginHistory=driver.findElement(By.xpath(" //a[@id='LoginHistory_font']"));
		click(LoginHistory,"LoginHistory");
		WebElement Downloadframe=driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/div/a"));
		click(Downloadframe,"Downloadframe");
		//Dont know how to download the file.
		
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		//
		WebElement Display=driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
		click(Display,"display");
		driver.quit();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox is closed",ExtentColor.GREEN));
		
	}
     
	public static void DeveloperConsole() throws Exception 
	{logger=extent.createTest("Developers Tab");
	
	launchApplication("firefox");
	logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement UserName=driver.findElement(By.id("username"));
		enterText(UserName,"pradeepajul11@gmail.com","Username");
		WebElement Password=driver.findElement(By.id("password"));
		enterText(Password,"p*6194329354","Password");
		WebElement Login=driver.findElement(By.id("Login"));
		click(Login,"LoginButton");
		Thread.sleep(3000);
		WebElement UserMenu = driver.findElement((By.xpath("//*[@id='userNav-arrow']")));
		click(UserMenu,"UserMenu");	
		Thread.sleep(3000);	
		WebElement DeveloperConsole=driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[3]"));
		Thread.sleep(1000);	
		click(DeveloperConsole,"DeveloperconsoleTab");
		String mainwindow=driver.getWindowHandle();
		System.out.println(mainwindow);
		Set<String> Allwindows=driver.getWindowHandles();
		System.out.println(Allwindows);
		Iterator it=Allwindows.iterator();
		String CurrentWindowId;
		while(it.hasNext())
		{
		CurrentWindowId =it.next().toString();
		if(!(CurrentWindowId.equals(mainwindow)))
		{
			driver.switchTo().window(CurrentWindowId);
			Thread.sleep(1000);
			driver.close();
		}
		}
		driver.quit();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox is closed",ExtentColor.GREEN));
	}
     
	public static void MyProfile() throws Exception
	{logger=extent.createTest("My Profile TAB");
	
	launchApplication("firefox");
	logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	WebElement UserName=driver.findElement(By.id("username"));
	enterText(UserName,"pradeepajul11@gmail.com","Username");
	WebElement Password=driver.findElement(By.id("password"));
	enterText(Password,"p*6194329354","Password");
	WebElement Login=driver.findElement(By.id("Login"));
	click(Login,"LoginButton");
	Thread.sleep(3000);
	WebElement UserMenu = driver.findElement((By.xpath("//*[@id='userNav-arrow']")));
	click(UserMenu,"Usermenu");	
	Thread.sleep(3000);
	WebElement ProfileOption=driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[1]"));
	Thread.sleep(1000);	
	click(ProfileOption,"profileoption");
	WebElement EditProfile=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
	click(EditProfile,"Editprofile");

	driver.switchTo().frame("contactInfoContentId");
	Thread.sleep(1000);
	WebElement AboutTab=driver.findElement(By.xpath("//*[@id='aboutTab']"));
	click(AboutTab,"AboutTab");
	Thread.sleep(1000);	
	WebElement LastName=driver.findElement(By.xpath("//*[@id='lastName']"));
	LastName.clear();
	LastName.sendKeys("Chidambaram");
	Thread.sleep(1000);
	WebElement SaveAll=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]"));
	click(SaveAll,"Saveall button");
	driver.switchTo().defaultContent();
	Thread.sleep(2000);
	WebElement post=driver.findElement(By.xpath("//span[text()='Post']"));
	click(post,"Post");
	Thread.sleep(2000);	
	
	WebElement framexpath=driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
	Thread.sleep(1000);
	click(framexpath,"Framepath");
	Thread.sleep(1000);
	driver.switchTo().frame(framexpath);
	Thread.sleep(1000);
	System.out.println("Posting");	
	Thread.sleep(1000);
	WebElement txt=driver.findElement(By.cssSelector("body"));
	txt.sendKeys("My 1st Post");
	driver.switchTo().defaultContent();
	Thread.sleep(1000);
	System.out.println("hhi posted");
	Thread.sleep(1000);		
	WebElement Share=driver.findElement(By.xpath(" //input[@id='publishersharebutton']"));
	click(Share,"Share button");
	 WebElement File=driver.findElement(By.xpath("//span[contains(text(),'File')]"));
	 Thread.sleep(3000);
	 WebElement img=driver.findElement(By.xpath("//span[@class='profileImage chatter-avatarFull chatter-avatar']"));
	 Actions a=new Actions(driver);
	 a.moveToElement(img).build().perform();
	 WebElement Upload=driver.findElement(By.xpath("//a[@id='uploadLink']"));
	click(Upload,"Upload");
	Thread.sleep(3000);
		WebElement photoframe=driver.findElement(By.id("uploadPhotoContentId"));
		driver.switchTo().frame(photoframe);
		WebDriverWait wait=new WebDriverWait(driver,40);
		WebElement browsePhoto=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_id0:uploadFileForm:uploadInputFile']")));
	
//		browsePhoto.sendKeys("D:\\Picture.txt");
//	
//		WebElement savePhoto=driver.findElement(By.xpath("//*[@id='j_id0:uploadFileForm:uploadBtn']"));
//		savePhoto.click();
//		
////		Actions action=new Actions(driver); 
////		action.dragAndDropBy(driver.findElement(By.xpath(".//*[@id='j_id0:outer']/div[1]/div/div/div/div[6]")), 100, 20);
//		driver.findElement(By.xpath("//*[@id='j_id0:j_id7:save']")).click(); 
//		
//		driver.switchTo().defaultContent();
		driver.quit();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox is closed",ExtentColor.GREEN));
	}
     
	public static void CreateAccountInCreateAccount() throws Exception 
		{
		logger=extent.createTest("CreateAccount");	
		launchApplication("firefox");
		logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
		WebDriverWait wait=new WebDriverWait(driver,30);//explicitwait
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("pradeepajul11@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("p*6194329354");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		System.out.println("Entering account");
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		System.out.println("closing");
		Thread.sleep(1000);
		WebElement createnewbutton=driver.findElement(By.xpath("//div[@id='createNewButton']"));
		wait.until(ExpectedConditions.elementToBeClickable(createnewbutton));
		click(createnewbutton,"Create new button");
		WebElement accmenuButton=driver.findElement(By.xpath("//div/a[@class='accountMru menuButtonMenuLink']"));
		click(accmenuButton,"AccountMneu Button");
		WebElement txt=driver.findElement(By.xpath("//input[@id='acc2']"));
		enterText(txt,"AccountName1","name");
		WebElement save= driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[1]/table/tbody/tr/td[2]/input[1]"));
		click(save,"Save button");
		driver.quit();
		logger.log(Status.PASS, MarkupHelper.createLabel("Closing the firefox",ExtentColor.GREEN));
		}
    
	public static void CreateNewViewInCreateAccount() throws Exception
	{
			logger=extent.createTest("CReateNewViewInCreateAccount");	
			launchApplication("firefox");
			logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
			WebDriverWait wait=new WebDriverWait(driver,30);
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("pradeepajul11@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("p*6194329354");
			driver.findElement(By.xpath("//input[@id='Login']")).click();
			System.out.println("Entering account");
			driver.findElement(By.xpath("//a[text()='Accounts']")).click();
			System.out.println("closing");
			Thread.sleep(1000);
			WebElement CreateNewView=driver.findElement(By.xpath("//div/span/span/a[text()='Create New View']"));
			click(CreateNewView,"CreateNewView");
			WebElement ViewName=driver.findElement(By.xpath("//input[@id='fname']"));
			enterText(ViewName,"Pradeepa c","ViewNameInAccountsTab");
			WebElement ViewUniquename=driver.findElement(By.xpath("//input[@id='devname']"));
			enterText(ViewUniquename,"Pc","ViewUniqueNameInAccountsTab");			
			WebElement save=driver.findElement(By.xpath("//input[@class='btn primary']"));			
			wait.until(ExpectedConditions.elementToBeClickable(save));
			click(save,"Savebutton");			
			driver.quit();
			logger.log(Status.PASS, MarkupHelper.createLabel("Closing the firefox",ExtentColor.GREEN));
		}
     
	public static void EditViewInCreateAccount() throws Exception 
	{
		logger=extent.createTest("CReateEditViewInCreateAccount");	
		launchApplication("firefox");
		logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
		WebDriverWait wait=new WebDriverWait(driver,30);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("pradeepajul11@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("p*6194329354");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(1000);
		System.out.println("Entering account");
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		System.out.println("closing");
		Thread.sleep(1000);
//		WebDriverWait wait1 = new WebDriverWait(driver, 500);
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/nav/ul//a[text()='Accounts']"))).click();
		
		WebElement Edit=driver.findElement(By.xpath("//div/span/span/a[text()='Edit']"));
		click(Edit,"EditButton");
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Deepa");	
		
			WebElement Field=driver.findElement(By.id("fcol1"));
			selectByVisibleText(Field,"Account Name");	
			wait.until(ExpectedConditions.elementToBeClickable(Field));
			WebElement Operator=driver.findElement(By.id("fop1"));
			selectByVisibleText(Operator,"contains");			
			WebElement Fval1=driver.findElement(By.xpath("//input[@id='fval1']"));
			Fval1.clear();
			enterText(Fval1,"a","value");
			WebElement AvailField=driver.findElement(By.id("colselector_select_0"));
			selectByVisibleText(AvailField,"Last Activity");
			Thread.sleep(1000);
			WebElement Add=driver.findElement(By.xpath("//div/a[@id='colselector_select_0_right']"));
			click(Add,"add");						
			WebElement save=driver.findElement(By.xpath("//input[@class='btn primary']"));
			click(save,"SaveButton");
			driver.quit();
			logger.log(Status.PASS, MarkupHelper.createLabel("Firefox is closed", ExtentColor.GREEN));			
		}
     
	public static void MergeAccountsInCreateAccount() throws Exception
	{	logger=extent.createTest("MergeAccountsInCreateAccount");
		launchApplication("chrome");
		logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
		WebDriverWait wait=new WebDriverWait(driver,30);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("pradeepajul11@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("p*6194329354");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		System.out.println("Entering account");
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		System.out.println("closing");
		Thread.sleep(1000);
		WebElement Merg=driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		click(Merg,"Merge");
		WebElement AccountToMerge=driver.findElement(By.xpath("//input[@id='srch']"));
		enterText(AccountToMerge,"AccountName1","Alphabetstomerge");
		WebElement click=driver.findElement(By.xpath("//input[@value='Find Accounts']"));
		wait.until(ExpectedConditions.elementToBeClickable(click));
		click(click,"ClickToCheckAcc sStarts With aaa");
		Thread.sleep(1000);
		WebElement account1=driver.findElement(By.xpath(" //input[@id='cid0']"));
		click(account1,"SelectAccount1");
		WebElement account2=driver.findElement(By.xpath(" //input[@id='cid1']"));
		click(account2,"SelectAccount2");
		WebElement account3=driver.findElement(By.xpath(" //input[@id='cid2']"));
		click(account3,"SelectAccount3");			
		WebElement Next=driver.findElement(By.xpath("//div[@class='pbTopButtons']//input[@title='Next']"));
		click(Next,"NextButton");
		WebElement Merging=driver.findElement(By.xpath("//div[@class='pbTopButtons']//input[@title='Merge']"));
		click(Merging,"Merge");
		
		driver.quit();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox is closed", ExtentColor.GREEN));	
		}
     
	public static void CreateNewOptyInCreateOpty() throws Exception
	{	logger=extent.createTest("CreateNewOptyInOppurtunity");		
		launchApplication("chrome");
		logger.log(Status.PASS, MarkupHelper.createLabel("Application is launched",ExtentColor.GREEN));
		WebDriverWait wait=new WebDriverWait(driver,30);		
		Oppurtunity();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);		
		Thread.sleep(1000);
		WebElement New=driver.findElement(By.xpath("//input[@title='New']"));
		click(New,"New Button");
		WebElement oppName=driver.findElement(By.xpath("//input[@id='opp3']"));
		enterText(oppName,"Oppurt 1","OptName");
		WebElement AccountName1=driver.findElement(By.xpath(" //input[@id='opp4']"));
		enterText(AccountName1,"aaa","AccountName1");
		WebElement date=driver.findElement(By.xpath(" //input[@id='opp9']"));
		click(date,"date");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='calToday']")).click();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		WebElement stage=driver.findElement(By.xpath("//select[@id='opp11']"));
		click(stage,"Stage");		
		selectByVisibleText(stage,"Qualification");
		Thread.sleep(1000);
		WebElement Type=driver.findElement(By.xpath("//select[@id='opp5']"));
		click(Type,"Type");		
		selectByVisibleText(Type,"Existing Customer - Upgrade");
		String img=takeScreenShot(driver);
		logger.addScreenCaptureFromPath(img);
		
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']")).click();
		driver.quit();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox is closed", ExtentColor.GREEN));	
		
		logger.addScreenCaptureFromPath(img);
	}
	public static void SelectUserMenuinCreateOpty() throws Exception
	{ 
	logger=extent.createTest("DropDownInOpty");
	launchApplication("chrome");	
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	Oppurtunity();
	Thread.sleep(1000);	
	WebElement opt=driver.findElement(By.xpath("//select[@id='fcf']"));
	click(opt,"options");			
	String choice[]= { "All Oppotunities","Closing Next Month","Closing This Month","My Opportunities","New Last Week","New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities","Won"};
	WebElement selectid=driver.findElement(By.id("fcf"));
	CompareDropdown(choice,selectid );
//	List<WebElement> element=select.getOptions();
//	for(WebElement w:element)
//	{
//	for(int i=1;i<element.size();i++)
//	{
//	if(w.getText().equals(choice[i]))
//		{
//		System.out.println("equal");
//		break;
//		}
//	}
//	}
	driver.quit();
	logger.log(Status.PASS, MarkupHelper.createLabel("Firefox is closed but error", ExtentColor.GREEN));
	String img=takeScreenShot(driver);
	logger.addScreenCaptureFromPath(img);		
		}

}
