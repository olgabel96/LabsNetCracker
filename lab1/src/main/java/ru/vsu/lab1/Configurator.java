package ru.vsu.lab1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.vsu.sorters.BubbleSorter;
import ru.vsu.sorters.ISorter;

import java.io.*;
import java.util.Properties;

public class Configurator {

    public static Configurator configurator = new Configurator();

    private static final Logger LOGGER = LogManager.getLogger(Configurator.class);
    private static final String PATH = "lab1/src/main/resources/config.properties";
    private static ISorter sorter;
    private static Properties properties;

    private Configurator() {
    }

    public static Configurator getInstance() {
        return configurator;
    }


    public ISorter getSorter() {
        properties = new Properties();
        String sortProperty = "";
        try {
            properties.load(new FileInputStream(new File(PATH)));
            sortProperty = properties.getProperty("SORTER");
            Class name = Class.forName("ru.vsu.sorters."+sortProperty + "Sorter");
            return this.sorter = (ISorter) name.newInstance();

        } catch (FileNotFoundException e) {
            LOGGER.error("Configuration file config.properties not found in " + PATH);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            LOGGER.error("Class " + "ru.vsu.sorters."+sortProperty + "Sorter not found");
            e.printStackTrace();
        }
        return new BubbleSorter();
    }
}
