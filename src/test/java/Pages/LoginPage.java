package Pages;

import Utils.BaseClass;
import Utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage extends Base{

    static By userField = By.id("user-name");
    static By passwordField = By.id("password");
    static By loginButton = By.id("login-button");
    static By errorMessage = By.cssSelector("*[data-test=\"error\"]");


    public static void login(String user, String password) throws Exception {
        driver = BaseClass.getDriver();
        wait(5);
        Type(user,userField);
        wait(1);
        Type(password,passwordField);
        wait(1);
        Click(loginButton);
    }

    public static void emptyLogin() throws Exception {
        driver = BaseClass.getDriver();
        Click(loginButton);
        AssertText(driver,errorMessage,"Epic sadface: Username is required");
    }

    public static void lockedLogin(String user, String password) throws Exception {
        driver = BaseClass.getDriver();
        wait(5);
        Type(user,userField);
        wait(1);
        Type(password,passwordField);
        wait(1);
        Click(loginButton);
        wait(3);
        AssertText(driver,errorMessage,"Epic sadface: Sorry, this user has been locked out.");
    }


}
