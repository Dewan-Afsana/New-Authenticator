package WebStepDefination;

import Core.Helper;
import SearchPage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefination extends Helper {
    @Given("manager to the add customer page")
    public void managerToTheAddCustomerPage() {
       Helper hp = new Helper();
       hp.chrome();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--headless");

    }

    @When("manger enters {string} and {string} and {string}")
    public void mangerEntersFirstNameAndLastNameAndPostCode(String fName, String lName, String pCode) {
        LoginPage lp = new LoginPage(driver);
        lp.addCustomers(fName,lName,pCode);
    }

    @And("click add customer button")
    public void clickAddCustomerButton() {
        LoginPage lp = new LoginPage(driver);
        lp.clickButton();

    }

    @Then("manager will navigate to successful popup page")
    public void managerWillNavigateToSuccessfulPopupPage() {
        LoginPage lp = new LoginPage(driver);
        lp.popUp();

    }
}
