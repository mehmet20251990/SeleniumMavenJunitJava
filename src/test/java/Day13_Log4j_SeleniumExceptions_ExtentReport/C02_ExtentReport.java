package Day13_Log4j_SeleniumExceptions_ExtentReport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTestReport;
public class C02_ExtentReport extends BaseTestReport {
    @Test
    public void test(){
        // Testi yapacak olan her turlu mesaji gecip kaldigini belirtecek extentTest objemizi olusturuyoruz
        extentTest = extentReports.createTest("My Test", "Bu bir aciklamadir");

        //info mesaji yazdiriliyor
        extentTest.info("Amazon a gidiliyor");
        driver.get("https://www.amazon.com.tr/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Arama kismina log4j yaziliyor");
        searchBox.sendKeys("log4j");

        //Pass mesaji
        extentTest.pass("Testimiz gecerli");

        //Fail mesaji
        extentTest.fail("Testimiz gecersiz");

        //Skip mesaji
        extentTest.skip("Testimiz skip edildi");
    }
}







