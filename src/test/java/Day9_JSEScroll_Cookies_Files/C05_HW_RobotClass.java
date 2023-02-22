package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;
public class C05_HW_RobotClass extends BaseTest {
    /*
    https://api.jquery.com/ sitesine gidelim
    arama alanina json yazalim
    Enter islemini robot class kullanrak yapalim
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void robotClassTest() throws AWTException {
        driver.get("https://api.jquery.com/");
        WebElement input = driver.findElement(By.className("ds-input"));
        input.click();
        input.sendKeys("json");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Assert.assertEquals("jQuery.parseJSON()", driver.findElement(By.xpath("//h1[@class='entry-title']")).getText());
    }
}
