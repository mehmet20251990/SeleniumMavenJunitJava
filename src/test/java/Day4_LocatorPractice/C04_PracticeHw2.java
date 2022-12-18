package Day4_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_PracticeHw2 {
// Navigate to https://testpages.herokuapp.com/styled/index.html
// Click on Calculate under Micro Apps.
// Type any number in the first input.
// Type any number in the second input.
// Click on Calculate.
// Get the result.
// Print the result.

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @Test
    public void test() throws InterruptedException {
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        Thread.sleep(3000);
        driver.findElement(By.id("calculatetest")).click();
        Thread.sleep(3000);

        WebElement numb1 = driver.findElement(By.id("number1"));
        numb1.sendKeys("12");
        Thread.sleep(3000);

        WebElement numb2 = driver.findElement(By.id("number2"));
        numb2.sendKeys("9");
        Thread.sleep(3000);

        driver.findElement(By.id("calculate")).click();
        Thread.sleep(3000);

        WebElement result = driver.findElement(By.id("answer"));
        System.out.println("result= "+result.getText());
    }
    @After
    public void tearDown() throws InterruptedException {
       driver.quit();
    }
}
