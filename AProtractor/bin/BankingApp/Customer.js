
var datajson=require("C:/Users/prade/eclipse-workspace/AProtractor/src/BankingApp/data.json");
var winston=require('winston');
describe("Customer",function()
{
	beforeEach(function(){
		browser.get(datajson.url);
	});
	afterEach(function(){
		console.log("End of the test");	
	});
	it("LoginPage",function()
		{
		browser.sleep(3000);
		
		var cuslog=element(by.buttonText("Customer Login"));
		console.log("messageerror="+cuslog);
		expect(cuslog.getText()).toEqual('Customer Login');
		browser.sleep(2000);
		var manlog=element(by.buttonText("Bank Manager Login"));
		console.log("messageerror="+manlog);
		expect(manlog.getText()).toEqual('Bank Manager Login');
		browser.sleep(2000);
	}),
	//VerifyCurrencyType2
	it("VerifyCurrencyType2",function()
			{
			browser.sleep(3000);			
			element(by.buttonText("Customer Login")).click();
			element.all(by.repeater('cust in Customers')).then(function(options){

				   options[1].click(); //Harrypotter
			 });
			element(by.buttonText("Login")).click();
			var d=element(by.className("ng-binding")).getText();
			console.log(d);
			browser.sleep(3000);
			//expect(element(by.className("ng-binding")).getText().toBe("Dollar"));
			expect(element(by.xpath("//strong[contains(text(),'Dollar')]")).getText()).toBe('Dollar');
			element.all(by.options("account for account in Accounts")).then(function(opt){
				opt[1].click();
			});
			browser.sleep(3000);
			expect(element(by.xpath("//strong[contains(text(),'Pound')]")).getText()).toBe('Pound');
			element.all(by.options("account for account in Accounts")).then(function(opt){
				opt[2].click();
			});
			browser.sleep(3000);
			expect(element(by.xpath("//strong[contains(text(),'Rupee')]")).getText()).toBe('Rupee');
			browser.sleep(2000);
		}),
	//InitialTransaction3
	it("InitialTransaction3",function()
			{
			browser.sleep(3000);			
			element(by.buttonText("Customer Login")).click();
			element.all(by.repeater('cust in Customers')).then(function(options){

				   options[1].click(); //Harrypotter
			 });
			element(by.buttonText("Login")).click();
			element(by.partialButtonText("Transactions")).click();
			
			browser.sleep(5000);
			element.all(by.repeater('tx in transactions')).then(function(rows){
			    rows.forEach(function(row){
			        row.all(by.tagName('td')).then(function(columns){
			            /* For getting text in date column*/
			            columns[0].getAttribute('innerText').then(function(dateText){
			                console.log('Date: ' + dateText);
			            });
			            /* For getting text in Amount column*/
			            columns[1].getAttribute('innerText').then(function(amountText){
			                console.log('Amount: ' + amountText);
			                expect(element(by.xpath("//td[contains(text(),'0')]")).getText()).toBe('0');
			            });
			            /* For getting text in Transaction column*/
			            columns[2].getAttribute('innerText').then(function(transactionType){
			                console.log('Transaction Type: ' + transactionType);
			            });
			        });
			    });
			});
			browser.sleep(6000);
		});
		//DepositMoney4
	it("DepositMoney4",function()
				{
				browser.sleep(3000);			
				element(by.buttonText("Customer Login")).click();
				element.all(by.repeater('cust in Customers')).then(function(options){

					   options[1].click(); //Harrypotter
				 });
				element(by.buttonText("Login")).click();
				element.all(by.options("account for account in Accounts")).then(function(opt){
					opt[2].click();
				});
				element(by.partialButtonText("Deposit")).click();
				var amt=element(by.model("amount")).click();
				amt.sendKeys(datajson.depamount);
				browser.sleep(2000);
				element(by.className("btn btn-default")).click();
				var e=element(by.className("error ng-binding")).getText();
				expect(e).toBe("Deposit Successful");
				browser.sleep(2000);
				
			}),
		//TransAfterDeposit5
		it("TransactionAfterDeposit5",function()
				{
				browser.sleep(3000);			
				element(by.buttonText("Customer Login")).click();
				element.all(by.repeater('cust in Customers')).then(function(options){

					   options[1].click(); //Harrypotter
				 });
				element(by.buttonText("Login")).click();
				element.all(by.options("account for account in Accounts")).then(function(opt){
					opt[2].click();
				});
				element(by.partialButtonText("Transactions")).click();
				browser.sleep(5000);
				element.all(by.repeater('tx in transactions')).then(function(rows){
				    rows.forEach(function(row){
				        row.all(by.tagName('td')).then(function(columns){
				            /* For getting text in date column*/
				            columns[0].getAttribute('innerText').then(function(dateText){
				                console.log('Date: ' + dateText);
				            });
				            /* For getting text in Amount column*/
				            columns[1].getAttribute('innerText').then(function(amountText){
				                console.log('Amount: ' + amountText);
				 expect(element(by.xpath("//td[contains(text(),'2000')]")).getText()).toBe('2000');
				            });
				            /* For getting text in Transaction column*/
				            columns[2].getAttribute('innerText').then(function(transactionType){
				                console.log('Transaction Type: ' + transactionType);
				            });
				        });
				    });
				});
				browser.sleep(6000);
			});
		//WithDrawError6
		it("withdrawError6",function()
				{
				browser.sleep(3000);			
				element(by.buttonText("Customer Login")).click();
				element.all(by.repeater('cust in Customers')).then(function(options){

					   options[1].click(); //Harrypotter
				 });
				element(by.buttonText("Login")).click();
				element.all(by.options("account for account in Accounts")).then(function(opt){
					opt[2].click();
				});
				element(by.partialButtonText("Withdrawl")).click();
				var amt=element(by.model("amount")).click();
				amt.sendKeys(datajson.withdrawamount);				
				browser.sleep(2000);
				element(by.buttonText("Withdraw")).click();
				var act=element(by.className("error ng-binding"));
				expect(act.getText()).toEqual('Transaction Failed. You can not withdraw amount more than the balance.');
				browser.sleep(4000);
			}),
		//WithDrawSuccess7
		it("withdrawSuccess7",function()
		{
		browser.sleep(3000);			
		element(by.buttonText("Customer Login")).click();
		element.all(by.repeater('cust in Customers')).then(function(options){

			   options[1].click(); //Harrypotter
		 });
		element(by.buttonText("Login")).click();
		element.all(by.options("account for account in Accounts")).then(function(opt){
			opt[2].click();
		});
		element(by.partialButtonText("Withdrawl")).click();
		var amt=element(by.model("amount")).click();
		amt.sendKeys(datajson.withdrawamount1);				
		browser.sleep(2000);
		element(by.buttonText("Withdraw")).click();
		var act=element(by.className("error ng-binding"));
		expect(act.getText()).toEqual("Transaction successful");		
		browser.sleep(4000);
	}),	
		//TransAfterWithdraw8
		it("TransactionAfterWithdraw8",function()
				{
				browser.sleep(3000);			
				element(by.buttonText("Customer Login")).click();
				element.all(by.repeater('cust in Customers')).then(function(options){

					   options[1].click(); //Harrypotter
				 });
				element(by.buttonText("Login")).click();
				element.all(by.options("account for account in Accounts")).then(function(opt){
					opt[2].click();
				});
				element(by.partialButtonText("Transactions")).click();
				
				browser.sleep(5000);
				element.all(by.repeater('tx in transactions')).then(function(rows){
				    rows.forEach(function(row){
				        row.all(by.tagName('td')).then(function(columns){
				            /* For getting text in date column*/
				            columns[0].getAttribute('innerText').then(function(dateText){
				                console.log('Date: ' + dateText);
				            });
				            /* For getting text in Amount column*/
				            columns[1].getAttribute('innerText').then(function(amountText){
				                console.log('Amount: ' + amountText);
				 expect(element(by.xpath("//td[contains(text(),'1001')]")).getText()).toBe('1001');
				            });
				            /* For getting text in Transaction column*/
				            columns[2].getAttribute('innerText').then(function(transactionType){
				                console.log('Transaction Type: ' + transactionType);
				            });
				        });
				    });
				});
				browser.sleep(6000);
			});
			
		//TransAfterReset9
		it("TransactionAfterReset9",function()
				{
				browser.sleep(3000);			
				element(by.buttonText("Customer Login")).click();
				element.all(by.repeater('cust in Customers')).then(function(options){

					   options[1].click(); //Harrypotter
				 });
				element(by.buttonText("Login")).click();
				element.all(by.options("account for account in Accounts")).then(function(opt){
					opt[2].click();
				});
				element(by.partialButtonText("Transactions")).click();
				browser.sleep(5000);
				
				element.all(by.repeater('tx in transactions')).then(function(rows){
				    rows.forEach(function(row){
				        row.all(by.tagName('td')).then(function(columns){
				            /* For getting text in date column*/
				            columns[0].getAttribute('innerText').then(function(dateText){
				                console.log('Date: ' + dateText);
				            });
				            /* For getting text in Amount column*/
				            columns[1].getAttribute('innerText').then(function(amountText){
				                console.log('Amount: ' + amountText);
				
				            });
				            /* For getting text in Transaction column*/
				            columns[2].getAttribute('innerText').then(function(transactionType){
				                console.log('Transaction Type: ' + transactionType);
				            });
				        });
				    });
				});
				
				element(by.buttonText("Reset")).click();
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
				});
});

			