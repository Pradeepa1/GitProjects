var datajson=require("C:/Users/prade/eclipse-workspace/AProtractor/src/BankingApp/data.json");
var harrypotteraccount=function()
{
	var name=element(by.className("ng-binding"));
	var checkdollar=element(by.xpath("//strong[contains(text(),'Dollar')]"));
	var clickdollar=element.all(by.options("account for account in Accounts"));
	var checkpound=element(by.xpath("//strong[contains(text(),'Pound')]"));
	var clickpound=element.all(by.options("account for account in Accounts"));
	var checkrupee=element(by.xpath("//strong[contains(text(),'Rupee')]"));
	var trans=element(by.partialButtonText("Transactions"));
	var initialtrans=element.all(by.repeater('tx in transactions'));
	var amount=element(by.xpath("//td[contains(text(),'0')]"));
	var back=element(by.buttonText("Back"));
	var deposit=element(by.buttonText("Deposit"));
	var depamt=element(by.model("amount"));
	var submit=element(by.className("btn btn-default"));
	var depmsg=element(by.className("error ng-binding"));
	var home=element(by.buttonText("Home"));
	var withdrawl=element(by.partialButtonText("Withdrawl"));
	var withdrawlconf=element(by.buttonText("Withdraw"));
	var reset=element(by.buttonText("Reset"));
	var logout=element(by.buttonText("Logout"));
	this.HPTransaction=function()
	{
		browser.sleep(3000);	
		name.getText();
		
		browser.sleep(3000);
		
		expect(checkdollar.getText()).toBe('Dollar');
		clickdollar.then(function(opt){
			opt[1].click();
		});
		browser.sleep(3000);
		expect(checkpound.getText()).toBe('Pound');
		clickpound.then(function(opt){
			opt[2].click();
		});
		browser.sleep(3000);
		expect(checkrupee.getText()).toBe('Rupee');
		browser.sleep(2000);
		
	}
	this.InitialTransaction=function()
	{
		trans.click();		
		browser.sleep(5000);
		initialtrans.then(function(rows){
		    rows.forEach(function(row){
		        row.all(by.tagName('td')).then(function(columns){
		        	
		            /* For getting text in Amount column*/
		            columns[1].getAttribute('innerText').then(function(amountText){
		                console.log('Amount: ' + amountText);
		                expect(amount.getText()).toBe('0');
		            });
		            
		        });
		    });
		});
		back.click();
		return this;
	}
	this.DepositMoney=function()
	{
		browser.sleep(2000);
		element.all(by.options("account for account in Accounts")).then(function(opt){
			opt[2].click();
		});
		
		deposit.click();
		depamt.click();
		depamt.sendKeys(datajson.depamount);
		submit.click();
		var e=depmsg.getText();
		expect(e).toBe("Deposit Successful");
		console.log(e);
		browser.sleep(2000);
		
		return this;
	}
	this.TransactionAfterDep=function()
	{
		trans.click();		
		initialtrans.then(function(rows){
		    rows.forEach(function(row){
		        row.all(by.tagName('td')).then(function(columns){
		            
		            columns[1].getAttribute('innerText').then(function(amountText){
		                console.log('Amount: ' + amountText);
		 expect(element(by.xpath("//td[contains(text(),'2000')]")).getText()).toBe('2000');
		            });		            
		        });
		    });
		});
		browser.sleep(6000);
		back.click();
		return this;
	}
	this.WithDrawError=function()
	{
		browser.sleep(3000);
		element.all(by.options("account for account in Accounts")).then(function(opt){
			opt[2].click();
		});
		withdrawl.click();
		depamt.click();
		depamt.sendKeys(datajson.withdrawamount);				
		browser.sleep(2000);
		withdrawlconf.click();		
		expect(depmsg.getText()).toEqual('Transaction Failed. You can not withdraw amount more than the balance.');
		browser.sleep(4000);
		return this;
	}
	this.WithDrawSuccess=function()
	{		
		depamt.sendKeys(datajson.withdrawamount1);				
		browser.sleep(2000);
		withdrawlconf.click();		
		expect(depmsg.getText()).toEqual("Transaction successful");		
		browser.sleep(4000);
		
	}
	this.TransactionAfterWithdrawl=function()
	{
		browser.sleep(3000);			
		trans.click();
		element.all(by.repeater('tx in transactions')).then(function(rows){
		    rows.forEach(function(row){
		        row.all(by.tagName('td')).then(function(columns){
		            
		            /* For getting text in Amount column*/
		            columns[1].getAttribute('innerText').then(function(amountText){
		                console.log('Amount: ' + amountText);
		 expect(element(by.xpath("//td[contains(text(),'1001')]")).getText()).toBe('1001');
		            });
		        });
		    });
		});
		browser.sleep(6000);
	}
	this.TransactionReset=function()
	{
		trans.click();
		reset.click();
		browser.sleep(5000);
		element.all(by.repeater('tx in transactions')).then(function(rows){
		    rows.forEach(function(row){
		        row.all(by.tagName('td')).then(function(columns){
		            
		            /* For getting text in Amount column*/
		            columns[1].getAttribute('innerText').then(function(amountText){
		                console.log('Amount: ' + amountText);
		                expect(element(by.xpath("//td[contains(text(),'0')]")).getText()).toBe('0');
		            });
		        });
		    });
		});
		
	}
	this.Mainpage=function()
	{
		back.click();
	}
	this.Logout=function()
	{
		logout.click();
	}
}

module.exports=new harrypotteraccount();
