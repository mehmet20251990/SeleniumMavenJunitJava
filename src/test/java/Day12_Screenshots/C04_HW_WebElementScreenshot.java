package Day12_Screenshots;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public void wEScshot() throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date());
        String path = "test-output\\Screenshots\\oHRMPageScreenshot_" + date + ".png";

        // Aldigimiz screenshotı istedigimiz pathe kaydediyoruz
        FileHandler.copy(source, new File(path));
    }
}
