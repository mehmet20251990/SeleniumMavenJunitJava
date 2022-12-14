package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_JunitAssertions {
//    Go to Amazon homepage.
//    Do the following tasks by creating 3 different test methods.
//    1- Test if the URL contains Amazon.
//    2- Test if the title does not contain Facebook.
//    3- Test that the Amazon logo appears in the upper left corner.
    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @After
    public void after(){
        driver.quit();
    }
    @Test
    public void assertionURLTest(){
        driver.get("https://www.amazon.com");
        String url = driver.getCurrentUrl();

        // Mesaj, TEST FAILED olursa çalışır...
        Assert.assertTrue("URL Amazon içermiyor", url.contains("Amazon"));
    }
    @Test
    public void assertionTitleTest(){
        driver.get("https://www.amazon.com");
        String title = driver.getTitle();

        // Mesaj, TEST FAILED olursa çalışır...
        Assert.assertFalse("Title Facebook içermiyor", title.contains("Facebook"));
    }

}
