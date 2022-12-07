package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class HomePage {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

    public static final By USERNAME = By.id("user-name");

    public static final By PASSWORD = By.id("password");

    public static final By FIRSTNAME = By.id("first-name");

    public static final By LASTNAME = By.id("last-name");

    public static final By POSTAL_CODE = By.id("postal-code");

    public static final By LOGIN_ERROR =  By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeLightToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addSauceLabsBoltShirtToCartButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "first-name")
    private WebElement firstname;

    @FindBy(id = "last-name")
    private WebElement lastname;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(className = "summary_total_label")
    private WebElement totalLabel;

    @FindBy(className = "summary_tax_label")
    private WebElement taxLabel;

    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotalLabel;
    @FindBy(className = "product_sort_container")
    private WebElement productSortButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]")
    private  WebElement nameZTOAButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
    private  WebElement lowToHighButton;
    @FindBy(xpath = "//*[@id=\"item_3_title_link\"]/div")
    private WebElement tShirtRed;

    @FindBy(xpath = "//*[@id=\"item_2_title_link\"]/div")
    private WebElement sauceLabsOnesie;

    @FindBy(xpath = "//*[@id=\"item_5_title_link\"]/div")
    private WebElement sauceLabsFleeceJacket;

    @FindBy(xpath = "//*[@id=\"item_1_title_link\"]/div")
    private WebElement sauceLabsBoltTShirt;

    @FindBy(xpath = "//*[@id=\"item_0_title_link\"]/div")
    private WebElement sauceLabsBikeLight;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private WebElement sauceLabsBackpack;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackButton;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(){
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private WebElement reactBurgerMenuButton;
    @FindBy(xpath = "//*[@id=\"reset_sidebar_link\"]")
    private WebElement resetAppStateButton;

    @FindAll({@FindBy(css = "#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div")})
    private List<WebElement> priceList;

    public void fillField(By locator, String value) {
        getField(locator).sendKeys(value);
    }

    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickReactBurgerMenuButton(){
        reactBurgerMenuButton.click();
    }

    public void clickResetAppStateButton(){
        resetAppStateButton.click();
    }

    public void addBackPackToCart(){
        addBackpackToCartButton.click();
    }

    public void addBikeLightToCart() {
        addBikeLightToCartButton.click();
    }

    public void addSauceLabsBoltShirtToCart() {
        addSauceLabsBoltShirtToCartButton.click();
    }
    public void removeBackpack(){
        removeBackpackButton.click();
    }

    public void clickOnCart(){
        shoppingCartLink.click();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void clickProductSortButton(){
        productSortButton.click();
    }

    public void clickNameZToAButton() {
        nameZTOAButton.click();
    }

    public void clickLowToHighButton() {
        lowToHighButton.click();
    }

    public String getTotal(){
        return totalLabel.getText();
    }

    public Optional <String> getLoginError(){
        return getErrorMessage(LOGIN_ERROR);
    }

    private Optional<String> getErrorMessage(By errorLocator) {
        Optional<WebElement> error = getError(errorLocator);
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }

    private Optional<WebElement> getError(By errorLocator) {
        List<WebElement> elements = driver.findElements(errorLocator);
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }

    public ArrayList<String> getProductListSorted(){
        ArrayList<String> productList = new ArrayList();
        productList.add(tShirtRed.getText());
        productList.add(sauceLabsOnesie.getText());
        productList.add(sauceLabsFleeceJacket.getText());
        productList.add(sauceLabsBoltTShirt.getText());
        productList.add(sauceLabsBikeLight.getText());
        productList.add(sauceLabsBackpack.getText());

        Collections.sort(productList);
        return productList;
    }

    public ArrayList<String> getPriceListSorted(){
        ArrayList<String> sortList = new ArrayList<>();
        for(WebElement element: priceList){
            sortList.add(element.getText());
        }
        Collections.sort(sortList);
        return sortList;
    }

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement shoppingCartBadgeNumber;

    public String getShoppingCartBadgeNumber() {
        return shoppingCartBadgeNumber.getText();
    }

    public String getTax() {
        return taxLabel.getText();
    }

    public String getItemTotal() {
        return itemTotalLabel.getText();
    }
}
