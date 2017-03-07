package com.rozetkatest.tests;

import com.rozetka.pages.WebElementsPage;
import entity.SmartPhone;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConnectionToDB;

import java.util.List;


/**
 * Created by beznisco on 27.01.2017.
 */
public class TestRozetkaTopSale extends BaseTest {


    @Test
    public void getTopSaleTestOne() {
        List<SmartPhone> smartPhoneList;
        ConnectionToDB connectionToDB = new ConnectionToDB();
        WebElementsPage webElementsPage = new WebElementsPage(driver);
        webElementsPage.openToSmartPhonePage();
        smartPhoneList = webElementsPage.getSmartPhoneList();
        Assert.assertNotNull(smartPhoneList, "No top sale phones");
        for (int i = 0; i < smartPhoneList.size(); i++){
            Assert.assertTrue(connectionToDB.putData(smartPhoneList.get(i).getId(), smartPhoneList.get(i).getTitle(), smartPhoneList.get(i).getPrice()));
        }
    }
}