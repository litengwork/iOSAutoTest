package com.appium.Base;

import java.util.HashMap;

public class AppiumServerController {

    //private Process mProcess;
    private HashMap<String, Process> processHashMap = new HashMap<String, Process>();
    private String nodePath = "node";
    private String appiumJsPath;
    private String port;
    private String bootstrapPort;
    private String chromedriver_port;
    private String UID;

    private static AppiumServerController appiumServerController = new AppiumServerController();

    private AppiumServerController() {
    }

    public static AppiumServerController getInstance() {
        return appiumServerController;
    }

    public void startServer(String deviceName,String platformVersion, String port) throws Exception {

        Process process;
        String cmd = "/usr/local/bin/appium -a 127.0.0.1 " + "-p " + port;
        System.out.println(cmd);
        process = Runtime.getRuntime().exec(cmd);
//		processHashMap.put(port, process);
//		System.out.println(process);
//		InputStream inputStream = process.getInputStream();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//		String line;
//		while ((line = reader.readLine()) != null) {
//			if(line.startsWith("[Appium] Appium REST http interface listener started on")) {
//				serverLock.unlock();
//            }
//		}
//		process.waitFor();
//		System.out.println("Stop appium server");
//		inputStream.close();
//		reader.close();
//		process.destroy();
    }

    public void stopServer(Process process) {

        if (process != null) {
            System.out.println(process);
            process.destroy();
        }
    }

    public void stopServer(String port) {

        Process process = processHashMap.get(port);
        stopServer(process);
        processHashMap.remove(port);

    }

}


