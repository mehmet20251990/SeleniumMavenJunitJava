package Day8_WindowHandles_Actions;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class C01_WindowHandleSe4 extends BaseTest {
    /*
    Go to URL: https://testproject.io/
    Selenium’s 4 newWindow() method to open a new Window for TestProject’s Blog page.
    https://blog.testproject.io/
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void newWindow(){
        driver.get("https://testproject.io/");

        //driver.switchTo().newWindow(WindowType.WINDOW);
        //driver.get("https://blog.testproject.io/");
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://blog.testproject.io/");
    }
    @Test
    public void newTab(){
        driver.get("https://testproject.io/");

        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        newTab.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());

        // driver.switchTo().newWindow(WindowType.TAB);
        // driver.get("https://www.amazon.com/");
        // driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com/");
    }
    @Test
    public void handleWindows(){
        driver.get("https://www.amazon.com/");

        String homePageHandle= driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com.tr/");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com/");

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> i = handles.iterator();

         while (i.hasNext()) {
             String currentTab= i.next();
             driver.switchTo().window(currentTab);

             System.out.println(driver.getTitle());

             if (driver.getWindowHandle().equals(homePageHandle)){
                 driver.close();
             }
             /*
             if (!driver.getTitle().contains("Spend")){
                 driver.close();
             } */
         }
    }
}
