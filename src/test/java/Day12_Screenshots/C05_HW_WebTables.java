package Day12_Screenshots;

import org.junit.Test;
import utilities.BaseTest;

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

    }
}
