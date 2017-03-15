package org.automationtest.slumber.web;

import org.automationtest.slumber.logging.Logs;
import org.automationtest.slumber.utils.PropertyFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This class handles Browser related actions
 */
public class Browser {
    private WebDriver webDriver;
    private Logs logs;
    private String testPlatform;
    private String testBrowser;
    private String browserExecLocation;
    private String firefoxDriverLocation;
    private String chromeDriverLocation;
    private String headlessDriverLocation;
    private PropertyFactory props = new PropertyFactory();

    /**
     * Simple constructor
     */
    public Browser() {
        logs = new Logs();
    }

    /**
     * Constructor
     * @param webDriver
     */
    public Browser(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Open an URL
     * @param URL URL
     */
    public void openURL(String URL) {
        webDriver.get(URL);
    }

    /**
     * Get current URL
     * @return URL
     */
    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    /**
     * Close browser
     */
    public void closeBrowser() {
        webDriver.quit();
    }

    /**
     * Get test platform
     * @return Test platform
     */
    public String getTestPlatform() {
        return testPlatform;
    }

    /**
     * Get test browser
     * @return Test browser
     */
    public String getTestBrowser() {
        return testBrowser;
    }

    /**
     * Set test platform
     * @param testPlatform Test platform
     */
    public void setTestPlatform(String testPlatform) {
        this.testPlatform = testPlatform;
    }

    /**
     * Set test browser
     * @param testBrowser Test browser
     */
    public void setTestBrowser(String testBrowser) {
        this.testBrowser = testBrowser;
    }

}
