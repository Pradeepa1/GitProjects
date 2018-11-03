var xlfile=require("xlsx");

describe("Data Driven Testing",function()
{
xit("Reading data from Xlsx",function()
{
	var workbook=xlfile.readFile("./src/Utility/Test.xlsx");
	var sheet=workbook.SheetNames[0];
	var worksheet=workbook.Sheets[sheet];
	var cell=worksheet['A1'];
	var res=cell.v;
	console.log("Value of cell A1 is    "+res);
});

xit("Writing data in Xlsx",function()
{
	var workbook=xlfile.readFile("./src/Utility/Test.xlsx");
	var sheet=workbook.SheetNames[0];
	var worksheet=workbook.Sheets[sheet];
	var cell=worksheet['A1'];
	var res=cell.v;
	console.log("Value of cell A1 is    "+res);
	worksheet['A1'].v="PetAnimals";
	xlfile.writeFile(workbook,"./src/Utility/Test.xlsx");
});

it("Readind all the datas in xlsx",function()
{
	var workbook=xlfile.readFile("./src/Utility/Test.xlsx");
	var allSheetNames=workbook.SheetNames;
	allSheetNames.forEach(function(SheetName)
			{
		var sheet=workbook.Sheets[SheetName];
		for(cells in sheet)
			{
			if(cells[0]==='!')
				continue;
			console.log(SheetName+" and "+cells+" data= "+sheet[cells].v);
			}
			});
	
});
	
});