package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class C08_FileExist {
    @Test
    public void fileExist() {
        // C:\\Users\\user\\Desktop\\fileExist.png

        System.out.println(System.getProperty("user.home")); // Home yolunu yazdirdik
        String homePath = System.getProperty("user.home"); // Home yolunu atadik
        String filePath = "\\Desktop\\fileExist.png"; // Dosyanin kalan yolunu atadik

        String fullPath = homePath + filePath; // home ve dosya yollarini birlestirip full path i elde ettik

        File image = new File(fullPath); // Path imizi file a cevirdik

        Assert.assertTrue(image.exists()); // exists metoduyla varolup olmadigini kontrol ettik
    }
}
