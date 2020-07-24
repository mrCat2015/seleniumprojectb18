package test.day09_testbase_properties_driverUnit;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromProperties {

    @Test
    public void reading_properties_file() throws IOException {
        //Properties class object allows us
        //to read from configuration.properties
        Properties properties = new Properties();

        //We need to show where the file is stored
        //We need the path of the file
        String path = "configuration.properties";

        //We need to open this configuration.properties file in java memory
        FileInputStream file = new FileInputStream(path);

        //We need to load the opened file into the properties object
        properties.load(file);

        //we can read the configuration.properties file using properties object
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));

    }

    @Test
    public void using_configuration_utility(){
        String browser = ConfigurationReader.getProperty("browser");
        System.out.println("browser = " + browser);

        String userName = ConfigurationReader.getProperty("username");
        System.out.println("userName = " + userName);

        String password = ConfigurationReader.getProperty("password");
        System.out.println("password = " + password);

    }


}
