import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.net.URL;
import java.net.MalformedURLException;
import java.time.Duration;

public class AND_BaseClass {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public UiAutomator2Options options;

    @BeforeClass
    public void setUp() {


        // Set UiAutomator2 Options
        options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Android Emulator");  // Replace with your device name if using a real device
        options.setPlatformVersion("13.0");         // Replace with your Android version
        options.setApp(System.getProperty("user.dir") + "/apps/your-app.apk");  // Path to your APK
        options.setAppPackage("com.example.yourapp");   // Replace with your app's package name
        options.setAppActivity("com.example.yourapp.MainActivity");  // Replace with your app's main activity

        try {
            // Initialize the Android Driver
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Appium server URL is incorrect.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

        if (service != null && service.isRunning()) {
            service.stop();
        }
    }
}
