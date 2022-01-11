package myapp.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import myapp.imp.BeanFileLogger;
import myapp.imp.FileLogger;
import myapp.imp.SimpleCalculator;
import myapp.imp.StderrLogger;
import myapp.services.ICalculator;
import myapp.services.ILogger;

public class TestLoggerServices {

	@Before
	public void beforeEachTest() {
		System.out.println("==========");
	}
	
	@After
	public void afterEachTest() {
		System.out.println("==========");
	}
	
	//use a logger
	public void use(ILogger logger) {
		logger.log("Voila le résultat = hello");
	}
	
	void use(ICalculator calc) {
		calc.add(100, 200);
	}
	
	// Test StderrLogger
	@Test
	public void testStderrLogger() {
		
		// create the service
		StderrLogger logger = new StderrLogger();
		
		// start the service
		logger.start();
		
		// use (logger)
		use(logger);
		
		// stop the service
		logger.stop();
	}
	
	@Test
	public void testFileLogger() {
		FileLogger logger = new FileLogger("tmp/myapp.log");
		logger.start();
		use(logger);
		logger.stop();
	}
	
	@Test
	public void testBeanFileLogger() {
		
		//create the service
		BeanFileLogger logger = new BeanFileLogger();
		
		//set parameter
		logger.setFileName("tmp/myapp.log");
		
		//start
		logger.start();
		
		//use
		use(logger);
		
		//stop
		logger.stop();
	}
	
	@Test
	public void testCalculatorAndStderrLogger() {
		
		//create and start the logger service (on stderr)
		//create file logger
		BeanFileLogger logger = new BeanFileLogger();
		logger.setFileName("tmp/myapp.log");
		logger.start();
		
		//create, inject and start the calculator service
		SimpleCalculator calculator = new SimpleCalculator();
		calculator.setLogger(logger);
		calculator.start();
		
		//use calculator service
		use(calculator);
		
		//stop calculator service
		calculator.stop();
		
		//stop the logger service
		logger.stop();
		
	}

}
