package Login;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class Login1 {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
       
            // Set the desired capabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("PLATFORM_NAME" , "Android");
            capabilities.setCapability("PLATFORM_VERSION", "11"); // Use the version of your device
            capabilities.setCapability("DEVICE_NAME", "Android"); // Or use the device name from adb devices
            capabilities.setCapability("APP", "C:\\Users\\SynccIT\\app-release.apk"); // Path to your APK file
            capabilities.setCapability("AUTOMATION_NAME", "UiAutomator2"); // Automation engine for Android
// System.out.println("capabilities");
//            UiAutomator2
            // Initialize the AndroidDriver with Appium server URL and capabilities
            URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
            System.out.println("serverUrl"+serverUrl);
//            AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(serverUrl, capabilities); // Use the correct driver class for Android

            AndroidDriver  driver = new AndroidDriver(serverUrl, capabilities);
            System.out.println("serverUrl"+serverUrl);
            System.out.println("capabilities"+capabilities);
            System.out.println("App is launched successfully");

            // Perform actions with the app here (e.g., find elements, click buttons)
            Thread.sleep(5000); // Wait for a few seconds to see the results

            // Close the app after test
//            driver.quit();
            
       
    }
}
