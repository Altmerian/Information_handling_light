package by.epam.pavelshakhlovich.informationhandling.entity;

public class LeafTextComponent implements TextComponent {
    private final String string;

    public LeafTextComponent(String string) {
        this.string = string;
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
    public TextComponent getChild(int childIndex) {
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

    @Override
    public String[] operation(String string) {
        return new String[0];
    }
}
