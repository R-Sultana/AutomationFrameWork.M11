package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "-----Test Execution Started-----");
		
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "----- Test PASS -----");
		test.log(Status.PASS, methodName+"====Test Pass====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "----- Test FAIL -----");
		
		test.log(Status.FAIL, methodName+"====Test Pass====");
		
		SeleniumUtility su = new SeleniumUtility();
		javaUtility ju = new javaUtility();
		
		String ScreenShotName = methodName+" "+ju.getDate();
		
		try {
			su.takeScreenShot(BaseClass.sDriver, ScreenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "----- Test SKIP -----");
		
		test.log(Status.SKIP, methodName+"====Test Skip====");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("-----Test Suite Execution Started-----");
		ExtentSparkReporter rep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new javaUtility().getDate()+".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setTheme(Theme.DARK);
		rep.config().setReportName("VTiger Execution Report");
		
		report= new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base Browser", "ChromeDriver");
		report.setSystemInfo("Base Platform", "Testing");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Base Platform", "Testing");
		report.setSystemInfo("Base Url", "http://localhost:8888");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("-----Test Suite Execution Finished-----");
		//generate extent report
		report.flush();
	}
	
	

}
