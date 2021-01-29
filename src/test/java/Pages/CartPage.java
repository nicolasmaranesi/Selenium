package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartPage extends Base {

    static By continueShoppingButton = By.xpath("//a[contains(text(),'Continue Shopping')]");
    static By elementsRemoveToCart = By.xpath("//button[contains(.,'REMOVE')]");
    static By firstProductRemoveButton = By.cssSelector(".cart_item:nth-child(3) .btn_secondary");
    static By cartBanner = By.cssSelector(".subheader");
    static By checkoutButton = By.xpath("//a[contains(text(),'CHECKOUT')]");




    public static void continueShopping() throws Exception {
        wait(10);
        Click(continueShoppingButton);
        wait(10);
    }

    public static void removeItem() throws Exception {
        wait(10);
        int numberOfProducts = 0;
        List<WebElement> products = driver.findElements(elementsRemoveToCart);
        for (WebElement ignored : products){
            numberOfProducts++;
            wait(2);
        }
        String firstAmountOfProduct = Integer.toString(numberOfProducts);

        Click(firstProductRemoveButton);

        for (WebElement ignored : products){
            numberOfProducts++;
            wait(2);
        }
        String lastAmountOfProduct = Integer.toString(numberOfProducts);
        Assert.assertNotEquals(firstAmountOfProduct,lastAmountOfProduct);

    }

    public static void assertCartBanner() throws Exception {
        wait(10);
        AssertText(driver,cartBanner,"Your Cart");
    }

    public static void checkuout() throws Exception {
        wait(10);
        Click(checkoutButton);
        wait(10);
    }
}
