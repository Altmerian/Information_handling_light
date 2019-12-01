package by.epam.pavelshakhlovich.informationhandling.entity;

import java.util.ArrayList;
import java.util.List;

public class CompositeTextComponent extends TextComponent {

    private final List<TextComponent> children = new ArrayList<>();

    public CompositeTextComponent(TextPartType type, String storedString) {
        super(type, storedString);
    }


    @Override
    public TextComponent addChild(TextComponent textComponent) {
        children.add(textComponent);
        return textComponent;
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
    public void outputChildren() {
        StringBuilder text = new StringBuilder("\t");
        for (TextComponent textComponent : children) {
            String delimiter = textComponent.getType() == TextPartType.PARAGRAPH ? "\n\t" : " ";
            text.append(textComponent).append(delimiter);
        }
    }

}


