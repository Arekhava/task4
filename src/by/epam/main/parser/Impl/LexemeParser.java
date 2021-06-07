package by.epam.main.parser.Impl;

import by.epam.main.entity.impl.CompositeType;
import by.epam.main.entity.impl.TextComposite;
import by.epam.main.parser.AbstractTextParser;
import by.epam.main.parser.TextParserHelper;

public class LexemeParser extends AbstractTextParser {
    @Override
    public TextComposite parse(String data) {
        String[] lexemeList= TextParserHelper.getLexemes(data);
        TextComposite lexemeTextComposite = new TextComposite(CompositeType.LEXEME);
        for(String lexeme : lexemeList) {
            TextComposite nextComposite = nextParser.parse(lexeme);
            lexemeTextComposite.add(nextComposite);
        }
        return lexemeTextComposite;
    }
}
