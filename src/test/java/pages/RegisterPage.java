package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(30)),
                this);
    }

    @AndroidFindBy(id = "com.koinal.android:id/activityRegister_loginAction")
    public AndroidElement loginText;

    @AndroidFindBy(id = "com.koinal.android:id/activityRegister_editText_email")
    public AndroidElement emailPlaceHolder;

    @AndroidFindBy(id = "com.koinal.android:id/activityRegister_editText_password")
    public AndroidElement passWordPlaceHolder;

    @AndroidFindBy(id = "com.koinal.android:id/activityRegister_editText_passwordRetype")
    public AndroidElement reTypePassWordPlaceHolder;

}
