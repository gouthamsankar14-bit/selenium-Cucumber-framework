package basePack;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class Listen extends DriverSetUp implements ITestListener{
	
	@Override
	public void onFinish(ITestContext context) {
		if(DriverSetUp.extent!=null) {
	    DriverSetUp.extent.flush();
	  }}
	

}
