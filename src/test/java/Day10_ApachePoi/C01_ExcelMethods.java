package Day10_ApachePoi;

import org.apache.poi.ss.usermodel.*;
import utilities.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
public class C01_ExcelMethods extends BaseTest {
    public static void main(String[] args) throws IOException {
        // Excel dosyamizin pathini aldik
        String path = "src\\test\\java\\resources\\excelfile.xlsx";

        // Dosyamizi actik
        FileInputStream fileInputStream = new FileInputStream(path);

        // Actigimiz dosyayi excel workbook una cevirdik
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // workbook umuzdan sheetimize gecis yaptik
        Sheet sheet1 = workbook.getSheetAt(0);

        // Sheetimizden istedigimiz satiri aldik. Index 0 dan baslar
        Row row1 = sheet1.getRow(0);

        // satirimizdan istedigimiz hucreyi aldik. Index 0 dan baslar
        Cell cell1 = row1.getCell(0);

        // Hucrelerimizde string operasyonlari gerceklestirmek istersek toString() methodunu kullanarak hucreyi stringe cevirmeliyiz
        System.out.println("Cell 1 = " + cell1.toString().toLowerCase());
    }
}





