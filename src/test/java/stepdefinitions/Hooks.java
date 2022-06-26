package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.EmailPushMessage;
import utilities.SlackPushMessage;
import utilities.TestResultMessage;

import java.io.File;
import java.io.IOException;

import static utilities.Driver.appiumDriver;


public class Hooks {


    String textMessage;

    @Before
    public void setUp() {
    }

    @After

    public void tearDown(Scenario scenario) throws Exception {
        TestResultMessage [] testResultMessages = {new SlackPushMessage(),new EmailPushMessage()};

        if (scenario.isFailed()) {

            textMessage = "Test Error!!!";
            File scrFile = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("./FailedScreenShots/" + scenario.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            textMessage  = "Everything is OK";
        }

        runTestResult(testResultMessages,textMessage);
        Driver.quitAppiumDriver();
    }

    public static void runTestResult(TestResultMessage[] testResultMessages , String message) throws Exception {

        for (TestResultMessage testResultMessage : testResultMessages) {
            testResultMessage.pushTestResultMessage(message);
        }
    }

}
