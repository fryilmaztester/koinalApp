package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static utilities.Driver.appiumDriver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    @AndroidFindBy(id = "com.koinal.android:id/activityLogin_editText_email")
    public AndroidElement loginEmail;

    @AndroidFindBy(id = "com.koinal.android:id/activityLogin_editText_password")
    public AndroidElement loginPassword;


}
