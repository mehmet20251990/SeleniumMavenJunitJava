package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class C06_HW_CookiesTest extends BaseTest {
    /*
    Go to URL: http://facebook.com
    getCookies,
    addCookie,
    deleteCookieNamed,
    deleteAllCookies.
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void cookiesTest() {
        driver.get("http://facebook.com");

        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("allCookies= " + allCookies.size());

        Cookie faceCookie = new Cookie("man", "cahal");
        driver.manage().addCookie(faceCookie);
        allCookies = driver.manage().getCookies();
        System.out.println("allCookies= " + allCookies.size());

        driver.manage().deleteCookieNamed(faceCookie.getName());
        allCookies = driver.manage().getCookies();
        System.out.println("allCookies= " + allCookies.size());

        driver.manage().deleteAllCookies();
        allCookies = driver.manage().getCookies();
        System.out.println("allCookies = " + allCookies.size());
    }
}
