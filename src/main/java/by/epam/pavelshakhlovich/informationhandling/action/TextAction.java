package by.epam.pavelshakhlovich.informationhandling.action;

import by.epam.pavelshakhlovich.informationhandling.comporator.GrandChildCountComparator;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;

public class TextAction {

    public static void sortParagraphsBySentenceCount(TextComponent textComponent) {
        if (textComponent.getType() == TextPartType.TEXT) {
            GrandChildCountComparator grandChildCountComparator = new GrandChildCountComparator();
            textComponent.getChildren().sort(grandChildCountComparator);
        }
    }

    public static void sortSentencesByWordsLength(TextComponent textComponent) {
    }

    public static void sortSentencesByWordsCount(TextComponent textComponent) {
    }

    public static void outputTextComponent(TextComponent textComponent) {
        if (!textComponent.isLeafComponent()) {
            StringBuilder text = new StringBuilder("\t");
            for (TextComponent component : textComponent.getChildren()) {
                String delimiter = component.getType() == TextPartType.PARAGRAPH ? "\n\t" : " ";
                text.append(component.getStoredString()).append(delimiter);
            }
            System.out.println(text);
        } else {
            System.out.println(textComponent.getStoredString());
        }
    }
}
