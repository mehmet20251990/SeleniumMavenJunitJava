package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;
public class C09_FileDownload extends BaseTest {
    /*
    Go to URL: https://opensource-demo.orangehrmlive.com/
    Login page valid credentials.
    Download sample CSV file.
    Verify if the file downloaded successfully.
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void fileDownload() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123" + Keys.ENTER);

        WebElement pımButton=driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper'][2]"));
        pımButton.click();

        driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
        driver.findElement(By.linkText("Data Import")).click();

        driver.findElement(By.className("download-link")).click();
        Thread.sleep(5000);// Ne olur ne olmaz dosyanin inmesi icin bekliyoruz

        // Indirilen dosyamizin path'i
        String downloadPath = "C:\\Users\\samet\\Downloads\\importData.csv";

        Assert.assertTrue("indirilen dosya bulunamadı", Files.exists(Paths.get(downloadPath)));
        /*
        File indiMi = new File("\\C:\\Users\\samet\\Downloads\\importData.csv");
        Assert.assertTrue(indiMi.exists());
         */
    }
}
