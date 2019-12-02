package by.epam.pavelshakhlovich.informationhandling.inputdata;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataReader {
    private static Logger logger = Logger.getRootLogger();

    public String readTextFromFile(Path path) {
        String text = "";
        try {
            text = Files.readString(path);
            logger.info("text data has been read from file: " + path);
        } catch (IOException e) {
            logger.error("IOException", e);
        }
        return text;
    }

}
