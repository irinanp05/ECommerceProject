package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listener implements ITestListener {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configureReport() {
        htmlReporter = new ExtentSparkReporter("ExtentListenerReport.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        reports.setSystemInfo("Machine", "Admin");
        reports.setSystemInfo("OS", "Windows 11 Home");

        htmlReporter.config().setDocumentTitle("Extent Listener Report");
        htmlReporter.config().setReportName("Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onTestStart(ITestResult result) {
        System.out.println("The test has started");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("The name of the successfully executed test method is: " + result.getName());

        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("The name of the passed test case is: " + result.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("The name of the failed test method is: " + result.getName());

        String failedTest = result.getName();
        String screenshot = "./Screenshots/";
        test = reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("The name of the failed test case is: " + result.getName(), ExtentColor.RED))
                .addScreenCaptureFromPath(screenshot + failedTest + ".png");

        String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";
        File screenshotFile = new File(screenshotPath);

        if(screenshotFile.exists()) {
            test.fail("Captured screenshot is below: " + test.addScreenCaptureFromPath(screenshotPath));
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("The name of the skipped test method is: " + result.getName());

        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("The name of the skipped test case is: " + result.getName(), ExtentColor.YELLOW));
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithinTimeout(ITestResult result) {
        onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        configureReport();
        System.out.println("On start method invoked...");
    }

    public void onFinish(ITestContext context) {
        System.out.println("On finish method invoked...");
        reports.flush();
    }
}
