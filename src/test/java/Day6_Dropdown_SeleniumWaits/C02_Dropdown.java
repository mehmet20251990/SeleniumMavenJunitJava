package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_Dropdown {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
      //  driver.quit();
    }
    @Test
    public void selectByIndex(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement drpDown =driver.findElement(By.name("country"));

        // Locate edilen dropdown select objesine oluşturuldu
        Select select = new Select(drpDown);

        // selectByIndex() methodu "0" ile başlar
        select.selectByIndex(1);
    }
    @Test
    public void selectByValue() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");

    }
}
