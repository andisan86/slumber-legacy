package org.automationtest.slumber.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Interface for DriverSetup
 */
public interface DriverSetup {
    WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities);
    DesiredCapabilities getDesiredCapabilities();
}
