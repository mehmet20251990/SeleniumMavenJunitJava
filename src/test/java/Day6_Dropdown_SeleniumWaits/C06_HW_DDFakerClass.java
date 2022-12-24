package Day6_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;

public class C06_HW_DDFakerClass extends BaseTest {
/*
    Go to URL: https://opensource-demo.orangehrmlive.com/
    Login with Username: Admin
    Login with Password: admin123
    Click login button
    Click on PIM
    Click on Employee List
    Employee Name -> Use Faker Class
    ID -> Use Faker Class
    Employment Status -> select by index: 2
    Include -> selectByVisibleText: Current and Past Employees
    Supervisor Name -> Use Faker Class
    Job Title ->selectByValue: IT Manager
    Sub Unit ->selectByValue: 3
    Click search button
    Verify text visible : "No Records Found"
 */
    @Override
    public void tearDown() {
    }
    @Test
    public void dDFakerTest(){
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement inputusername=driver.findElement(By.name("username"));
        inputusername.sendKeys("Admin");
        WebElement inputpassword=driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active'and@name='password']"));
        inputpassword.sendKeys("admin123");

        WebElement submitButton=driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        WebElement pımButton=driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper'][2]"));
        pımButton.click();

        //İnput kısımları liste atandı
        List<WebElement> inputs = driver.findElements(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']"));
        //Faker objesi oluşturuldu.Bilgiler faker objesi ile üretilerek girildi.
        Faker faker=new Faker();
        Actions act = new Actions(driver);

        act.click(inputs.get(0)).sendKeys(faker.name().firstName()).perform();
        act.click(inputs.get(1)).sendKeys((CharSequence) faker.idNumber()).perform();////

        Select status = new Select(inputs.get(2));
        status.selectByIndex(2);

        Select include = new Select(inputs.get(3));
        include.selectByVisibleText("Current and Past Employees");

        inputs.get(4).sendKeys(faker.name().firstName());

        Select job = new Select(inputs.get(5));
        job.selectByValue("IT Manager");

        Select sUnit = new Select(inputs.get(6));
        job.selectByValue("3");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
