package by.epam.pavelshakhlovich.informationhandling.appdemo;

import by.epam.pavelshakhlovich.informationhandling.action.TextAction;
import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;
import by.epam.pavelshakhlovich.informationhandling.inputdata.DataReader;
import by.epam.pavelshakhlovich.informationhandling.parser.PrimaryParser;
import org.apache.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ApplicationDemo {
    private static Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {
        logger.trace("Entry");
        DataReader reader = new DataReader();
        PrimaryParser primaryParser = new PrimaryParser();

        Path path1 = Paths.get("data/textData1.txt");
        CompositeTextComponent text1 = new CompositeTextComponent(TextPartType.TEXT, reader.readTextFromFile(path1));
        TextComponent parsedText1 = primaryParser.handleText(text1);
        TextAction.sortParagraphsBySentenceCount(parsedText1);
        TextAction.outputText(parsedText1);

        TextAction.sortWordsByLength(parsedText1);
        TextAction.outputText(parsedText1);

        Path path2 = Paths.get("data/textData2.txt");
        CompositeTextComponent text2 = new CompositeTextComponent(TextPartType.TEXT, reader.readTextFromFile(path2));
        TextComponent parsedText2 = primaryParser.handleText(text2);
        TextAction.sortSentencesByWordsCount(parsedText2);
        TextAction.outputText(parsedText2);

        logger.trace("Exit");
    }
}
