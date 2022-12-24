package Day6_Dropdown_SeleniumWaits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class C07_HomeWork2 extends BaseTest {

    //- https://demoqa.com/select-menu sitesine gidin
    //- multiple <select> elementini locate edin
    //* Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin

    @Override
    public void tearDown() {

    }
    @Test
    public void multiSelectTest() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

        WebElement mS = driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[3]"));

        Actions act = new Actions(driver);

        act.click(mS).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        act.click(mS).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        act.click(mS).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        System.out.println(mS.getText());
    }
}
