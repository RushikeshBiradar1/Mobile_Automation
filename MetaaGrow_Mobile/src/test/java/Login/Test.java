package Login;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        // Set the desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11"); // Use the version of your device
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android"); // Or use the device name from adb devices
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\SynccIT\\app-release.apk"); // Path to your APK file
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // Automation engine for Android

        // Initialize the AndroidDriver with Appium server URL and capabilities
        URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub"); // Correct the IP address
        System.out.println("Server URL: " + serverUrl);

        // Initialize the driver
        AndroidDriver driver = new AndroidDriver(serverUrl, capabilities);
        System.out.println("App is launched successfully");

        // Perform actions with the app here (e.g., find elements, click buttons)
        // Example: driver.findElement(By.id("element_id")).click();

        Thread.sleep(5000); // Wait for a few seconds to see the results

        // Close the app after the test
        driver.quit(); // Always quit to clean up the session
    }
}
