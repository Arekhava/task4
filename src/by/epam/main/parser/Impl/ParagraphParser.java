package by.epam.main.parser.Impl;


import by.epam.main.entity.impl.CompositeType;
import by.epam.main.entity.impl.TextComposite;
import by.epam.main.parser.AbstractTextParser;
import by.epam.main.parser.TextParserHelper;

import java.util.List;

public class ParagraphParser extends AbstractTextParser{


    @Override
    public TextComposite parse(String data) {
        List<String> paragraphList = TextParserHelper.getParagraphs(data);
        TextComposite paragraphTextComposite = new TextComposite(CompositeType.PARAGRAPH);
        for (String paragraph : paragraphList) {
            TextComposite nextTextComposite = nextParser.parse(paragraph);
            paragraphTextComposite.add(nextTextComposite);
        }
        return paragraphTextComposite;
    }
}
