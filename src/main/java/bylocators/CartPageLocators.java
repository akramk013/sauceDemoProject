package bylocators;


import org.openqa.selenium.By;

public class CartPageLocators {

    // Cart page elements
    public static final By CART_TITLE = By.className("title");
    public static final By CART_ITEM = By.className("cart_item");
    public static final By CART_ITEM_LABEL = By.className("cart_item_label");
    public static final By CART_QUANTITY = By.className("cart_quantity");
    public static final By CART_ITEM_NAME = By.className("inventory_item_name");
    public static final By CART_ITEM_DESC = By.className("inventory_item_desc");
    public static final By CART_ITEM_PRICE = By.className("inventory_item_price");

    // Buttons
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By REMOVE_BUTTON = By.cssSelector("[data-test^='remove']");

    // Specific product remove buttons
    public static final By REMOVE_SAUCE_LABS_BACKPACK = By.cssSelector("[data-test='remove-sauce-labs-backpack']");
    public static final By REMOVE_SAUCE_LABS_BIKE_LIGHT = By.cssSelector("[data-test='remove-sauce-labs-bike-light']");
    public static final By REMOVE_SAUCE_LABS_BOLT_TSHIRT = By.cssSelector("[data-test='remove-sauce-labs-bolt-t-shirt']");
    public static final By REMOVE_SAUCE_LABS_FLEECE_JACKET = By.cssSelector("[data-test='remove-sauce-labs-fleece-jacket']");
    public static final By REMOVE_SAUCE_LABS_ONESIE = By.cssSelector("[data-test='remove-sauce-labs-onesie']");
    public static final By REMOVE_TEST_ALL_THE_THINGS_TSHIRT = By.cssSelector("[data-test='remove-test.allthethings()-t-shirt-(red)']");

    // Empty cart
    public static final By EMPTY_CART_MESSAGE = By.xpath("//div[@class='cart_list']//div[contains(text(),'Your cart is empty')]");

    // Cart badge
    public static final By CART_BADGE = By.className("shopping_cart_badge");

    // Navigation
    public static final By BACK_TO_PRODUCTS = By.id("back-to-products");
}
