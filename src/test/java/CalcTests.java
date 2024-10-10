import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class CalcTests {
    private static AndroidDriver<AndroidElement> driver;
    @BeforeAll
    public static void initialize(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkCalculate() {
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"3\"]").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"plus\"]").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"2\"]").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"equals\"]").click();
        assert(driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.google.android.calculator:id/result_final\"]").getText().equals("5"));
    }
}
