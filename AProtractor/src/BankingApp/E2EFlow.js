var flow=require("C:/Users/prade/eclipse-workspace/AProtractor/src/BankingApp/data.json");//process.cwd()+"/src/.json" current working directory
var winston=require('winston');
winston.add(new winston.transports.File({
	  filename: 'Reports/logger.log',
	  handleExceptions: true
	}));
var login=require(process.cwd()+"/src/BankingApp/LoginPage.js");
describe("E2E flow",function()
		{
	it("Inside the flow",function()
			{
		browser.sleep(6000);
		browser.get(flow.url);
		winston.info("urlOpened","urlinfo");
		browser.sleep(3000);		
		login.CusLogin();
		winston.info("CheckingCustomerLogin","logininfo");
		login.MangLogin();
		var Mangr=login.MangLoginClick();
		Mangr.Options();
		Mangr.AddCust();
		Mangr.OpenAccDollar();
		Mangr.OpenAccPound();
		Mangr.OpenAccRupee();
		var C=Mangr.Customers();
		var Transaction=C.customer();
		Transaction.HPTransaction();
		Transaction.InitialTransaction();
		Transaction.DepositMoney();
		Transaction.TransactionAfterDep();
		Transaction.WithDrawError();
		Transaction.WithDrawSuccess();
		Transaction.TransactionAfterWithdrawl();
		Transaction.Mainpage();
		Transaction.Logout();
	});
});