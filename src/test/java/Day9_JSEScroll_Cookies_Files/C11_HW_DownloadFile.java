package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import utilities.BaseTest;

public class C11_HW_DownloadFile extends BaseTest {
    // Go to https://the-internet.herokuapp.com/download
    //  Download sample.png file
    //  Then verify if the file downloaded successfully
    @Override
    public void tearDown() {
    }

    @Test
    public void downloadFileTest() {
        driver.get("https://the-internet.herokuapp.com/download");

    }
}
