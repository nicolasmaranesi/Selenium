package Pages;

import org.openqa.selenium.By;

public class FinishPage extends Base{

    static By finishBanner = By.cssSelector(".subheader");




    public static void assertFinishBanner() throws Exception {
        wait(10);
        AssertText(driver,finishBanner,"Finish");
    }
}
