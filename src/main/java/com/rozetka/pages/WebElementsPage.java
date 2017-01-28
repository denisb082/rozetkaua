package com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by beznisco on 27.01.2017.
 */
public class WebElementsPage extends BasePage {

    public WebElementsPage(WebDriver driver) { super(driver);} // прочитать спросить

    @FindBy(xpath = ConstantsElements.PHONES_TV_ELECTRONICS_LINK)
    private WebElement phonesTvElectronicsLink;

    @FindBy(xpath = ConstantsElements.PHONES_LINK)
    private WebElement phonesLink;

    @FindBy(xpath = ConstantsElements.SMARTPHONES_LINK)
    private WebElement smartphonesLink;

    @FindBy (xpath = ConstantsElements.PAGE_TWO_LINK)
    private WebElement pageTwoLink;

    @FindBy (xpath = ConstantsElements.PAGE_THREE_LINK)
    private WebElement pageThreeLink;

    @FindBy(xpath = ConstantsElements.TOP_SALE_XPATH)
    private List<WebElement> list; // xpath fo top sale

    public void goToSmartphonesList(){
        phonesTvElectronicsLink.click();
        phonesLink.click();
        smartphonesLink.click();
    }

    public void searchAllTopSale() {
        String id;
        String names = "";
        String prices = "";
        for (WebElement option : list) {
            String str = String.format(String.valueOf(option.getAttribute("id")));
            id = str.replaceAll("[^-?0-9]+", "");
            WebElement element = driver.findElement(By.xpath(".//*[@id='goods_price_block_" + id + "'")); // 10026384
            prices = element.getText();
            List<WebElement> namesList = driver.findElements(By.xpath(".//a[contains(@onclick, \"document.fireEvent('goodsTitleClick', {extend_event: [{name: 'goods_id', value: " + id + "}]}); return true\")]"));
            for (WebElement name : namesList) {
                names = name.getText();
            }
        }
    }



    public void clickOnSecondPage(){
        pageTwoLink.click();
    }

    public void clickOnThirdPage(){
        pageThreeLink.click();
    }
//
//        ConnectionT
//
//        ConnectionToD con = new ConnectionToDB();
//        con.putData(prices, names);


}
