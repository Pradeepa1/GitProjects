describe("NonAngularApplications",function()
{
	it("SalesforceLogin",function()
	{browser.ignoreSynchronization=true;
		browser.get("https://login.salesforce.com");
		element(by.id("username")).sendKeys("ryt");
		//wont enetre the text. will check to know the angular or not
	});
	
});