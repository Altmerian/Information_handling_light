package by.epam.pavelshakhlovich.informationhandling.entity;

import java.util.List;

public abstract class TextComponent {
    private String storedString;
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

    public void setStoredString(String storedString) {
        this.storedString = storedString;
    }

    public abstract TextComponent[] addChild(TextComponent... textComponents);

    public abstract boolean removeChild(TextComponent textComponent);

    public abstract List<TextComponent> getChildren();

    public abstract boolean isLeafComponent();

    public abstract int countChildren();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TextComponent)) return false;

        TextComponent that = (TextComponent) obj;

        if (!storedString.equals(that.storedString)) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = storedString.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
