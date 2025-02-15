package tutorialsninja.register;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonUtils;
public class TC_RF_010 
{
	@Test
	public void verifyRegisteringInvalidEmail() throws InterruptedException, IOException 
	{
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Kavin");
		driver.findElement(By.id("input-lastname")).sendKeys("S");
		driver.findElement(By.id("input-email")).sendKeys("kavinsakthivel");
		driver.findElement(By.id("input-telephone")).sendKeys("987383747");
		driver.findElement(By.id("input-password")).sendKeys("1234");
		driver.findElement(By.id("input-confirm")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		File screenShot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot1, new File(System.getProperty("user.dir")+"\\Screenshot\\sc1Actual.png"));
		
		Assert.assertFalse(CommonUtils.compareToScreenshot(System.getProperty("user.dir")+"\\Screenshot\\sc1Actual.png",System.getProperty("user.dir")+"\\Screenshot\\sc1Expected.png"));
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("kavinsakthivel@");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		File screenShot2 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot2, new File(System.getProperty("user.dir")+"\\Screenshot\\sc2Actual.png"));
		
		Assert.assertFalse(CommonUtils.compareToScreenshot(System.getProperty("user.dir")+"\\Screenshot\\sc2Actual.png",System.getProperty("user.dir")+"\\Screenshot\\sc2Expected.png"));
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("kavinsakthivel@gmail");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		String emailWarning="E-Mail Address does not appear to be valid!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(), emailWarning);
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("kavinsakthivel@gmail.");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(3000);
		File screenShot4 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot4, new File(System.getProperty("user.dir")+"\\Screenshot\\sc4Actual.png"));
		
		Assert.assertFalse(CommonUtils.compareToScreenshot(System.getProperty("user.dir")+"\\Screenshot\\sc4Actual.png",System.getProperty("user.dir")+"\\Screenshot\\sc4Expected.png"));
		driver.quit();
	}
	
}
