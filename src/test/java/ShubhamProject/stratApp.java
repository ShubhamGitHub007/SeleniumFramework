package ShubhamProject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class stratApp extends BaseTest {
	
	pageObjects page;
	//String[] appNum;
	
	@BeforeMethod
	public void initPageElement() {
		 page = new pageObjects(driver);
	}
	
	
	
	@Test(priority = 1)
	public void tc1() throws Exception {
		
		page.loginApplication("countyrp@ecb.com","Ric5000!$");
		page.stratApplicationCreation("ACricketfa1");
	//	appNum = page.getAppNumber();		
		page.logoutApplication();			
		}
	
	@Test(priority = 2)
	public void tc2() throws Exception {
		
		page.loginApplication("regionaleastmids@ecb.com","123456");
		page.viewBtn.click();
		page.stratSecondUser();
		
		page.logoutApplication();			
		}
	
	@Test(priority = 3)
	public void tc3() throws Exception {
		
		page.loginApplication("national_approver@ecb.com","123456");
		page.viewBtn.click();
		page.stratThirdUser();
		page.logoutApplication();			
		}
	
	@Test(priority = 4)
	public void tc4() throws Exception {
		
		page.loginApplication("agent@ecb.com","123456");
		page.viewBtn.click();
		page.stratFourthUser();
		page.drag1();
		page.plusBtn1.click();
		page.fillStratDetails();
		page.stratFile();
		page.plusBtn2.click();
		page.stratFile();
		page.plusBtn3.click();
		page.stratFile();
		page.plusBtn4.click();
		page.stratFile();
		page.plusBtn5.click();
		page.stratFile();
		page.stratEditBankDetails();
		page.plusBtn6.click();
		page.stratFile();
		page.plusBtn7.click();
		page.stratFile();
		page.plusBtn8.click();
		page.stratFile();
		page.plusBtn9.click();
		page.stratFile();
		page.suppEvi.click();
		Thread.sleep(4000);
		page.plusBtn10.click();
		page.stratFile();
		page.plusBtn11.click();
		page.stratFile();
		page.plusBtn12.click();
		page.stratFile();
		page.plusBtn13.click();
		page.stratFile();
		page.plusBtn14.click();
		page.stratFile();
		page.plusBtn15.click();
		page.stratFile();
		page.plusBtn16.click();
		page.stratFile();
		page.plusBtn17.click();
		page.stratFile();
		page.logoutApplication();			
		}
	
	

}
