package tutorialsninja.register;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import utils.CommonUtils;

public class TC_RF_011 
{
	public void verifyWithInvalidPhone()
	{
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Kavin");
		driver.findElement(By.id("input-lastname")).sendKeys("S");
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateBrandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("abcde");
		driver.findElement(By.id("input-password")).sendKeys("1234");
		driver.findElement(By.id("input-confirm")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String telephoneWarning="Telephone number does not appear to be valid!";
		SoftAssert a=new SoftAssert();
		a.assertEquals(driver.findElement(By.xpath("//input[@name='telephone']/following-sibling::div")).getText(), telephoneWarning);
		driver.quit();
		a.assertAll();
	}
}
