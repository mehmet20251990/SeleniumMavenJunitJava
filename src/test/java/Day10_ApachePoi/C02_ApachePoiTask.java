package Day10_ApachePoi;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import utilities.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C02_ApachePoiTask extends BaseTest {
    /*
    Add the excel file on the resources folder.
    Open the file.
    Open the workbook using file input stream.
    Open the first worksheet.
    Go to first row.
    Go to first cell on that first row and print.
    Go to second cell on that first row and print.
    Go to 2nd row first cell and assert if the data equal to Russia.
    Go to 3rd row 2nd cell-chain the row and cell.
    Find the number of used row.
    Print country, area key value pairs as map object.
     */
    public static void main(String[] args) throws IOException {
        String path = "src\\test\\java\\resources\\excelfile.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheetAt(0);

        Row row1 = sheet1.getRow(0);
        Cell cell11 = row1.getCell(0);
        System.out.println("cell11 = " + cell11);
        Cell cell12 = row1.getCell(1);
        System.out.println("cell12 = " + cell12);

        Row row2 = sheet1.getRow(1);
        Cell cell21 = row2.getCell(0);
        Assert.assertEquals("Rusya", cell21.toString());

        // Zincirleme olarakta yazabiliriz...
        Cell cell32 = sheet1.getRow(2).getCell(1);
        System.out.println("cell32 = " + cell32);

        // Komple tablo olarak düşünerek kullanılan satırları verir. Arada boş satır varsa null değer atanır...
        System.out.println("sheet1.getPhysicalNumberOfRows() = " + sheet1.getPhysicalNumberOfRows());
        System.out.println("sheet1.getLastRowNum() = " + sheet1.getLastRowNum());

        int totalRows = sheet1.getPhysicalNumberOfRows();
        Map<String,String> countryAreas = new HashMap<>();

        for (int row = 1; row < totalRows; row++){
            String country = sheet1.getRow(row).getCell(0).toString();
            //System.out.println((row+1)+". satır= "+country);
            String area = sheet1.getRow(row).getCell(1).toString();
            //System.out.println("Country = " + country+" - Area = " + area);

            countryAreas.put(country,area);
        }
        System.out.println(countryAreas);
    }
}
