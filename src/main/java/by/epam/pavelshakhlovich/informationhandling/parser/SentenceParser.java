package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;

public class SentenceParser implements TextParser {
    private final TextParser nextParser;

    public SentenceParser() {
        nextParser = new LexemeParser();
    }

    @Override
    public TextComponent parse(TextComponent textComponent) {
        return null;
    }
}
