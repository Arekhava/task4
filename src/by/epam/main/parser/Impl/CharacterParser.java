package by.epam.main.parser.Impl;

import by.epam.main.entity.TextComponent;
import by.epam.main.entity.impl.CompositeType;
import by.epam.main.entity.impl.SymbolLeaf;
import by.epam.main.entity.impl.TextComposite;
import by.epam.main.parser.AbstractTextParser;
import by.epam.main.parser.TextParserHelper;

import java.util.List;

public class CharacterParser extends AbstractTextParser {
    @Override
    public TextComposite parse(String data) {
        List<Character> characterList = TextParserHelper.getCharacters(data);
        TextComposite characterTextComposite = new TextComposite(CompositeType.SYMBOL);
        for (Character character : characterList) {
            TextComponent textComponent = new SymbolLeaf(character);
            characterTextComposite.add(textComponent);
        }
        return characterTextComposite;
    }
}
