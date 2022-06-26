package stepdefinitions;

import io.cucumber.java.en.When;
import pages.AllPage;
import utilities.ConfigReader;

public class LoginStepDefinitions {


    AllPage allPage = new AllPage();

    @When("User writes email address for login")
    public void emailForLogin() {
      allPage.loginPage().loginEmail.sendKeys(ConfigReader.getProperty("email"));
    }


    @When("User writes password for login")
    public void passWordForLogin() {
        allPage.loginPage().loginPassword.sendKeys(ConfigReader.getProperty("passWord"));
    }

}
