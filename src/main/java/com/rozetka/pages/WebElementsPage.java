package com.rozetka.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConnectionToDB;

import java.io.IOException;
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

    @FindBy(xpath = ConstantsElements.TOP_SALE_XPATH)
    private List<WebElement> list; // xpath fo top sale

    @FindBy(linkText = "page=1")
    private WebElement pageOne;

    @FindBy(linkText = "page=3")
    private WebElement pageTwo;



    public void goToSmartphonesList(){
        phonesTvElectronicsLink.click();
        phonesLink.click();
        smartphonesLink.click();
    }

    public void searchAllTopSale() throws IOException {
        String id;
        String names = "";
        String prices = "";
        for (WebElement option : list) {
            String str = String.format(String.valueOf(option.getAttribute("id")));
            id = str.replaceAll("[^-?0-9]+", "");
            WebElement element = driver.findElement(By.xpath(".//*[@id='goods_price_block_"+ id +"']")); // 10026384
            prices = element.getText();
            List<WebElement> namesList = driver.findElements(By.xpath(".//a[contains(@onclick, \"document.fireEvent('goodsTitleClick', {extend_event: [{name: 'goods_id', value: "+ id +"}]}); return true\")]"));
            for (WebElement name : namesList) {
                names = name.getText();
                if (StringUtils.isNotEmpty(names) && StringUtils.isNotEmpty(prices)){
                    System.out.println(id + "," + names + ","+ prices);
                    ConnectionToDB con = new ConnectionToDB();
                    con.putData(id, names, prices);
            }

        }

        }

    }

    public void clickOnNextPage() {
        for (int i = 1; i<4; i++){
            WebElement page = driver.findElement(By.xpath(".//*[@id='page"+ i +"']"));
            page.click();

        }
    }
/*    public void clickOnSecondPage(){
        pageTwoLink.click();
    }

    public void clickOnThirdPage(){
        pageThreeLink.click();
    }*/

//    public void allertDismiss(){
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, 3);
//            wait.until(ExpectedConditions.alertIsPresent());
//            Alert alertMiss = driver.switchTo().alert();
//            alertMiss.dismiss();
//        }
//        finally {
//        }
//    }

}
