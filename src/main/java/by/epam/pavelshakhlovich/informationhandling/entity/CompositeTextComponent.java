package by.epam.pavelshakhlovich.informationhandling.entity;

import java.util.LinkedList;
import java.util.List;

public class CompositeTextComponent implements TextComponent {
    private final List<TextComponent> children = new LinkedList<>();
    private final String string;

    public CompositeTextComponent(String string) {
        this.string = string;
    }

    @Override
    public TextComponent addChild(TextComponent textComponent) {
        return null;
    }

    @Override
    public boolean removeChild(TextComponent textComponent) {
        return false;
    }

    @Override
    public TextComponent getChild(int childIndex) {
        return null;
    }

    @Override
    public boolean isLeafComponent() {
        return false;
    }

    @Override
    public int countChildren() {
        return 0;
    }

    @Override
    public String[] operation(String string) {
        return new String[0];
    }
}
