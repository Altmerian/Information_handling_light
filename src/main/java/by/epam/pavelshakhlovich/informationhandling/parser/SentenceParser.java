package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;

public class SentenceParser implements TextParser {
    private final TextParser nextParser;

    public SentenceParser() {
        nextParser = new LexemeParser();
    }

    @Override
    public TextComponent handleText(TextComponent textComponent) {
        String paragraph = textComponent.getStoredString();
        String[] sentences = parseText(paragraph);
        for (String sentence : sentences) {
            TextComponent sentenceComponent = new CompositeTextComponent(TextPartType.SENTENCE, sentence);
            textComponent.addChild(nextParser.handleText(sentenceComponent));
        }
        return textComponent;
    }

    @Override
    public String[] parseText(String string) {
        string = string.trim();
        String regEx = "(?<=(\\w{2,}[.!?]))\\s*";
        return string.split(regEx);
    }
}
