package Day6_Dropdown_SeleniumWaits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseTest;

public class C10_HW_DDTask extends BaseTest {
    /*
    Go to URL: http://demo.automationtesting.in/Alerts.html
    Click "Alert with OK" and click 'click the button to display an alert box:’
    Accept Alert(I am an alert box!) and print alert on console.
    Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
    Cancel Alert  (Press a Button !)
    Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
    And then sendKeys «BootcampCamp» (Please enter your name)
    Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("http://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Thread.sleep(2000);

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Alert with OK & Cancel")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        driver.findElement(By.id("demo")).getText();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Alert with Textbox")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("SDET");
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("demo1")).getText());

        Assert.assertEquals("Hello SDET user How are you today",driver.findElement(By.id("demo1")).getText());
    }
}
