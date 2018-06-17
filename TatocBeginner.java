package tatoc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TatocBeginner {
	public static void main (String args[]){
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://10.0.1.86/tatoc");
		
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.className("greenbox")).click();
		
	}
}
