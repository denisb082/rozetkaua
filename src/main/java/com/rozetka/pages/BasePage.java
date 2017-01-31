package com.rozetka.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by beznisco on 26.01.2017.
 */
public class BasePage {

    protected WebDriver driver;

    /*Alert alert;*/
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        }
    }

 /*   public boolean isAlertPresent(Alert alert) {

        try {
            *//*WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            alert = driver.switchTo().alert();*//*
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }*/
