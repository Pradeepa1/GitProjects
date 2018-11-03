

//var Jasmine2HtmlReporter=require('protractor-jasmine2-html-reporter');
var AllureReporter = require('Jasmine-allure-reporter');

exports.config = {
  //seleniumAddress:'http://www.localhost:4444/wd/hub',
		directConnect:true,
  // Capabilities to be passed to the webdriver instance.
 capabilities: { 
    'browserName': 'chrome'   
//    shardTestFiles:true,
//    maxInstances:3//3 browsers got opened//parallel testing
  },
  
//  multiCapabilities:[
//	  {
//	  'browserName':'chrome',
  suites: {
	  manager:'./src/BankingApp/E2EFlow.js',
	  customer:'./src/BankingApp/Customer.js'
	  	        
	},
//	  },
//	  {
//		  'browserName':'firefox',
	  	   //specs: ['./src/BankingApp/E2EFlow.js'],
//	  }
//  					],
  framework: 'jasmine',
  onPrepare: function() {
	     jasmine.getEnv().addReporter(new AllureReporter({
	      resultsDir: './node_modules/jasmine-allure-reporter/allure-results'
	    }))
  },
//      jasmine.getEnv().addReporter(
//        new Jasmine2HtmlReporter({
//          savePath: 'target/screenshots',
//        	  takeScreenshots: true,
//        	   takeScreenshotsOnlyOnFailures: true
//        })
//      )
//  },
  jasmineNodeOpts: {defaultTimeoutInterval:500000}
	};