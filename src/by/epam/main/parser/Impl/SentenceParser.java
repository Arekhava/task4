package by.epam.main.parser.Impl;

import by.epam.main.entity.impl.CompositeType;
import by.epam.main.entity.impl.TextComposite;
import by.epam.main.parser.AbstractTextParser;
import by.epam.main.parser.TextParserHelper;

import java.util.List;

public class SentenceParser extends AbstractTextParser {
    @Override
    public TextComposite parse(String data) {
        List<String> sentenceList = TextParserHelper.getSentences(data);
        TextComposite sentenceTextComposite = new TextComposite(CompositeType.SENTENCE);
        for (String sentence : sentenceList) {
            TextComposite nextTextComposite = nextParser.parse(sentence);
            sentenceTextComposite.add(nextTextComposite);
        }
        return sentenceTextComposite;
    }
}

