package Pages;

import Utils.BaseClass;
import Utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IndexPage extends Base{

    static By banner = By.cssSelector(".product_label");
    static By firstCartButton = By.cssSelector(".inventory_item:nth-child(1) .btn_primary");
    static By productsCounter = By.cssSelector(".fa-layers-counter");
    static By elementsAddToCart = By.xpath("//button[contains(.,'ADD TO CART')]");
    static By cart = By.cssSelector("path");




    public static void assertProductBanner() throws Exception {
        wait(10);
        AssertText(driver,banner,"Products");
    }

    public static void addFirstProduct() throws Exception {
        wait(10);
        Click(firstCartButton);
        AssertText(driver,productsCounter,"1");
    }

    public static void addAllProduct() throws Exception {
        wait(10);
        int numberOfProducts = 0;
        List<WebElement> products = driver.findElements(elementsAddToCart);
        for (WebElement ignored : products){
            numberOfProducts++;
            Click(elementsAddToCart);
            wait(2);

        }
        String numberOfProduct = Integer.toString(numberOfProducts);
        AssertText(driver,productsCounter,numberOfProduct);
    }
    public static void goToCart() throws Exception {
        wait(10);
        Click(cart);
    }

}
