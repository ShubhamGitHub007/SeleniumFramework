package ShubhamProject;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class pageObjects extends utils{
	
	
	
WebDriver driver;
	
	public pageObjects(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="OutSystemsUIWeb_wt8_block_wtLogin_OutSystemsUIWeb_wt22_block_wtLogin_PortalCommonWeb_BL_wt6_block_OutSystemsUIWeb_wt36_block_wtInput_wtEmailInput")
	WebElement id;
	
	@FindBy(id="OutSystemsUIWeb_wt8_block_wtLogin_OutSystemsUIWeb_wt22_block_wtLogin_PortalCommonWeb_BL_wt6_block_OutSystemsUIWeb_wt16_block_wtInput_wtPasswordInput")
	WebElement password;
	
	@FindBy(id="OutSystemsUIWeb_wt8_block_wtLogin_OutSystemsUIWeb_wt22_block_wtLogin_PortalCommonWeb_BL_wt6_block_wt2")
	WebElement loginBtn;
	
	@FindBy(id="IMS_Theme_wt296_block_OutSystemsUIWeb_wt2_block_wtHeader_wt30_OutSystemsUIWeb_wt7_block_wtContent_wt6")
	WebElement logoutBtn;
	
	@FindBy (id="IMS_Theme_wt296_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_OutSystemsUIWeb_wt323_block_wtColumn1_IMS_Widgets_wt146_block_wt26")
	WebElement nextBtn;
	
	@FindBy(id="searchDropdownBox")
	WebElement dropdwn;
	
	@FindBy(id="IMS_Theme_wt296_block_OutSystemsUIWeb_wt2_block_wtContent_wtActions_wt271")
	WebElement createAppBtn;
	
	@FindBy(xpath="//select[@name='IMS_Theme_wtLayout$block$OutSystemsUIWeb_wt2$block$wtContent$wtMainContent$wt80$OutSystemsUIWeb_wt55$block$wtContent$OutSystemsUIWeb_wt14$block$wtContent$wt44$wtListOrganisations']")
	WebElement appDrpDwn;
	
	@FindBy(xpath="(//input[@type='submit'])[4]")
	WebElement contBtn;
	
	@FindBy(id="IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt94_OutSystemsUIWeb_wtCard_block_wtContent_wtProject_ProjectTheme")
	WebElement prjctTheme;
	
	@FindBy(id="IMS_Theme_wt22_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_DevPre_Applications_wt20_block_IMS_Theme_wt17_block_wtPlaceholder2_wt5_OutSystemsUIWeb_wt203_block_wtContent_wtProject_ProjectTheme")
	WebElement stratprjctTheme;
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	WebElement chkbx1;
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	WebElement chkbx2;
	@FindBy(xpath="(//input[@type='checkbox'])[3]")
	WebElement chkbx3;
	
	@FindBy(xpath="(//input[@type='text'])[13]")
	WebElement estPlayer;
	
	@FindBy(xpath="(//select[@class='select OSFillParent SmartInput ReadOnly'])[2]")
	WebElement prjctype;
	
	@FindBy(xpath="(//select[@class='select OSFillParent SmartInput ReadOnly'])[3]")
	WebElement stratprjctype;
	
	@FindBy(xpath="//textarea[@name='IMS_Theme_wtLayout$block$OutSystemsUIWeb_wt2$block$wtContent$wtMainContent$IMS_Applications_wt17$block$IMS_Theme_wt45$block$wtPlaceholder2$wt94$OutSystemsUIWeb_wtCard$block$wtContent$IMS_Widgets_wt451$block$wtTextAreaPlaceholder$wtProject_Name']")
	WebElement desc;
	
	@FindBy(xpath="//textarea[@name='IMS_Theme_wt22$block$OutSystemsUIWeb_wt2$block$wtContent$wtMainContent$IMS_DevPre_Applications_wt20$block$IMS_Theme_wt17$block$wtPlaceholder2$wt5$OutSystemsUIWeb_wt203$block$wtContent$IMS_Widgets_wt145$block$wtTextAreaPlaceholder$wtProject_Name']")
	WebElement stratdesc;
	@FindBy(id="IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt94_OutSystemsUIWeb_wtCard_block_wtContent_OutSystemsUIWeb_wt538_block_wtContent_wtProject_TotalCost_mask")
	WebElement totalprjCost;
	@FindBy(xpath="(//input[@class='input OSFillParent SmartInput ReadOnly'])[1]")
	WebElement estPrjctCost;
	
	@FindBy(xpath="//input[@id='IMS_Theme_wt22_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_DevPre_Applications_wt20_block_IMS_Theme_wt17_block_wtPlaceholder2_wt5_OutSystemsUIWeb_wt203_block_wtContent_OutSystemsUIWeb_wt56_block_wtContent_wtProject_GrantAmount_mask']")
	WebElement estgrantReq;
	@FindBy(xpath="//input[@id='IMS_Theme_wt22_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_DevPre_Applications_wt20_block_IMS_Theme_wt17_block_wtPlaceholder2_wt5_OutSystemsUIWeb_wt203_block_wtContent_OutSystemsUIWeb_wt211_block_wtContent_wtProject_LoanAmount_mask']")
	WebElement loanAmt;
	
	@FindBy(xpath="(//select[@class='select OSFillParent SmartInput ReadOnly'])[7]")
	WebElement stratDesign;
	@FindBy(xpath="(//select[@class='select OSFillParent SmartInput ReadOnly'])[8]")
	WebElement stratPerm;
	@FindBy(xpath="(//select[@class='select OSFillParent SmartInput ReadOnly'])[9]")
	WebElement stratPart;
	
	@FindBy(xpath="(//input[@type='radio'])[3]")
	WebElement fullAppRadioBtn;
	
	@FindBy(xpath="(//select[@class='select OSFillParent Not_Valid Not_Valid SmartInput ReadOnly'])[1]")
	WebElement loanDur;
	@FindBy(xpath="(//select[@class='select OSFillParent Not_Valid Not_Valid SmartInput ReadOnly'])[2]")
	WebElement stratTenureType;
	@FindBy(xpath="(//select[@class='select OSFillParent Not_Valid Not_Valid SmartInput ReadOnly'])[3]")
	WebElement stratScndContact;
	
	@FindBy(id="IMS_Theme_wt58_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt36_block_IMS_Theme_wt99_block_wtPlaceholder2_wt35_OutSystemsUIWeb_wt439_block_wtContent_IMS_GeneralWebBlocks_wt114_block_wtGetPostProjectQuestions_List_ctl00_wt7_wt49_wtTextInput")
	WebElement testQues;
	
	@FindBy(id="IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt94_OutSystemsUIWeb_wtCard_block_wtContent_OutSystemsUIWeb_wt351_block_wtContent_wtProject_GrantAmount_mask")
	WebElement grantReq;
	
	@FindBy(id="IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt94_OutSystemsUIWeb_wtCard_block_wtContent_wtProject_TenureTypeId")
	WebElement tenureType;
	
	@FindBy(name="IMS_Theme_wtLayout$block$OutSystemsUIWeb_wt2$block$wtContent$wtMainContent$IMS_Applications_wt17$block$IMS_Theme_wt45$block$wtPlaceholder2$wt94$OutSystemsUIWeb_wtCard$block$wtContent$IMS_GeneralWebBlocks_wt225$block$wtGetPostProjectQuestions_List$ctl00$wt7$wt49$OutSystemsUIWeb_wt14$block$wtContent$wtInputCurrency_mask")
	WebElement test;
	
	@FindBy(xpath="//input[@value='Save and Continue']")
	WebElement save;
	
	@FindBy(xpath="//*[@id='IMS_Theme_wt296_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_OutSystemsUIWeb_wt323_block_wtColumn1_wtListRecordsProjects_ctl00_OutSystemsUIWeb_wt321_block_wtContent_OutSystemsUIWeb_wt556_block_wtContent_wt97']/div/span")
	WebElement appNumber;
	
	@FindBy(id="IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt21_OutSystemsUIWeb_wt109_block_wtContent_wt111")
	WebElement submit;
	
	@FindBy(xpath="//input[@value='Submit To Review']")
	WebElement submitfrReview;
	
	
	@FindBy(id="IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt31_OutSystemsUIWeb_wt4_block_wtContent_wt1_wtTransitionsTR_ctl00_wtbutton1")
	WebElement submit2;
	
	@FindBy(id="IMS_Theme_wt296_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_OutSystemsUIWeb_wt7_block_wtInput_wtSearchInput")
	WebElement searchBox;
	
	@FindBy(xpath="//span[text()='View Details']")
	WebElement viewBtn;
	
	@FindBy(xpath="//div[@class='dropdown-header select']/div[1]")
	WebElement approveDrpDwn;
	
	@FindBy(xpath="//div[@id='IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt74_OutSystemsUIWeb_wt23_block_wtContent_IMS_GeneralWebBlocks_wtChangeStatus_block_OutSystemsUIWeb_wt8_block_wtDropdownList_OutSystemsUIWeb_wt46_block_wtContent']")
	WebElement appBtn;
	
	@FindBy(xpath="(//span[text()='Approved'])[3]")
	WebElement orgApp;
	
	@FindBy(xpath="//div[@id='IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt21_OutSystemsUIWeb_wt109_block_wtContent_IMS_GeneralWebBlocks_wtChangeStatus_block_OutSystemsUIWeb_wt8_block_wtDropdownList_OutSystemsUIWeb_wt46_block_wtContent']")
	WebElement partnerFundApp;
	
	@FindBy(xpath="//input[@value='Save and Continue']")
	WebElement saveContBtn;
	
	@FindBy(xpath="//input[@value='Add New Guarantor']")
	WebElement gurantor;
	@FindBy(xpath="//select[@class='select OSFillParent SmartInput ReadOnly']")
	WebElement title;
	@FindBy(xpath="(//input[@class='input OSFillParent SmartInput SmartInput_Changed ReadOnly'])[1]")
	WebElement fName;
	@FindBy(xpath="(//input[@class='input OSFillParent SmartInput SmartInput_Changed ReadOnly'])[2]")
	WebElement lName;
	@FindBy(xpath="(//input[@class='input OSFillParent SmartInput ReadOnly'])[1]")
	WebElement gurEmail;
	@FindBy(xpath="(//input[@class='input ThemeGrid_Width6 os-internal-ui-autocomplete-input SmartInput ReadOnly'])[1]")
	WebElement postcode;
	@FindBy(xpath="(//input[@class='input OSFillParent SmartInput ReadOnly'])[4]")
	WebElement address;
	@FindBy(xpath="(//input[@class='input OSFillParent SmartInput ReadOnly'])[6]")
	WebElement town;
	
	
	
	@FindBy(xpath="//span[text()='Approve All']")
	WebElement appAll;
	
	@FindBy(id="IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt61_OutSystemsUIWeb_wt89_block_wtContent_wtBudgetYearCombo")
	WebElement budget;
	
	@FindBy(xpath="//input[@value='Approve']")
	WebElement approveBtn;
	
	@FindBy(xpath="//span[text()='County Board Review']")
	WebElement countybtn;
	
	@FindBy(xpath="//span[text()='Partnership Funding']")
	WebElement partFunding;
	
	@FindBy(xpath="//select[@id='IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt94_OutSystemsUIWeb_wtCard_block_wtContent_wtOff']")
	WebElement sndContact;
	
	@FindBy(xpath="(//input[@type='submit'])[5]")
	WebElement fundSource;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//input[@id='wtPartners_Name']")
	WebElement partName;
	
	@FindBy(xpath="//input[@id='IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt21_OutSystemsUIWeb_wt109_block_wtContent_wtPartnerProjectTable_ctl03_OutSystemsUIWeb_wt52_block_wtContent_wtAmountInput_mask']")
	WebElement amount;
	
	@FindBy(xpath="//span[text()='Mandatory']")
	WebElement manBtn;
	@FindBy(xpath="//span[text()='Supporting Evidence (if applicable)']")
	WebElement supBtn;
	@FindBy(xpath="//span[text()='Organisation Documents']")
	WebElement orgBtn;
	
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[1]")
	WebElement plusBtn1;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[2]")
	WebElement plusBtn2;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[3]")
	WebElement plusBtn3;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[4]")
	WebElement plusBtn4;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[5]")
	WebElement plusBtn5;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[6]")
	WebElement plusBtn6;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[7]")
	WebElement plusBtn7;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[8]")
	WebElement plusBtn8;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[9]")
	WebElement plusBtn9;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[10]")
	WebElement plusBtn10;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[11]")
	WebElement plusBtn11;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[12]")
	WebElement plusBtn12;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[13]")
	WebElement plusBtn13;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[14]")
	WebElement plusBtn14;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[15]")
	WebElement plusBtn15;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[16]")
	WebElement plusBtn16;
	@FindBy(xpath="(//span[@class='fa fa-fw fa-plus-circle fa-lg'])[17]")
	WebElement plusBtn17;
	
	@FindBy(xpath="//span[text()='Add Files']")
	WebElement addFilesBtn;
	
	@FindBy(xpath="(//span[text()='Documents'])[1]")
	WebElement docsBtn;
	
	@FindBy(xpath="//*[@id='OutSystemsUIWeb_wt151_block_wtMainContent_wtfiles']/div/div[2]/a")
	WebElement add;
	
	@FindBy(xpath="//input[@id='OutSystemsUIWeb_wt151_block_wtMainContent_wtUploadButton']")
	WebElement fileUploadSaveBtn;
	@FindBy(xpath="//input[@name='OutSystemsUIWeb_wt1$block$wtMainContent$wtUploadButton']")
	WebElement stratFileUploadSaveBtn;
	
	@FindBy(xpath="//span[@class='Feedback_Message_Text']")
	WebElement feedbckMsg;
	
	@FindBy(xpath="//span[text()='Supporting Evidence (if applicable)']")
	WebElement suppEvi;
	
	@FindBy(xpath="//span[text()='Organisation Documents']")
	WebElement orgDocs;
	
	@FindBy(xpath="//span[@class='fa fa-fw fa-edit fa-lg']")
	WebElement bankEdit;
	
	@FindBy(xpath="//input[@id='OutSystemsUIWeb_wt151_block_wtMainContent_wtBankAccountNameInput']")
	WebElement bankName;
	
	@FindBy(xpath="//input[@name='OutSystemsUIWeb_wt151$block$wtMainContent$wtSortCodeInput']")
	WebElement sortCode;
	
	@FindBy(xpath="//input[@name='OutSystemsUIWeb_wt151$block$wtMainContent$wtBankAccountNumberInput']")
	WebElement accNumber;
	
	@FindBy(xpath="//div[@id='OutSystemsUIWeb_wt151_block_wtMainContent_wtButtonsContainer']/child::input[2]")
	WebElement bankSaveBtn;
	
	@FindBy(xpath="//span[text()='Application']")
	WebElement appTabBtn;
	
	@FindBy(xpath="//span[text()='County Board Review']")
	WebElement countyReview;
	
	@FindBy(xpath="//span[text()='Actions']")
	WebElement actionsBtn;
	
	@FindBy(xpath="//textarea[@id='IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt61_OutSystemsUIWeb_wt89_block_wtContent_IMS_Widgets_wt103_block_wtTextAreaPlaceholder_wtProject_DevelopmentOutcomes']")
	WebElement devOutcomeBox;
	
	@FindBy(xpath="//textarea[@name='IMS_Theme_wtLayout$block$OutSystemsUIWeb_wt2$block$wtContent$wtMainContent$IMS_Applications_wt17$block$IMS_Theme_wt45$block$wtPlaceholder2$wt61$OutSystemsUIWeb_wt89$block$wtContent$IMS_Widgets_wt48$block$wtTextAreaPlaceholder$wtProject_StrategicNeed']")
	WebElement stratBox;
	
	@FindBy(xpath="(//span[text()='Approved'])[5]")
	WebElement countyReviewPartFundAppBtn;
	
	@FindBy(xpath="//div[@role='combobox']")
	WebElement countyDocAppDrpDwn;
	
	@FindBy(xpath="(//a[@tabindex='0'])[2]")
	WebElement countyDocAppBtn;
	
	@FindBy(xpath="(//a[@tabindex='0'])[2]")
	WebElement greenBox;
	
	@FindBy(xpath="//input[@value='Edit County Review']")
	WebElement editCountyRev;
	
	
	@FindBy(id="IMS_Theme_wtLayout_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_Applications_wt17_block_IMS_Theme_wt45_block_wtPlaceholder2_wt61_OutSystemsUIWeb_wt89_block_wtContent_OutSystemsUIWeb_wt94_block_wtContent_wtProject_GrantAmount_County_mask")
	WebElement ccbCont;
	
	@FindBy(xpath="//select[@class='select ThemeGrid_Width6 SmartInput ReadOnly']")
	WebElement keyContact;
	
	@FindBy(xpath="(//textarea[@id='IMS_Theme_wt22_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_DevPre_Applications_wt20_block_IMS_Theme_wt17_block_wtPlaceholder2_wt21_OutSystemsUIWeb_wt8_block_wtContent_IMS_Widgets_wt105_block_wtTextAreaPlaceholder_wtPre_Project_DevelopmentOutcomes'])")
	WebElement devOutcome;
	
	@FindBy(xpath="(//textarea[@id='IMS_Theme_wt22_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_DevPre_Applications_wt20_block_IMS_Theme_wt17_block_wtPlaceholder2_wt21_OutSystemsUIWeb_wt8_block_wtContent_IMS_Widgets_wt41_block_wtTextAreaPlaceholder_wtPre_Project_TechnicalAnalysis'])")
	WebElement techAnalysis;
	
	@FindBy(xpath="(//textarea[@id='IMS_Theme_wt22_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_DevPre_Applications_wt20_block_IMS_Theme_wt17_block_wtPlaceholder2_wt21_OutSystemsUIWeb_wt8_block_wtContent_IMS_Widgets_wt16_block_wtTextAreaPlaceholder_wtPre_Project_CostAnalysis'])")
	WebElement costAnalysis;
	@FindBy(xpath="(//textarea[@id='IMS_Theme_wt22_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_DevPre_Applications_wt20_block_IMS_Theme_wt17_block_wtPlaceholder2_wt21_OutSystemsUIWeb_wt8_block_wtContent_IMS_Widgets_wt75_block_wtTextAreaPlaceholder_wtPre_Project_RelationshipCountyPartnershi'])")
	WebElement relatAggr;
	@FindBy(xpath="(//textarea[@id='IMS_Theme_wt22_block_OutSystemsUIWeb_wt2_block_wtContent_wtMainContent_IMS_DevPre_Applications_wt20_block_IMS_Theme_wt17_block_wtPlaceholder2_wt21_OutSystemsUIWeb_wt8_block_wtContent_IMS_Widgets_wt76_block_wtTextAreaPlaceholder_wtPre_Project_RelationshipInspiringGenerat'])")
	WebElement relatgen;
	
	@FindBy(xpath="(//input[@class='input OSFillParent SmartInput ReadOnly'])[7]")
	WebElement stratItem;
	@FindBy(xpath="//input[@id='OutSystemsUIWeb_wt1_block_wtMainContent_OutSystemsUIWeb_wt83_block_wtContent_wt79']")
	WebElement stratGrantRadioBtn;
	@FindBy(xpath="(//input[@id='OutSystemsUIWeb_wt1_block_wtMainContent_wtDocuments_QuotationItem_Supplier'])")
	WebElement stratSupplier;
	@FindBy(xpath="//input[@class='input OSFillParent Not_Valid Not_Valid SmartInput ReadOnly']")
	WebElement stratDate;
	@FindBy(xpath="//input[@class='input ThemeGrid_Width11 Not_Valid Not_Valid SmartInput ReadOnly']")
	WebElement stratVAT;
	
	public void loginApplication(String loginId,String pw) throws InterruptedException
	{
		id.sendKeys(loginId);
		password.sendKeys(pw);	
		clickOnWebElement(loginBtn);
	}
	
	
	
	public void agentApplicationCreation(String value) throws InterruptedException
	{
		clickOnWebElement(createAppBtn);
		waitForvisibilityOfElement(appDrpDwn);
		selectByVisibleText(appDrpDwn,value);
		waitForElementToBeClickable(contBtn);
		clickOnWebElement(contBtn);
		waitForvisibilityOfElement(prjctTheme);
		selectByVisibleText(prjctTheme,"Creating Welcoming Environments");
		waitForElementToBeClickable(chkbx1);
		clickOnWebElement(chkbx1);
		clickOnWebElement(chkbx2);
		clickOnWebElement(chkbx3);
		estPlayer.sendKeys("12");
		selectByVisibleText(prjctype,"Test");
		desc.sendKeys("ABCTesting");
		Thread.sleep(3000);
		totalprjCost.sendKeys("5000");
		Thread.sleep(2000);
		grantReq.sendKeys("2000");
		Thread.sleep(3000);
		selectByVisibleText(tenureType,"Freehold");
		test.sendKeys("2000"+Keys.TAB);
		Thread.sleep(3000);
		clickOnWebElement(save);	
		waitForvisibilityOfElement(save);
		clickOnWebElement(save);
		waitForvisibilityOfElement(submit);
		clickOnWebElement(submit);
		Thread.sleep(2000);
		clickOnWebElement(submit2);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
	}
	
	public void stratApplicationCreation(String value) throws InterruptedException
	{
		clickOnWebElement(createAppBtn);
		waitForvisibilityOfElement(appDrpDwn);
		selectByVisibleText(appDrpDwn,value);
		waitForElementToBeClickable(contBtn);
		clickOnWebElement(contBtn);
		waitForvisibilityOfElement(keyContact);
		selectByVisibleText(keyContact,"Artur Grilo");
		selectByVisibleText(stratprjctTheme,"Strategic Grant Theme 1");
		Thread.sleep(3000);
		selectByVisibleText(stratprjctype,"Strategic Type");
		stratdesc.sendKeys("ABCTesting");
		Thread.sleep(3000);
		estPrjctCost.sendKeys("5000");
		Thread.sleep(2000);
		
		clickOnWebElement(save);
		Thread.sleep(4000);
		clickOnWebElement(save);
	//	clickOnWebElement(save);
		waitForvisibilityOfElement(submitfrReview);
		clickOnWebElement(submitfrReview);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
	}
	public void stratApplicationCreation1(String value) throws InterruptedException
	{
		clickOnWebElement(createAppBtn);
		waitForvisibilityOfElement(appDrpDwn);
		selectByVisibleText(appDrpDwn,value);
		waitForElementToBeClickable(contBtn);
		clickOnWebElement(contBtn);
		waitForvisibilityOfElement(keyContact);
		selectByVisibleText(keyContact,"Agent Test");
		selectByVisibleText(stratprjctTheme,"Strategic Grant Theme 1");
		Thread.sleep(3000);
		selectByVisibleText(stratprjctype,"Strategic Type");
		stratdesc.sendKeys("ABCTesting");
		Thread.sleep(3000);
		estPrjctCost.sendKeys("5000"+Keys.ENTER);
		Thread.sleep(2000);
		estgrantReq.sendKeys("1000"+Keys.ENTER);
		Thread.sleep(2000);
		loanAmt.sendKeys("500"+Keys.ENTER);
		Thread.sleep(2000);
		selectByVisibleText(stratDesign,"Compliant");
		Thread.sleep(1000);
		selectByVisibleText(stratPerm,"In Progress");
		Thread.sleep(1000);
		selectByVisibleText(stratPart,"Confirmed");
		Thread.sleep(1000);
		clickOnWebElement(save);
		Thread.sleep(4000);
		clickOnWebElement(save);
	//	clickOnWebElement(save);
		waitForvisibilityOfElement(submitfrReview);
		clickOnWebElement(submitfrReview);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
	}
	
	public void stratSecondUser() throws InterruptedException {
		scrollToElementClick(save);
		Thread.sleep(2000);
		devOutcome.sendKeys("abc");
		Thread.sleep(2000);
		techAnalysis.sendKeys("efg");
		Thread.sleep(2000);
		costAnalysis.sendKeys("123");
		Thread.sleep(2000);
		relatAggr.sendKeys("456");
		Thread.sleep(2000);
		relatgen.sendKeys("xyz");
		Thread.sleep(2000);
		scrollToElementClick(save);
		Thread.sleep(2000);
		clickOnWebElement(actionsBtn);
		waitForvisibilityOfElement(submitfrReview);
		clickOnWebElement(submitfrReview);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
		
	}
	
	public void stratThirdUser() throws InterruptedException {
		scrollToElementClick(save);
		Thread.sleep(2000);
		scrollToElementClick(save);
		Thread.sleep(2000);
		clickOnWebElement(actionsBtn);
		Thread.sleep(2000);
		clickOnWebElement(fullAppRadioBtn);
		Thread.sleep(2000);
		clickOnWebElement(approveBtn);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
		
	}
	
	public void stratThirdUser1() throws InterruptedException {
		scrollToElementClick(save);
		Thread.sleep(2000);
		scrollToElementClick(save);
		Thread.sleep(2000);
		clickOnWebElement(actionsBtn);
		Thread.sleep(2000);
		clickOnWebElement(fullAppRadioBtn);
		Thread.sleep(2000);
		clickOnWebElement(approveBtn);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
		
	}
	
	public void stratFourthUser() throws InterruptedException {
		selectByVisibleText(loanDur,"1 Year");
		Thread.sleep(1000);
		selectByVisibleText(stratTenureType,"Freehold");
		Thread.sleep(3000);
		selectByVisibleText(stratScndContact,"Agent Alex Santos");
		Thread.sleep(1000);
		testQues.sendKeys("test");
		Thread.sleep(1000);
		scrollToElementClick(save);
		
		waitForvisibilityOfElement(fundSource);
		clickOnWebElement(fundSource);
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		partName.sendKeys("abc");
		clickOnWebElement(saveBtn);
		Thread.sleep(5000);
		amount.sendKeys("3500");
		Thread.sleep(2000);
		clickOnWebElement(saveContBtn);
		Thread.sleep(2000);
		clickOnWebElement(gurantor);
		Thread.sleep(5000);
		driver.switchTo().frame(1);
		selectByVisibleText(title,"Mr");
		Thread.sleep(2000);
		fName.sendKeys("Shubham");
		lName.sendKeys("Shubham");
		gurEmail.sendKeys("abc@gmail.com");
		postcode.sendKeys("123");
		address.sendKeys("89");
		town.sendKeys("abc");
		clickOnWebElement(saveBtn);
		Thread.sleep(3000);
		clickOnWebElement(saveContBtn);	
	}
	
	public String[] getAppNumber() {
		String[] text =	getText(appNumber," -");
		return text;
	}
	public void searchApp(String appNum) throws InterruptedException {
		searchBox.sendKeys(appNum);
		Thread.sleep(2000);
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		viewBtn.click();
		Thread.sleep(2000);
		
	}
	
	public void approved() throws InterruptedException {
		
		//waitForvisibilityOfElement(approveDrpDwn);
		clickOnWebElement(approveDrpDwn);
		Thread.sleep(1000);
		appBtn.click();
		Thread.sleep(2000);
		clickOnWebElement(saveContBtn);
		Thread.sleep(3000);
		clickOnWebElement(approveDrpDwn);
		orgApp.click();
		Thread.sleep(2000);
		clickOnWebElement(saveContBtn);
		Thread.sleep(1000);
		scrollToElementClick(appAll);
		Thread.sleep(1000);
		clickOnWebElement(saveContBtn);
		Thread.sleep(1000);
		scrollToElement(budget);
		selectByVisibleText(budget,"2024");
		scrollToElementClick(saveContBtn);
		Thread.sleep(3000);
		clickOnWebElement(partFunding);
		clickOnWebElement(approveDrpDwn);
		Thread.sleep(2000);
		clickOnWebElement(partnerFundApp);
		Thread.sleep(2000);
		clickOnWebElement(saveContBtn);
		Thread.sleep(2000);
		clickOnWebElement(approveBtn);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
	}
	
	public void appTabapproved() throws InterruptedException {
		
		
	//	scrollToElement(sndContact);
		selectByVisibleText(sndContact,"Agent Alex Santos");
		Thread.sleep(4000);
		selectByVisibleText(sndContact,"Agent Alex Santos");
		clickOnWebElement(saveContBtn);
		//Thread.sleep(2000);
		waitForvisibilityOfElement(fundSource);
		clickOnWebElement(fundSource);
		Thread.sleep(5000);
	//	waitForvisibilityOfElement(partName);
		driver.switchTo().frame(0);
		partName.sendKeys("abc");
		clickOnWebElement(saveBtn);
		Thread.sleep(5000);
	//	waitForvisibilityOfElement(amount);
		amount.sendKeys("3000");
		Thread.sleep(2000);
		clickOnWebElement(saveContBtn);
		Thread.sleep(3000);
		clickOnWebElement(manBtn);
		clickOnWebElement(plusBtn1);
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		WebElement add = driver.findElement(By.xpath("//*[@id='OutSystemsUIWeb_wt151_block_wtMainContent_wtfiles']/div/div[2]/a"));
		clickOnWebElement(add);
		clickOnWebElement(add);
		clickOnWebElement(add);
		
	}
	
	public void applicationTab() {
		
		clickOnWebElement(appTabBtn);
		
		
	}
	
	public void Drag() throws InterruptedException, AWTException {
		clickOnWebElement(docsBtn);
		clickOnWebElement(manBtn);
		clickOnWebElement(plusBtn1);
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		WebElement add = driver.findElement(By.xpath("//*[@id='OutSystemsUIWeb_wt151_block_wtMainContent_wtfiles']/div/div[2]/a"));
		singleClick(add);
		Thread.sleep(3000);
	    fileUpload("C:\\Users\\Shubham\\Desktop\\ims manual.txt");
	    Thread.sleep(3000);
	    clickOnWebElement(fileUploadSaveBtn);
	    waitForvisibilityOfElement(feedbckMsg);
		
		
		
	}
	
	public void fillStratDetails() throws InterruptedException {
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		stratGrantRadioBtn.click();
		 clickOnWebElement(stratFileUploadSaveBtn);
		 Thread.sleep(2000);
		stratItem.sendKeys("abc");
		stratSupplier.sendKeys("xyz");
		stratDate.sendKeys("05/04/2023"+Keys.ENTER);
		Thread.sleep(1000);
		stratVAT.sendKeys("1");
		
		
		
	}
	
	public void file() throws InterruptedException, AWTException {
		driver.switchTo().frame(0);
		Thread.sleep(4000);
		WebElement add = driver.findElement(By.xpath("//*[@id='OutSystemsUIWeb_wt151_block_wtMainContent_wtfiles']/div/div[2]/a"));
		singleClick(add);
		Thread.sleep(3000);
	    fileUpload("C:\\Users\\Shubham\\Desktop\\ims manual.txt");
	    Thread.sleep(3000);
	    clickOnWebElement(fileUploadSaveBtn);
	    Thread.sleep(5000);
		
	}
	public void stratFile() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		WebElement stratAdd = driver.findElement(By.xpath("//span[text()='Add Files']"));
		singleClick(stratAdd);
		Thread.sleep(3000);
	    fileUpload("C:\\Users\\Shubham\\Desktop\\ims manual.txt");
	    Thread.sleep(3000);
	    clickOnWebElement(stratFileUploadSaveBtn);
	    Thread.sleep(5000);
		
	}
	
	public void editBankDetails() throws InterruptedException {
		clickOnWebElement(saveContBtn);
		waitForvisibilityOfElement(docsBtn);
		clickOnWebElement(docsBtn);
		clickOnWebElement(manBtn);
		Thread.sleep(3000);
		clickOnWebElement(bankEdit);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		bankName.sendKeys("abc");
		sortCode.sendKeys("123456");
		accNumber.sendKeys("9876543");
		clickOnWebElement(bankSaveBtn);
		Thread.sleep(3000);
		clickOnWebElement(saveContBtn);
		waitForvisibilityOfElement(submit2);
		clickOnWebElement(submit2);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		
	}
	public void stratEditBankDetails() throws InterruptedException {
		clickOnWebElement(bankEdit);
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		bankName.sendKeys("abc");
		sortCode.sendKeys("123456");
		accNumber.sendKeys("9876543");
		clickOnWebElement(bankSaveBtn);
		Thread.sleep(4000);
	}
	
	public void drag1() throws InterruptedException, AWTException {
		
		clickOnWebElement(docsBtn);
		clickOnWebElement(manBtn);
	}
	
	public void drag2() throws InterruptedException, AWTException {
		clickOnWebElement(docsBtn);
		clickOnWebElement(manBtn);
		List<WebElement> plus = driver.findElements(By.xpath("//span[@class='fa fa-fw fa-plus-circle fa-lg']"));
		for(int i=0;i<plus.size();i++)
		{	
			plus.get(i).click();
	//		Thread.sleep(2000);
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			singleClick(add);
			Thread.sleep(3000);
		    fileUpload("C:\\Users\\Shubham\\Desktop\\ims manual.txt");
		    Thread.sleep(3000);
		    clickOnWebElement(fileUploadSaveBtn);
		    Thread.sleep(5000);
		    
		    if(i==3) {
				clickOnWebElement(suppEvi);
				Thread.sleep(4000);
				
				
			}
		    
		   }
	}
	
	public void countyReview() throws InterruptedException {
		clickOnWebElement(countyReview);
		devOutcomeBox.sendKeys("Abc");
		stratBox.sendKeys("ABCDEF");
		clickOnWebElement(saveContBtn);
		Thread.sleep(3000);
		clickOnWebElement(approveDrpDwn);
		Thread.sleep(1000);
		clickOnWebElement(countyReviewPartFundAppBtn);
		clickOnWebElement(saveContBtn);
		Thread.sleep(3000);
	}
	

	public void countyReviewDocsApproved() throws InterruptedException, AWTException {
		clickOnWebElement(docsBtn);
		//Thread.sleep(2000);
		clickOnWebElement(manBtn);	
		Thread.sleep(2000);
	//	scrollToElementClick(manBtn);	
	List<WebElement> countyapprDropdwn = driver.findElements(By.xpath("//div[@role='combobox']"));
//	WebElement countyapprDropdwnBtn = driver.findElement(By.xpath("(//a[@tabindex='0'])[2]"));
	for(int i=0;i<countyapprDropdwn.size();i++)
	{
		countyapprDropdwn.get(i).click();
		Thread.sleep(3000);
		clickOnWebElement(greenBox);
		Thread.sleep(3000);
		if(i==3) {
			clickOnWebElement(suppEvi);
			Thread.sleep(2000);
			
			
		}
		if(i==11) {
			clickOnWebElement(orgDocs);
			Thread.sleep(2000);
		}
		
		
	}
	clickOnWebElement(saveContBtn);
	Thread.sleep(3000);
	clickOnWebElement(editCountyRev);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	clickOnWebElement(approveBtn);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	
	
	}
	
	public void fifthUserSubmit() throws InterruptedException {
		clickOnWebElement(actionsBtn);
		Thread.sleep(2000);
		clickOnWebElement(submit2);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		
	}
	
	public void sixthUserSubmit() throws InterruptedException {
		clickOnWebElement(actionsBtn);
		Thread.sleep(2000);
		clickOnWebElement(editCountyRev);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		clickOnWebElement(countyReview);
		Thread.sleep(2000);
		ccbCont.sendKeys("1000");
		scrollToElementClick(saveContBtn);
		amount.clear();
		amount.sendKeys("2000");
		Thread.sleep(2000);
		clickOnWebElement(approveDrpDwn);
		Thread.sleep(2000);
		clickOnWebElement(partnerFundApp);
		Thread.sleep(2000);
		clickOnWebElement(saveContBtn);
		Thread.sleep(2000);
		clickOnWebElement(saveContBtn);
		Thread.sleep(2000);
		clickOnWebElement(approveBtn);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
	}
	
	public void sixthUserSubmit1() throws InterruptedException {
		clickOnWebElement(actionsBtn);
		Thread.sleep(2000);
		clickOnWebElement(editCountyRev);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		clickOnWebElement(approveBtn);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
	}
	
	public void testCode() throws InterruptedException {
		driver.get("http://www.google.com/");
        driver.manage().window().maximize();
        getSS("GooglePage1");
        driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Laptop"+ Keys.ENTER);
        Thread.sleep(3000);
        getSS("LaptopPage2");
		
	}
	
	public void testCode2() throws InterruptedException {
		ExcelDataProvider excel = new ExcelDataProvider();
		driver.get(excel.getStringData("Data1", 0, 0));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys(excel.getStringData("Data1", 0, 1)+ Keys.ENTER);
        Thread.sleep(3000);
		
	}
	
	public void testcode3() throws IOException {
		write("Shubham");
	//	excel.writeDataFromExcel(0, 1, "Data", "Shubham");
	}
	
	public void seventhUserSubmit() throws InterruptedException {
		clickOnWebElement(actionsBtn);
		Thread.sleep(2000);
		clickOnWebElement(submit2);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}
	
	public void logoutApplication()
	{
		clickOnWebElement(logoutBtn);
		waitForElementToBeClickable(loginBtn);
	}
	   		   



}
