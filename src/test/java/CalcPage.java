import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CalcPage {
    private AndroidDriver<WebElement> driver;
    private static CalcPage instance;
    @FindBy(id = "com.google.android.calculator:id/digit_0")
    private WebElement btn_0;

    @FindBy(id = "com.google.android.calculator:id/digit_1")
    private WebElement btn_1;

    @FindBy(id = "com.google.android.calculator:id/digit_2")
    private WebElement btn_2;

    @FindBy(id = "com.google.android.calculator:id/digit_3")
    private WebElement btn_3;

    @FindBy(id = "com.google.android.calculator:id/digit_4")
    private WebElement btn_4;

    @FindBy(id = "com.google.android.calculator:id/digit_5")
    private WebElement btn_5;

    @FindBy(id = "com.google.android.calculator:id/digit_6")
    private WebElement btn_6;

    @FindBy(id = "com.google.android.calculator:id/digit_7")
    private WebElement btn_7;

    @FindBy(id = "com.google.android.calculator:id/digit_8")
    private WebElement btn_8;

    @FindBy(id = "com.google.android.calculator:id/digit_9")
    private WebElement btn_9;

    @FindBy(id = "com.google.android.calculator:id/op_div")
    private WebElement btn_divide;

    @FindBy(id = "com.google.android.calculator:id/op_mul")
    private WebElement btn_multiply;

    @FindBy(id = "com.google.android.calculator:id/op_sub")
    private WebElement btn_minus;

    @FindBy(id = "com.google.android.calculator:id/op_add")
    private WebElement btn_plus;

    @FindBy(id = "com.google.android.calculator:id/eq")
    private WebElement btn_equals;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    private WebElement result;

    @FindBy(id = "com.google.android.calculator:id/formula")
    private WebElement formula;

    @FindBy(id = "com.google.android.calculator:id/clr")
    private WebElement btn_clear;

    private CalcPage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public static CalcPage getInstance(AndroidDriver<WebElement> driver) {
        if (instance == null) {
            instance = new CalcPage(driver);
        }
        return instance;
    }

    public void click_0() {
        btn_0.click();
    }

    public void click_1() {
        btn_1.click();
    }

    public void click_2() {
        btn_2.click();
    }

    public void click_3() {
        btn_3.click();
    }

    public void click_4() {
        btn_4.click();
    }

    public void click_5() {
        btn_5.click();
    }

    public void click_6() {
        btn_6.click();
    }

    public void click_7() {
        btn_7.click();
    }

    public void click_8() {
        btn_8.click();
    }

    public void click_9() {
        btn_9.click();
    }

    public void click_div() {
        btn_divide.click();
    }

    public void click_mul() {
        btn_multiply.click();
    }

    public void click_plus() {
        btn_plus.click();
    }

    public void click_minus() {
        btn_minus.click();
    }

    public void click_ac() {
        btn_clear.click();
    }

    public void click_equals() {
        btn_equals.click();
    }

    public String scanResult() {
        return result.getText();
    }

    public String scanFormula() {
        return formula.getText();
    }
}
