package org.automationtest.slumber.test;

import org.automationtest.slumber.config.InitDriver;
import org.automationtest.slumber.logging.Logs;
import org.automationtest.slumber.utils.PropertyFactory;
import org.automationtest.slumber.utils.RunSlumber;
import org.automationtest.slumber.web.Browser;
import org.automationtest.slumber.web.WebObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Unit tests
 */
public class UnitTest {
    private WebDriver testDriver;
    private Browser testBrowser;
    private PropertyFactory propertyFactory;

    /**
     * Main method
     * @param args Args
     */
    public void main(String[] args) {
        testPropertyFactory();
        testLogs();
        testInitDriver();
        testBrowser();
        testWebObjects();
    }

    /**
     * Test PropertyFactory class
     */
    @Test
    public void testPropertyFactory() {
        propertyFactory = new PropertyFactory();
        SoftAssert s = new SoftAssert();
        s.assertNotNull(propertyFactory.getProps().isEmpty(), "PropertyFactory not created");
        s.assertEquals(propertyFactory.getPropFileLoc(), "files/config.properties", "Incorrect default property file location");
        s.assertAll();
    }

    /**
     * Test Logs class
     */
    @Test
    public void testLogs() {
        Logs logs = new Logs();
        SoftAssert s = new SoftAssert();
        s.assertTrue(logs.getLogDirPath().toString().contains("file:/tmp/log4j2"), "Incorrect log4j2 xml location");
        s.assertAll();
    }

    /**
     * Test WebObjects class
     */
    @Test
    public void testWebObjects() {
        WebObjects webObjects = new WebObjects();
        webObjects.setWebObject("Google Home Logo");
        SoftAssert s = new SoftAssert();
        s.assertEquals(webObjects.getObjectName(), "Google Home Logo", "Incorrect web object name");
        s.assertAll();
    }

    /**
     * Test InitDriver class
     */
    @Test(dependsOnMethods = {"testWebObjects"})
    public void testInitDriver() {
        InitDriver initDriver = new InitDriver();
        try {
            testDriver = initDriver.getDriver();
            SoftAssert s = new SoftAssert();
            s.assertNotNull(testDriver, "Null driver");
            s.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test Browser class
     */
    @Test(dependsOnMethods = {"testInitDriver", "testWebObjects"})
    public void testBrowser() {
        testBrowser = new Browser(testDriver);
        testBrowser.openURL("http://www.google.com");
        SoftAssert s = new SoftAssert();
        s.assertTrue(testBrowser.getCurrentURL().contains("google"), "Not going to Google");
        s.assertAll();
        testBrowser.closeBrowser();
    }

    /**
     * Test GeneralSteps class
     */
    @Test(dependsOnMethods = {"testBrowser"})
    public void testGeneralSteps() {
        String[] args = new String[2];
        args[0] = propertyFactory.getValueString("default.cucumber.glue.package");
        args[1] = propertyFactory.getValueString("default.cucumber.feature.location");
        try {
            RunSlumber.main(args);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
