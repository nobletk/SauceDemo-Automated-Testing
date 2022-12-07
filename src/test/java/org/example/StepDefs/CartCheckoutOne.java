package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.junit.Assert;

public class CartCheckoutOne extends AbstractsStepDefs {

    @Given("the Sauce Labs Backpack is added to the cart")
    public void sauceLabsBackpackAddedToCart(){
        homePage.addBackPackToCart();
    }

    @And("the cart icon is clicked")
    public void cartIconClicked(){
        homePage.clickOnCart();
    }

    @And("the Checkout button is clicked")
    public void checkoutButtonClicked(){
        homePage.clickCheckoutButton();
    }

    @And("the First name is filled with {string}")
    public void firstNameFilled(String firstName){
        homePage.fillField(HomePage.FIRSTNAME, firstName);
    }

    @And("the Last name is filled with {string}")
    public void lastNameFilled(String lastName){
        homePage.fillField(HomePage.LASTNAME, lastName);
    }

    @And("the Zip code is filled with {string}")
    public void zipCodeFilled(String zipCode){
        homePage.fillField(HomePage.POSTAL_CODE, zipCode);
    }

    @When("the Continue button is clicked")
    public void continueButtonClicked(){
        homePage.clickContinueButton();
    }

    @Then("{string} should be shown as total price")
    public void total$ShouldBeShown(String total) {
        Assert.assertEquals(total, homePage.getTotal());
    }

    @And("the Sauce Labs Bike Light is added to the cart")
    public void theSauceLabsBikeLightIsAddedToTheCart() {
        homePage.addBikeLightToCart();
    }

    @Then("the number {string} should be showing on top of the shopping cart badge")
    public void shoppingCartBadgeNumber(String number) {
        Assert.assertEquals(number, homePage.getShoppingCartBadgeNumber());
    }

    @And("the Sauce Labs Backpack is removed from the cart")
    public void theSauceLabsBackpackIsRemovedFromTheCart() {
        homePage.removeBackpack();
    }

    @And("the Sauce Labs Bolt T-Shirt is added to the cart")
    public void theSauceLabsBoltTShirtIsAddedToTheCart() {
        homePage.addSauceLabsBoltShirtToCart();
    }

    @And("{string} should be shown as tax")
    public void tax$ShouldBeShownAsTax(String tax) {
        Assert.assertEquals(tax, homePage.getTax());
    }

    @And("{string} should be shown as an item total")
    public void itemTotal$ShouldBeShownAsAnItemTotal(String itemTotal) {
        Assert.assertEquals(itemTotal, homePage.getItemTotal());
    }
}
