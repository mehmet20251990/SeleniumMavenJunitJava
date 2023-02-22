package Day8_WindowHandles_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;
public class C05_Actions extends BaseTest {
    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement accountAndLists = driver.findElement(By.id("nav-link-accountList"));

        Actions actions = new Actions(driver);
        //actions.moveToElement(accountAndLists).click(driver.findElement(By.id("nav_prefetch_yourorders"))).perform();
        //movetoelement den sonra alt kısım hemen açılmazsa komutu ikiye ayırıp araya wait koymak gerekir.
        actions.moveToElement(accountAndLists).perform();
        Thread.sleep(3000);
        actions.click(driver.findElement(By.id("nav_prefetch_yourorders"))).perform();
        Assert.assertEquals("Amazon Sign-In", driver.getTitle());
    }
}
