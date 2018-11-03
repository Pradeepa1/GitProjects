
var winston=require('winston');
//addd the transportfile in winston
winston.add(new winston.transports.File({
	  filename: 'Reports/logger.log',
	  handleExceptions: true
	}));
describe("WinstonLogging",function(){
	it("Information",function()
	{
	winston.log('error','Level1');
	winston.warn('warn','Level2');
	winston.info('info','Level3');
	});
});