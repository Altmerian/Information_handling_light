package by.epam.pavelshakhlovich.informationhandling.comporator;

import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;

import java.util.Comparator;

public class ChildCountComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent textComponent1, TextComponent textComponent2) {
        return Integer.compare(textComponent1.countChildren(), textComponent2.countChildren());
    }
}
