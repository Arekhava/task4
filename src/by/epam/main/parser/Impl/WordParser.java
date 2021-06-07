package by.epam.main.parser.Impl;

import by.epam.main.entity.TextComponent;
import by.epam.main.entity.impl.CompositeType;
import by.epam.main.entity.impl.PunctuationLeaf;
import by.epam.main.entity.impl.TextComposite;
import by.epam.main.parser.AbstractTextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends AbstractTextParser {

    private static final String PUNCTUATION_REGEX = "[.=,!?:;)(\\t\\n]";

    @Override
    public TextComposite parse(String data) {
            TextComposite wordTextComposite = new TextComposite(CompositeType.WORD);
            boolean isDone = false;
            Pattern pattern = Pattern.compile(PUNCTUATION_REGEX);
            Matcher matcher = pattern.matcher(data);
            int beginIndex = 0;
            while (matcher.find()) {
                char symbol = matcher.group().charAt(0);
                String symbolString = String.valueOf(symbol);
                if (data.startsWith(symbolString)) {
                    TextComponent component = new PunctuationLeaf(symbol);
                    TextComposite composite = new TextComposite(CompositeType.PUNCTUATION);
                    composite.add(component);
                    wordTextComposite.add(composite);
                    beginIndex++;
                } else {
                    int position = data.indexOf(symbol);
                    if (beginIndex < position) {
                        String part = data.substring(beginIndex, position);
                        TextComposite nextTextComposite = nextParser.parse(part);
                        wordTextComposite.add(nextTextComposite);
                    }
                    TextComponent component = new PunctuationLeaf(symbol);
                    TextComposite composite = new TextComposite(CompositeType.PUNCTUATION);
                    composite.add(component);
                    wordTextComposite.add(composite);
                    beginIndex = ++position;
                    if (data.endsWith(symbolString)) {
                        isDone = true;
                    }
                }
            }
            if (!isDone) {
                String part = data.substring(beginIndex);
                TextComposite nextTextComposite = nextParser.parse(part);
                wordTextComposite.add(nextTextComposite);
            }
            return wordTextComposite;
        }
    }

