package Day6_Dropdown_SeleniumWaits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;
public class C09_HW_SGetMeth extends BaseTest {
    /*
    - https://demoqa.com/select-menu sitesine gidin
    - multiple <select> elementini locate edin
    - getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
      * Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin
        Deselect all the options.
        Select 'Opel' using the index and deselect the same using index.
        Select 'Saab' using value and deselect the same using value.
    Close the browser.
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void sGetMeth() {
        driver.get("https://demoqa.com/select-menu");
        Select select = new Select(driver.findElement(By.id("cars")));
        System.out.println(select.isMultiple());

        select.selectByValue("opel");
        select.selectByVisibleText("Saab");
        select.selectByIndex(3);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options){
            System.out.println(option.getText());
        }
        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for (WebElement option : selectedOptions){
            System.out.print(option.getText()+", ");
        }
        select.deselectAll();
        select.selectByIndex(2);
        select.deselectByIndex(2);
        select.selectByValue("saab");
        select.deselectByValue("saab");
    }
}
