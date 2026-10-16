package Base.Pages;

import Base.Class.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

@Test
public class AmazonAddCart extends BaseTest {

    public void amazonAddCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Dairy milk");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
       // driver.findElement(By.xpath("//h2[@aria-label='Sponsored Ad - Cadbury Dairy Milk Silk Fruit and Nut Chocolate Bar, 129 Grams']/span")).click();
        driver.findElement(By.linkText("Cadbury Dairy Milk Silk Fruit and Nut Chocolate Bar, 129 Grams")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        Iterator iterator = windowHandles.iterator();
        String parent = (String) iterator.next();
        String child = (String) iterator.next();
        driver.switchTo().window(child);
        System.out.println(parent);
        System.out.println(child);
        driver.switchTo().window(child);
        //WebElement innerBox =driver.findElement(By.className("a-box-inner"));

        //System.out.println(innerBox.getText());
       /* for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());

        }*/
         //WebElement dropdown =driver.findElement(By.xpath("//select[@name='quantity']"));
        //WebElement qtyButtonLocator = driver.findElement(By.xpath("(//span[@id='a-autoid-0-announce'])[1]"));
/*
        WebElement qtyButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(qtyButtonLocator));
        qtyButton.click(); */
        //WebElement innerBox = driver.findElement(By.id("innerBoxId"));
        //WebElement dropdown = driver.findElement(By.id("dropdownId"));
        WebElement innerBox =driver.findElement(By.className("a-box-inner"));
        WebElement dropdown =driver.findElement(By.xpath("//select[@name='quantity' and not(contains(@class,'aok-hidden'))]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollTop = arguments[1].offsetTop;",
                innerBox,
                dropdown
        );

//        dropdown.click();

        Select select=new Select(dropdown);
        select.selectByValue("5");


        //driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    }
}
