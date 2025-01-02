package Android;

import baseCommand.commonPageAndroid;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class goToHomePage extends commonPageAndroid {

    @Test
    public void verifyGoToHomePageByNext() throws URISyntaxException {
        commonPageAndroid command = new commonPageAndroid();
        command.startAndroidApp();
        command.clickAndroidElementByXpath("//android.widget.Button[@resource-id=\"com.studiobluelime.ecommerceapp:id/btn_next\"]\n");
        command.clickAndroidElementByXpath("//android.widget.Button[@resource-id=\"com.studiobluelime.ecommerceapp:id/btn_next\"]\n");
        command.clickAndroidElementByXpath("//android.widget.Button[@resource-id=\"com.studiobluelime.ecommerceapp:id/btn_next\"]\n");
        command.assertElementText("//android.widget.TextView[@text=\"eCommerce App\"]\n", "eCommerce App");
    }

    @Test
    public void VerifyHomePageItems() throws  URISyntaxException {
        commonPageAndroid command = new commonPageAndroid();
        verifyGoToHomePageByNext();
        String[] ItemsClicks = {"Clothing","Groceries"};
        for(String ItemsClick : ItemsClicks){
            var element = "//android.widget.TextView[@resource-id=\"com.studiobluelime.ecommerceapp:id/tv_android\" and @text=\""+ItemsClick+"\"]\n";
            command.waitForElementToVisible(element);
            command.assertElementText(element,ItemsClick);
        }

    }
    @Test
    public void ClothingPageClick() throws URISyntaxException {
        commonPageAndroid command = new commonPageAndroid();
        verifyGoToHomePageByNext();
        var el = "//android.widget.TextView[@resource-id=\"com.studiobluelime.ecommerceapp:id/tv_android\" and @text=\"Clothing\"]";
        command.waitForElementToVisible(el);
        command.clickAndroidElementByXpath(el);
        String[] ClothingItems = {"Kids","Men","Women"};
        for(String ClothingItem: ClothingItems ){
            var ClothingChoiceEl ="//android.widget.TextView[@resource-id=\"com.studiobluelime.ecommerceapp:id/tv_android\" and @text=\""+ClothingItem+"\"]\n";
            command.waitForElementToVisible(ClothingChoiceEl);
            command.assertElementText(ClothingChoiceEl,ClothingItem);
        }


    }


    @Test
    public void verifyGoToHomePageBySkip() throws URISyntaxException {
        commonPageAndroid command = new commonPageAndroid();
        command.startAndroidApp();
        command.clickAndroidElementByXpath("//android.widget.Button[@resource-id=\"com.studiobluelime.ecommerceapp:id/btn_skip\"]\n");
        command.assertElementText("//android.widget.TextView[@text=\"eCommerce App\"]\n", "eCommerce App");
    }
}
