package pl.itgolo.plugin.helper.Application;

import pl.itgolo.plugin.helper.Logger.Enums.Level;
import pl.itgolo.plugin.helper.Logger.LoggerHelper;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by ITGolo on 04.03.2017.
 */
public class EnvHelper {

    /* @var file env */
    private static File fileEnv = null;

    /**
     * Set file env
     * @param fileEnv file env
     */
    public static void setFileEnv(File fileEnv) {
        EnvHelper.fileEnv = fileEnv;
    }

    /**
     * Get property from env
     *
     * @param key of property
     * @return value of property
     */
    public static String getProperty(String key) {
        String result = "";
        if (Objects.isNull(fileEnv)){
            fileEnv = new File("ENV.properties");
        }
        Properties properties = new Properties();
        InputStreamReader inStream = null;
        try {
            inStream = new InputStreamReader(new FileInputStream(fileEnv), "UTF8");
            properties.load(inStream);
            inStream.close();
            result = properties.getProperty(key);
        } catch (IOException e) {
            LoggerHelper.setLog(EnvHelper.class, Level.ERROR, String.format("Error get property from env file. Path file env: %1$s.", fileEnv.getAbsolutePath()), e);
        }
        return result;
    }
}
