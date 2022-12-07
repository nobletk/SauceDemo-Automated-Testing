package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.StepDefs.AbstractsStepDefs;

public class CommonStepDefs extends AbstractsStepDefs {
    @Given("the homepage is open")
    public void homePageIsOpened() {
        homePage.openPage();
    }

    @And("the React Burger Menu is clicked")
    public void theReactBurgerMenuIsClicked() {
        homePage.clickReactBurgerMenuButton();
    }

    @Given("the Reset App State is clicked")
    public void theResetAppStateIsClicked() {
        homePage.clickResetAppStateButton();
    }

    @And("the page is refreshed")
    public void refreshPage(){
        driver.navigate().refresh();
    }
}
