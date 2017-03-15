package org.automationtest.slumber.utils;


/**
 * This class executes the Cucumber CLI runner
 */
public class RunSlumber {
    private static String cucumberGlueLocation;
    private static String cucumberFeatureLocation;
    private static PropertyFactory propertyFactory = new PropertyFactory();

    /**
     * Main method
     * @param args Command line arguments
     * @throws Throwable Exception
     */
    public static void main(String args[]) throws Throwable {
        System.setProperty("browser", System.getProperty("browser"));
        System.setProperty("driverLocation", System.getProperty("driverLocation"));
        setCucumberGlueLocation(System.getProperty("cucumberGlueLocation"));
        setCucumberFeatureLocation(System.getProperty("cucumberFeatureLocation"));
        String[] arguments = {
                                "--glue"
                                , cucumberGlueLocation
                                , cucumberFeatureLocation
                            };
        cucumber.api.cli.Main.main(arguments);
    }

    /**
     * Set Cucumber glue location
     * @param cucumberGlueLocation Custom Cucumber glue location
     */
    public static void setCucumberGlueLocation(String cucumberGlueLocation) {
        if (cucumberGlueLocation.isEmpty()) {
            RunSlumber.cucumberGlueLocation = propertyFactory.getValueString("default.cucumber.glue.package");
        } else {
            RunSlumber.cucumberGlueLocation = cucumberGlueLocation;
        }
    }

    /**
     * Set Cucumber feature location
     * @param cucumberFeatureLocation Custom Cucumber feature location
     */
    public static void setCucumberFeatureLocation(String cucumberFeatureLocation) {
        if (cucumberFeatureLocation.isEmpty()) {
            RunSlumber.cucumberFeatureLocation = propertyFactory.getValueString("default.cucumber.feature.location");
        } else {
            RunSlumber.cucumberFeatureLocation = cucumberFeatureLocation;
        }
    }

    /**
     * Get Cucumber glue location
     * @return Cucumber glue location
     */
    public static String getCucumberGlueLocation() {
        return cucumberGlueLocation;
    }

    /**
     * Get Cucumber feature location
     * @return Cucumber feature location
     */
    public static String getCucumberFeatureLocation() {
        return cucumberFeatureLocation;
    }
}
