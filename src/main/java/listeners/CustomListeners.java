package listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import base.Page;
import utilities.MonitoringMail;
import utilities.TestConfig;
import utilities.Utilities;


public class CustomListeners extends Page implements ITestListener, ISuiteListener {

	public String messageBody;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = rep.startTest(result.getName().toUpperCase());
		/*if (!TestUtil.isTestRunnable(result.getName(), excel)) {
			throw new SkipException("Skipping the test " + result.getName() + " as the run Mode is N");
		}*/
		ITestListener.super.onTestStart(result);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		// TODO Auto-generated method stub
		test.log(LogStatus.PASS, result.getName().toUpperCase() + " passed");
		rep.endTest(test);
		rep.flush();

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		test.log(LogStatus.FAIL, result.getName().toUpperCase() + "Failed with exception :" + result.getThrowable());
		String name = Utilities.screenshotName;
		test.log(LogStatus.FAIL, test.addScreenCapture(name));
		rep.endTest(test);
		rep.flush();
		Reporter.log("login successfull!");
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName
				+ " height=200 width=200></img></a>");
		rep.endTest(test);
		rep.flush();

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.SKIP, result.getName().toUpperCase() + " passed");
		rep.endTest(test);
		rep.flush();
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ISuite arg0) {

		MonitoringMail mail = new MonitoringMail();
		System.out.print("Finshed1");

		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/PageObjectModelBasics/Extent_20Report/";
			System.out.print("Finshed1 -- " + messageBody);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
