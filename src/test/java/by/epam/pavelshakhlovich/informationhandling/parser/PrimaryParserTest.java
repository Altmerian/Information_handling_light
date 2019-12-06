package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.LeafTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PrimaryParserTest {
    private static PrimaryParser primaryParser = new PrimaryParser();
    private static final String TEXT = "   One. Three words here.\n   Two words. One.";

    @Test
    public void testHandleText() {
        String testText = "One.";
        TextComponent word = new CompositeTextComponent(TextPartType.WORD, "One");
        word.addChild(new LeafTextComponent("O"), new LeafTextComponent("n"),
            new LeafTextComponent("e"));
        TextComponent leaf = new LeafTextComponent(".");
        TextComponent lexeme = new CompositeTextComponent(TextPartType.LEXEME, "One.");
        lexeme.addChild(word, leaf);
        TextComponent sentence = new CompositeTextComponent(TextPartType.SENTENCE, "One.");
        sentence.addChild(lexeme);
        TextComponent paragraph = new CompositeTextComponent(TextPartType.PARAGRAPH, "One.");
        paragraph.addChild(sentence);
        TextComponent expected = new CompositeTextComponent(TextPartType.TEXT, testText);
        expected.addChild(paragraph);

        TextComponent actual = primaryParser.handleText(new CompositeTextComponent(TextPartType.TEXT, testText));
        assertEquals(actual, expected);
    }

    @Test
    public void testParseText() {
        String[] expected = new String[]{"One. Three words here.\n", "Two words. One."};
        String[] actual = primaryParser.parseText(TEXT);
        assertEquals(actual, expected);
    }
}