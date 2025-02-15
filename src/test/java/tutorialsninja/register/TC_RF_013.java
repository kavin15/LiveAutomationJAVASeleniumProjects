package tutorialsninja.register;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TC_RF_013 
{
	@Test
	public void verifyRegistringPlaceholder() throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String expectedPlaceHolderFirstName="First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getDomAttribute("placeholder"), expectedPlaceHolderFirstName);
		
		String expectedPlaceHolderLastName="Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getDomAttribute("placeholder"), expectedPlaceHolderLastName);
		
		String expectedPlaceHolderEmail="E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getDomAttribute("placeholder"), expectedPlaceHolderEmail);
		
		String expectedPlaceHolderTelephone="Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getDomAttribute("placeholder"), expectedPlaceHolderTelephone);
		
		String expectedPlaceHolderPassword="Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getDomAttribute("placeholder"), expectedPlaceHolderPassword);
		
		String expectedPlaceHolderPasswordConfirm="Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getDomAttribute("placeholder"), expectedPlaceHolderPasswordConfirm);
		
		driver.quit();
	}
}
