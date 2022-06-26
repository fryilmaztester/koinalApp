package pages;


public class AllPage {

    public AllPage() {
    }


    private RegisterPage registerPage;
    private LoginPage loginPage;


    public RegisterPage registerPage() {
        if (registerPage == null) {
            registerPage = new RegisterPage();
        }
        return registerPage;
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }


}
