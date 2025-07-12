package pages;


import base.BasePage;
import bylocators.InventoryPageLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(className = "app_logo")
    private WebElement appLogo;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement burgerMenuClose;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productTitles;

    @FindBy(className = "inventory_item_desc")
    private List<WebElement> productDescriptions;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPrices;

    @FindBy(css = "[data-test^='add-to-cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(css = "[data-test^='remove']")
    private List<WebElement> removeButtons;

    @FindBy(className = "inventory_item_img")
    private List<WebElement> productImages;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(id = "inventory_container")
    private WebElement inventoryContainer;

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    public InventoryPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    // Header actions
    public void clickShoppingCart() {
        click(shoppingCartLink);
    }

    public void clickBurgerMenu() {
        click(burgerMenu);
    }

    public void closeBurgerMenu() {
        click(burgerMenuClose);
    }

    public boolean isAppLogoDisplayed() {
        return isElementDisplayed(appLogo);
    }

    public boolean isShoppingCartBadgeDisplayed() {
        return isElementDisplayed(shoppingCartBadge);
    }

    public String getShoppingCartBadgeCount() {
        return getText(shoppingCartBadge);
    }

    // Product actions
    public void addProductToCart(int productIndex) {
        if (productIndex >= 0 && productIndex < addToCartButtons.size()) {
            click(addToCartButtons.get(productIndex));
        }
    }

    public void removeProductFromCart(int productIndex) {
        if (productIndex >= 0 && productIndex < removeButtons.size()) {
            click(removeButtons.get(productIndex));
        }
    }

    public void clickProductTitle(int productIndex) {
        if (productIndex >= 0 && productIndex < productTitles.size()) {
            click(productTitles.get(productIndex));
        }
    }

    public void clickProductImage(int productIndex) {
        if (productIndex >= 0 && productIndex < productImages.size()) {
            click(productImages.get(productIndex));
        }
    }

    // Product information
    public String getProductTitle(int productIndex) {
        if (productIndex >= 0 && productIndex < productTitles.size()) {
            return getText(productTitles.get(productIndex));
        }
        return null;
    }

    public String getProductDescription(int productIndex) {
        if (productIndex >= 0 && productIndex < productDescriptions.size()) {
            return getText(productDescriptions.get(productIndex));
        }
        return null;
    }

    public String getProductPrice(int productIndex) {
        if (productIndex >= 0 && productIndex < productPrices.size()) {
            return getText(productPrices.get(productIndex));
        }
        return null;
    }

    public int getProductCount() {
        return inventoryItems.size();
    }

    // Sorting functionality
    public void sortByNameAtoZ() {
        selectByValue(sortDropdown, "az");
    }

    public void sortByNameZtoA() {
        selectByValue(sortDropdown, "za");
    }

    public void sortByPriceLowToHigh() {
        selectByValue(sortDropdown, "lohi");
    }

    public void sortByPriceHighToLow() {
        selectByValue(sortDropdown, "hilo");
    }

    public String getCurrentSortOption() {
        return getAttribute(sortDropdown, "value");
    }

    // Specific product actions
    public void addSauceLabsBackpack() {
        click(InventoryPageLocators.SAUCE_LABS_BACKPACK);
    }

    public void addSauceLabsBikeLight() {
        click(InventoryPageLocators.SAUCE_LABS_BIKE_LIGHT);
    }

    public void addSauceLabsBoltTshirt() {
        click(InventoryPageLocators.SAUCE_LABS_BOLT_TSHIRT);
    }

    public void addSauceLabsFleeceJacket() {
        click(InventoryPageLocators.SAUCE_LABS_FLEECE_JACKET);
    }

    public void addSauceLabsOnesie() {
        click(InventoryPageLocators.SAUCE_LABS_ONESIE);
    }

    public void addTestAllTheThingsTshirt() {
        click(InventoryPageLocators.TEST_ALL_THE_THINGS_TSHIRT);
    }

    // Remove specific products
    public void removeSauceLabsBackpack() {
        click(InventoryPageLocators.REMOVE_SAUCE_LABS_BACKPACK);
    }

    public void removeSauceLabsBikeLight() {
        click(InventoryPageLocators.REMOVE_SAUCE_LABS_BIKE_LIGHT);
    }

    public void removeSauceLabsBoltTshirt() {
        click(InventoryPageLocators.REMOVE_SAUCE_LABS_BOLT_TSHIRT);
    }

    public void removeSauceLabsFleeceJacket() {
        click(InventoryPageLocators.REMOVE_SAUCE_LABS_FLEECE_JACKET);
    }

    public void removeSauceLabsOnesie() {
        click(InventoryPageLocators.REMOVE_SAUCE_LABS_ONESIE);
    }

    public void removeTestAllTheThingsTshirt() {
        click(InventoryPageLocators.REMOVE_TEST_ALL_THE_THINGS_TSHIRT);
    }

    // Page verification
    public boolean isInventoryPageDisplayed() {
        return isElementDisplayed(InventoryPageLocators.INVENTORY_CONTAINER) &&
                isElementDisplayed(InventoryPageLocators.SORT_DROPDOWN);
    }

    public boolean isProductDisplayed(String productName) {
        for (WebElement title : productTitles) {
            if (getText(title).equals(productName)) {
                return true;
            }
        }
        return false;
    }

    // Get all product titles
    public List<String> getAllProductTitles() {
        return productTitles.stream()
                .map(this::getText)
                .toList();
    }

    // Get all product prices
    public List<String> getAllProductPrices() {
        return productPrices.stream()
                .map(this::getText)
                .toList();
    }
}
