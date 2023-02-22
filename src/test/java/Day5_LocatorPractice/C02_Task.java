package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class C02_Task {
// https://www.teknosa.com/ adresine gidiniz.
// Arama çubuğuna ''oppo'’ yazıp ENTER tıklayınız.
// Sonuç sayısını yazdırınız.
// Çıkan ilk ürüne tıklayınız.
// Sepete ekleyiniz.
// Sepetime gite tıklayınız.
// Konsolda "Sipariş Özeti" WebElement'inin text'ini yazdırınız.
// Alışverişi tamamlayınız.
// Son olarak "Teknosa'ya Hoş Geldiniz" WebElement'inin text'ini yazdırınız.
// Driver'ı kapatınız.
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
        driver.quit();
    }
    @Test
    public void teknosaTest() throws InterruptedException {
        driver.get("https://www.teknosa.com/");
        WebElement search = driver.findElement(By.id("search-input"));
        search.sendKeys("oppo"+ Keys.ENTER);

        WebElement result = driver.findElement(By.className("plp-info"));
        System.out.println("result= " +result.getText());

        driver.findElement(By.className("prd-link")).click();
        driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]")).click();
        // [1] -> xpath'lerin 0.indexi ya da 1. elemanı demek... Çoklu sonuçlarda kullanılır...

        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();
        WebElement ozet = driver.findElement(By.className("cart-sum-title"));
        System.out.println("Sipariş= " +ozet.getText());

        driver.findElement(By.xpath("//a[@title='Alışverişi Tamamla']")).click();
        Thread.sleep(3000);

        WebElement message = driver.findElement(By.className("lrp-title"));
        System.out.println("Mesaj= " +message.getText());
    }
}
