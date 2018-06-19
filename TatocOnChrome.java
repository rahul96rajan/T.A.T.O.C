package tatoc;



	import java.util.Iterator;
	import java.util.Set;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver; 			
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.Cookie;

	public class TatocOnChrome {

		public static void main (String args[])
		{
			WebDriver driver = new ChromeDriver();
			driver.get("http://10.0.1.86/tatoc");
			driver.findElement(By.linkText("Basic Course")).click();
			//GREEN BOX
			driver.findElement(By.className("greenbox")).click();
			//FRAME DUNGEON
			driver.switchTo().frame("main");
			String box1color = driver.findElement(By.id("answer")).getAttribute("className"), box2color;
			while (true)
			{
				driver.switchTo().frame("child");
				box2color = driver.findElement(By.id("answer")).getAttribute("className");
				if (box1color.equalsIgnoreCase(box2color)) 
				{
					driver.switchTo().parentFrame();
					driver.findElement(By.linkText("Proceed")).click();
					break;
				}
				driver.switchTo().parentFrame();
				driver.findElement(By.linkText("Repaint Box 2")).click();
			}
			//DRAG AND DROP
			Actions act = new Actions(driver);	
			WebElement from = driver.findElement(By.id("dragbox"));
			WebElement to = driver.findElement(By.id("dropbox"));
			act.dragAndDrop(from, to).build().perform();
			driver.findElement(By.linkText("Proceed")).click();
			//POPUP WINDOW
			driver.findElement(By.linkText("Launch Popup Window")).click();
			String MainWindow = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			while(it.hasNext())
			{
				
				String ChildWindow = it.next();	
				driver.switchTo().window(ChildWindow);	
				if(!MainWindow.equalsIgnoreCase(ChildWindow))	
				{                                                                                                  
		           		driver.findElement(By.id("name")).sendKeys("RAHUL RAJAN");
		            		driver.findElement(By.id("submit")).click();
		            		break;
				}
			}
			driver.switchTo().window(MainWindow);
			driver.findElement(By.linkText("Proceed")).click();
			//COOKIE
			driver.findElement(By.linkText("Generate Token")).click();
			String Cookie_val = driver.findElement(By.id("token")).getText();
			Cookie cookie = new Cookie("Token", Cookie_val.substring(7));
			driver.manage().addCookie(cookie);
			driver.findElement(By.linkText("Proceed")).click();
		}
	}

