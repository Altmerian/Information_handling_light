package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.CompositeTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.LeafTextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;

public class CharacterParser implements TextParser {


    @Override
    public TextComponent handleText(TextComponent textComponent) {
        String word = textComponent.getStoredString();
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            TextComponent charComponent = new LeafTextComponent(String.valueOf(aChar));
            textComponent.addChild(charComponent);
        }
        return textComponent;
    }

    @Override
    public String[] parseText(String string) {
        return null;
    }
}
