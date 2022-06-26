package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AllPage;

import java.time.Duration;
import java.util.List;

public class ReusableMethods extends Driver {

    public static WebDriverWait wait;
    static AllPage allpage = new AllPage();

    public static void waitFor(int second) {

        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static AndroidElement waitForVisibility(AndroidElement element, int timeToWaitInSec) {

        wait = new WebDriverWait(appiumDriver, timeToWaitInSec);
        return (AndroidElement) wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForText(String text) {
        nativeFindElementsByText(text).stream().forEach(t -> Assert.assertTrue(t.isDisplayed()));
    }

    private static List<AndroidElement> nativeFindElementsByText(String text) {
        return (List<AndroidElement>) appiumDriver.findElementsByXPath("//*[@text=" + " '" + text + "']");
    }


    public static void textWithClick(String text) {
        appiumDriver.findElementByXPath("//*[@text " + "=" + " '" + text + "']").click();
    }

    public static void scrollElement(double anc, double startP, double endP) {

        Dimension size = appiumDriver.manage().window().getSize();


        int anchor = (int) (size.width * anc);
        int startPoint = (int) (size.height * startP);
        int endPoint = (int) (size.height * endP);

        ReusableMethods.waitFor(1);

        new TouchAction(appiumDriver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();

    }

    public static void scroolElementWithUiSelector(String text) {

        appiumDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))." +
                "scrollIntoView(text(\"" + text + "\"))");
    }


}
