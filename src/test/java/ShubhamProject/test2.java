package ShubhamProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class test2 extends BaseTest {
	
	
	
	@Test
	public void tc1() throws InterruptedException {
		logger =report.createTest("Test1");
		logger.pass("Navigating to google");
		driver.get("http://www.google.com/");
        driver.manage().window().maximize();
        logger.pass("Entereting laptop");
        driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Laptop"+ Keys.ENTER);
        Thread.sleep(3000);
        
	}
	
	
	
	

}
