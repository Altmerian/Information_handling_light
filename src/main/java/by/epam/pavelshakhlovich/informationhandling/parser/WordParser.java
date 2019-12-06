package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.LeafTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;

import java.util.Arrays;
import java.util.stream.Collectors;

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
            if (word.length() == 1) {
                TextComponent charComponent = new LeafTextComponent(word);
                textComponent.addChild(charComponent);
            } else {
                TextComponent wordComponent = new CompositeTextComponent(TextPartType.WORD, word);
                textComponent.addChild(nextParser.handleText(wordComponent));
            }
        }
        return textComponent;
    }

    @Override
    public String[] parseText(String string) {
        string = string.trim();
        String[] result = string.split("\\s+|(?<=[\\p{Punct}])|(?=\\p{Punct})");
        return Arrays.stream(result)
            .filter(x -> !x.isEmpty())
            .collect(Collectors.toList())
            .toArray(String[]::new);
    }
}
