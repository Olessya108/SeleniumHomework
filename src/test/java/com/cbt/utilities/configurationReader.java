package com.cbt.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class configurationReader {
    private static Properties properties;  //use properties object

    static {

        try {
            //what file to read
            String path = "configuration.properties";
            //read the file into java, finds the path using the string path
            FileInputStream input = new FileInputStream(path);
            // properties class  >> class that loads properties in key/value format
            properties = new Properties();  // need an object of the properties class
            //the values from the file input is loaded / fed into the properties object
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {    //using this method, when the class is loaded only once
        return properties.getProperty(keyName);

    }


}

