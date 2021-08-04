package testscenario4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VerifyOrder extends TestBase {

	@Test
	public void verifyOrder() throws AWTException {
		
		//login
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		
		driver.findElement(By.id("email")).sendKeys("testSelenium13@gmail.com");
		
		driver.findElement(By.id("passwd")).sendKeys("Password");
		
		driver.findElement(By.id("SubmitLogin")).click();
		
		//order history verifying orders in order history
		
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[7]/a[1]")).click();
		
		boolean ordersPlaced = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).isDisplayed();
		
		if(ordersPlaced) {
			System.out.println("There are orders present within your order history");
			
		}else {
			System.out.println("There are no orders present within your order history...returning to previous page");
			driver.navigate().back();
		}
		
		boolean orderTotal = driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[3]")).isDisplayed();
		
		boolean detailTotal = driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[2]/td[3]/span")).isDisplayed();
		
		if(orderTotal == detailTotal) {
			System.out.println("The totals are verified and are the same");
		}else {
			System.out.println("The totals do not match...requesting cancelation");
			driver.findElement(By.xpath("//*[@id=\"sendOrderMessage\"]/p[2]/select")).click();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			
			driver.findElement(By.xpath("//*[@id=\"sendOrderMessage\"]/p[3]/textarea")).sendKeys("The order totals do not match, i would like to cancel my order.");
			
			driver.findElement(By.xpath("//*[@id=\"sendOrderMessage\"]/div/button")).click();
		
	
		}
	}
}
