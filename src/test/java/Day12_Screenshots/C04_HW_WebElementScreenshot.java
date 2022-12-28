package Day12_Screenshots;

import org.junit.Test;
import utilities.BaseTest;

public class C04_HW_WebElementScreenshot extends BaseTest {
    /*
    Go to URL: https://opensource-demo.orangehrmlive.com/
Getting screenshot of  Orange HRM Page Section.
Save the screenshot with format 'screenshotname_yyyy-MM-dd_hh-mm-ss.png'
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void wEScshot() {
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }
}
