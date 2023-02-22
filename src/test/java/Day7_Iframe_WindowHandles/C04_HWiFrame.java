package Day7_Iframe_WindowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;
import java.util.Set;
public class C04_HWiFrame extends BaseTest {
    /*
    Go to URL: http://demo.guru99.com/test/guru99home/
    Find the number of iframes on the page.
    Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
    Exit the iframe and return to the main page.
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void iFrameTest() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("iframes.size() = " + iframes.size());
        String homePageId = driver.getWindowHandle();

        driver.switchTo().frame("a077aa5e");
        WebElement iframe = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
        iframe.click();

        Set<String> links = driver.getWindowHandles();
        for (String link : links) {
            driver.switchTo().window(link);
            if(driver.getWindowHandle().equals(homePageId)){
                continue;
            }
            driver.close();
        }
    //    driver.switchTo().defaultContent();
    }
}
