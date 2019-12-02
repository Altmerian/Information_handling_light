package by.epam.pavelshakhlovich.informationhandling.entity;

import java.util.List;

public abstract class TextComponent {
    private final String storedString;
    private final TextPartType type;

    public TextComponent(TextPartType type, String storedString) {
        this.type = type;
        this.storedString = storedString;
    }

    public TextPartType getType() {
        return type;
    }

    public String getStoredString() {
        return storedString;
    }

    public abstract TextComponent addChild(TextComponent textComponent);

    public abstract boolean removeChild(TextComponent textComponent);

    public abstract List<TextComponent> getChildren();

    public abstract boolean isLeafComponent();

    public abstract int countChildren();
}
