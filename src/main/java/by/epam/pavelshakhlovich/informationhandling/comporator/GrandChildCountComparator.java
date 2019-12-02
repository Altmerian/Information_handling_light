package by.epam.pavelshakhlovich.informationhandling.comporator;

import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;

import java.util.Comparator;

public class GrandChildCountComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent textComponent1, TextComponent textComponent2) {
        int count1 = textComponent1.getChildren()
                .stream().map(TextComponent::countChildren)
                .mapToInt(Integer::intValue).sum();
        int count2 = textComponent2.getChildren()
                .stream().map(TextComponent::countChildren)
                .mapToInt(Integer::intValue).sum();
        return Integer.compare(count1, count2);
    }
}
