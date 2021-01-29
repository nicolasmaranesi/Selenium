package Pages;

import org.openqa.selenium.By;

public class CheckoutPage extends Base{

    static By checkoutBanner = By.cssSelector(".subheader");
    static By cancelButton = By.xpath("//a[contains(text(),'CANCEL')]");
    static By continueButton = By.xpath("//input[@value='CONTINUE']");
    static By errorMessage = By.cssSelector("*[data-test=\"error\"]");
    static By firstNameTextField = By.id("first-name");
    static By lastNameTextField = By.id("last-name");
    static By zipCodeTextField = By.id("postal-code");




    public static void assertCheckoutBanner() throws Exception {
        wait(10);
        AssertText(driver,checkoutBanner,"Checkout: Your Information");
    }

    public static void cancelCheckout() throws Exception {
        wait(10);
        Click(cancelButton);
    }

    public static void clickContinueButton() throws Exception {
        wait(10);
        Click(continueButton);
    }

    public static void assertFirstNameError() throws Exception {
        wait(10);
        AssertText(driver,errorMessage,"Error: First Name is required");
    }

    public static void inputFirstName() throws Exception {
        wait(10);
        Click(firstNameTextField);
        Type("Nicolas",firstNameTextField);
    }

    public static void assertLastNameError() throws Exception {
        wait(10);
        AssertText(driver,errorMessage,"Error: Last Name is required");
    }

    public static void inputLastName() throws Exception {
        wait(10);
        Click(lastNameTextField);
        Type("Maranesi",lastNameTextField);
    }

    public static void assertZipCodeError() throws Exception {
        wait(10);
        AssertText(driver,errorMessage,"Error: Postal Code is required");
    }

    public static void inputZipCode() throws Exception {
        wait(10);
        Click(zipCodeTextField);
        Type("B1655",zipCodeTextField);
    }

}
