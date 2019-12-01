package by.epam.pavelshakhlovich.informationhandling.parser;

import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;

public interface TextParser {
    TextComponent handleText (TextComponent textComponent);
    String[] parseText(String string);
}
