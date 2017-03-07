package com.rozetka.pages;

import entity.SmartPhone;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beznisco on 27.01.2017.
 */
public class WebElementsPage extends BasePage {

    public WebElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ConstantsElements.PHONES_TV_ELECTRONICS_LINK)
    private WebElement phonesTvElectronicsLink;

    @FindBy(xpath = ConstantsElements.PHONES_LINK)
    private WebElement phonesLink;

    @FindBy(xpath = ConstantsElements.SMARTPHONES_LINK)
    private WebElement smartphonesLink;

    @FindBy(xpath = ConstantsElements.TOP_SALE_XPATH)
    private List<WebElement> goodsIdList; // xpath fo top sale


    public void openToSmartPhonePage() {
        Actions builder = new Actions(driver);
        builder.moveToElement(phonesTvElectronicsLink).click().build().perform();
        phonesLink.click();
        smartphonesLink.click();
    }

    private List<SmartPhone> getSmartPhoneListPhromeOnePage() {
        String id;
        String title;
        String price;
        List <SmartPhone> smartPhoneList = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        for (WebElement option : goodsIdList) {
            String str = String.format(String.valueOf(option.getAttribute("id")));
            id = str.replaceAll("[^-?0-9]+", "");
            WebElement priceElement = driver.findElement(By.xpath(".//*[@id='goods_price_block_" + id + "']")); // 10026384
            price = priceElement.getText();
            List<WebElement> namesList = driver.findElements(By.xpath(".//a[contains(@onclick, \"document.fireEvent('goodsTitleClick', {extend_event: [{name: 'goods_id', value: " + id + "}]}); return true\")]"));
            for (WebElement nameElement : namesList) {
                title = nameElement.getText();
                if (StringUtils.isNotEmpty(title) && StringUtils.isNotEmpty(price)) {
                    smartPhoneList.add(new SmartPhone(id, title, price));
                }
            }
        }
        return smartPhoneList;
    }

    public List<SmartPhone> getSmartPhoneList() {
        List <SmartPhone> smartPhoneListFromOnePage;
        List <SmartPhone> smartPhones = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            WebElement page = driver.findElement(By.xpath(".//*[@id='page" + i + "']"));
            page.click();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            smartPhoneListFromOnePage = getSmartPhoneListPhromeOnePage();
            for (int j = 0; j < smartPhoneListFromOnePage.size(); j++){
                smartPhones.add(smartPhoneListFromOnePage.get(j));
            }
        }
        return smartPhones;
    }

}
