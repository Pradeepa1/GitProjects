exports.config={
		seleniumAddress:'http://localhost:4444/wd/hub',
		
		capabilities:{'browserName':'chrome'},
		framework:'jasmine',
		specs: ['./src/CalciSpec.js','./src/CalciRepeater.js'],
		jasmineNodeOpts: {defaultTimeoutInterval:30000}
		};
