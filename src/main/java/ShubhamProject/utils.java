package ShubhamProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.math3.analysis.function.Constant;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.v108.log.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.dockerjava.api.model.Driver;
import com.microsoft.schemas.office.visio.x2012.main.CellType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utils  {
	
 static WebDriver driver ;
 
 private XSSFSheet excelSheet;
	private XSSFWorkbook excelWorkbook;
	private XSSFCell cell;
	private XSSFRow row;
	private static final int DEFAULT_WAIT_SECONDS = 30;
	public ExtentReports report;
	public ExtentTest logger;
 
	
	public utils(WebDriver driver) {
		this.driver = driver;
	}
	
	
	

//	@BeforeSuite
	public void setUpSuite() {
		String path =System.getProperty("user.dir")+"\\reportss\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		report = new ExtentReports();
		report.attachReporter(reporter);
	}
	
	public static String getScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ getCurrentDateTime()+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
	}
	
	public static String getCurrentDateTime(){
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		return dateFormat.format(date);
		}
	
	
	
	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid red'", element);
	}
	
	public void clickOnWebElement(WebElement element){
		highlightElement(element);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
	//	highLighterMethod(element);
	}	

	public void selectByVisibleText(WebElement element, String visibleText){
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		
	}
	
	public void selectByValue(WebElement element, String value){
		Select select = new Select(element);
		select.selectByValue(value);
		
	}
	
	public void selectByIndex(WebElement element, int value){
		Select select = new Select(element);
		select.selectByIndex(value);
		
	}
	
	
	
	public void scrollToElement(WebElement element){		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		highlightElement(element);
	}
	
	public void scrollToElementClick(WebElement element){		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		highlightElement(element);
		clickOnWebElement(element);
	}
	
	public void waitForvisibilityOfElement(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForvisibilityOfElementClick(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		highlightElement(element);
		clickOnWebElement(element);
	}
	 public static void waitUntilElementStaleness(WebElement element){
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.stalenessOf(element));
	    }	
	public void waitForinvisibilityOfElement(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void singleClick(WebElement element) {
		Actions action = new Actions(driver);
		highlightElement(element);
		action.moveToElement(element).click().build().perform();
	}
	
	public void javaScriptClick(WebElement element) {
		highlightElement(element);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}
	
	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		highlightElement(element);
		action.moveToElement(element).doubleClick().build().perform();
	}
	
	 public String[] getText(WebElement ele,String text1)
		{
			String text =ele.getText();
			String[] splittext =text.split(text1);
		   System.out.println(splittext[0]);
		   return splittext;
		}
	 
	 public static List<String> getElementsText(List<WebElement> list) {
			List<String> elemTexts = new ArrayList<>();
			for (WebElement el : list) {
				if (!el.getText().isEmpty()) {
					elemTexts.add(el.getText());
				}
			}
			return elemTexts;
		}

		public static List<String> getElementsText(By locator) {

			List<WebElement> elems = driver.findElements(locator);
			List<String> elemTexts = new ArrayList<>();

			for (WebElement el : elems) {
				if (!el.getText().isEmpty()) {
					elemTexts.add(el.getText());
				}
			}
			return elemTexts;
		}
	 
	 public void fileUpload(String path) throws AWTException {
		 Robot rb = new Robot();
		 
		    // copying File path to Clipboard
		    StringSelection str = new StringSelection(path);
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 
		     // press Contol+V for pasting
		     rb.keyPress(KeyEvent.VK_CONTROL);
		     rb.keyPress(KeyEvent.VK_V);
		 
		    // release Contol+V for pasting
		    rb.keyRelease(KeyEvent.VK_CONTROL);
		    rb.keyRelease(KeyEvent.VK_V);
		 
		    // for pressing and releasing Enter
		    rb.keyPress(KeyEvent.VK_ENTER);
		    rb.keyRelease(KeyEvent.VK_ENTER);
	 }
	 
	 public void dragDrop(WebElement from, WebElement to) {
		 Actions builder = new Actions(driver);
			org.openqa.selenium.interactions.Action dragAndDrop = builder.clickAndHold(from)
			.moveToElement(to)
			.release(to)
			.build();
			dragAndDrop.perform();
	 }
	 
	 public void openTab() {
		 driver.get("https://www.facebook.com/");
			//	driver.switchTo().newWindow(WindowType.TAB);
				driver.switchTo().newWindow(WindowType.WINDOW);
				driver.navigate().to("https://www.google.com/");
	 }
	 
	 public void switchtab() throws InterruptedException {
		 Set<String> windows = driver.getWindowHandles(); 
	//	 Iterator<String> it = windows.iterator();
			java.util.Iterator<String> it = windows.iterator();
			String parentId = it.next();
			String childId = it.next();
			driver.switchTo().window(childId);
			Thread.sleep(3000);
	 }
	 
	 public void switchToIframe(WebElement frameXpath) {
//		 System.out.println(driver.findElements(By.tagName("iframe")).size());
		 // if only one frame use index 0
//		 driver.switchTo().frame(0);
		 //with xpath
		 driver.switchTo().frame(frameXpath);
		 // to switch back to window
		// driver.switchTo().defaultContent();
	 }
	 
	 public void switchToDiffBrowser() {
		 
	
	 String currentWindowHandle = driver.getWindowHandle();

	// Get the window handles of all open windows
	Set<String> windowHandles = driver.getWindowHandles();

	// Loop through all open windows and switch to the new window
	for (String windowHandle : windowHandles) {
	    if (!windowHandle.equals(currentWindowHandle)) {
	        driver.switchTo().window(windowHandle);
	        break;
	    }
	    //switch to original window
	    driver.switchTo().window(currentWindowHandle);
	}
	 }

	 
	 public boolean waitForAlertPresent() {
			boolean flag = false;
			new WebDriverWait(driver, Duration.ofSeconds(20)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.alertIsPresent());
			try{
				driver.switchTo().alert();
				return flag = true;
			}catch(Exception Ex){
				return flag;
			}
		}
	 
	 public boolean waitForElementToBeClickableBool(By attributeValue) {	
			boolean flag = false;
			try{
				new WebDriverWait(driver, Duration.ofSeconds(20)).ignoring(StaleElementReferenceException.class)
						.until(ExpectedConditions.elementToBeClickable(attributeValue));
				flag=true;
				return flag;
				
			}catch(Exception Ex){
				return flag;
			}
		}
	 
	
	 
	 public boolean waitForElementToBeVisible(By attributeValue) {
			boolean flag = false;
			try {
				new WebDriverWait(driver, Duration.ofSeconds(20)).ignoring(StaleElementReferenceException.class)
						.until(ExpectedConditions.visibilityOfElementLocated(attributeValue));
				flag=true;
				return flag;
			} catch (Exception Ex) {
				return flag;
			}
		}
	 

	 
	public ArrayList<String> getExcelData(String testcaseName) throws IOException {
		 ArrayList<String> a = new ArrayList<String>();
	        FileInputStream fis = new FileInputStream("C:\\Users\\Shubham\\Downloads\\Book.xlsx");
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        int sheets = workbook.getNumberOfSheets();
	        for(int i=0;i<sheets;i++)
	        {
	        	if(workbook.getSheetName(i).equalsIgnoreCase("test"))
	        	{
	        		XSSFSheet sheet = workbook.getSheetAt(i);
	        		
	        	java.util.Iterator<Row>	rows = sheet.iterator();
	        Row	firstRow = rows.next();	   
	      java.util.Iterator<Cell> ce=  firstRow.cellIterator();
	      int k =0;
	      int column = 0;
	      while(ce.hasNext())
	      {
	    	  Cell value =ce.next();
	    	  if(value.getStringCellValue().equalsIgnoreCase("Testcase"))
	    	  {
	    		  column =k;
	    	  }
	    	  k++;
	      }
	      System.out.println(column);
	      
	      while(rows.hasNext())
	      {
	    	  Row r = rows.next();
	    	  if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
	    			  {
	    		  			java.util.Iterator<Cell> cv=r.cellIterator();
	    		  			while(cv.hasNext())
	    		  			{
	    		  				a.add(cv.next().toString());
	    		  			}
	    			  }
	      }
	        	}
	        }
			return a;
	}
	
	public void getSS(String testCaseName) {
		   File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  // DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa"); 

	        try {
	            FileUtils.copyFile(scrFile, new File("tmp\\"+testCaseName+".png"));
	        } catch (IOException e) {
	            System.out.print("Error while taking screenshot: " + e);
	        }
	}
	
	
	public  void write(String string) throws IOException {
		File src = new File("./TestData/Data.xlsx");
	//	String path = "C:\\Users\\Shubham\\Downloads\\Book.xlsx";
		FileInputStream fs = new FileInputStream(src);
		Workbook wb = new XSSFWorkbook(fs);
		Sheet sheet1 = wb.getSheetAt(0);
		int lastRow = sheet1.getLastRowNum();
		for(int i=0; i<=lastRow; i++){
		Row row = sheet1.getRow(i);
		Cell cell = row.createCell(2);

		cell.setCellValue(string);

		}

		FileOutputStream fos = new FileOutputStream(src);
		wb.write(fos);
		fos.close();
		}
	


		}




		


	   


	

	





		 
	

	 
	
	 






