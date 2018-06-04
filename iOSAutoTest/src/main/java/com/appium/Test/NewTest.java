package com.appium.Test;


import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.Base.AppiumTestCaseBase;
import com.appium.PageObject.LoginPageView;
import com.appium.Util.Swipe;

// 测试case文件要继承 AppiumTestCaseBase
public class NewTest extends AppiumTestCaseBase{

    //  采用@Test 注解的方式 进行写测试 case
    @Test
    public void TestCase3(){
        driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"AppiuTestDemo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField").sendKeys("admin");
        driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"AppiuTestDemo\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField").sendKeys("123456");
        driver.findElementByAccessibilityId("Confirm").click();
        IOSDriver loginDriver = driver;
        LoginPageView obj = new LoginPageView();
        Assert.assertEquals(obj.isLoginButtonShow(loginDriver),true,"TestFail");
    }

    public void sleep(long s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


