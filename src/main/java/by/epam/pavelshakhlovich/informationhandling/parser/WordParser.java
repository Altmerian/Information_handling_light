package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;

public class WordParser implements TextParser {
    private final TextParser nextParser;

    public WordParser() {
        this.nextParser = new CharacterParser();
    }

    @Override
    public TextComponent handleText(TextComponent textComponent) {
        String lexeme = textComponent.getStoredString();
        String[] words = parseText(lexeme);
        for (String word : words) {
            TextComponent wordComponent = new CompositeTextComponent(TextPartType.WORD, word);
            textComponent.addChild(nextParser.handleText(wordComponent));
        }
        return textComponent;
    }

    @Override
    public String[] parseText(String string) {
        string = string.trim();
        String regEx = "\\W+";
        return string.split(regEx);
    }
}
