package com.rozetkatest.tests;

import com.rozetka.pages.WebElementsPage;
import org.testng.annotations.Test;
import java.io.IOException;


/**
 * Created by beznisco on 27.01.2017.
 */
public class TestRozetkaTopSale extends BaseTest {


    @Test
    public void getTopSaleTestOne() throws InterruptedException, IOException {

        WebElementsPage webElementsPage = new WebElementsPage(driver);
        webElementsPage.actionWithMainMenuElement();
        webElementsPage.searchingTopSale();

    }
}