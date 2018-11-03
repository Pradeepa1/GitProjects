

var manager=function()
{
	var addcust=element(by.buttonText("Add Customer"));
	var openacc=element(by.buttonText("Open Account"));
	var cust=element(by.buttonText("Customers"));
	var fname=element(by.model("fName"));
	var lname=element(by.model("lName"));
	var postcode=element(by.model("postCd"));
	var submit=element(by.className("btn btn-default"));
	var openaccount=element(by.buttonText("Open Account"));
	var customerid=element(by.model("custId"));
	var currency=element(by.id("currency"));
	var process=element(by.buttonText("Process"));
	var customerstab=element(by.buttonText("Customers"));
	var searchcust=element(by.model("searchCustomer"));
	var deletecust=element(by.buttonText("Delete"));
	var homepage=element(by.buttonText("Home"));
	this.Options=function()
	{
		element(addcust.getText().then(function(text) {
			  console.log(text);
			}));		
		expect(addcust.getText()).toEqual("Add Customer");
		element(openacc.getText().then(function(text) {
			  console.log(text);
			}));
		expect(openacc.getText()).toEqual("Open Account");
		element(cust.getText().then(function(text) {
			  console.log(text);
			}));
		expect(cust.getText()).toEqual("Customers");
		return this;
	}
	this.AddCust=function()
	{
		addcust.click();
		fname.sendKeys("aaa");
		lname.sendKeys("bbb");
		postcode.sendKeys("534561")
		browser.sleep(3000);	
		submit.click();
		var alt=browser.switchTo().alert();
		
		element(alt.getText().then(function(text) {
			  console.log(text);
			  expect(text).toEqual("Customer added successfully with customer id :6");
			}));
		
		browser.sleep(6000);
		
		browser.switchTo().alert().accept();
		return this;
	}
	
	this.OpenAccDollar=function()
	{
		openaccount.click();
		customerid.click();
		browser.sleep(2000);
		element(by.model("custId")).click();
		element.all(by.repeater('cust in Customers')).then(function(options){

			   options[5].click();
		 });		
		browser.sleep(5000);
		element(by.model('currency')).$('[value="Dollar"]').click();
		process.click();
		var alt=browser.switchTo().alert();
		
		element(alt.getText().then(function(text) {
			  console.log(text);
			  expect(text).toEqual("Account created successfully with account Number :1016");
			}));
		browser.switchTo().alert().accept();
		return this;
		
	}
	this.OpenAccPound=function()
	{
		openaccount.click();
		customerid.click();
		browser.sleep(2000);
		element(by.model("custId")).click();
		element.all(by.repeater('cust in Customers')).then(function(options){

			   options[5].click();
		 });		
		browser.sleep(5000);
		element(by.model('currency')).$('[value="Pound"]').click();
		process.click();
		var alt=browser.switchTo().alert();
		
		element(alt.getText().then(function(text) {
			  console.log(text);
			  expect(text).toEqual("Account created successfully with account Number :1017");
			}));
		browser.switchTo().alert().accept();
		return this;	
	}
	this.OpenAccRupee=function()
	{
		openaccount.click();
		customerid.click();
		browser.sleep(2000);
		element(by.model("custId")).click();
		element.all(by.repeater('cust in Customers')).then(function(options){

			   options[5].click();
		 });		
		browser.sleep(5000);
		element(by.model('currency')).$('[value="Rupee"]').click();
		process.click();
		var alt=browser.switchTo().alert();
		
		element(alt.getText().then(function(text) {
			  console.log(text);
			  expect(text).toEqual("Account created successfully with account Number :1018");
			}));
		browser.switchTo().alert().accept();
		return this;	
	}
	this.Customers=function()
	{
		customerstab.click();
		browser.sleep(4000);
		searchcust.sendKeys("aaa");
		searchcust.click();
		deletecust.click();
		homepage.click();
	
	return require("./CustomerLogin.js")
		
	}
		
}
module.exports=new manager();