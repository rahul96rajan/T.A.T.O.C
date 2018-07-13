package assignmentOneTOTAC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TatocOnChromeAdv {
	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://10.0.1.86/tatoc");
		 driver.findElement(By.xpath("//a[text()='Advanced Course']")).click();
		 
		 //hover/menu
		 WebElement Menu2 = driver.findElement(By.cssSelector("div[class='menutop m2']"));
		 Actions act = new Actions(driver);
		 act.moveToElement(Menu2).build().perform();
		 driver.findElement(By.cssSelector("span[onclick='gonext();']")).click();
		 
		 //query/gate
		 

	}

}
