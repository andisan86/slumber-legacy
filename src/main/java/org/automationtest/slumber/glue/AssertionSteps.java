package org.automationtest.slumber.glue;

import cucumber.api.java.en.Then;
import org.automationtest.slumber.config.InitDriver;
import org.automationtest.slumber.utils.ParamOrganiser;
import org.automationtest.slumber.web.Actions;
import org.automationtest.slumber.web.Browser;
import org.automationtest.slumber.web.WebObjects;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * This class contains all the assertion steps
 */
public class AssertionSteps {
    private WebObjects webObjects;
    private WebDriver webDriver;
    private Actions actions;
    private Browser browser;

    /**
     * Constructor, and injects parameters
     *
     * @param paramOrganiser ParamOrganiser
     */
    public AssertionSteps(ParamOrganiser paramOrganiser) {
        this.browser = (Browser) paramOrganiser.getParams().get("browser");
        this.webDriver = (WebDriver) paramOrganiser.getParams().get("webDriver");
        this.actions = (Actions) paramOrganiser.getParams().get("actions");
        this.webObjects = (WebObjects) paramOrganiser.getParams().get("webObjects");
    }

    /**
     * Then I should see "objectName"
     *
     * @param objectName objectName
     */
    @Then("I should see \"(.*)\"$")
    public void I_should_see(String objectName) {
        assertTrue("Should see", actions.isObjectDisplayed(objectName));
    }

    /**
     * Assert if a condition is true
     * @param desc Description
     * @param condition Condition to test
     */
    private void assertTrue(String desc, Boolean condition) {
        Assert.assertTrue(desc, condition);
    }

    /**
     * Assert if a condition is false
     * @param desc Description
     * @param condition Condition to test
     */
    private void assertFalse(String desc, Boolean condition) {
        Assert.assertFalse(desc, condition);
    }

    /**
     * Assert if two objects are equal
     * @param desc Description
     * @param expected Expected
     * @param actual Actual
     */
    private void assertEquals(String desc, Object expected, Object actual) {Assert.assertEquals(desc, expected, actual);}

    /**
     * Assert if two objects are not equal
     * @param desc Description
     * @param expected Expected
     * @param actual Actual
     */
    private void assertNotEquals(String desc, Object expected, Object actual) {Assert.assertNotEquals(desc, expected, actual);}
}
