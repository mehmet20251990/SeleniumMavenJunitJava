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
import java.util.List;

public class C02_CSSPractice {
// http://the-internet.herokuapp.com/add_remove_elements/
// Click on the "Add Element" button 100 times.
// Write a function that takes a number, and clicks the "Delete" button.
// Given number of times, and then validates that given number of buttons was deleted.
// 1. Method: createButtons(100)
// 2. Method: DeleteButtonsAndValidate()
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
    public void cssSelectorTest(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createElements(100);
        deleteButtonsAndValidate(50);

    }
    public void deleteButtonsAndValidate(int amount){
        List<WebElement> removeButtonList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int beforeDeleteAmount = removeButtonList.size();

        for (int i = 0; i < amount; i++) {
            removeButtonList.get(i).click();
        }
        List<WebElement> removeButtonListAfter = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int deleteAmountAfter = removeButtonListAfter.size();

        Assert.assertEquals(beforeDeleteAmount-amount,deleteAmountAfter);
    }
    public void createElements(int amount){
        WebElement addElementButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < amount; i++) {
            addElementButton.click();
        }
    }
}
