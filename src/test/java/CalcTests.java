import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalcTests {
    private static AndroidDriver<WebElement> driver;
    private CalcPage calcPage;

    @BeforeAll
    public static void initialize() {
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

    @BeforeEach
    public void clear(){
        calcPage = CalcPage.getInstance(driver);
        calcPage.click_ac();
    }

    @Test
    @DisplayName("Push button check")
    public void checkButtonsPushed() {
        calcPage.click_0();
        calcPage.click_1();
        calcPage.click_plus();
        calcPage.click_2();
        calcPage.click_mul();
        calcPage.click_3();
        calcPage.click_div();
        calcPage.click_4();
        calcPage.click_minus();
        calcPage.click_5();
        calcPage.click_6();
        calcPage.click_7();
        calcPage.click_8();
        calcPage.click_9();
        assertEquals("01\u002b2\u00D73\u00F74\u221256789", calcPage.scanFormula());
    }

    @Test
    @DisplayName("Addition check")
    public void checkAddition() {
        calcPage.click_3();
        calcPage.click_plus();
        calcPage.click_2();
        calcPage.click_equals();
        assertEquals("5", calcPage.scanResult());
    }

    @Test
    @DisplayName("Multiplication check")
    public void checkMultiplication() {
        calcPage.click_6();
        calcPage.click_mul();
        calcPage.click_9();
        calcPage.click_equals();
        assertEquals("54", calcPage.scanResult());
    }

    @Test
    @DisplayName("Division check")
    public void checkDivision() {
        calcPage.click_8();
        calcPage.click_div();
        calcPage.click_4();
        calcPage.click_equals();
        assertEquals("2", calcPage.scanResult());
    }

    @Test
    @DisplayName("Subtraction check")
    public void checkSubtraction() {
        calcPage.click_7();
        calcPage.click_minus();
        calcPage.click_5();
        calcPage.click_equals();
        assertEquals("2", calcPage.scanResult());
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}