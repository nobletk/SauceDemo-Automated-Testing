package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.Pages.HomePage;
import org.example.StepDefs.AbstractsStepDefs;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class LoginStepDefs extends AbstractsStepDefs {
    @And("the Username is filled with {string}")
    public void usernameIsFilledWithStandard_user(String username){
        homePage.fillField(HomePage.USERNAME, username);
    }

    @And("the Password is filled with {string}")
    public void passwordIsFilledWithSecret_sauce(String password){
        homePage.fillField(HomePage.PASSWORD, password);
    }

    @And("the login button is clicked")
    public void loginButtonClicked(){
        homePage.clickLoginButton();
    }

    @Then("the {string} error message is shown")
    public void theMsgErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getLoginError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }
}
