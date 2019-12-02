package by.epam.pavelshakhlovich.informationhandling.entity;

import java.util.List;

public class LeafTextComponent extends TextComponent {

    public LeafTextComponent(String storedString) {
        super(TextPartType.CHARACTER, storedString);
    }

    @Override
    public TextComponent addChild(TextComponent textComponent) {
        return null;
    }

    @Override
    public boolean removeChild(TextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getChildren() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isLeafComponent() {
        return true;
    }

    @Override
    public int countChildren() {
        throw new UnsupportedOperationException();
    }

}
