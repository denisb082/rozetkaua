package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by beznisco on 27.01.2017.
 */
public class BaseTest {
    public WebDriver driver;

    public static final String URL = "http://rozetka.com.ua";

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\denis\\Amazon\\chrome\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }


    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
   }




}
