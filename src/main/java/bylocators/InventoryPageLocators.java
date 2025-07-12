package bylocators;

import org.openqa.selenium.By;

public class InventoryPageLocators {

    // Header elements
    public static final By APP_LOGO = By.className("app_logo");
    public static final By SHOPPING_CART_BADGE = By.className("shopping_cart_badge");
    public static final By SHOPPING_CART_LINK = By.className("shopping_cart_link");
    public static final By BURGER_MENU = By.id("react-burger-menu-btn");
    public static final By BURGER_MENU_CLOSE = By.id("react-burger-cross-btn");

    // Product elements
    public static final By PRODUCT_TITLE = By.className("inventory_item_name");
    public static final By PRODUCT_DESCRIPTION = By.className("inventory_item_desc");
    public static final By PRODUCT_PRICE = By.className("inventory_item_price");
    public static final By ADD_TO_CART_BUTTON = By.cssSelector("[data-test^='add-to-cart']");
    public static final By REMOVE_BUTTON = By.cssSelector("[data-test^='remove']");
    public static final By PRODUCT_IMAGE = By.className("inventory_item_img");

    // Sort dropdown
    public static final By SORT_DROPDOWN = By.className("product_sort_container");
    public static final By SORT_NAME_A_TO_Z = By.cssSelector("option[value='az']");
    public static final By SORT_NAME_Z_TO_A = By.cssSelector("option[value='za']");
    public static final By SORT_PRICE_LOW_TO_HIGH = By.cssSelector("option[value='lohi']");
    public static final By SORT_PRICE_HIGH_TO_LOW = By.cssSelector("option[value='hilo']");

    // Product specific locators
    public static final By SAUCE_LABS_BACKPACK = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    public static final By SAUCE_LABS_BIKE_LIGHT = By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']");
    public static final By SAUCE_LABS_BOLT_TSHIRT = By.cssSelector("[data-test='add-to-cart-sauce-labs-bolt-t-shirt']");
    public static final By SAUCE_LABS_FLEECE_JACKET = By.cssSelector("[data-test='add-to-cart-sauce-labs-fleece-jacket']");
    public static final By SAUCE_LABS_ONESIE = By.cssSelector("[data-test='add-to-cart-sauce-labs-onesie']");
    public static final By TEST_ALL_THE_THINGS_TSHIRT = By.cssSelector("[data-test='add-to-cart-test.allthethings()-t-shirt-(red)']");

    // Remove buttons
    public static final By REMOVE_SAUCE_LABS_BACKPACK = By.cssSelector("[data-test='remove-sauce-labs-backpack']");
    public static final By REMOVE_SAUCE_LABS_BIKE_LIGHT = By.cssSelector("[data-test='remove-sauce-labs-bike-light']");
    public static final By REMOVE_SAUCE_LABS_BOLT_TSHIRT = By.cssSelector("[data-test='remove-sauce-labs-bolt-t-shirt']");
    public static final By REMOVE_SAUCE_LABS_FLEECE_JACKET = By.cssSelector("[data-test='remove-sauce-labs-fleece-jacket']");
    public static final By REMOVE_SAUCE_LABS_ONESIE = By.cssSelector("[data-test='remove-sauce-labs-onesie']");
    public static final By REMOVE_TEST_ALL_THE_THINGS_TSHIRT = By.cssSelector("[data-test='remove-test.allthethings()-t-shirt-(red)']");

    // Product links
    public static final By SAUCE_LABS_BACKPACK_LINK = By.cssSelector("[data-test='item-4-title-link']");
    public static final By SAUCE_LABS_BIKE_LIGHT_LINK = By.cssSelector("[data-test='item-0-title-link']");
    public static final By SAUCE_LABS_BOLT_TSHIRT_LINK = By.cssSelector("[data-test='item-1-title-link']");
    public static final By SAUCE_LABS_FLEECE_JACKET_LINK = By.cssSelector("[data-test='item-5-title-link']");
    public static final By SAUCE_LABS_ONESIE_LINK = By.cssSelector("[data-test='item-2-title-link']");
    public static final By TEST_ALL_THE_THINGS_TSHIRT_LINK = By.cssSelector("[data-test='item-3-title-link']");

    // Inventory container
    public static final By INVENTORY_CONTAINER = By.id("inventory_container");
    public static final By INVENTORY_LIST = By.className("inventory_list");
    public static final By INVENTORY_ITEM = By.className("inventory_item");

    // Footer
    public static final By FOOTER = By.className("footer");
    public static final By SOCIAL_TWITTER = By.cssSelector(".social_twitter a");
    public static final By SOCIAL_FACEBOOK = By.cssSelector(".social_facebook a");
    public static final By SOCIAL_LINKEDIN = By.cssSelector(".social_linkedin a");
}