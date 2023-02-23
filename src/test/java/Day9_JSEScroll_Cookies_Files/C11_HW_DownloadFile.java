package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;
public class C11_HW_DownloadFile extends BaseTest {
    // Go to https://the-internet.herokuapp.com/download
    //  Download sample.png file
    //  Then verify if the file downloaded successfully
    @Override
    public void tearDown() {
    }
    @Test
    public void downloadFileTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("sample.png")).click();

        String dwnPath = "C:\\Users\\samet\\Downloads\\sample.png";
        Thread.sleep(3000);
        Assert.assertTrue("indirilen dosya bulunamadı", Files.exists(Paths.get(dwnPath)));
    }
}
