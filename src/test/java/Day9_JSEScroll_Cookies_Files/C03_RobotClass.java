package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;
public class C03_RobotClass extends BaseTest {
    @Override
    public void tearDown() {
    }
    @Test
    public void test() throws AWTException, InterruptedException {
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement input = driver.findElement(By.id("uploadfile_0"));
        input.sendKeys("C:\\Users\\samet\\IdeaProjects\\CWJunitSelenium\\src\\test\\java\\resources\\robot.txt");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(2000);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
/*
        Eğer enter işe yaramazsa üstüne kaydetmek için;
        robot.keyPress(KeyEvent.VK_LEFT);//sol ok
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
*/
    }
}
