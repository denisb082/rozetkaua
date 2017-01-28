package com.rozetkatest.tests;

import com.rozetka.pages.WebElementsPage;
import org.junit.Test;
import org.openqa.selenium.net.Urls;

/**
 * Created by beznisco on 27.01.2017.
 */
public class TestRozetkaTopSale extends BaseTest {

    @Test
    public void getTopSaleTest{
        BaseTest.url(Urls.ROZETKA_URL.getUrl());
        WebElementsPage webElementsPage = new WebElementsPage();
        webElementsPage.goToSmartphonesList();
        webElementsPage.searchAllTopSale();
        webElementsPage.clickOnSecondPage();
        webElementsPage.searchAllTopSale();
        webElementsPage.clickOnThirdPage();
        webElementsPage.searchAllTopSale();

    }

    Connec
