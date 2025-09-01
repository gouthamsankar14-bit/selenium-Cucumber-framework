package stepDefenition;

import basePack.DriverSetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends DriverSetUp {

	@Before
	public void beforeScenario(Scenario scenario) throws Exception {
	    htmlreport(scenario.getName());      // report setup
	    setUp();       // launch browser per scenario
	}

	@After
	public void afterScenario(Scenario scenario) {
		tearDown();        // quit browser per scenario
	    flushReport();       // flush report
	}

}
