package tutorialsninja.register;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtils;
public class TC_RF_001 
{
	@Test 
	public  void VerifyWithMandatoryFields() 
	{
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	  driver.manage().window().maximize();
	  driver.get("http://tutorialsninja.com/demo");
	  driver.findElement(By.xpath("//span[text()='My Account']")).click();
	  driver.findElement(By.linkText("Register")).click();
	  driver.findElement(By.id("input-firstname")).sendKeys("Kavin"); 
	  driver.findElement(By.id("input-lastname")).sendKeys("Sakthivel");
	  driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateBrandNewEmail());
	  driver.findElement(By.id("input-telephone")).sendKeys("9872346473");
	  driver.findElement(By.id("input-password")).sendKeys("12345");
	  driver.findElement(By.id("input-confirm")).sendKeys("12345");
	  driver.findElement(By.name("agree")).click();
	  driver.findElement(By.xpath("//input[@value='Continue']")).click();
	  Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
	  String expectedHeading="Your Account Has Been Created!";
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);
	  String properDetailsOne="Congratulations! Your new account has been successfully created!";
	  String properDetailsTwo="You can now take advantage of member privileges to enhance your online shopping experience with us.";
	  String properDetailsThree="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
	  String properDetailsFour="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
	  String properDetailsFive="contact us.";
	  String ExpectedProperDetails=driver.findElement(By.id("content")).getText();
	  Assert.assertTrue(ExpectedProperDetails.contains(properDetailsOne));
	  Assert.assertTrue(ExpectedProperDetails.contains(properDetailsTwo));
	  Assert.assertTrue(ExpectedProperDetails.contains(properDetailsThree));
	  Assert.assertTrue(ExpectedProperDetails.contains(properDetailsFour));
	  Assert.assertTrue(ExpectedProperDetails.contains(properDetailsFive));
	  driver.findElement(By.xpath("//a[text()='Continue']")).click();
	  Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	  driver.quit();
	}
	
}
