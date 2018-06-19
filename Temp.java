package assignmentOneTOTAC;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.Iterator;
import java.util.Set;

public class Totac {
	public static void main (String args[]){
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		//
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
		
		driver.switchTo().defaultContent();
		WebElement from = driver.findElement(By.id("dragbox"));
		WebElement to = driver.findElement(By.id("dropbox"));
      	Actions act = new Actions(driver);							
        act.dragAndDrop(from, to).build().perform();
        driver.findElement(By.linkText("Proceed")).click();
        
        //Pop-Up Windows
        driver.findElement(By.linkText("Launch Popup Window")).click();
        String MainWindow=driver.getWindowHandle();
        String subWindow = null;
        Set<String> windows = driver.getWindowHandles();
        
	
        
        
        //COOKIE 
		
       // driver.get("http://10.0.1.86/tatoc/basic/cookie");
        driver.findElement(By.linkText("Generate Token")).click();
        String TokenTmp = driver.findElement(By.id("token")).getText();
        String Token = TokenTmp.substring(7, TokenTmp.length());
        Cookie cookie =new Cookie("Token",Token);
        driver.manage().addCookie(cookie);
        driver.findElement(By.linkText("Proceed")).click();
        
	
	}
}
