package tests.java.myapp.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import main.java.myapp.services.ICalculator;
import main.java.myapp.services.ILogger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "config.xml")
public class TestSpringJUnitIntegration {
	
	@Autowired
	ILogger logger;
	
	@Autowired
	ICalculator calc;
	
	@Before
	public void beforeEachTest() {
		System.err.println("==========");
	}
	
	void use(ILogger logger) {
		logger.log("voila le résultat");
	}
	
	void use(ICalculator calc) {
		calc.add(100, 200);
	}
	
	@Test
	public void testStderrLogger() {
		System.err.println("+++ StderrLogger");
		use(logger);
	}
	
	@Test
	public void testCalculatorWithLogger() {
		use(calc);
	}

}
