package Day8_WindowHandles_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C02_Actions extends BaseTest {

    @Test
    public void doubleClick(){
        driver.get("https://demoqa.com/buttons");
        WebElement dClickButton = driver.findElement(By.id("doubleClickBtn"));

        Actions actions = new Actions(driver);
        actions.doubleClick(dClickButton).perform();

        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());
    }
    @Test
    public void rightClick(){
        driver.get("https://demoqa.com/buttons");
        WebElement rClickButton = driver.findElement(By.id("rightClickBtn"));

        Actions actions = new Actions(driver);
        actions.contextClick(rClickButton).perform();

        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed());
    }
    @Test
    public void click(){
        driver.get("https://demoqa.com/buttons");
        WebElement dClickButton = driver.findElement(By.xpath("//button[.='Click Me']"));
        dClickButton.click();
/*
        Actions actions = new Actions(driver);
        actions.click(dClickButton).build().perform(); // Build() siz de tek komut olduğu için çalışır
*/
        Assert.assertTrue(driver.findElement(By.id("dynamicClickMessage")).isDisplayed());
    }
}
