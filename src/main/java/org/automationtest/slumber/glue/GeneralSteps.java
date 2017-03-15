package org.automationtest.slumber.glue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.automationtest.slumber.config.InitDriver;
import org.automationtest.slumber.web.Actions;
import org.automationtest.slumber.web.Browser;
import org.automationtest.slumber.web.WebObjects;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;

/**
 * This class contains all general steps
 */
public class GeneralSteps {
    private WebObjects webObjects;
    private Browser browser;
    private InitDriver initDriver;
    private WebDriver webDriver;
    private Actions actions;

    /**
     * Constructor
     */
    public GeneralSteps() {
        initDriver = new InitDriver();
        webDriver = initDriver.getDriver();
        webObjects = new WebObjects(webDriver);
        actions = new Actions(webDriver, webObjects);
    }

    /**
     * Given I open a browser
     */
    @Given("I open a browser")
    public void I_open_a_browser() {
        browser = new Browser(webDriver);
    }

    /**
     * When I go to this URL URL
     * @param URL
     */
    @When("I go to this URL (.*)")
    public void I_go_to_this_URL(String URL) {
        browser.openURL(URL);
    }

    /**
     * When I click on this "objectName"
     * @param objectName Object to be manipulated
     */
    @When("I click on this \"(.*)\"")
    public void I_click_on_this(String objectName) {
        actions.click(objectName);
    }

    /**
     * When I close browser
     */
    @When("I close browser")
    public void I_close_browser() {
        browser.closeBrowser();
    }

    /**
     * Get parameters in this class, and prep for injection to others
     * @return Map of parameters
     */
    public Map<String, Object> getParameters() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("browser", browser);
        params.put("webDriver", webDriver);
        params.put("webObjects", webObjects);
        params.put("actions", actions);
        return params;
    }
}
