package assignmentOneTOTAC;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Totac {
	public static void main (String args[]){
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		//GRID GATE
		driver.findElement(By.className("greenbox")).click();
		
		//FRAME DUNGEON
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
		
		// DRAG AND DROP
		driver.switchTo().defaultContent();
		WebElement from = driver.findElement(By.id("dragbox"));
		WebElement to = driver.findElement(By.id("dropbox"));
      		Actions act=new Actions(driver);							
        	act.dragAndDrop(from, to).build().perform();
        	driver.findElement(By.linkText("Proceed")).click();
		
		//Popup Windows
		
	}
}
