var data=require("../Utility/PageData.json");
describe("MultiForm",function(){
it("Multifrm",function()
{
	browser.get(data.url);
	
	element(by.model("formData.name")).sendKeys(data.username);
	browser.sleep(2000);
	element(by.model("formData.email")).sendKeys(data.email);
	element(by.className("btn btn-block btn-info")).click();
	
	browser.manage().timeouts().implicitlyWait(5000);
	browser.sleep(3000);
	element.all(by.model("formData.type")).get(0).click();
	browser.sleep(3000);
	element(by.partialLinkText("Next")).click();
	browser.sleep(1000);
	element(by.buttonText("Submit")).click();
	browser.sleep(1000);
	browser.switchTo().alert().accept();
	browser.sleep(5000);	
});	
});