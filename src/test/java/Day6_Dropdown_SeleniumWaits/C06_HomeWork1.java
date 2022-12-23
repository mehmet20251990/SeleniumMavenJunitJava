package Day6_Dropdown_SeleniumWaits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class C06_HomeWork1 extends BaseTest {
    // - https://demoqa.com/select-menu sitesine gidin
    // - Multiple select yapabileceginiz <select> elementini locate edin
    // - Birden fazla secim yapip secimlerinizi DOGRULAyin

    @Test
    public void multiSelectTest(){
        driver.get("https://demoqa.com/select-menu");

        Select select = new Select(driver.findElement(By.id("cars")));
        System.out.println(select.isMultiple());

        select.selectByValue("opel");
        select.selectByVisibleText("Saab");
        select.selectByIndex(3);

    }
}
