package Pages;

import org.openqa.selenium.By;

public class OverviewPage extends Base{

    static By checkoutBanner = By.cssSelector(".subheader");
    static By cancelButton = By.xpath("//a[contains(text(),'CANCEL')]");
    static By finishButton = By.xpath("//a[contains(text(),'FINISH')]");




    public static void assertOverviewBanner() throws Exception {
        wait(10);
        AssertText(driver,checkoutBanner,"Checkout: Overview");
    }

    public static void cancelOverview() throws Exception {
        wait(10);
        Click(cancelButton);
    }

    public static void finishOverview() throws Exception {
        wait(10);
        Click(finishButton);
    }
}
