package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;
public class C12_HW_UploadFile extends BaseTest {
    /*
    Go to URL: https://www.monsterindia.com/seeker/registration
    Upload file.
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void uploadFileTest() throws InterruptedException {
        driver.get("https://www.monsterindia.com/seeker/registration");
        String path = "C:\\Users\\samet\\Desktop\\Mevlana.rtf";

        // İnput elementini almaya dikkat etmeliyiz...
        WebElement uploadButton = driver.findElement(By.id("file-upload"));
        uploadButton.sendKeys(path);

        WebElement registraionDetails = driver.findElement(By.id("registrationDetails"));
        Assert.assertEquals("Mevlana.rtf" , registraionDetails.getText());
    }
}
