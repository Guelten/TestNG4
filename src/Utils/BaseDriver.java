package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Gun01._03_Enable.driver;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    void baslangicIslemleri()
    {
        System.out.println("Baslangic islemleri");
        // ilk adimda calisan kismi

        Logger logger= Logger.getLogger("");     // bütün log`lara üreten objeye/servise ulastim ("")
        logger.setLevel(Level.SEVERE);                 // Sadece errorları göster

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // ChromeServici sessiz modda çalıştır
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();                   // web sayfasini kontrol eden görevli

        //driver.manage().window().setPosition(new Point(-1650,130));
        //driver.manage().window().maximize();         // Ekranı max yapıyor.
        driver.manage().deleteAllCookies();            // sitenin senin bilgisayarında yaptığı ayarlar
        // siliniyor, sayfa başlangıç ayarlarına dönüyor

        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr); // Sadece tüm sayfanın kodlarının bilgisyarınıza
        // inmesi süresiyle ilgili
        // bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.:
        // 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
        // eğer 2 sn yüklerse 30 sn. beklmez.

        driver.manage().timeouts().implicitlyWait(dr);  // Bütün weblementlerin element bazında, elemente özel işlem yapılmadan önce
        // hazır hale gelmesi verilen mühlet yani süre.

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }



    @AfterClass
    public static void driverBekleKapat()
    {
        Tools.Bekle(3);
        driver.quit();
    }
}
