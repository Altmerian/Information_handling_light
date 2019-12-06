package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;

public class LexemeParser implements TextParser {
    private final TextParser nextParser;

    public LexemeParser() {
        this.nextParser = new WordParser();
    }


    @Override
    public TextComponent handleText(TextComponent textComponent) {
        String sentence = textComponent.getStoredString();
        String[] lexemes = parseText(sentence);
        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = new CompositeTextComponent(TextPartType.LEXEME, lexeme);
            textComponent.addChild(nextParser.handleText(lexemeComponent));
        }
        return textComponent;
    }

    @Override
    public String[] parseText(String string) {
        string = string.trim();
        return string.split("\\s+");
    }
}
