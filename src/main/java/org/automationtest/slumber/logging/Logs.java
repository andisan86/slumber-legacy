package org.automationtest.slumber.logging;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.automationtest.slumber.utils.PropertyFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Path;

/**
 * This class handles logging
 */
public class Logs {
    private final Logger LOGGER = LogManager.getLogger(Logs.class.getName());
    private URI logDirPath;
    PropertyFactory props = new PropertyFactory();

    /**
     * Constructor
     */
    public Logs() {
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        InputStream in = getClass().getResourceAsStream(props.getValueString("setting.log4j2.config"));
        try {
            File tempFile = File.createTempFile("log4j2", ".xml");
            tempFile.deleteOnExit();
            FileOutputStream out = new FileOutputStream(tempFile);
            IOUtils.copy(in, out);
            context.setConfigLocation(tempFile.toURI());
            logDirPath = context.getConfigLocation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Log an info message
     * @param message Message
     */
    public void logInfo(String message) { LOGGER.info(message); }

    /**
     * Log a debug message
     * @param message Message
     */
    public void logDebug(String message) { LOGGER.debug(message); }

    /**
     * Log an error message
     * @param message Message
     */
    public void logError(String message) { LOGGER.error(message); }

    /**
     * Set log directory
     * @param logDirPath Log directory
     */
    public void setLogDirPath(URI logDirPath) { this.logDirPath = logDirPath; }

    /**
     * Get log directory
     * @return Log directory
     */
    public URI getLogDirPath() { return logDirPath; }
}
