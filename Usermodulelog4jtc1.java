package reports;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ItestListeners.class )
public class Usermodulelog4jtc1 {
	private static Logger log=Logger.getLogger(Sellerlog4jtc1.class);
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest 
	public void open(){
		DOMConfigurator.configure("log4j.xml");
		pr=new ProfilesIni();
		fp=pr.getProfile("shylaja");
		driver=new FirefoxDriver(fp);
		log.info("succ profile created");
		driver.get("http://webwaves.in/ecommerce/index");
		log.info("succ page navigated");
		}
	@Test
	public void data() throws IOException, InterruptedException {
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
List<WebElement>links=driver.findElements(By.tagName("a"));
 int count=0;
 for(int i=0;i<links.size();i++){
	if(links.get(i).isDisplayed()){
		count++;
		System.out.println(count);
		
	
	
        	   
         String lname=links.get(i).getText();
	        
		   
		   links.get(i).click();
		  Thread.sleep(5000);
			
				
			
		    String url=driver.getCurrentUrl();
		  
		    
		   String title=driver.getTitle();
		   
	      
		    
		   log.info("succ no.of links count");
		   
		   
		   System.out.println("no.of links"+" "+links.size());
	       
	       System.out.println(lname+" "+url+" "+title);
	       log.info("succ links name captured");
	       log.info("succ url captured");
	      
	       driver.navigate().back();
		    
		   links=driver.findElements(By.tagName("a"));
		   
			
			
           }
	
		}
 System.out.println(links.size());
 System.out.println(links.size()-count);
		

	}}
