package com.appium.PageObject;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

public class LoginPageView {

    // 判断login页面上的 button活性的问题
    public boolean isLoginButtonShow(IOSDriver<WebElement> dirver){
        try {
            return dirver.findElementByAccessibilityId("Confirm").isEnabled();
        }catch (Exception e){
            return false;
        }
    }

}


