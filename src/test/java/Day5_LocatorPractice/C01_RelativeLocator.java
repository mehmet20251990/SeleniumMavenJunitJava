package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocator {
// Go to http://www.bestbuy.com
// Verify that the page title contains "Best" Also, using Relative Locator.
// LogoTest  Verify if the BestBuy logo is displayed.
// mexicoLinkTest  Verify if the link is displayed.
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver imiz kapatildi
        driver.quit();
    }
    @Test
    public void RelativeLocator(){
        driver.get("http://www.bestbuy.com");
        Assert.assertTrue("TİTLE Best kelimesini içermiyor",driver.getTitle().contains("Best"));

        By logoLocator = RelativeLocator.with(By.tagName("img")).above(By.xpath("//div[.='Hello!']"));
        WebElement logo = driver.findElement(logoLocator);
        Assert.assertTrue("Logo görünmüyor",logo.isDisplayed());

        By logoFlagLocator = RelativeLocator.with(By.tagName("img"))
         .toRightOf(By.xpath("//img[@alt='United States']"));//çoklu xpath-> //div[lang='en']//a[@class='us-link']
                                                                          // Parent-child olarakta xpath yazılabilir...
        WebElement logoFlag = driver.findElement(logoFlagLocator);
        Assert.assertTrue("Logo görünmüyor",logoFlag.isDisplayed());
    }

}
