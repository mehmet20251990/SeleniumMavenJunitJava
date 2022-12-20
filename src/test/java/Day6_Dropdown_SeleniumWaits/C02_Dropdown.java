package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
          driver.quit();
    }
    @Test
    public void selectByIndex() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement drpDown = driver.findElement(By.name("country"));

        // Locate edilen dropdown select objesine oluşturuldu
        Select select = new Select(drpDown);

        // selectByIndex() methodu "0" ile başlar
        select.selectByIndex(1);
    }
    @Test
    public void selectByValue() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement drpDown = driver.findElement(By.name("country"));

        // Locate edilen dropdown select objesine oluşturuldu
        Select select = new Select(drpDown);

        select.selectByValue("TURKEY");
    }
    @Test
    public void selectByVisibleText() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement drpDown = driver.findElement(By.name("country"));

        // Locate edilen dropdown select objesine oluşturuldu
        Select select = new Select(drpDown);

        select.selectByVisibleText("TURKEY");

        System.out.println(select.isMultiple());
    }
    @Test
    public void multipleSelect() {
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));
        System.out.println(select.isMultiple());

        select.selectByValue("apple");
        select.selectByVisibleText("Grape");
        select.selectByIndex(0);
    }
    @Test
    public  void getOptions(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        Select select = new Select(driver.findElement(By.name("country")));

        List <WebElement> options = select.getOptions();

        for (WebElement option : options){
            System.out.println(option.getText());
        }
    }
    @Test
    public void getFirstSelectedOption() {
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));
        System.out.println(select.isMultiple());

        select.selectByValue("apple");
        select.selectByVisibleText("Grape");
        select.selectByIndex(0);

        // Seçili olanlardan index'i en küçük olanını verir
        System.out.println(select.getFirstSelectedOption().getText());

        // WebElement firstSelected = select.getFirstSelectedOption();
        // System.out.println(firstSelected.getText());
    }
    @Test
    public void getAllSelectedOptions() {
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));
        System.out.println(select.isMultiple());

        select.selectByValue("apple");
        select.selectByVisibleText("Grape");
        select.selectByIndex(0);

        List<WebElement> selectedOptions = select.getAllSelectedOptions();

        System.out.println(selectedOptions.get(1).getText());

        for (WebElement option : selectedOptions){
            System.out.println(option.getText());
        }
    }
}
