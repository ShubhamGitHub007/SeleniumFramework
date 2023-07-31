package ShubhamProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class BaseTest {
	public ExcelDataProvider excel;
	public  WebDriver driver;
	static pageObjects page;
	public ExtentReports extent;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		excel = new ExcelDataProvider();
		String path =System.getProperty("user.dir")+"\\reportss\\index_ "+ utils.getCurrentDateTime()+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Shubham");
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed: ", MediaEntityBuilder.createScreenCaptureFromPath(utils.getScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed: ", MediaEntityBuilder.createScreenCaptureFromPath(utils.getScreenshot(driver)).build());
		}
		
		report.flush();
	}
	
	@BeforeTest
	public void launchApplication()
	{	ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://devapps.ecb.co.uk/IMS/Login.aspx");
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//	driver.manage().window().maximize();
	
	
		
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
	}
	public String getScreenshot1(String testCaseName,WebDriver driver) throws IOException
	{
		   File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		   String destinationFile = System.getProperty("user.dir")+"tmp\\"+testCaseName+".png";
	        try {
	        	
	            FileUtils.copyFile(scrFile, new File(destinationFile));
	        } catch (IOException e) {
	            System.out.print("Error while taking screenshot: " + e);
	        }
			return destinationFile;
	       
		
	}
	
	@AfterTest	
	public void tearDown()
	{
		driver.close();
		
	}

}



