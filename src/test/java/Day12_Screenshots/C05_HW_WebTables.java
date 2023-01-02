package Day12_Screenshots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.util.List;

public class C05_HW_WebTables extends BaseTest {
    /*
    Go to URL: https://the-internet.herokuapp.com/tables
    Print the entire table
    Print All Rows
    Print Last row data only
    Print column 5 data in the table body
    Write a method that accepts 2 parameters
    parameter 1 = row number
    parameter 2 = column number
    printData(3,4); => prints

    parameter 3 = table id
    printData(3,4,"table1") => prints data in 3rd row 4th Column with table id
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void webTables() {
        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement table1 = driver.findElement(By.id("table1"));
        WebElement table2 = driver.findElement(By.id("table2"));

        System.out.println(table1.getText());
        System.out.println(table2.getText());

        List<WebElement> table1Rows = table1.findElements(By.xpath(".//tr"));
        List<WebElement> table2Rows = table1.findElements(By.xpath(".//tr"));
        System.out.println("-----------TABLE 1 --------------");
        for (WebElement each:table1Rows) {
            System.out.println(each.getText());
        }
        System.out.println("-----------TABLE 2 --------------");
        table2Rows.forEach(x-> System.out.println(x.getText()));

        System.out.println(table1Rows.get(table1Rows.size()-1).getText());
        System.out.println(table2Rows.get(table2Rows.size()-1).getText());

        List<WebElement> table1Clms = table1.findElements(By.xpath(".//td[5]"));
        List<WebElement> table2Clms = table1.findElements(By.xpath(".//td[5]"));
        System.out.println("-----------TABLE 1 --------------");
        for (WebElement each:table1Clms) {
            System.out.println(each.getText());
        }
        System.out.println("-----------TABLE 2 --------------");
        table2Clms.forEach(x-> System.out.println(x.getText()));








    }
}
