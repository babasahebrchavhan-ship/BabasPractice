package Base.Class;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




public class XpathPractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Java\\Program\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://www.amazon.in/");
	    //WebElement elements=driver.findElement(By.id("searchDropdownDescription"));
	    
	    Select select=new Select(driver.findElement(By.id("searchDropdownDescription")));
	    
	    List<WebElement> lists=select.getOptions();
	    
	    for(WebElement ele:lists)
	    {
	    	System.out.println(ele.getText());
	   	}
	    
	    
	    //driver.quit();

	}

}
