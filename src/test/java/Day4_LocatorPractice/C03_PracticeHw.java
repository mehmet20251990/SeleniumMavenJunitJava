package Day4_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_PracticeHw {
//https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        driver.get("https://id.heroku.com/login");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("qwer@er.com");

        WebElement pswd = driver.findElement(By.id("password"));
        pswd.sendKeys("1234");

        driver.findElement(By.name("commit")).click();

        WebElement alert = driver.findElement(By.xpath("//div[@role='alert']"));
        System.out.println(alert.isDisplayed() ? "Kayıt Yapılamadı" : "Kayıt Yapıldı");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
