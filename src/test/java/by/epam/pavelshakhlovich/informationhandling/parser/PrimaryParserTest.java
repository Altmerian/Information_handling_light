package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PrimaryParserTest {
    private static PrimaryParser primaryParser = new PrimaryParser();
    private static final String REGEX = "(?<=[\r\n])(\\s{3,}|\\t)";
    private static final String TEXT = "   One. Three words here.\n   Two words. One.";

    @Test
    public void testHandleText() {
        TextComponent expected = new CompositeTextComponent(TextPartType.TEXT, TEXT);
        expected.addChild(new CompositeTextComponent(TextPartType.PARAGRAPH, "One. Three words here.\n"),
                new CompositeTextComponent(TextPartType.PARAGRAPH, "Two words. One."));

        TextComponent actual = primaryParser.handleText(new CompositeTextComponent(TextPartType.TEXT, TEXT));
        assertEquals(actual, expected);
    }

    @Test
    public void testParseText() {
        String[] expected = new String[]{"One. Three words here.\n", "Two words. One."};
        String[] actual = primaryParser.parseText(TEXT);
        assertEquals(actual, expected);
    }
}