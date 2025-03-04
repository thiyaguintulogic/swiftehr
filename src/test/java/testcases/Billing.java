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

	@Test(priority = 0, description = "Generated the (OP) bill")
	public static void OPBill() throws AWTException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);
		
		WebElement viewAppointmentsButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),' View Appointments')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewAppointmentsButton);

		WebElement checkInButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Check In'])[1]")));
		checkInButton.click();

		WebElement firstRowFirstColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[1]/span")));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText().trim();
        System.out.println("Before Payment - OP Bill Patient Code :" + valueOfFirstRowFirstColumn);

		WebElement OPmenuIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor OPexecutor = (JavascriptExecutor) driver;
		OPexecutor.executeScript("arguments[0].click();", OPmenuIcon);

		WebElement opButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' OP']")));
		opButton.click();
		Thread.sleep(2000);
		
		WebElement searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Search']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton);
		
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
		
		WebElement searchButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton1);
		
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
		System.out.println("After paying the OP Bill - Bill Date    : " + AfterPaidBillDate);
		System.out.println("After paying the OP Bill - Bill Status  : " + AfterPaidStatus);
	}

		
	@Test(priority = 1,description = "Generated the (Lab) bill")
	public static void Lab_Bill() throws InterruptedException, AWTException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
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
        System.out.println("Before Payment - Lab Bill Patient Code : " + valueOfFirstRowFirstColumn);

     // Lab Billing Steps

     		WebElement CurrentmenuIcon = wait
     				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
     		JavascriptExecutor Currentmenuexecutor = (JavascriptExecutor) driver;
     		Currentmenuexecutor.executeScript("arguments[0].click();", CurrentmenuIcon);

     		WebElement admissionsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Current Admissions')]")));
     		((JavascriptExecutor) driver).executeScript("arguments[0].click();", admissionsLink);
     		Thread.sleep(5000);
     		
     		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
     		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton);
     		
     		
     		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
     		SearchStatus.sendKeys(valueOfFirstRowFirstColumn);
     		SearchStatus.sendKeys(Keys.ENTER);
     		Thread.sleep(2000);

		WebElement firstElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[8]/div[1]/a[1]/span[1]")));
		firstElement.click();
		
		WebElement labElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Lab')]")));
		labElement.click();
		
		WebElement addNewElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'Add New')])")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addNewElement1);
		
		WebElement selectDropdown1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectDropdown1);
		
		WebElement altBloodTest = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'01 lab test ')]")));
		wait.until(ExpectedConditions.elementToBeClickable(altBloodTest)).click();
		
		WebElement addNewElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])")));
		addNewElement2.click();
		
		WebElement selectDropdown2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectDropdown2);

		WebElement bilirubinPack = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Allergy Skin Test ')]")));
		bilirubinPack.click();
		
		WebElement addNewElement3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])")));
		addNewElement3.click();
		
		WebElement selectDropdown3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectDropdown3);
		
		WebElement liverTestPack = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Antibiotic Sensitivity Test ')]")));
		liverTestPack.click();
		
		WebElement saveAndCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),' Save & Close ')])[2]")));
		saveAndCloseButton.click();
		Thread.sleep(2000);
		
		WebElement LabtmenuIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor Labexecutor = (JavascriptExecutor) driver;
		Labexecutor.executeScript("arguments[0].click();", LabtmenuIcon);
		
		WebElement lablink = driver.findElement(By.xpath("(//a[text()=' Lab'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", lablink);
		Thread.sleep(2000);
		
		WebElement searchButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton1);
		
		
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
		
		WebElement lablink1 = driver.findElement(By.xpath("(//a[text()=' Lab'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", lablink1);
		Thread.sleep(2000);
		
		WebElement searchButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton2);
		
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
		System.out.println("After paying the Lab Bill - Bill Date    : " + AfterPaidBillDate);
		System.out.println("After paying the Lab Bill - Bill Status  : " + AfterPaidStatus);
	}
	
	
		@Test(priority = 2, description = "Generated the (Scan) bill")
		public static void Scan_Bill() throws InterruptedException, AWTException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

//		WebElement viewAppointmentsButton = wait
//			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),' View Appointments')]")));
//			wait.until(ExpectedConditions.elementToBeClickable(viewAppointmentsButton)).click();
		WebElement viewAppointmentsButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),' View Appointments')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewAppointmentsButton);
		
		WebElement firstRowFirstColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[1]/span")));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText().trim();
        System.out.println("Before Payment - Scan Bill Patient Code : " + valueOfFirstRowFirstColumn);
        
        WebElement CurrentmenuIcon = wait
 				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
 		JavascriptExecutor Currentmenuexecutor = (JavascriptExecutor) driver;
 		Currentmenuexecutor.executeScript("arguments[0].click();", CurrentmenuIcon);

 		WebElement currentAdmissionsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Current Admissions')]")));
 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", currentAdmissionsLink);
 		Thread.sleep(4000);

 		
 		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton);
 		
 		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
 		SearchStatus.sendKeys(valueOfFirstRowFirstColumn);
 		SearchStatus.sendKeys(Keys.ENTER);
 		Thread.sleep(2000);

 		WebElement firstElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[1]/td[8]/div[1]/a[1]/span[1]")));
 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstElement);

	
	WebElement ScanElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Scan')]")));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", ScanElement);
	
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
	
	WebElement labLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[text()=' Scan'])[1]")));
	executor.executeScript("arguments[0].click();", labLink);
	Thread.sleep(2000);
	
	WebElement searchButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton1);
	
	WebElement SearchPatient = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
	SearchPatient.sendKeys(valueOfFirstRowFirstColumn);
	SearchPatient.sendKeys(Keys.ENTER);
	Thread.sleep(4000);
	
	WebElement firstTableButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[1]/tr[1]/td[10]/div[1]/div[1]/button[1]")));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", firstTableButton);

	WebElement payButton = driver.findElement(By.xpath("//button[contains(text(),'Pay Bill')]"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", payButton);
	Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", payButton);

	
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
	
	WebElement scanLink = driver.findElement(By.xpath("(//a[text()=' Scan'])[1]"));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", scanLink);
	Thread.sleep(2000);
	
	WebElement searchButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton2);
	
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
	System.out.println("After paying the Scan Bill - Bill Date    : " + AfterPaidBillDate);
	System.out.println("After paying the Scan Bill - Bill Status  : " + AfterPaidStatus);
		
	}
	
	
}
