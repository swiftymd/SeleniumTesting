package scenario2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

	@Test(priority=1)
	public void chiffonDress() {
		
		driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
		
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		
		boolean isDisplayed = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[1]/span[1]")).isDisplayed();
		
		if(isDisplayed) {
			System.out.println("The dress is in stock, adding it to cart");
			
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/h5/a")).click();
			
			driver.findElement(By.id("add_to_cart")).click();
			
		}else {
			System.out.println("Dress is not in stock");
			driver.quit();
		}
		
	}
	
	@Test(priority=2)
	public void summerDress() {
		
		driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
		
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		
		boolean isDisplayed = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span[1]")).isDisplayed();
	
		if(isDisplayed) {
			
			System.out.println("The summer dress is in stock, adding it too cart");
			
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).click();
			
			driver.findElement(By.id("add_to_cart")).click();
			
		}else {
			System.out.println("dress is not in stock");
			
			driver.quit();
		}
	}
	
	@Test(priority=3)
	public void noResults() {
		
		driver.findElement(By.id("search_query_top")).sendKeys("Printedd Dress");
		
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		
		boolean isDisplayed = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).isDisplayed();
		
		if(isDisplayed) {
			System.out.println("Your Search had zero results...returning to homepage");
			
			driver.get("http://automationpractice.com/index.php");
		}else {
			driver.quit();
		}
		
	}
	
	
}
