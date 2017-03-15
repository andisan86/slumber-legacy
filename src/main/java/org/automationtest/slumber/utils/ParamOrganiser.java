package org.automationtest.slumber.utils;

import org.automationtest.slumber.glue.GeneralSteps;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is a conduit to pass parameters between objects
 */
public class ParamOrganiser {
    private Map<String, Object> params = new HashMap<String, Object>();

    /**
     * Constructor
     * @param generalSteps GeneralSteps objects
     */
    public ParamOrganiser(GeneralSteps generalSteps) {
        this.params.put("browser", generalSteps.getParameters().get("browser"));
        this.params.put("webDriver", generalSteps.getParameters().get("webDriver"));
        this.params.put("webObjects", generalSteps.getParameters().get("webObjects"));
        this.params.put("actions", generalSteps.getParameters().get("actions"));
    }

    /**
     * Get parameters
     * @return Map of parameters
     */
    public Map<String, Object> getParams() {
        return params;
    }
}
