package my.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Inspired by: http://www.wunderkraut.com/blog/creating-and-running-a-simple-selenium-webdriver-test/2011-09-15
 */
public class MyTest {

    private HtmlUnitDriver driver;

    @Before
    public void openBrowser() {
        driver = new HtmlUnitDriver();
        driver.setJavascriptEnabled(true);
    }

    @After
    public void saveScreenshotAndCloseBrowser() throws IOException {
        // won't save screenshot with htmlUnit.
//        saveScreenshot("screenshot.png");
        driver.quit();
    }

    @Test
    public void loadBecomeEuTest() throws IOException {
        driver.get("https://my.become.eu/Pangora/Registration/index.jsf?language=de");
        assertEquals(driver.getTitle(), "ANMELDEN BEI BECOME");
        WebElement nameField = driver.findElement(By.id("helloForm:firstName"));
        assertEquals(nameField.getAttribute("name"), "helloForm:firstName");
//        System.out.print(driver.getPageSource());
    }

    public void saveScreenshot(String screenshotFileName) throws IOException {
        File screenshot = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(screenshotFileName));
    }
}

