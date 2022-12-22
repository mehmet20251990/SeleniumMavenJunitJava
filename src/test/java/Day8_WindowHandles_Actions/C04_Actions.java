package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C04_Actions extends BaseTest {

    @Test
    public void dragAndDropOffsetX(){
        driver.get("https://rangeslider.js.org/");

        WebElement slider = driver.findElement(By.xpath("(//div[@class='rangeslider__handle'])[1]"));
        Actions actions = new Actions(driver);

        // sola kaydırmak için (-) kullanılır, dikeyde hareket olmaması için y = 0 olmalıdır...
        actions.dragAndDropBy(slider,-300,0).perform();
    }
    @Test
    public void dragAndDropOffsetY(){

    }
}
