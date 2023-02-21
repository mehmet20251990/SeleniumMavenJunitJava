package Day4_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class C01_Practice {
//Navigate to website  https://testpages.herokuapp.com/styled/index.html
// Under the ORIGINAL CONTENTS
// Click on Alerts
// Print the URL
// Navigate back
// Print the URL
// Click on Basic Ajax
// Print the URL
// Enter value  20 and Enter
// And then verify Submitted Values is displayed open page
// Close driver.
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
    public void test() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        Thread.sleep(3000);

        WebElement alertsLink = driver.findElement(By.xpath("//a[@id='alerts']"));
        alertsLink.click();
        Thread.sleep(3000);

        String alertsUrl = driver.getCurrentUrl();
        System.out.println(alertsUrl);

        driver.navigate().back();
        Thread.sleep(3000);

        String homeUrl = driver.getCurrentUrl();
        System.out.println(homeUrl);

        WebElement basicAjaxLink = driver.findElement(By.id("basicajax"));
        basicAjaxLink.click();
        Thread.sleep(3000);

        String basicAjaxUrl = driver.getCurrentUrl();
        System.out.println(basicAjaxUrl);
        driver.findElement(By.id("lteq30")).sendKeys("20"+ Keys.ENTER);

        WebElement submittedValuesText = driver.findElement(By.xpath("//p[.='Submitted Values']")); //text()
        Assert.assertTrue(submittedValuesText.isDisplayed());
    }
}
