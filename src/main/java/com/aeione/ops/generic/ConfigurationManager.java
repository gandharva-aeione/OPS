package com.aeione.ops.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager
{

    private static ConfigurationManager instance;
    private final Properties prop = new Properties();

    private ConfigurationManager(String configFile) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(configFile);
        prop.load(inputStream);
    }

    public String getProperty(String key)
    {
        return prop.getProperty(key);
    }

    public static ConfigurationManager getInstance(String propertyFileName) throws IOException {
        if (instance == null) {
            String configFile = getPropertyFilePath()+ File.separator+""+propertyFileName+"";
            instance = new ConfigurationManager(configFile);
        }
        return instance;
    }
    private static String getPropertyFilePath() {

        String propFilePath = "";
        String currentDir = System.getProperty("user.dir");

        File file = new File(currentDir);

        String capsPath = file.getParentFile().getPath() + File.separator + "src/main/resources";
        File capsDir = new File(capsPath);

        if (capsDir.exists()) {
            propFilePath = capsDir.getPath();

        } else {
            propFilePath = currentDir + File.separator + "src/main/resources";

        }

        return propFilePath;

    }

}
