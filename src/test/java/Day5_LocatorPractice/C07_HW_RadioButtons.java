package Day5_LocatorPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;
public class C07_HW_RadioButtons extends BaseTest {
    //Go to URL: https://demoqa.com/radio-button
    //Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
    //Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.
    @Override
    public void tearDown() {
    }
    @Test
    public void cBox() throws InterruptedException {
        driver.get("https://demoqa.com/radio-button");
        WebElement yes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        WebElement impr = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        WebElement no = driver.findElement(By.xpath("//label[@for='noRadio']"));

        if (!yes.isSelected()){
            yes.click();
        }
        System.out.println(driver.findElement(By.className("mt-3")).getText());
        Thread.sleep(2000);
        if (!impr.isSelected()){
            impr.click();
        }
        System.out.println(driver.findElement(By.className("mt-3")).getText());
        Thread.sleep(2000);
        if (!no.isSelected()){
            no.click();
        }
        System.out.println(driver.findElement(By.className("mt-3")).getText());
        Thread.sleep(2000);
        Assert.assertTrue("Seçili değil", driver.findElement(By.id("impressiveRadio")).isSelected());
    }
}
