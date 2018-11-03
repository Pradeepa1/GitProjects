

var flow=require("C:/Users/prade/eclipse-workspace/AProtractor/src/Utility/PageData.json");//process.cwd()+"/src/.json" current working directory

var profile=require("C:/Users/prade/eclipse-workspace/AProtractor/src/PageOBjectModelRepository/Profile.js");
describe("E2E flow",function()
		{
	it("Inside the flow",function()
			{
		browser.sleep(3000);
		browser.get(flow.url);
		
		console.log(flow.url);
		browser.sleep(1000);
		profile.EnterName();
		console.log("outsideurl");
		profile.EnterEmail();
		var Interest=profile.ClickNext();
		Interest.radiobutton(1);
		var conf=Interest.next();
		conf.submit();
		conf.acceptalert();
		
	});
});