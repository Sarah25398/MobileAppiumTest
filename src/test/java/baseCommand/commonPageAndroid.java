package baseCommand;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class commonPageAndroid {

    public static AndroidDriver driver;

    public void startAndroidApp() throws URISyntaxException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", "com.studiobluelime.ecommerceapp");
        capabilities.setCapability("appium:appActivity", "com.studiobluelime.ecommerceapp.WelcomeActivity");

        try {
            driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitForElementToVisible(String xpath){
        FluentWait<AndroidDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(xpath)));
    }

    public void clickAndroidElementByXpath(String xpath){
        this.waitForElementToVisible(xpath);
        driver.findElement(AppiumBy.xpath(xpath)).click();
    }

    public void assertElementText(String xpath, String content){
        this.waitForElementToVisible(xpath);
        var actualString = driver.findElement(AppiumBy.xpath(xpath)).getText();
        Assert.assertEquals(actualString, content);
    }
}
