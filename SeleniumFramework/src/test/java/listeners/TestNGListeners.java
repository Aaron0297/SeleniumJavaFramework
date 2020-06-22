package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test Passed :"+ result.getName());
		
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is successful :"+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("Test is failed :"+result.getName());
		
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped :"+result.getName());		
	}
	public void onFinish(ITestContext context) {
		System.out.println("Test completed :"+context.getName());
	}

}
