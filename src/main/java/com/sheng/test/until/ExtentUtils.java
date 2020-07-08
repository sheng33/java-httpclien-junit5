package com.sheng.hrt.until;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;


public class ExtentUtils implements TestWatcher , BeforeAllCallback, BeforeTestExecutionCallback {
    static String reportPath = "reports/demo/index2.html";
    private static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
    private static ExtentReports extent = new ExtentReports();
    ExtentTest test;
    ExtentTest second;
    String childName;
    public ExtentUtils() {
        // 设置静态
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setDocumentTitle("华润通api自动化测试报告");
        htmlReporter.config().setReportName("自动化测试报告");
        htmlReporter.config().setTheme(Theme.STANDARD);
//        htmlReporter.config().setCSS(".node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;}");
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
    }
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        ExtentTest test2  = second.createNode(context.getDisplayName(),"Test Aborted");
        // step log
        test2.log(Status.SKIP, reason.toString());
        flushReports(extent, test2);
    }
    @Override
    public void testSuccessful(ExtensionContext context) {
        ExtentTest test1 = second.createNode(context.getDisplayName().toString(),"PA");
        // step log
        test1.log(Status.PASS, "-");
        flushReports(extent, test1);
    }
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        ExtentTest test2  = second.createNode(context.getDisplayName(),"Test Aborted");
        // step log
        test2.log(Status.SKIP, cause);
        flushReports(extent, test2);
    }
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ExtentTest test2  = second.createNode(context.getDisplayName(),"Test failed");
        // step log
        test2.log(Status.FAIL, cause);
        flushReports(extent, test2);
    }

    private void flushReports(ExtentReports extent, ExtentTest test){
        extent.flush();
    }



    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        ExtentTest test = extent.createTest(extensionContext.getDisplayName());
        this.test = test;
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        Optional<ExtensionContext> str = extensionContext.getParent();
        if (str.isPresent()){
            ExtentTest second = this.test.createNode(str.get().getDisplayName());
            String childName = str.get().getDisplayName();
            if (childName!=this.childName || this.childName==null){
                this.second = second;
                this.childName = childName;
            }else if(second!=this.second&&this.second!=null){
                extent.removeTest(second);
            }
            extensionContext.getTags().forEach(second::assignCategory);
        }else{
            ExtentTest second = this.test.createNode(str.get().getDisplayName());
            extensionContext.getTags().forEach(second::assignCategory);
            this.second = second;
        }

    }
}