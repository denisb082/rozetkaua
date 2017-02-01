package com.rozetkatest.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by beznisco on 27.01.2017.
 */
public class BaseTest {
    public WebDriver driver;

    public static final String URL = "http://rozetka.com.ua";

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.gecko.driver", "C:\\denis\\Amazon\\geckodriver-v0.13.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
   }




}
