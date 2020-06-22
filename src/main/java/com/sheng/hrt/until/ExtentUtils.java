package com.sheng.hrt.until;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

/**
 * Created by wangx on 17/9/25.
 * #
 */
public class ExtentUtils implements TestWatcher {
    static String reportPath = "reports/demo/index.html";
    private static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
    private static ExtentReports extent = new ExtentReports();
    ExtentTest test = extent.createTest("Banner管理");
    public ExtentUtils() {
        // 设置静态
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setDocumentTitle("api自动化测试报告");
        htmlReporter.config().setReportName("api自动化测试报告");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setCSS(".node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;}");
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
    }
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }
    @Override
    public void testSuccessful(ExtensionContext context) {
//        ExtentTest test = extent.startTest(context.getDisplayName(), "-");
        ExtentTest test  = extent.createTest(context.getDisplayName(),"-");
        // step log
        test.log(Status.PASS, "-");
        flushReports(extent, test);
    }
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

    }
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ExtentTest test  = extent.createTest(context.getDisplayName(),"Test failed");
        // step log
        test.log(Status.FAIL, cause);

        flushReports(extent, test);
    }

    private void flushReports(ExtentReports extent, ExtentTest test){
        extent.flush();
    }
}