package Day2_WebElementLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locators {
    WebDriver driver;
    @Before
    public void setup(){
        //Driver olusturuldu
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Sayfanın yüklenmesi beklendi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //LinkedIn sitesine gidildi
        driver.get("https://www.linkedin.com/");
        // driver imiz maximize edildi
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
        // driver imiz kapatildi
        //driver.quit();
    }
    @Test
    public void idLocator(){
        // id Locator -> "session_key"
        WebElement email = driver.findElement(By.id("session_key"));
        email.sendKeys("Clarusway selenium dersinden selamlar");
    }
    @Test
    public void nameLocator(){
        // name locator -> "session_password"
        WebElement password = driver.findElement(By.name("session_password"));
        password.sendKeys("Sifre");
    }
    @Test
    public void classLocator(){
        // class locator -> "input__input"
        WebElement email = driver.findElement(By.className("input__input"));
        email.sendKeys("Class locater test");
    }
    @Test
    public void tagLocator(){
        // tag locator -> "input"
     //   WebElement email = driver.findElement(By.tagName("input")); // parent classı hidden olduğu için bulamadı.
                                                                        // FAILED
        List<WebElement> emailList = driver.findElements(By.tagName("input"));

        // Hidden olduğu için get'le 2. elementimizi aldık, 2. elementimiz email text alanımız.
        WebElement email = emailList.get(1);    //Bu yüzden bu elemanı email değişkenine assign ettik

        email.sendKeys("Tag locater test");
    }
    @Test
    public void linkTextLocator(){
        // link text -> "Şifrenizi mi unuttunuz?"
        WebElement forgotPwd = driver.findElement(By.linkText("Şifrenizi mi unuttunuz?"));
        forgotPwd.click();
    }
    @Test
    public void partialLinkTextLocator(){
        // link text -> "Şifrenizi"
        WebElement forgotPwd = driver.findElement(By.partialLinkText("Şifrenizi"));
        forgotPwd.click();
    }
    @Test
    public void absoluteXpath(){
        WebElement email = driver.findElement // AbasoluteXpath tavsiye edilmez, relativeXpath tavsiye edilir.
                          (By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"));
        email.sendKeys("AbasoluteXpath konusu başarı ile tamamlandı...");
    }
    @Test
    public void relativeXpath(){
        WebElement email = driver.findElement // AbasoluteXpath tavsiye edilmez, relativeXpath tavsiye edilir.
                (By.xpath("//input[@name=\"session_key\"]"));
        email.sendKeys("RelataiveXpath konusu başarı ile tamamlandı...");
    }

}
