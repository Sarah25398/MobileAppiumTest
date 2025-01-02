package stepDefinitionAndroid;

import Android.verifySideMenu;
import io.cucumber.java.en.Then;

import java.net.URISyntaxException;

public class sideMenuVerification {
    verifySideMenu sideMenuCommand = new verifySideMenu();
    @Then("^I verify Menu Items$")
    public void verify_menu_item() throws URISyntaxException {
        sideMenuCommand.sideMenuItemVerify();
    }
}
