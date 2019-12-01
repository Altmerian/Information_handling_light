package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;

public class LexemeParser implements TextParser {
    private final TextParser nextParser;

    public LexemeParser() {
        this.nextParser = new WordParser();
    }

    @Override
    public TextComponent parse(TextComponent textComponent) {
        return null;
    }
}
