package com.appium.Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import com.appium.PageObject.LoginPageView;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import io.appium.java_client.ios.IOSDriver;

public class AppiumTestCaseBase {

    public static IOSDriver<WebElement> driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    private boolean isInstall = false;

    // 优先调用 配置文件进行属性配置
    @BeforeTest
    @Parameters({"deviceName", "platformVersion", "port", "udid"})
    public void setUp(String deviceName, String platformVersion, String port, String udid) throws MalformedURLException {
        // 配置 Appium Server 注释掉 就可以手动启动 命令:appium -a 127.0.0.1 -p 4723
//        try {
//            AppiumServerController.getInstance().startServer(deviceName,platformVersion,port);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println("[-----------Paramaters-----------] port=" + port);
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("bundleId", "com.litengs.AppiuTestDemo");
        capabilities.setCapability("noReset", "true");
        System.out.println(capabilities.toString());
        try {
            if (driver == null) {
                driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
                // 获取上下文 判断是否是webview/native app
                Set<String> contextNames = driver.getContextHandles();
                for (String contextName : contextNames) {
                    System.out.println(contextName);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }


}

