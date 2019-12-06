package by.epam.pavelshakhlovich.informationhandling.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeTextComponent extends TextComponent {

    private final List<TextComponent> children = new ArrayList<>();

    public CompositeTextComponent(TextPartType type, String storedString) {
        super(type, storedString);
    }

    @Override
    public TextComponent[] addChild(TextComponent...textComponents) {
        children.addAll(Arrays.asList(textComponents));
        return textComponents;
    }

    @Override
    public boolean removeChild(TextComponent textComponent) {
        return false;
    }

    @Override
    public List<TextComponent> getChildren() {
        return children;
    }

    @Override
    public boolean isLeafComponent() {
        return false;
    }

    @Override
    public int countChildren() {
        return children.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CompositeTextComponent)) return false;
        if (!super.equals(obj)) return false;

        CompositeTextComponent that = (CompositeTextComponent) obj;

        return children.equals(that.children);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + children.hashCode();
        return result;
    }
}


