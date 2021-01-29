package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.log4j.varia.NullAppender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseClass {

    public static WebDriver driver;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentReports extent;
    public ExtentTest test;
    private static int caseNumber = 0;

    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeSuite

    public void setReport(){
        String SuiteName = this.getClass().getSimpleName();
        htmlReporter = new ExtentHtmlReporter(".\\src\\Report\\"+SuiteName+".html");
        htmlReporter.config().setEncoding("uft-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Nicolas Carlos Maranesi");
        org.apache.log4j.BasicConfigurator.configure(new NullAppender());
    }

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
    }
    @BeforeMethod
    public void setUp() {
        caseNumber++;
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_GREEN = "\u001B[32m";

        WebDriverUtils.capturarEvidence(driver, this.getClass().getSimpleName(), result.getName(),result.getName());

        if (result.getStatus() == ITestResult.FAILURE) {

            System.out.println("Scenario number: " + caseNumber + " was wrongly executed.");
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "SKIPPED TEST: -->" + result.getName());
            System.out.println(ANSI_YELLOW+"Scenario number: " + caseNumber + " was skipped.");
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test: " + result.getInstanceName()+ "Passed");
            System.out.println(ANSI_GREEN+"Scenario number: " + caseNumber + " was correctly executed. ");
        }
        driver.close();
    }

    public void tearDown() {driver.close();}
    @AfterClass
    public void afterClassmethod(){


    }

    @AfterSuite
    public void endClass(){
        extent.flush();
        if (driver != null) driver.quit();
        System.out.println("Se finalizo la Suite");
    }

}
