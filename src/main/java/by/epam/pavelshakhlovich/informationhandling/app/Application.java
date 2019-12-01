package by.epam.pavelshakhlovich.informationhandling.app;

import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.inputdata.DataReader;
import by.epam.pavelshakhlovich.informationhandling.parser.PrimaryParser;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) {
        Path path = Paths.get("data/TextData.txt");
        DataReader reader = new DataReader();
        CompositeTextComponent text = new CompositeTextComponent(reader.readTextFromFile(path));
        PrimaryParser primaryParser = new PrimaryParser(text);
        primaryParser.parse(text);
    }
}
