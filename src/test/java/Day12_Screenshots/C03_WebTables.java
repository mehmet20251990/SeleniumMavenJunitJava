package Day12_Screenshots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C03_WebTables extends BaseTest {
    /*
    Go to URL: http://demo.guru99.com/test/web-table-element.php
    To find third row of table
    To get 3rd row's 2nd column data
    Get all the values of a Dynamic Table
     */
    @Override
    public void tearDown() {
    }
    @Test
    public void webTableExample() {
        driver.get("http://demo.guru99.com/test/web-table-element.php");
        WebElement table = driver.findElement(By.className("dataTable")).findElement(By.tagName("tbody"));
        // WebElementlerde [] index 1'den başlar... "dataTable"da çalışsaydık () içine alarak tüm tr'lerin 4.sünü alırdık.
        // () içinde olmasaydı en az 3 tane tr barındıran taglerin ilkinin 4.sünü alırdık...

        // Body'deki 3. satır locate edildi.
        WebElement row3 = table.findElement(By.xpath(".//tr[3]"));//"(.//tr[4])" olurdu "dataTable"da çalışsaydık
        System.out.println(row3.getText());

        // 3. satir 3. sutun (hucre) locate edildi
        WebElement row3cell3 = row3.findElement(By.xpath(".//td[3]"));

        // Satir sayimizi bulduk
        int satirSayisi = table.findElements(By.xpath(".//tr")).size();
        System.out.println(satirSayisi);

        //sutun sayimizi bulduk
        int sutunSayisi = row3.findElements(By.xpath(".//td")).size();
        System.out.println(sutunSayisi);

        // For donguleri ile tum hucreleri geziyoruz
        for (int i = 1; i<=satirSayisi; i++){
            //her bir satir

            for (int j = 1; j<=sutunSayisi; j++){
                // her satirin sutunu

                By locator = By.xpath(".//tr["+ i +"]//td[" + j + "]");
                WebElement tableData = table.findElement(locator);
                System.out.print(tableData.getText() + " ");
            }
            System.out.println();
        }
    }
}
