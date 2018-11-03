

var Conf=function()
{
//	element(by.buttonText("Submit")).click();
//	browser.sleep(1000);
//	browser.switchTo().alert().accept();
	var submit=element(by.buttonText("Submit"));
	
	this.submit=function()
	{
	submit.click();
	
	}
	
	this.acceptalert=function()
	{
		browser.switchTo().alert().accept();	
	}
}
module.exports=new Conf();