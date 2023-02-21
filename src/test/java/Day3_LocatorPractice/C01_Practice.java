package Day3_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class C01_Practice {
//    Go to https://www.linkedin.com/
//    When we write an e-mail without the @ sign in the e-mail box and press enter.
//    Let's test the "Invalid email address" warning.
    WebDriver driver;
    @Before
    public void setup(){
        //Driver olusturuldu
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Sayfanın yüklenmesi beklendi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // driver imiz maximize edildi
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        // driver imiz kapatildi
        driver.quit();
    }
    @Test
    public void xpathPractice(){
        // LinkedIn sitesine gidildi
        driver.get("https://www.linkedin.com/");
        // @ sembolü olmayan email girildi
        driver.findElement(By.xpath("//input[@id='session_key']"))
                            .sendKeys("ms1234.com"+ Keys.ENTER);
        // Hata mesajının görüntülendiği doğruladık
        WebElement alertMessage= driver.findElement(By.xpath("//p[@class='alert-content']"));
        Assert.assertTrue(alertMessage.isDisplayed());
        // Assert.assertEquals(true,alertMessage.isDisplayed());
        // Assert.assertFalse(!alertMessage.isDisplayed());
    }
}
