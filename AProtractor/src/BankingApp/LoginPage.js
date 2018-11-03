var datajson=require("C:/Users/prade/eclipse-workspace/AProtractor/src/BankingApp/data.json");

var loginpage=function()
{

 	var cuslogin=element(by.buttonText("Customer Login"));
 	var manlogin=element(by.buttonText("Bank Manager Login"));
 	//browser.wait().manage().implicitlyWait(6000);
 	
 	this.CusLogin=function()
 	{
 		browser.sleep(2000);
 		
 		expect(cuslogin.getText()).toEqual("Customer Login");
 		
 		element(cuslogin.getText().then(function(text) {
 			  console.log(text);
 			 expect(cuslogin.getText().isPresent()).toEqual(true);
 			}));
 		return this;
 	}
 		
 	this.MangLogin=function()
 	{
 		browser.sleep(2000);
 		expect(manlogin.getText()).toEqual("Bank Manager Login");
 		element(manlogin.getText().then(function(text) {
 			  console.log(text);
 			}));
 		return this;
 	}
 	this.MangLoginClick=function()
 	{
 		browser.sleep(2000);
 		manlogin.click();
 		browser.sleep(2900);
 		return require("./ManagerOpt.js");
 	}
}
module.exports=new loginpage();
