package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;

public class PrimaryParser implements TextParser {
    private final TextComponent textComponent;
    private final TextParser nextParser;
    private final String regEx = "(?<=[\r\n])(\\s{3,}|\\t)";

    public PrimaryParser(TextComponent textComponent) {
        this.textComponent = textComponent;
        this.nextParser = new SentenceParser();
    }

    @Override
    public TextComponent parse(TextComponent textComponent) {
        return null;
    }
}
