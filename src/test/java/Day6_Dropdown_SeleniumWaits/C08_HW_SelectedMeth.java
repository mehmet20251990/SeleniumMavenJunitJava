package Day6_Dropdown_SeleniumWaits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;
public class C08_HW_SelectedMeth extends BaseTest {
   /*
    - https://demoqa.com/select-menu sitesine gidin
    - <select> elementini locate edin
    - <select> elementinin seceneklerini yazdirin
    - Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
    * Yellow (index)
    * Purple (value)
    * Black  (text)
    seceneklerini secin
    */
    @Override
    public void tearDown() {
    }
    @Test
    public void sMeth() {
        driver.get("https://demoqa.com/select-menu");
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
        System.out.println(select.isMultiple());

        select.selectByIndex(3);
        select.selectByValue("4");
        select.selectByVisibleText("Black");

        List<WebElement> color =select.getOptions();
        for (WebElement colour: color) {
            System.out.println(colour.getText());
        }
    }
}
