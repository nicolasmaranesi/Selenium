package Test;

import Data.UserData;
import Pages.*;
import Utils.BaseClass;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseClass {
    UserData userData = new UserData();

    @Test(priority = 10)
    public void assertFirstNameError() throws Exception {
        test = extent.createTest("assert First Name Error");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addFirstProduct();
        IndexPage.goToCart();
        CartPage.checkuout();
        CheckoutPage.clickContinueButton();
        CheckoutPage.assertFirstNameError();
    }

    @Test(priority = 11)
    public void assertLastNameError() throws Exception {
        test = extent.createTest("assert Last Name Error");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addFirstProduct();
        IndexPage.goToCart();
        CartPage.checkuout();
        CheckoutPage.inputFirstName();
        CheckoutPage.clickContinueButton();
        CheckoutPage.assertLastNameError();
    }

    @Test(priority = 12)
    public void assertZipCodeError() throws Exception {
        test = extent.createTest("assert Zip Code Error");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addFirstProduct();
        IndexPage.goToCart();
        CartPage.checkuout();
        CheckoutPage.inputFirstName();
        CheckoutPage.inputLastName();
        CheckoutPage.clickContinueButton();
        CheckoutPage.assertZipCodeError();
    }

    @Test(priority = 13)
    public void cancelCheckout() throws Exception {
        test = extent.createTest("cancel Checkout");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addFirstProduct();
        IndexPage.goToCart();
        CartPage.checkuout();
        CheckoutPage.inputFirstName();
        CheckoutPage.cancelCheckout();
        CartPage.assertCartBanner();
    }

    @Test(priority = 14)
    public void continueCheckout() throws Exception {
        test = extent.createTest("continue Checkout");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addFirstProduct();
        IndexPage.goToCart();
        CartPage.checkuout();
        CheckoutPage.clickContinueButton();
        CheckoutPage.inputFirstName();
        CheckoutPage.inputLastName();
        CheckoutPage.inputZipCode();
        CheckoutPage.clickContinueButton();
        OverviewPage.assertOverviewBanner();
    }

}
