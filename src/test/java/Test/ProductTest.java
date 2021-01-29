package Test;

import Data.UserData;
import Pages.CartPage;
import Pages.IndexPage;
import Pages.LoginPage;
import Utils.BaseClass;
import org.testng.annotations.Test;

public class ProductTest extends BaseClass {
    UserData userData = new UserData();

    @Test(priority = 1)
    public void addOneProductToCart() throws Exception {
        test = extent.createTest("add One Product To Cart test");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addFirstProduct();
    }
    @Test(priority = 2)
    public void addAllProductsToCart() throws Exception {
        test = extent.createTest("add All Products To Cart test");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addAllProduct();
    }

    @Test(priority = 3)
    public void goToCart() throws Exception {
        test = extent.createTest("go to Cart test");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addFirstProduct();
        IndexPage.goToCart();
        CartPage.assertCartBanner();
    }


}
