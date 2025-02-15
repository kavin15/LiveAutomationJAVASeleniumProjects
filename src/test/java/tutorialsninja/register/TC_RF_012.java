package tutorialsninja.register;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonUtils;
public class TC_RF_012 
{
	@Test
	public void verifyRegistringAccountUsingKeyboards() 
	{
		 WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		  driver.manage().window().maximize();
		  driver.get("http://tutorialsninja.com/demo");
		  driver.findElement(By.xpath("//span[text()='My Account']")).click();
		  driver.findElement(By.linkText("Register")).click();
		  Actions actions=new Actions(driver);
		  for(int i=1;i<=23;i++) 
		  {
			  actions.sendKeys(Keys.TAB).perform();
		  }
		  actions.sendKeys("kavin").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		  .sendKeys("Sakthivel").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		  .sendKeys(CommonUtils.generateBrandNewEmail()).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		  .sendKeys("1425234715").pause(Duration.ofSeconds(1)).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		  .sendKeys("1234").pause(Duration.ofSeconds(2)).sendKeys(Keys.TAB)
		  .sendKeys("1234").pause(Duration.ofSeconds(2)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(2)).sendKeys(Keys.LEFT).pause(Duration.ofSeconds(1))
		  .sendKeys(Keys.TAB).pause(Duration.ofSeconds(2)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		  .sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		  
		  Assert.assertTrue(driver.findElement(By.xpath("//*[@id='column-right']//a[text()='Logout']")).isDisplayed());
		  Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		  
		  driver.quit();
	}
}
