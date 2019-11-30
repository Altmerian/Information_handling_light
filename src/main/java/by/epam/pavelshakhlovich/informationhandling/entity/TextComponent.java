package by.epam.pavelshakhlovich.informationhandling.entity;

public interface TextComponent {
    TextComponent addChild(TextComponent textComponent);
    boolean removeChild(TextComponent textComponent);
    TextComponent getChild(int childIndex);
    boolean isLeafComponent();
    int countChildren();
    String[] operation (String string);

}
