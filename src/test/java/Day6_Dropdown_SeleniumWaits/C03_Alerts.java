package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Alerts {
    /*
driver.switchTo().alert().accept();     //ok demek
driver.switchTo().alert().dismiss();    //cancel demek
driver.switchTo().alert().getText();    //metni getirir
driver.switchTo().alert().sendKeys(""); //metin kutusu doldurulur
     */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void alerts() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        WebElement idInput = driver.findElement(By.name("cusid"));
        idInput.sendKeys("1234");

        driver.findElement(By.name("submit")).click();

        driver.switchTo().alert().accept(); // 1. alert
        driver.switchTo().alert().accept(); // 2. alert

        // Sayfa yenilendikten sonra tekrar girdi yapabilmek için yeniden locate işlemi yapmak gerekir...
        Thread.sleep(3000);
        WebElement idInput1 = driver.findElement(By.name("cusid"));
        idInput1.sendKeys("123");

        driver.findElement(By.name("submit")).click();

        driver.switchTo().alert().dismiss(); // 1. alert
    }
}
