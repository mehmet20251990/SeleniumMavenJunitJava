package Day6_Dropdown_SeleniumWaits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class C07_HomeWork2 extends BaseTest {

    //- https://demoqa.com/select-menu sitesine gidin
    //- multiple <select> elementini locate edin
    //- getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
    //* Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin

    @Override
    public void tearDown() {

    }

    @Test
    public void multiSelectTest(){
        driver.get("https://demoqa.com/select-menu");

        WebElement mS = driver.findElement(By.xpath("(//div[.='Select...'])[4]"));

        Select select = new Select(mS);
        ////////////////////////////////////


    }
}
