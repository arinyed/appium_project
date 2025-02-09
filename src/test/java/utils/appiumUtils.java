package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.MalformedURLException;
import java.time.Duration;

public class appiumUtils {
    public void configureAppium() throws MalformedURLException {

        service = new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        options = new UiAutomator2Options();

        options.setDeviceName("Arin emulator");

        options.setChromedriverExecutable("/Users/arinyedgarian/documents/chromedriver 11");

        //options.setApp(
        //		"/Users/arinyedgarian/eclipse-workspace/eclipse-workplace3/Appium/src/test/java/resources/ApiDemos-debug.apk");

        options.setApp(
                "/Users/arinyedgarian/eclipse-workspace/eclipse-workplace3/Appium/src/test/java/resources/General-Store.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}