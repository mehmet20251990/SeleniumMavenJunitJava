package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import utilities.BaseTest;

public class C12_HW_UploadFile extends BaseTest {
    /*
    Go to URL: https://www.monsterindia.com/seeker/registration
    Upload file.
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void uploadFileTest() {
        driver.get("https://www.monsterindia.com/seeker/registration");

    }
}
