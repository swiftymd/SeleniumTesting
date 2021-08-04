package scenario3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Cart extends TestBase{

	@Test
	public void cartVerification() {
		
		//Searching for dress and verifying that its in stock then proceeding to add it to cart

		driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
		
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		
		boolean isDisplayed = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).isDisplayed();
		
		if(isDisplayed) {
			
			System.out.println("The Summer dress is in stock adding it to cart");
			
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).click();
			
			driver.findElement(By.id("add_to_cart")).click();
			
		}else {
			System.out.println("Dress is not in stock...returning to main page");
			
			driver.get("http://automationpractice.com/index.php");
		}
		
		//proceeding to cart to verify the correct dress is present then adding an additional dress
		
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")).click();
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
		
		boolean dressIsDisplayed = driver.findElement(By.linkText("Printed Summer Dress")).isDisplayed();
		
		if(dressIsDisplayed) {
			System.out.println("The dress is in the cart...updating quantity to two");
			
			
			WebElement element = driver.findElement(By.xpath("//*[@id=\"cart_quantity_up_5_19_0_0\"]/span"));
			
			Actions action = new Actions(driver);
			
			action.moveToElement(element).perform();
			action.click(element).perform();
			
			System.out.println("Updated to two dresses...proceeding to checkout");
			
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
			
		}else {
			System.out.println("The wrong dress was selected...removing it from cart");
			
			driver.findElement(By.xpath("//*[@id=\"5_19_0_547985\"]")).click();
		}
		
		driver.findElement(By.id("email")).sendKeys("testSelenium13@gmail.com");
		
		driver.findElement(By.id("passwd")).sendKeys("Password");
		
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
	}
	
}
