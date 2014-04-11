/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Twitter4JplusProcessing2;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Properties;

/**
 *
 * @author geodo
 */
public class Utils {

    public static String accessTokenKey, consumerTokenKey, accessTokenSecret, consumerTokenSecret;

    public Utils() {

        //REFLECTION GUBBINZ
        //Load name of .properties file from .init file
        Properties configFile = new Properties();

        try {
            configFile.load(new FileInputStream("tw.properties"));
        } catch (Exception e) {
            System.err.println("file not found");
        }

//        for (String key : configFile.stringPropertyNames()) {
//            String value = configFile.getProperty(key);
//            System.out.println(key + " => " + value);
//        }
//        
        Enumeration keys = configFile.keys();

        //Filename should be the first element in the file. If there's more than one uncommented
        //This will not necessarily pick the first.
        Object key, value;

        while (keys.hasMoreElements()) {

            System.out.println("here?");

            key = keys.nextElement();
            value = configFile.get(key);

            //try boolean first (try catch nest 1)
            try {

                Class cls = Class.forName("Twitter4JplusProcessing2.Utils");
                Field fld = cls.getField(key.toString());
         
                //going to assume they're Strings coming from the properties file
                fld.set(this, value.toString());

            } catch (Throwable e) {

                System.out.println("oops! " + e.getLocalizedMessage() + e.getMessage());

            }

        }

    }//end while for iterating over .properties file

}
