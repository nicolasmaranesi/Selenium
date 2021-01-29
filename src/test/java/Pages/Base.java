package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static void Click(By locator) throws Exception {
        try {
            driver.findElement(locator).click();
        } catch (Exception e) {
            throw new Exception("No se pudo clickear sobre el elemento: " + locator);
        }
    }

    public static void Type(String inputText, By locator) throws Exception {
        try {
            driver.findElement(locator).sendKeys(inputText);
        } catch (Exception e) {
            throw new Exception("No se pudo escribir sobre el elemento: " + locator);
        }
    }

    public static void SubmitField(Keys inputText, By locator) throws Exception {
        try {
            driver.findElement(locator).sendKeys(inputText);
        } catch (Exception e) {
            throw new Exception("No se pudo : " + locator);
        }
    }

    public static void wait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }


    public static void AssertText(WebDriver driver, By locator, String elementText) {
        WebElement element = driver.findElement(locator);
        String actualString = element.getText();
        Assert.assertTrue(actualString.contains(elementText));
    }

    public static void AssertElementIsPresent(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertEquals(true, element.isDisplayed());
    }

    public static void Clear(By locator) throws Exception {
        try {
            driver.findElement(locator).clear();
        } catch (Exception e) {
            throw new Exception("No se pudo borrar el texto del elemento: " + locator);
        }
    }
}
