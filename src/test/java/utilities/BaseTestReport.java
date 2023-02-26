package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
public class BaseTestReport {
    protected WebDriver driver;
    protected ExtentReports extentReports; // raporlama işlemini gerçekleştirir
    protected ExtentHtmlReporter extentHtmlReporter; // raporu HTML olarak düzenler
    protected ExtentTest extentTest;//testimizin Pass veya Fail old.u saklayan objedir. Ekran görüntüleri içinde kullanılır.
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Extent report objelerimizi de oluşturuyoruz.
        extentReports = new ExtentReports();

        // Kaydedeceğimiz dosya için tarih oluşturuldu.
        String currentDay = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/reports/" + currentDay + ".html";

        // HTML raporu oluşturacak obje dosya yoluyla initialize edildi.
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        // Raporlama yapan extentreport objemize HTML reporter bağlandı.
        extentReports.attachReporter((extentHtmlReporter));

        // Rapor ile alakalı extra opsiyonel bilgiler verildi.
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");

        // HTML raporunda görüntülemek istediğimiz konfigürasyonlar yapıldı.
        extentHtmlReporter.config().setDocumentTitle("CWReport");
        extentHtmlReporter.config().setReportName("Test run report");
    }
    @After
    public void tearDown(){
        driver.quit();
        extentReports.flush();
    }
}
