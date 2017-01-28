package com.rozetkatest.tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by beznisco on 27.01.2017.
 */
public class BaseTest {
    protected static RemoteWebDriver driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        String hubUrl ="http://localhost:4444/wd/hub";
        driver = new RemoteWebDriver(new URL(hubUrl), DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public static RemoteWebDriver getDriver() { return driver; }


}
