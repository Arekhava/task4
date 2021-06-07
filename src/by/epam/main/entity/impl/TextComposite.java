package by.epam.main.entity.impl;

import by.epam.main.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

public class TextComposite implements TextComponent {

    private final static Logger logger = LogManager.getLogger(TextComposite.class);
    private CompositeType compositeType;
    private final List<TextComponent> textComponents = new ArrayList<>();

    public TextComposite(CompositeType compositeType) {
        this.compositeType = compositeType;
    }

    @Override
    public void add(TextComponent textComponent) {
        logger.info("Composite -> adding child");
        textComponents.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
        logger.info("Composite -> deleting child");
        textComponents.remove(textComponent);
    }

    @Override
    public TextComponent getChild(int index) {
        logger.info("Composite -> getting child by index {}", index);
        return textComponents.get(index);
    }

    @Override
    public CompositeType getType() {
        logger.info("Composite -> getting type: {}", compositeType);
        return compositeType;
    }

    @Override
    public List<TextComponent> getChildList() {
            logger.info("Composite -> get list");
            return textComponents;
    }

    @Override
    public int getChildListSize() {
        logger.info("Composite -> get getChildListSize: {}", textComponents.size());
        return textComponents.size();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(compositeType.getDelimiter(), compositeType.getPrefix(), "");
        for (TextComponent textComponent : textComponents) {
            stringJoiner.add(textComponent.toString());
        }
        return stringJoiner.toString();
    }
    public static class SentenceAmountComparator implements Comparator<TextComponent> {

        @Override
        public int compare(TextComponent o1, TextComponent o2) {
            return Integer.compare(o1.getChildListSize(), o2.getChildListSize());
        }
    }
}
