package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverManagerTest {
// Set Path.
// Create chrome driver.
// Maximize the window.
// Open google home page https://www.google.com/
// Verify that you are Google in the title.
public static void main(String[] args) throws InterruptedException {

    // WebDriverManager classını kullanarak chromedriver binary'lerimizi indirdik.
    WebDriverManager.chromedriver().setup();
    // Driver obj.mizi oluşturduk.
    WebDriver driver = new ChromeDriver();

    // Windowsu max. ettik.
    driver.manage().window().maximize();

    Thread.sleep(3000);
    // Sitemizi açtık.
    driver.get("https://www.google.com/");

    // Titlemızı aldık.
    String title = driver.getTitle();

    // Titlemızı doğruladık.
    if (title.equals("Google")) {
        System.out.println("Test PASSED");
    }else System.out.println("Test FAILED");

    Thread.sleep(3000);
    driver.quit();

}
}
