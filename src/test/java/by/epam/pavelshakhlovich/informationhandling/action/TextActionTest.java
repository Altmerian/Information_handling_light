package by.epam.pavelshakhlovich.informationhandling.action;

import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;
import by.epam.pavelshakhlovich.informationhandling.inputdata.DataReader;
import by.epam.pavelshakhlovich.informationhandling.parser.PrimaryParser;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

public class TextActionTest {
    private static DataReader reader = new DataReader();
    private static PrimaryParser primaryParser = new PrimaryParser();
    private static Path path1 = Paths.get("src/test/test_data/testData3.txt");
    private static Path path2 = Paths.get("src/test/test_data/testData2.txt");


    @Test
    public void testSortParagraphsBySentenceCount() {
        String text = reader.readTextFromFile(path1);
        TextComponent textComponent = new CompositeTextComponent(TextPartType.TEXT, text);
        primaryParser.handleText(textComponent);
        TextAction.sortParagraphsBySentenceCount(textComponent);
        String actualString = textComponent.getStoredString().trim();
        String expectedText = "Two words. One.\n\t" +
                "One. Three words here. Two words.\r\n\t" +
                "Sixteen four a three two it. One. Three words here. Two words.";
        assertEquals(actualString, expectedText);

    }

    @Test
    public void testSortSentencesByWordsCount() {
        String text = reader.readTextFromFile(path1);
        TextComponent textComponent = new CompositeTextComponent(TextPartType.TEXT, text);
        primaryParser.handleText(textComponent);
        TextAction.sortSentencesByWordsCount(textComponent);
        String actualString = textComponent.getStoredString().trim();
        String expectedText = "One. Two words. Three words here. Sixteen four a three two it. \n\t" +
                "One. Two words. Three words here. \n\t" +
                "One. Two words.";
                assertEquals(actualString, expectedText);
    }

    @Test
    public void testSortWordsByLength() {
        String text = reader.readTextFromFile(path2);
        TextComponent textComponent = new CompositeTextComponent(TextPartType.TEXT, text);
        primaryParser.handleText(textComponent);
        TextAction.sortWordsByLength(textComponent);
        String actualString = textComponent.getStoredString().trim();
        String expectedText = "a it. two four three sixteen";
        assertEquals(actualString, expectedText);
    }

    @Test
    public void testOutputText() {
    }
}