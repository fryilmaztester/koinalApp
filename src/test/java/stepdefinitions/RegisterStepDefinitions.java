package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AllPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class RegisterStepDefinitions {

    AllPage allPage = new AllPage();

    @Then("User verify that koinal is opened")
    public void verifyAppOpened() {

        ReusableMethods.waitForVisibility(allPage.registerPage().loginText, 5);
        Assert.assertTrue(allPage.registerPage().loginText.isDisplayed());
    }

    @Then("User verify all of placeholder and text")
    public void userVerifyAllPlaceHolderText(DataTable table) {
        table.row(0).stream().forEach(t -> {
            System.out.println("text: " + t);
            ReusableMethods.waitForText(t);
        });
    }

    @When("User writes email address")
    public void sendEmail() {
        allPage.registerPage().emailPlaceHolder.sendKeys(ConfigReader.getProperty("email"));
    }

    @When("User writes password")
    public void sendPassWord() {
        allPage.registerPage().emailPlaceHolder.sendKeys(ConfigReader.getProperty("passWord"));
    }

    @When("User writes retype password")
    public void reSendPassword() {
        allPage.registerPage().reTypePassWordPlaceHolder.sendKeys(ConfigReader.getProperty("rePassWord"));
    }

    @When("User clicks {string} button")
    public void clicksButton(String buttonName) {
        try {
            ReusableMethods.textWithClick(buttonName);
        } catch (Exception e) {
            ReusableMethods.scroolElementWithUiSelector(buttonName);
            ReusableMethods.textWithClick(buttonName);
        }
    }


}
