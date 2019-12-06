package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;

public class PrimaryParser implements TextParser {
    private final TextParser nextParser;

    public PrimaryParser() {
        this.nextParser = new SentenceParser();

    }

    @Override
    public TextComponent handleText(TextComponent textComponent) {
        String text = textComponent.getStoredString();
        String[] paragraphs = parseText(text);
        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = new CompositeTextComponent(TextPartType.PARAGRAPH, paragraph);
            textComponent.addChild(nextParser.handleText(paragraphComponent));
        }
        return textComponent;
    }

    @Override
    public String[] parseText(String string) {
        string = string.trim();
        return string.split("(?<=[\r\n])(\\s{3,}|\\t)");
    }

}
