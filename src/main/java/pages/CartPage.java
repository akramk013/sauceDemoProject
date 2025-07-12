package pages;

import base.BasePage;
import bylocators.CartPageLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "title")
    private WebElement cartTitle;

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    @FindBy(className = "cart_item_label")
    private List<WebElement> cartItemLabels;

    @FindBy(className = "cart_quantity")
    private List<WebElement> cartQuantities;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> cartItemNames;

    @FindBy(className = "inventory_item_desc")
    private List<WebElement> cartItemDescs;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> cartItemPrices;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = "[data-test^='remove']")
    private List<WebElement> removeButtons;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    public CartPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    // Page actions
    public void clickContinueShopping() {
        click(continueShoppingButton);
    }

    public void clickCheckout() {
        click(checkoutButton);
    }

    public void removeItem(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < removeButtons.size()) {
            click(removeButtons.get(itemIndex));
        }
    }

    // Page information
    public String getCartTitle() {
        return getText(cartTitle);
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public String getCartBadgeCount() {
        if (isElementDisplayed(cartBadge)) {
            return getText(cartBadge);
        }
        return "0";
    }

    // Item information
    public String getItemName(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < cartItemNames.size()) {
            return getText(cartItemNames.get(itemIndex));
        }
        return null;
    }

    public String getItemDescription(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < cartItemDescs.size()) {
            return getText(cartItemDescs.get(itemIndex));
        }
        return null;
    }

    public String getItemPrice(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < cartItemPrices.size()) {
            return getText(cartItemPrices.get(itemIndex));
        }
        return null;
    }

    public String getItemQuantity(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < cartQuantities.size()) {
            return getText(cartQuantities.get(itemIndex));
        }
        return null;
    }

    // Specific product removal
    public void removeSauceLabsBackpack() {
        click(CartPageLocators.REMOVE_SAUCE_LABS_BACKPACK);
    }

    public void removeSauceLabsBikeLight() {
        click(CartPageLocators.REMOVE_SAUCE_LABS_BIKE_LIGHT);
    }

    public void removeSauceLabsBoltTshirt() {
        click(CartPageLocators.REMOVE_SAUCE_LABS_BOLT_TSHIRT);
    }

    public void removeSauceLabsFleeceJacket() {
        click(CartPageLocators.REMOVE_SAUCE_LABS_FLEECE_JACKET);
    }

    public void removeSauceLabsOnesie() {
        click(CartPageLocators.REMOVE_SAUCE_LABS_ONESIE);
    }

    public void removeTestAllTheThingsTshirt() {
        click(CartPageLocators.REMOVE_TEST_ALL_THE_THINGS_TSHIRT);
    }

    // Validation methods
    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }

    public boolean isCartEmptyMessageDisplayed() {
        return isElementDisplayed(CartPageLocators.EMPTY_CART_MESSAGE);
    }

    public boolean isItemInCart(String itemName) {
        for (WebElement name : cartItemNames) {
            if (getText(name).equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isContinueShoppingButtonDisplayed() {
        return isElementDisplayed(continueShoppingButton);
    }

    public boolean isCheckoutButtonDisplayed() {
        return isElementDisplayed(checkoutButton);
    }

    public boolean isCheckoutButtonEnabled() {
        return checkoutButton.isEnabled();
    }

    // Page verification
    public boolean isCartPageDisplayed() {
        return isElementDisplayed(CartPageLocators.CART_TITLE) &&
                getText(cartTitle).equals("Your Cart");
    }

    // Get all item names
    public List<String> getAllItemNames() {
        return cartItemNames.stream()
                .map(this::getText)
                .toList();
    }

    // Get all item prices
    public List<String> getAllItemPrices() {
        return cartItemPrices.stream()
                .map(this::getText)
                .toList();
    }

    // Remove all items
    public void removeAllItems() {
        for (WebElement removeButton : removeButtons) {
            click(removeButton);
        }
    }
}
