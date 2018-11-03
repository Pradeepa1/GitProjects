

var InterestPage=function()
{
var RadioButton=element.all(by.model("formData.type"));
var next=element(by.partialLinkText("Next"));

this.radiobutton=function(index)
{
	RadioButton.get(index).click();
	return this;
}

this.next=function()
{
next.click();
return require("./ConfirmationPage.js");
}

}
module.exports=new InterestPage();