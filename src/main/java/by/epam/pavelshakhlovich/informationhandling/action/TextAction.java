package by.epam.pavelshakhlovich.informationhandling.action;

import by.epam.pavelshakhlovich.informationhandling.comporator.ChildCountComparator;
import by.epam.pavelshakhlovich.informationhandling.comporator.GrandChildCountComparator;
import by.epam.pavelshakhlovich.informationhandling.entity.TextComponent;
import by.epam.pavelshakhlovich.informationhandling.entity.TextPartType;
import org.apache.log4j.Logger;

import java.util.List;

public class TextAction {
    private static ChildCountComparator childCountComparator = new ChildCountComparator();
    private static GrandChildCountComparator grandChildCountComparator = new GrandChildCountComparator();
    private static Logger logger = Logger.getRootLogger();

    public static void sortParagraphsBySentenceCount(TextComponent textComponent) {
        if (textComponent.getType() == TextPartType.TEXT) {
            textComponent.getChildren().sort(childCountComparator.thenComparing(grandChildCountComparator));
            modifyStoredString(textComponent, "\n\t");
        }
        logger.info("paragraphs in the text have been sorted by sentence count");
    }

    public static void sortSentencesByWordsCount(TextComponent textComponent) {
        switch (textComponent.getType()) {
            case TEXT: {
                for (TextComponent paragraph : textComponent.getChildren()) {
                    paragraph.getChildren().sort(childCountComparator);
                    modifyStoredString(paragraph, " ");
                }
                modifyStoredString(textComponent, "\n\t");
                logger.info("sentences in the text have been sorted by words count");
                break;
            }
            case PARAGRAPH: {
                textComponent.getChildren().sort(childCountComparator);
                modifyStoredString(textComponent, " ");
                logger.info("sentences in the text have been sorted by words count");
                break;
            }
        }
    }

    public static void sortWordsByLength(TextComponent textComponent) {
        switch (textComponent.getType()) {
            case TEXT: {
                for (TextComponent paragraph : textComponent.getChildren()) {
                    for (TextComponent sentence : paragraph.getChildren()) {
                        sentence.getChildren().sort(grandChildCountComparator);
                        modifyStoredString(sentence, " ");
                    }
                    modifyStoredString(paragraph, " ");
                }
                modifyStoredString(textComponent, "\n\t");
                logger.info("words in the sentences have been sorted by length");
                break;
            }
            case PARAGRAPH: {
                for (TextComponent sentence : textComponent.getChildren()) {
                    sentence.getChildren().sort(grandChildCountComparator);
                    modifyStoredString(sentence, " ");
                }
                modifyStoredString(textComponent, " ");
                logger.info("words in the sentences have been sorted by length");
                break;
            }
            case SENTENCE: {
                textComponent.getChildren().sort(grandChildCountComparator);
                modifyStoredString(textComponent, " ");
                logger.info("words in the sentences have been sorted by length");
                break;
            }
        }
    }

    private static void modifyStoredString(TextComponent textComponent, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent childComponent : textComponent.getChildren()) {
            stringBuilder.append(childComponent.getStoredString()).append(delimiter);
        }
        textComponent.setStoredString(stringBuilder.toString());
    }

    public static void outputText(TextComponent textComponent) {
        logger.info("output the text\n\t" + textComponent.getStoredString());
    }

}
