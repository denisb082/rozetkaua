import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by beznisco on 26.01.2017.
 */
public class TestTest {

    public static String url = "http://rozetka.ua";
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\denis\\Amazon\\geckodriver-v0.13.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
