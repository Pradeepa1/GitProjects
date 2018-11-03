
var data=require("../../data.json");

describe('Calculator',function()
{
	beforeEach(function(){
		browser.get(data.url);	
	});
	afterEach(function(){
		console.log("End of the test");	
	});
it('Division',function()
	{	
	
	
	element(by.model('first')).sendKeys(data.Avalue);
	browser.sleep(3000);

	element.all(by.options("value for (key, value) in operators")).get(1).click();
	element(by.model('second')).sendKeys(data.Bvalue);
	element(by.buttonText("Go!")).click();
	
	
	element(by.model('first')).sendKeys(data.Cvalue);
	browser.sleep(3000);

	element.all(by.options("value for (key, value) in operators")).then(function(data)
	{
		data[0].click();
	
	});
	element(by.model('second')).sendKeys(data.Dvalue);
	element(by.buttonText("Go!")).click();
	var res=element(by.binding('latest')).getText().then(function(txt){
		console.log(txt);
	})
	
	browser.sleep(4000);
	});
});


