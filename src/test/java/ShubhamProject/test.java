package ShubhamProject;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;





public class test extends BaseTest {
	
	pageObjects page;
	String[] appNum;
	
	@BeforeMethod
	public void initPageElement() {
		 page = new pageObjects(driver);
	}
	
	
	
	@Test(priority = 1)
	public void tc1() throws Exception {
		
		page.loginApplication("agent@ecb.com","123456");
		page.agentApplicationCreation("ACricketfa1");
		appNum = page.getAppNumber();		
		page.logoutApplication();			
		}
	@Test(priority = 2)
	public void tc2() throws InterruptedException {
		page.loginApplication("countyrp@ecb.com","Ric5000!$");
	//	page.searchApp(appNum[0]);
		page.viewBtn.click();
		page.approved();
		page.logoutApplication();
	}
	@Test(priority = 3)
	public void tc3() throws Exception {
		
		page.loginApplication("agent@ecb.com","123456");
	//	page.searchApp(appNum[0]);
		page.viewBtn.click();
		page.appTabapproved();
		page.drag1();
		page.plusBtn1.click();
		page.file();
		page.plusBtn2.click();
		page.file();
		page.plusBtn3.click();
		page.file();
		page.plusBtn4.click();
		page.file();
		page.suppEvi.click();
		Thread.sleep(4000);
		page.plusBtn5.click();
		page.file();
		page.plusBtn6.click();
		page.file();
		page.plusBtn7.click();
		page.file();
		page.plusBtn8.click();
		page.file();
		page.plusBtn9.click();
		page.file();
		page.plusBtn10.click();
		page.file();
		page.plusBtn11.click();
		page.file();
		page.plusBtn12.click();
		page.file();
		page.editBankDetails();
		page.logoutApplication();
		
}
	
	@Test
	public void tc3copy() throws InterruptedException, AWTException {
		
		page.loginApplication("agent@ecb.com","123456");
		//	page.searchApp(appNum[0]);
			page.viewBtn.click();
		//	page.appTabapproved();
			page.drag2();
			page.editBankDetails();
			page.logoutApplication();
		
	}
	
	@Test(priority = 4)
	public void tc4() throws Exception {
		page.loginApplication("countyrp@ecb.com","Ric5000!$");
		//	page.searchApp(appNum[0]);
			page.viewBtn.click();
	//	page.countyReview();
			page.countyReviewDocsApproved();
			page.logoutApplication();

}
	@Test
	public void tc5() throws Exception {
		
		page.loginApplication("agent@ecb.com","123456");
		page.viewBtn.click();
		page.fifthUserSubmit();
		page.logoutApplication();			
		}
	
	@Test
	public void tc6() throws Exception {
		
		page.loginApplication("countyrp@ecb.com","Ric5000!$");
		page.viewBtn.click();
		page.sixthUserSubmit1();
		page.logoutApplication();			
		}
	
	@Test
	public void test1() {
		driver.get("https://www.facebook.com/");
	//	driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://www.google.com/");
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Laptop"+ Keys.ENTER);
		List<WebElement> lapPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<WebElement> textSize =driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
		for(int i=0;i<textSize.size();i++) {
			{
				if(textSize.get(i).getText().contains("Acer Extensa 15 Lightweight Laptop Intel Core i5 11th Gen Processor - (8 GB/ 512 GB SSD/ Windows 11 Home/ 1.7kg/ Black/ Elevated Hinge Design) EX215-54 with 39.6 cm (15.6 inches) FHD Display"))
				{
					
					
					System.out.println(lapPrice.get(i).getText());
					break;
			}
			
			
		}
	}
	
	}	
	
	@Test
	public void test3() throws InterruptedException {
		logger = report.createTest("Navigating to google");
	   page.testCode2(); 
	   logger.info("Entered details");
	   logger.log(Status.INFO, "Test Passeddddd: ");
	   logger.log(Status.INFO, MarkupHelper.createLabel("Test Passeddddd: ", ExtentColor.GREEN));
	 
	     
	}
	
	
}
	
