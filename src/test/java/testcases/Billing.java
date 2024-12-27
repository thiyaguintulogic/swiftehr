package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class Billing extends BaseTest {

	
	public static void Logintest() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin-email")));
		username.sendKeys("intuadmin");

		WebElement password = driver.findElement(By.id("signin-password"));
		password.sendKeys("scott");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(8000);

		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

	}

	@Test(priority = 0)
	public static void OPBill() throws AWTException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);
		
		WebElement viewAppointmentsButton = wait
			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),' View Appointments')]")));
			wait.until(ExpectedConditions.elementToBeClickable(viewAppointmentsButton)).click();

		WebElement checkInButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Check In'])[1]")));
		checkInButton.click();

		WebElement firstRowFirstColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[1]/span")));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText().trim();
        System.out.println("OP Bill Patient Code :" + valueOfFirstRowFirstColumn);

		WebElement OPmenuIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor OPexecutor = (JavascriptExecutor) driver;
		OPexecutor.executeScript("arguments[0].click();", OPmenuIcon);

		WebElement opButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' OP']")));
		opButton.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement firstAddButton = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[1]/tr[1]/td[10]/div[1]/div[1]/button[1]")));
		firstAddButton.click();

		WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='bill-view-opbilladd']")));
		addButton.click();

		WebElement firstSelectDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
		firstSelectDropdown.click();

		WebElement aadityaConsultationFees = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[contains(text(),'Dr.Neeraj Fees ')]")));
		aadityaConsultationFees.click();

		WebElement secondAddButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='bill-view-opbilladd']")));
		secondAddButton.click();

		WebElement secondSelectDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
		secondSelectDropdown.click();
		Thread.sleep(3000);

		WebElement opRegistrationFees = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[contains(text(),'Consultation fees ')]")));
		opRegistrationFees.click();

		WebElement payBillButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Pay Bill')]")));
		payBillButton.click();

		WebElement yesButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
		yesButton.click();
		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();

		Robot robot = new Robot();
		robot.delay(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		WebElement menuIcon_OP = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor_OP = (JavascriptExecutor) driver;
		executor_OP.executeScript("arguments[0].click();", menuIcon_OP);
		
		driver.findElement(By.xpath("(//a[text()=' OP'])")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus_OP = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus_OP.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus_OP.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		
		WebElement PatientCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
		String AfterPaidPatientCode = PatientCode.getText();

		WebElement Billnumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[5]")));
		String AfterPaidBillnumber = Billnumber.getText();
		
		WebElement BillDate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[6]")));
		String AfterPaidBillDate = BillDate.getText();

		WebElement AfterStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[8]")));
		String AfterPaidStatus = AfterStatus.getText();

		System.out.println("After paying the OP Bill - Patient Code : " + AfterPaidPatientCode);
		System.out.println("After paying the OP Bill - Bill Number  : " + AfterPaidBillnumber);
		System.out.println("After paying the OP Bill - Bill Number  : " + AfterPaidBillDate);
		System.out.println("After paying the OP Bill - Bill Status  : " + AfterPaidStatus);
	}

		
	@Test(priority = 1)
	public static void Lab_Bill() throws InterruptedException, AWTException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

		WebElement viewAppointmentsButton = wait
			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),' View Appointments')]")));
			wait.until(ExpectedConditions.elementToBeClickable(viewAppointmentsButton)).click();

//		WebElement checkInButton = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Check In'])[1]")));
//		checkInButton.click();

		WebElement firstRowFirstColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[1]/span")));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText().trim();
        System.out.println("Lab Bill Patient Code : " + valueOfFirstRowFirstColumn);

     // Lab Billing Steps

     		WebElement CurrentmenuIcon = wait
     				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
     		JavascriptExecutor Currentmenuexecutor = (JavascriptExecutor) driver;
     		Currentmenuexecutor.executeScript("arguments[0].click();", CurrentmenuIcon);

     		driver.findElement(By.xpath("//a[contains(text(),' Current Admissions')]")).click();
     		Thread.sleep(2000);

     		driver.findElement(By.xpath("//button[@title='Search']")).click();
     		
     		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
     		SearchStatus.sendKeys(valueOfFirstRowFirstColumn);
     		SearchStatus.sendKeys(Keys.ENTER);
     		Thread.sleep(2000);

		WebElement firstElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[8]/div[1]/a[1]/span[1]")));
		firstElement.click();
		
		WebElement labElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Lab')]")));
		labElement.click();
		
		WebElement addNewElement1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])")));
		addNewElement1.click();
		
		WebElement selectDropdown1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
		selectDropdown1.click();
		
		WebElement altBloodTest = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'01 lab test ')]")));
		altBloodTest.click();
		
		WebElement addNewElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])")));
		addNewElement2.click();
		
		WebElement selectDropdown2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
		selectDropdown2.click();

		WebElement bilirubinPack = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Allergy Skin Test ')]")));
		bilirubinPack.click();
		
		WebElement addNewElement3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])")));
		addNewElement3.click();
		
		WebElement selectDropdown3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
		selectDropdown3.click();
		
		WebElement liverTestPack = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Antibiotic Sensitivity Test ')]")));
		liverTestPack.click();
		
		WebElement saveAndCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),' Save & Close ')])[2]")));
		saveAndCloseButton.click();
		Thread.sleep(2000);
		
		WebElement LabtmenuIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor Labexecutor = (JavascriptExecutor) driver;
		Labexecutor.executeScript("arguments[0].click();", LabtmenuIcon);
		
		WebElement labLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()=' Lab'])[1]")));
		labLink.click();
		Thread.sleep(2000);
		
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchButton.click();
		
		WebElement SearchPatient = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchPatient.sendKeys(valueOfFirstRowFirstColumn);
		SearchPatient.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement firstTableButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[1]/tr[1]/td[10]/div[1]/div[1]/button[1]")));
		firstTableButton.click();
		
		WebElement payBillButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Pay Bill')]")));
		payBillButton.click();
		
		WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
		yesButton.click();
		
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();

		Robot robot = new Robot();
		robot.delay(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		WebElement menuIcon_OP = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor_OP = (JavascriptExecutor) driver;
		executor_OP.executeScript("arguments[0].click();", menuIcon_OP);
		
		driver.findElement(By.xpath("(//a[text()=' Lab'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus_OP = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus_OP.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus_OP.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		
		WebElement PatientCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
		String AfterPaidPatientCode = PatientCode.getText();

		WebElement Billnumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[5]")));
		String AfterPaidBillnumber = Billnumber.getText();
		
		WebElement BillDate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[6]")));
		String AfterPaidBillDate = BillDate.getText();

		WebElement AfterStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[8]")));
		String AfterPaidStatus = AfterStatus.getText();

		System.out.println("After paying the Lab Bill - Patient Code : " + AfterPaidPatientCode);
		System.out.println("After paying the Lab Bill - Bill Number  : " + AfterPaidBillnumber);
		System.out.println("After paying the Lab Bill - Bill Number  : " + AfterPaidBillDate);
		System.out.println("After paying the Lab Bill - Bill Status  : " + AfterPaidStatus);
	}
	
	
		
	public static void Scan_Bill() throws InterruptedException, AWTException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

		WebElement viewAppointmentsButton = wait
			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),' View Appointments')]")));
			wait.until(ExpectedConditions.elementToBeClickable(viewAppointmentsButton)).click();
		
		WebElement firstRowFirstColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[1]/span")));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText().trim();
        System.out.println("Scan Bill Patient Code : " + valueOfFirstRowFirstColumn);
        
        WebElement CurrentmenuIcon = wait
 				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
 		JavascriptExecutor Currentmenuexecutor = (JavascriptExecutor) driver;
 		Currentmenuexecutor.executeScript("arguments[0].click();", CurrentmenuIcon);

 		driver.findElement(By.xpath("//a[contains(text(),' Current Admissions')]")).click();
 		Thread.sleep(2000);

 		driver.findElement(By.xpath("//button[@title='Search']")).click();
 		
 		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
 		SearchStatus.sendKeys(valueOfFirstRowFirstColumn);
 		SearchStatus.sendKeys(Keys.ENTER);
 		Thread.sleep(2000);

	WebElement firstElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[8]/div[1]/a[1]/span[1]")));
	firstElement.click();
	
	WebElement ScanElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Scan')]")));
	ScanElement.click();
	
	WebElement addNewElement1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])")));
	addNewElement1.click();
	
	WebElement typescan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@role='combobox']")));
	typescan.clear();
	typescan.sendKeys("C");
	
	WebElement CTScan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),' CT Scan ')]")));
	CTScan.click();
	
	WebElement addNewElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])")));
	addNewElement2.click();
	
	WebElement typescan1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@role='combobox']")));
	typescan1.clear();
	typescan1.sendKeys("M");
	
	WebElement MRIScan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),' MRI SCAN ')]")));
	MRIScan.click();
	
	WebElement addNewElement3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])")));
	addNewElement3.click();
	
	WebElement typescan2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@role='combobox']")));
	typescan2.clear();
	typescan2.sendKeys("X");
	
	WebElement Xray = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),' x-Ray ')]")));
	Xray.click();
	
	WebElement saveAndCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),' Save & Close ')])")));
	saveAndCloseButton.click();
	Thread.sleep(2000);
	
	WebElement LabtmenuIcon = wait
			.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
	JavascriptExecutor Labexecutor = (JavascriptExecutor) driver;
	Labexecutor.executeScript("arguments[0].click();", LabtmenuIcon);
	
	WebElement labLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()=' Scan'])[1]")));
	labLink.click();
	Thread.sleep(2000);
	
	WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
	searchButton.click();
	
	WebElement SearchPatient = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
	SearchPatient.sendKeys(valueOfFirstRowFirstColumn);
	SearchPatient.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
	WebElement firstTableButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[1]/tr[1]/td[10]/div[1]/div[1]/button[1]")));
	firstTableButton.click();
	
	WebElement payBillButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Pay Bill')]")));
	payBillButton.click();
	
	WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
	yesButton.click();
	
	Thread.sleep(2000);
	
	Actions actions = new Actions(driver);
	actions.sendKeys(Keys.TAB).build().perform();
	actions.sendKeys(Keys.ENTER).build().perform();

	Robot robot = new Robot();
	robot.delay(2000);

	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);

	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);

	WebElement menuIcon_OP = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
	JavascriptExecutor executor_OP = (JavascriptExecutor) driver;
	executor_OP.executeScript("arguments[0].click();", menuIcon_OP);
	
	driver.findElement(By.xpath("(//a[text()=' Scan'])[1]")).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("//button[@title='Search']")).click();
	
	WebElement SearchStatus_OP = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
	SearchStatus_OP.sendKeys(valueOfFirstRowFirstColumn);
	SearchStatus_OP.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
	
	WebElement PatientCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
	String AfterPaidPatientCode = PatientCode.getText();

	WebElement Billnumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[6]")));
	String AfterPaidBillnumber = Billnumber.getText();
	
	WebElement BillDate = wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[5]")));
	String AfterPaidBillDate = BillDate.getText();

	WebElement AfterStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[8]")));
	String AfterPaidStatus = AfterStatus.getText();

	System.out.println("After paying the Scan Bill - Patient Code : " + AfterPaidPatientCode);
	System.out.println("After paying the Scan Bill - Bill Number  : " + AfterPaidBillnumber);
	System.out.println("After paying the Scan Bill - Bill Number  : " + AfterPaidBillDate);
	System.out.println("After paying the Scan Bill - Bill Status  : " + AfterPaidStatus);
		
	}
	
	
}
