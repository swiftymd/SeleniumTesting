package scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AccountCreation extends TestBase {

	@Test(priority=1)
	public void accountCreation() {
		
		//HomePage to Email Registration
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("testSelenium13@gmail.com");
		
		driver.findElement(By.id("SubmitCreate")).click();
		
		//Email Registration information
		
		driver.findElement(By.id("uniform-id_gender1")).click();
		
		driver.findElement(By.id("customer_firstname")).sendKeys("Test");
		
		driver.findElement(By.id("customer_lastname")).sendKeys("Selenium");
		
		driver.findElement(By.id("passwd")).sendKeys("Password!");
		
		WebElement day = driver.findElement(By.xpath("//*[@id=\"days\"]"));
		Select sel = new Select(day);
		sel.selectByValue("1");
		
		WebElement month = driver.findElement(By.xpath("//*[@id=\"months\"]"));
		Select sel1 = new Select(month);
		sel1.selectByValue("1");
		
		WebElement year = driver.findElement(By.xpath("//*[@id=\"years\"]"));
		Select sel2 = new Select(year);
		sel2.selectByValue("1996");
		
		driver.findElement(By.id("address1")).sendKeys("123 test selenium ways");
		
		driver.findElement(By.id("city")).sendKeys("selenium");
		
		WebElement state = driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
		Select sel3 = new Select(state);
		sel3.selectByValue("32");
		
		driver.findElement(By.id("postcode")).sendKeys("12345");
		
		driver.findElement(By.id("phone_mobile")).sendKeys("7475482485");
		
		driver.findElement(By.id("submitAccount")).click();
		
		
		}
	
	@Test(priority=2)
	public void updateInformation() {
		
	//HomePage to login to update information
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		
		driver.findElement(By.id("email")).sendKeys("testSelenium13@gmail.com");
		
		driver.findElement(By.id("passwd")).sendKeys("Password!");
		
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]/a")).click();
		
		//updated information
		
		driver.findElement(By.id("firstname")).sendKeys("testnew");
		
		driver.findElement(By.id("lastname")).sendKeys("seleniumnew");
		
		driver.findElement(By.id("lastname")).sendKeys("seleniumnew");
		
		WebElement day = driver.findElement(By.xpath("//*[@id=\"days\"]"));
		Select sel = new Select(day);
		sel.selectByValue("4");
		
		WebElement month = driver.findElement(By.xpath("//*[@id=\"months\"]"));
		Select sel1 = new Select(month);
		sel1.selectByValue("6");
		
		WebElement year = driver.findElement(By.xpath("//*[@id=\"years\"]"));
		Select sel2 = new Select(year);
		sel2.selectByValue("1995");
		
		driver.findElement(By.id("old_passwd")).sendKeys("Password!");
		
		driver.findElement(By.id("passwd")).sendKeys("Password");
		
		driver.findElement(By.id("confirmation")).sendKeys("Password");
		
		driver.findElement(By.xpath("//*[@id='center_column']/div/form/fieldset/div[11]/button")).click();
		
		
	}
	
	@Test(priority=3)
	public void updateAdditionalAddress() {
		
		//HomePage to login to update information Page
		
				driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
				
				driver.findElement(By.id("email")).sendKeys("testSelenium13@gmail.com");
				
				driver.findElement(By.id("passwd")).sendKeys("Password");
				
				driver.findElement(By.id("SubmitLogin")).click();
				
				driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[3]/a")).click();
				
				//Update Address button and information
				
				driver.findElement(By.xpath("//*[@id='center_column']/div[2]/a")).click();
		
				driver.findElement(By.id("address1")).sendKeys("124 Selenium Dr");
				
				driver.findElement(By.id("city")).sendKeys("Buffalo");
				
				WebElement state = driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
				Select sel = new Select(state);
				sel.selectByValue("30");
				
				driver.findElement(By.id("postcode")).sendKeys("13242");
				
				driver.findElement(By.id("phone")).sendKeys("7485742854");
				
				driver.findElement(By.id("alias")).sendKeys("Second Address");
				
				driver.findElement(By.id("submitAddress")).click();
				
	}
}
