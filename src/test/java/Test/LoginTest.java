package Test;

import Data.UserData;
import Pages.IndexPage;
import Pages.LoginPage;
import Utils.BaseClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    UserData userData = new UserData();

    @Test(priority = 1)
    public void correctLogin() throws Exception {
        test = extent.createTest("correct login test");
        LoginPage.login(userData.standardUser(),userData.genericPassword());
        IndexPage.assertProductBanner();
    }

    @Test(priority = 2)
    public void emptyFieldLogin() throws Exception {
        test = extent.createTest("empty fields login Test");
        LoginPage.emptyLogin();
    }

    @Test(priority = 3)
    public void lockedLogin() throws Exception {
        test = extent.createTest("locked user login Test");
        LoginPage.lockedLogin(userData.lockedUser(),userData.genericPassword());
    }

}
