//console.log("jdasgh");
var datajson=require("C:/Users/prade/eclipse-workspace/AProtractor/src/BankingApp/data.json");
var customerlogin=function()
{
	var cust=element(by.buttonText("Customer Login"));
	var dropdown=element.all(by.repeater('cust in Customers'));
	var login=element(by.buttonText("Login"));
	
	this.customer=function()
	{
		browser.sleep(3000);			
		cust.click();
		dropdown.then(function(options){

			   options[1].click(); //Harrypotter
		 });
		login.click();
		browser.sleep(3000);
		return require("./HPAccount.js");
	}
	
}

module.exports=new customerlogin();
