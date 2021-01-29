package Test;

import Data.UserData;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.IndexPage;
import Pages.LoginPage;
import Utils.BaseClass;
import org.testng.annotations.Test;

public class CartTests extends BaseClass {
    UserData userData = new UserData();

    @Test(priority = 7)
    public void continueShoppingButtonFunction() throws Exception {
        test = extent.createTest("continue Shopping Button Function");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addFirstProduct();
        IndexPage.goToCart();
        CartPage.continueShopping();
        IndexPage.assertProductBanner();
    }
    @Test(priority = 8)
    public void removeProductFromCart() throws Exception {
        test = extent.createTest("remove Product From Cart");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addAllProduct();
        IndexPage.goToCart();
        CartPage.removeItem();
    }
    @Test(priority = 9)
    public void checkoutButtonFunction() throws Exception {
        test = extent.createTest("checkout Button Function");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addFirstProduct();
        IndexPage.goToCart();
        CartPage.checkuout();
        CheckoutPage.assertCheckoutBanner();
    }
}
