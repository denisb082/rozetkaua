package com.rozetkatest.tests;

import com.rozetka.pages.WebElementsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by beznisco on 27.01.2017.
 */
public class TestRozetkaTopSale extends BaseTest {

    WebElementsPage webElementsPage;
    @Test
    public void getTopSaleTest() throws InterruptedException, IOException {

        driver.get("http://rozetka.com.ua/mobile-phones/c80003/preset=smartfon/");
        for (int i = 1; i<4; i++){
            WebElement page = driver.findElement(By.xpath(".//*[@id='page"+ i +"']"));
            page.click();
            Thread.sleep(2000);
            webElementsPage = new WebElementsPage(driver);
            // webElementsPage.goToSmartphonesList();
            webElementsPage.searchAllTopSale();
        }


    }

      /*  webElementsPage.clickOnSecondPage();
        webElementsPage.searchAllTopSale();
        webElementsPage.clickOnThirdPage();
        webElementsPage.searchAllTopSale();
*/
}
