package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import io.netty.handler.timeout.TimeoutException;

public class SmokeTest extends BaseTest {

	@Test(priority = 0)
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

	@Test(priority = 1)
	public static void PatientRegistration() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		// Click on 'Patient Registration'
		WebElement patientRegistration = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),' Patient Registration')]")));
		patientRegistration.click();

		// Fill out the registration form for the first patient
		WebElement firstName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='First Name']")));
		firstName.sendKeys("Layla");
		
		WebElement Lastname = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[2]")));
		Lastname.sendKeys("Ethan");

		WebElement age = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Age']")));
		age.sendKeys("23");

		WebElement phoneNumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Phone Number']")));
		phoneNumber.sendKeys("1232124253");

		WebElement genderFemale = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Female')]")));
		genderFemale.click();

		WebElement stateDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='cityChange']")));
		Select state = new Select(stateDropdown);
		state.selectByVisibleText(" Tamil Nadu ");

		WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"patientForm\"]/div[1]/div[15]/div/mat-form-field/div/div[1]")));
		cityField.click();

		WebElement cityChennai = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Cuddalore')]")));
		cityChennai.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");

		WebElement submitButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
		submitButton.click();

		Thread.sleep(5000);

		// Fill out the registration form for the second patient
//		WebElement firstName2 = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='First Name']")));
//		firstName2.sendKeys("Damian");
//		
//		WebElement Lastname2 = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[2]")));
//		Lastname2.sendKeys("Jeremiah");
//
//		WebElement age2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Age']")));
//		age2.sendKeys("25");
//
//		WebElement phoneNumber2 = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Phone Number']")));
//		phoneNumber2.sendKeys("3212412563");
//
//		WebElement genderMale = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Male')]")));
//		genderMale.click();
//
//		WebElement stateDropdown2 = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='cityChange']")));
//		Select state2 = new Select(stateDropdown2);
//		state2.selectByVisibleText(" Tamil Nadu ");
//
//		WebElement cityField2 = wait.until(ExpectedConditions.elementToBeClickable(
//				By.xpath("//*[@id=\"patientForm\"]/div[1]/div[15]/div/mat-form-field/div/div[1]")));
//		cityField2.click();
//
//		WebElement cityAruppukkottai = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Cuddalore')]")));
//		cityAruppukkottai.click();
//
//		js.executeScript("window.scrollBy(0, 500);");
//
//		WebElement submitButton2 = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
//		submitButton2.click();

	}

	
	@Test(priority = 2)
	public static void Create_Appointment() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", menuIcon);
        Thread.sleep(8000);

        WebElement patientSearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Patient Search')]")));
        wait.until(ExpectedConditions.visibilityOf(patientSearch));
        if (patientSearch.isEnabled()) {
            wait.until(ExpectedConditions.elementToBeClickable(patientSearch)).click();
            System.out.println("Patient Search clicked successfully");
        } else {
            System.out.println("Patient Search is not enabled");
        }

		// Loop for five appointments
		for (int i = 1; i <=1; i++) {
			// Click the appointment button on the ith row
			WebElement appointmentButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Appointment'])[" + i + "]")));
			appointmentButton.click();

			// Wait for the purpose dropdown to be clickable
			WebElement purposeDropdown = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Purpose of Visit']")));
			purposeDropdown.click();

			// Select "Out Patient" from the purpose dropdown
			Select selectPurposeofVisit = new Select(purposeDropdown);
			selectPurposeofVisit.selectByVisibleText("Out Patient");

			// Click the doctor dropdown to open options
			WebElement selectDoctorDropdown = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Doctor']")));
			selectDoctorDropdown.click();

			// Wait for the dropdown options to be interactable
			Select selectDoctor = new Select(selectDoctorDropdown);
			selectDoctor.selectByVisibleText(" Dr.Damien S ");

			// Click the "Save & Close" button
			WebElement saveAndCloseButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),' Save & Close ')]")));
			saveAndCloseButton.click();
			Thread.sleep(4000);
			
			WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Appointment Saved Successfully')]")));
			String message = successMessage.getText();
			System.out.println("Appointment message: " + message);

		}

	}

	
	public static void Appoinment_Already_Created() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(3000);

		WebElement patientSearch = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Patient Search')]")));
		patientSearch.click();

		// Loop for five appointments
		for (int i = 1; i <= 5; i++) {
			// Click the appointment button on the ith row
			WebElement appointmentButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Appointment'])[\" + i + \"]")));
			appointmentButton.click();

			// Wait for the purpose dropdown to be clickable
			WebElement purposeDropdown = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Purpose of Visit']")));
			purposeDropdown.click();

			// Select "Out Patient" from the purpose dropdown
			Select selectPurposeofVisit = new Select(purposeDropdown);
			selectPurposeofVisit.selectByVisibleText("Out Patient");

			// Click the doctor dropdown to open options
			WebElement selectDoctorDropdown = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Doctor']")));
			selectDoctorDropdown.click();

			// Wait for the dropdown options to be interactable
			Select selectDoctor = new Select(selectDoctorDropdown);
			selectDoctor.selectByVisibleText(" Dr.Damien S ");

			// Click the "Save & Close" button
			WebElement saveAndCloseButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),' Save & Close ')]")));
			saveAndCloseButton.click();
			
			

			WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Appointment Already Created For This Patient')]")));
            String message = successMessage.getText();
			System.out.println("Error message:" + message);
			
			

			if (message.contains("Appointment saved successfully")) {
				System.out.println("Appointment saved successfully for patient " + i);
			} else if (message.contains("Appointment Already Created For This Patient")) {
				// Click close button (assuming there's a close button next to
				// saveAndCloseButton)
				WebElement closeButton = driver.findElement(By.xpath("//button[@id='CloseAp']"));
				closeButton.click();
				System.out.println("Appointment already created for patient " + i);
			} else {
				System.out.println("Unknown message: " + message);
			}

		}

	}
	
	public void Create_Admission() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		
	}
	
	
	public static void Combined_Create_or_Already_Created_Appointment() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    // Navigate to Patient Search
	    WebElement patientSearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Patient Search')]")));
	    patientSearch.click();

	    // Loop for appointments
	    for (int i = 1; i <= 5; i++) {
	        // Click the appointment button on the ith row
	        WebElement appointmentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Appointment'])[" + i + "]")));
	        appointmentButton.click();

	        // Wait for the purpose dropdown to be clickable
	        WebElement purposeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Purpose of Visit']")));
	        purposeDropdown.click();

	        // Select "Out Patient" from the purpose dropdown
	        Select selectPurposeofVisit = new Select(purposeDropdown);
	        selectPurposeofVisit.selectByVisibleText("Out Patient");

	        // Click the doctor dropdown to open options
	        WebElement selectDoctorDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Doctor']")));
	        selectDoctorDropdown.click();

	        // Wait for the dropdown options to be interactable
	        Select selectDoctor = new Select(selectDoctorDropdown);
	        selectDoctor.selectByVisibleText(" Dr.Damien S ");

	        // Click the "Save & Close" button
	        WebElement saveAndCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),' Save & Close ')]")));
	        saveAndCloseButton.click();

	        // Check for success or error message
	        WebElement messageElement;

	        try {
	            messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Appointment Saved Successfully')]")));
	            System.out.println("Appointment saved successfully for patient " + i);
	        } catch (TimeoutException e) {
	            messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Appointment Already Created For This Patient')]")));
	            System.out.println("Appointment already created for patient " + i);

	            // Click close button (assuming there's a close button next to saveAndCloseButton)
	            WebElement closeButton = driver.findElement(By.xpath("//button[@id='CloseAp']"));
	            closeButton.click();
	        }

	        String message = messageElement.getText();
	        System.out.println("Message: " + message);
	    }
	}
	
}
