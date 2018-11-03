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
xit('CalculatorOperations',function()
	{	
	browser.get('http://www.way2automation.com/angularjs-protractor/calc/');
	
	add(3,5,0);
	add(4,6,1);
	add(5,5,4);
	element.all(by.repeater('result in memory')).then(function(data){
		for(i=0;i<data.length;i++)
			{
			data[i].getText().then(function(text)
					{
					console.log(text);
					})
			}
		
	});

	browser.sleep(4000);
	});

it('Printing all rows of data',function()
		{	
		browser.get('http://www.way2automation.com/angularjs-protractor/calc/');
		
		add(3,5,0);
		add(4,6,1);
		add(5,5,4);
		element.all(by.repeater('result in memory')).then(function(data){
			for(i=0;i<data.length;i++)
				{
				data[i].getText().then(function(text)
						{
						console.log(text);
						})
				}
			
		});

		browser.sleep(4000);
		});

it('Printing the firstrow',function()
		{	
		browser.get('http://www.way2automation.com/angularjs-protractor/calc/');
		
		add(3,5,0);
		add(4,6,1);
		add(5,5,4);
		//element.all(by.repeater('result in memory').row(1)).getText().then(function(data){console.log(data)});
		element.all(by.repeater('result in memory')).then(function(data){
			
				data[0].getText().then(function(text)
						{
						console.log(text);
						})							
		});

		browser.sleep(4000);
		});

it('Printing the firstColumn',function()
		{	
		browser.get('http://www.way2automation.com/angularjs-protractor/calc/');
		
		add(3,5,0);
		add(4,6,1);
		add(5,5,4);
		
		element.all(by.repeater('result in memory').column('result.value')).getText().then(function(data){
			console.log(data);
			});

		browser.sleep(4000);
		});
});


