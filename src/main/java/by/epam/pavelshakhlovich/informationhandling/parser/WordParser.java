package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;

public class WordParser implements TextParser {
    private final TextParser nextParser;

    public WordParser() {
        this.nextParser = new CharacterParser();
    }

    @Override
    public TextComponent parse(TextComponent textComponent) {
        return null;
    }
}
