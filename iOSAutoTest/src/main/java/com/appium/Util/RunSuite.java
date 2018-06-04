package com.appium.Util;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;

public class RunSuite {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		System.out.println("11111111");
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> testFieldList = new ArrayList<String>();
        //testFieldList.add("testng_main.xml");
        testFieldList.add("src/main/java/Device/TestNg_Main.xml");
//        testFieldList.add("testng1.xml");
        testng.setTestSuites(testFieldList);

        testng.addListener(tla);
        testng.setSuiteThreadPoolSize(1);
        testng.run();
        System.out.println("ConfigurationFailures: "+tla.getConfigurationFailures());
        System.out.println("FailedTests: " + tla.getFailedTests());
	}

}
