package by.epam.pavelshakhlovich.informationhandling.app;

import by.epam.pavelshakhlovich.informationhandling.action.TextAction;
import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;
import by.epam.pavelshakhlovich.informationhandling.inputdata.DataReader;
import by.epam.pavelshakhlovich.informationhandling.parser.PrimaryParser;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) {
        Path path = Paths.get("data/TextData.txt");
        DataReader reader = new DataReader();
        CompositeTextComponent text = new CompositeTextComponent(TextPartType.TEXT, reader.readTextFromFile(path));
        PrimaryParser primaryParser = new PrimaryParser();
        TextComponent parsedText = primaryParser.handleText(text);

        TextAction.sortParagraphsBySentenceCount(parsedText);
        TextAction.outputTextComponent(parsedText);

        TextAction.sortSentencesByWordsLength(parsedText);
        TextAction.sortSentencesByWordsCount(parsedText);

    }
}
