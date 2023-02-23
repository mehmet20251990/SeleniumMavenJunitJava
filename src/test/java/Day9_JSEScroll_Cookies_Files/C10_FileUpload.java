package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;
public class C10_FileUpload extends BaseTest {
    /*
    Go to URL: https://the-internet.herokuapp.com/upload
    Find the path of the file that you want to upload.
    Click on Upload button.
    Verify the upload message.
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void fileUpload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        //Upload edilecek dosyamizi seciyoruz
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys("C:\\Users\\samet\\Desktop\\fileExist.png");

        // Upload butonuna basiyoruz
        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        uploadFile.click();

        // Upload edilme mesajinin goruntulendigini dogruluyoruz
        WebElement uploadedMessage = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(uploadedMessage.isDisplayed());
        Assert.assertEquals("File Uploaded!" ,uploadedMessage.getText());
        /*
        //Upload edilme mesajinin goruntulenemeiği, No such elements hatasına karşı bu şekilde de yazılabilir...(TRİCK)
        List<WebElement> uploadedMessageList = driver.findElements(By.tagName("h3"));

        Assert.assertEquals("Upload mesajı görüntülenemedi", 1, uploadedMessageList.size());
        WebElement uploadedMessage = uploadedMessageList.get(0);

        Assert.assertTrue(uploadedMessage.isDisplayed());
        Assert.assertEquals("Mesaj Texti istenildiği gibi görüntülenemiyor","File Uploaded!" ,uploadedMessage.getText());
         */
    }
}
