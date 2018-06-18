package assignmentOneTOTAC;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Totac {
	public static void main (String args[]){
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.className("greenbox")).click();
		
		boolean found=false;
		driver.switchTo().frame("main");
		while(found==false){	
			String box1Class = driver.findElement(By.id("answer")).getAttribute("className");
			
			driver.switchTo().frame("child");
			
			String box2Class = driver.findElement(By.id("answer")).getAttribute("className");
			
			if (box1Class.equalsIgnoreCase(box2Class)) {
				driver.switchTo().parentFrame();
				driver.findElement(By.linkText("Proceed")).click();
				found=true;
				break;
			} 
			
			else {
				driver.switchTo().parentFrame();
				driver.findElement(By.linkText("Repaint Box 2")).click();
			}
		}
	}
}
