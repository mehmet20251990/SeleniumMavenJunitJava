package Day7_Iframe_WindowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C05_HW_WindHand extends BaseTest {
    /*
    Go to URL: https://demoqa.com/browser-windows
    Click on the windows - "WindowButton"
    Click on all the child windows.
    Print the text present on all the child windows in the console.
    Print the heading of the parent window in the console.
     */
    @Override
    public void tearDown() {
    }

    @Test
    public void wHandleTest() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");

        String homePageId = driver.getWindowHandle();
        System.out.println("homePageId = " + homePageId);

        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("windowButton")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("messageWindowButton")).click();

        Set<String> links = driver.getWindowHandles();
        /*
        for (String link:links) {
            driver.switchTo().window(link);
            if (!link.equals(homePageId)){
                System.out.println(driver.findElement(By.tagName("body")).getText());
                driver.close();
            }
            System.out.println("Title= "+driver.getTitle());
            continue;
        }
         */
        Iterator<String> itr = links.iterator();
        while (itr.hasNext()) {
            driver.switchTo().window(itr.next());
            if(driver.getWindowHandle().equals(homePageId)){
                System.out.println("Title= "+driver.getTitle());
                continue;
            }
            System.out.println("Text on the child window: "+driver.findElement(By.tagName("body")).getText());
            driver.close();
        }
    }
}
