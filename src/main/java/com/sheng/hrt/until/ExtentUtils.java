package com.sheng.hrt.until;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.junit.jupiter.api.extension.ExtensionContext;
import java.util.Optional;
import org.junit.jupiter.api.extension.TestWatcher;

/**
 * Created by wangx on 17/9/25.
 * #
 */
public class ExtentUtils implements TestWatcher {
    public  ExtentReports extent;
    String reportPath = "reports/demo/12345.html";
    public ExtentUtils() {
        extent = new ExtentReports(reportPath, true, NetworkMode.OFFLINE);
        //        String reportPath = "reports/demo/12345.html";
        //        extent = new ExtentReports(reportPath, true, NetworkMode.OFFLINE);
    }
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }
    @Override
    public void testSuccessful(ExtensionContext context) {
//        ExtentTest test = extent.startTest(context.getDisplayName(), "-");
        ExtentTest test  = extent.startTest(context.getDisplayName(),"-");
        // step log
        test.log(LogStatus.PASS, "-");
        flushReports(extent, test);
    }
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

    }
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ExtentTest test  = extent.startTest(context.getDisplayName(),"Test failed");
        // step log
        test.log(LogStatus.FAIL, cause);

        flushReports(extent, test);
    }

    private void flushReports(ExtentReports extent, ExtentTest test){
        // ending test
        extent.endTest(test);
        // writing everything to document
        extent.flush();
        extent.close();
    }
}