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

import java.time.Duration;
import java.util.List;

public class C06_RadioButtons {

//    Go to URL:  https://www.facebook.com/
//    Click on Create an Account button.
//    Then click on the radio buttons.
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
        driver.quit();
    }
    @Test
    public void radioButtons(){
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        /*
        List<WebElement> radioButtons = driver.findElements(By.name("sex"));
        WebElement rdBtn1 = radioButtons.get(0);
        WebElement rdBtn2 = radioButtons.get(1);
        WebElement rdBtn3 = radioButtons.get(2);
        rdBtn1.click();
        rdBtn3.click();
        rdBtn2.click();
        */
        WebElement rdBtn1 = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
        rdBtn1.click();
        WebElement rdBtn3 = driver.findElement(By.xpath("//input[@type='radio' and @value='-1']"));
        rdBtn3.click();
        WebElement rdBtn2 = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
        rdBtn2.click();

        Assert.assertTrue(!rdBtn1.isSelected());
        Assert.assertTrue(!rdBtn3.isSelected());
        Assert.assertTrue(rdBtn2.isSelected());

    }
}
