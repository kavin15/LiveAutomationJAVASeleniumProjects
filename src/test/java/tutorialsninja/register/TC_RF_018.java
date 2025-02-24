package tutorialsninja.register;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonUtils;
public class TC_RF_018  
{
	@Test
	public void verifyRegisteringAccountFieldWidth() throws IOException 
	{
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		String exceptedHeight="34px";
		String exceptedWidth="701.25px";

		WebElement firstNameField = driver.findElement(By.id("input-firstname"));
		String actualFirstNameHeight = firstNameField.getCssValue("height");
		String actualFirstNameWidth = firstNameField.getCssValue("width");
		Assert.assertEquals(actualFirstNameHeight, exceptedHeight);
		Assert.assertEquals(actualFirstNameWidth, exceptedWidth);

		firstNameField = driver.findElement(By.id("input-firstname"));
		firstNameField.sendKeys("");
		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		String expectedFirstNameWarning="First Name must be between 1 and 32 characters!";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), expectedFirstNameWarning);

		firstNameField = driver.findElement(By.id("input-firstname"));
		firstNameField.clear();
		firstNameField.sendKeys("a");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		firstNameField = driver.findElement(By.id("input-firstname"));
		firstNameField.clear();
		firstNameField.sendKeys("ab");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		firstNameField = driver.findElement(By.id("input-firstname"));
		firstNameField.clear();
		firstNameField.sendKeys("absueyoghfpynrks");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		firstNameField = driver.findElement(By.id("input-firstname"));
		firstNameField.clear();
		firstNameField.sendKeys("absueyoghfpynrksabsueyoghfpynrks");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		firstNameField = driver.findElement(By.id("input-firstname"));
		firstNameField.clear();
		firstNameField.sendKeys("absueyoghfpynrksabsueyoghfpynrksp");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), expectedFirstNameWarning);

		//-------------------------------------------------------

		WebElement lastNameField = driver.findElement(By.id("input-lastname"));
		String actualLastNameHeight = lastNameField.getCssValue("height");
		String actualLastNameWidth = lastNameField.getCssValue("width");
		String expectedLastNameWarning="Last Name must be between 1 and 32 characters!";
		Assert.assertEquals(actualLastNameHeight, exceptedHeight);
		Assert.assertEquals(actualLastNameWidth, exceptedWidth);

		lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.sendKeys("");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), expectedLastNameWarning);

		lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.clear();
		lastNameField.sendKeys("a");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));

		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.clear();
		lastNameField.sendKeys("ab");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));

		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.clear();
		lastNameField.sendKeys("absueyoghfpynrks");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));

		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.clear();
		lastNameField.sendKeys("absueyoghfpynrksabsueyoghfpynrks");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));

		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.clear();
		lastNameField.sendKeys("absueyoghfpynrksabsueyoghfpynrksp");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));

		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), expectedLastNameWarning);

		//-----------------------------------------------
		WebElement emailField = driver.findElement(By.id("input-email"));
		String actualEmailHeight = emailField.getCssValue("height");
		String actualEmailWidth = emailField.getCssValue("width");
		Assert.assertEquals(actualEmailHeight, exceptedHeight);
		Assert.assertEquals(actualEmailWidth, exceptedWidth);


		emailField.sendKeys("absueyoghfpynrksabsueyoghfpynrkspabsueyoghfpynrksabsueyoghfpynrk@gmail.com");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		//-----------------------------------------------

		WebElement telephoneField = driver.findElement(By.id("input-telephone"));
		String actualTelephoneHeight = telephoneField.getCssValue("height");
		String actualTelephoneWidth = telephoneField.getCssValue("width");
		String expectedTelephoneWarning="Telephone must be between 3 and 32 characters!";
		Assert.assertEquals(actualTelephoneHeight, exceptedHeight);
		Assert.assertEquals(actualTelephoneWidth, exceptedWidth);

		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.sendKeys("");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedTelephoneWarning);

		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.sendKeys("a");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedTelephoneWarning);

		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.clear();
		telephoneField.sendKeys("ab");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedTelephoneWarning);

		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.clear();
		telephoneField.sendKeys("abc");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.clear();
		telephoneField.sendKeys("abcd");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.clear();
		telephoneField.sendKeys("abcdefghijklmnop");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.clear();
		telephoneField.sendKeys("abcdefghijklmnopabcdefghijklmnop");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.clear();
		telephoneField.sendKeys("abcdefghijklmnopabcdefghijklmnopm");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedTelephoneWarning);

		//-----------------------------------------------

		WebElement passwordField = driver.findElement(By.id("input-password"));
		String actualPasswordHeight = passwordField.getCssValue("height");
		String actualPasswordWidth = passwordField.getCssValue("width");
		String expectedPasswordWarning="Password must be between 4 and 20 characters!";
		Assert.assertEquals(actualPasswordHeight, exceptedHeight);
		Assert.assertEquals(actualPasswordWidth, exceptedWidth);

		passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedPasswordWarning);

		passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("a");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedPasswordWarning);

		passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("ab");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedPasswordWarning);

		passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("abc");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedPasswordWarning);

		passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("abcd");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("abcde");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("abcdefghij");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("abcdefghijabcdefghi");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("abcdefghijabcdefghij");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("abcdefghijabcdefghijk");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedPasswordWarning);

		String actualConfirmPasswordHeight = driver.findElement(By.id("input-confirm")).getCssValue("height");
		String actualConfirmPasswordWidth = driver.findElement(By.id("input-confirm")).getCssValue("width");
		Assert.assertEquals(actualConfirmPasswordHeight, exceptedHeight);
		Assert.assertEquals(actualConfirmPasswordWidth, exceptedWidth);
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/register");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcScreenshot=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot,new File(System.getProperty("user.dir")+"\\Screenshot\\registerPageActual.png"));
		Assert.assertFalse(CommonUtils.compareToScreenshot(System.getProperty("user.dir")+"\\Screenshot\\registerPageActual.png", System.getProperty("user.dir")+"\\Screenshot\\registerPageExpected.png"));
		driver.quit();
	}
}
