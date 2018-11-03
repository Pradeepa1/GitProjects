describe('Calculator',function()
{
	beforeEach(function(){
		browser.get('http://www.way2automation.com/angularjs-protractor/calc/');	
	});
	afterEach(function(){
		console.log("End of the test");	
	});
it('Division',function()
	{	
	
	
	element(by.model('first')).sendKeys(8);
	browser.sleep(3000);

	element.all(by.options("value for (key, value) in operators")).get(1).click();
	element(by.model('second')).sendKeys(4);
	element(by.buttonText("Go!")).click();
	var res=element(by.binding('latest')).getText();
//	expect(res).toBe('2');	
//	browser.sleep(4000);
//	});
//
//it('Addition',function()//to disable it addx in it to keep the test in pending stage
//	{
//	browser.get("http://www.way2automation.com/angularjs-protractor/calc/");
	element(by.model('first')).sendKeys(4);
	browser.sleep(3000);

	element.all(by.options("value for (key, value) in operators")).then(function(data)
	{
		data[0].click();
	
	});
	element(by.model('second')).sendKeys(6);
	element(by.buttonText("Go!")).click();
	var res=element(by.binding('latest')).getText();
	expect(res).toBe('10');	
	browser.sleep(4000);
	});
});


