var datajson=require("../Utility/PageData.json");

var profilepage=function()
{
//	element(by.model("formData.name")).sendKeys(datajson.username);
//	browser.sleep(2000);
//	element(by.model("formData.email")).sendKeys(datajson.email);
//	element(by.className("btn btn-block btn-info")).click();

 	var username=element(by.model("formData.name"));
 	var email=element(by.model("formData.email"));
 	var nextbutton=element(by.className("btn btn-block btn-info"));
 	this.EnterName=function()
 	{
 		username.sendKeys(datajson.username);
 		return this;
 	}
 	this.EnterEmail=function()
 	{
 		email.sendKeys(datajson.email);
 		return this;
 	}
	
 	this.ClickNext=function()
 	{
 		nextbutton.click();
 		return require("./InterestPage.js");
 	}
}
module.exports=new profilepage();
	


