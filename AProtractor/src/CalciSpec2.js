var add=function(a,b,op)
{
	element(by.model('first')).sendKeys(a);
	browser.sleep(3000);

	element.all(by.options("value for (key, value) in operators")).then(function(data)
	{
		data[op].click();
	});
	element(by.model('second')).sendKeys(b);
	element(by.buttonText("Go!")).click();
};

describe('Calculator',function()
{
it('Division',function()
	{	
	browser.get('http://www.way2automation.com/angularjs-protractor/calc/');
	
	add(3,5,0);
	add(4,6,1);
	add(5,5,4);
//	var res=element(by.binding('latest')).getText();
//	expect(res).toBe('2');	
//	
//	element(by.model('first')).sendKeys(4);
//	browser.sleep(3000);
//
//	element.all(by.options("value for (key, value) in operators")).then(function(data)
//	{
//		data[0].click();
//	});
//	element(by.model('second')).sendKeys(6);
//	element(by.buttonText("Go!")).click();
//	var res=element(by.binding('latest')).getText();
//	expect(res).toBe('10');	
	browser.sleep(4000);
	});
});


