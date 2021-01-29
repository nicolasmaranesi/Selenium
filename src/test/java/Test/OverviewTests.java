package Test;

import Data.UserData;
import Pages.*;
import Utils.BaseClass;
import org.testng.annotations.Test;

public class OverviewTests extends BaseClass {
    UserData userData = new UserData();

    @Test(priority = 15)
    public void cancelOverview() throws Exception {
        test = extent.createTest("cancel Overview test");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addFirstProduct();
        IndexPage.goToCart();
        CartPage.checkuout();
        CheckoutPage.clickContinueButton();
        CheckoutPage.inputFirstName();
        CheckoutPage.inputLastName();
        CheckoutPage.inputZipCode();
        CheckoutPage.clickContinueButton();
        OverviewPage.cancelOverview();
        IndexPage.assertProductBanner();

    }
    @Test(priority = 16)
    public void completeOrder() throws Exception {
        test = extent.createTest("complete Order test");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.addFirstProduct();
        IndexPage.goToCart();
        CartPage.checkuout();
        CheckoutPage.clickContinueButton();
        CheckoutPage.inputFirstName();
        CheckoutPage.inputLastName();
        CheckoutPage.inputZipCode();
        CheckoutPage.clickContinueButton();
        OverviewPage.finishOverview();
        FinishPage.assertFinishBanner();
    }
}
