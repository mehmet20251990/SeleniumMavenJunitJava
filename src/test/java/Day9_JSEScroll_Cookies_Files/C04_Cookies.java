package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;
public class C04_Cookies extends BaseTest {
    // Go to URL: https://kitchen.applitools.com/ingredients/cookie
    // Get Cookie.
    // Find the total number of cookies.
    // Print all the cookies.
    // Add Cookie.
    // Edit Cookie.
    // Delete Cookie.
    // Delete All Cookies.
    @Override
    public void tearDown() {
    }
    @Test
    public void cookiesTest() {
        driver.get("http://kitchen.applitools.com/ingredients/cookie");
        System.out.println("test get cookies");

        Cookie cookie = driver.manage().getCookieNamed("protein");
        Assert.assertEquals("chicken", cookie.getValue());

        Set <Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies);

        for (Cookie each : allCookies) {
            System.out.println("each cookie= " + each);
            System.out.println("each cookie name= " + each.getName());
            System.out.println("each cookie value= " + each.getValue());
        }
        System.out.println("add cookies");
        Cookie cookie1 = new Cookie("fruit", "banana");
        driver.manage().addCookie(cookie1);
        Assert.assertEquals(cookie1.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());

        allCookies = driver.manage().getCookies();
        System.out.println("allCookies= " + allCookies.size());

        System.out.println("edit cookies");
        Cookie editedCookie = new Cookie(cookie1.getName(),"mango");
        driver.manage().addCookie(editedCookie);

        Assert.assertEquals(editedCookie.getValue(), driver.manage().getCookieNamed(cookie1.getName()).getValue());
        System.out.println(driver.manage().getCookieNamed(cookie1.getName()).getValue());

        allCookies = driver.manage().getCookies();
        System.out.println("allCookies= " + allCookies.size());
    }
    @Test
    public void deleteCookies() {
        driver.get("http://kitchen.applitools.com/ingredients/cookie");
        Set <Cookie> allCookies = driver.manage().getCookies();
        allCookies = driver.manage().getCookies();
        System.out.println("allCookies= " + allCookies.size());
        System.out.println("delete cookies");

        Cookie addedCookie = new Cookie("drinks", "ayran");
        driver.manage().addCookie(addedCookie);
        driver.manage().deleteCookie(addedCookie);

        Assert.assertNull("cookie halen var",driver.manage().getCookieNamed(addedCookie.getName()));
        allCookies = driver.manage().getCookies();
        System.out.println("allCookies= " + allCookies.size());

        driver.manage().deleteAllCookies(); //browserdan hepsi sildik
        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); // allCookies = 0
    }
}
