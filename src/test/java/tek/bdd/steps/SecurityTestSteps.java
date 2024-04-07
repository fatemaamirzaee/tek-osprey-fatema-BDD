package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.LoginPage;

import tek.bdd.utility.SeleniumUtilities;

public class SecurityTestSteps extends SeleniumUtilities {
    @Given("navigate to sign in page")
    public void navigatetosigninpage() {
       clickElement(HomePage.SING_IN_BUTTON);

    }
    @When("use valid username and password")
    public void usevalidusernameandpassword() {
        sendTextToElement(LoginPage.EMAIL_INPUT, "mohammad_osprey@tekschool.us");
        sendTextToElement(LoginPage.PASSWORD_INPUT, "12345678Ab@");
        clickElement(LoginPage.LOGIN_BUTTON);

    }
    @Then("validate user can successfully sign in and validate account button on home page")
    public void validateaccountpage() {
        boolean isDisplayed = isElementDisplayed(HomePage.ACCOUNT_LINK);
        Assert.assertTrue(isDisplayed);

    }
    @Then("validate error message {string}")
    public void validateErrorMessage(String expectedErrorMessage) {
        String actualError = getElementText(LoginPage.ERROR_MESSAGE);

        Assert.assertEquals(expectedErrorMessage, actualError);
    }
}
