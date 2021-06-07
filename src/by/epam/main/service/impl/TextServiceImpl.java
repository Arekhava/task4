package by.epam.main.service.impl;

import by.epam.main.entity.impl.TextComposite;
import by.epam.main.exception.CompositeException;
import by.epam.main.service.TextService;

import java.util.List;
import java.util.Map;

public class TextServiceImpl implements TextService {
    @Override
    public String paragraphSort(TextComposite textComposite) throws CompositeException {
        return null;
    }

    @Override
    public List<String> findLongWordSentences(TextComposite textComposite) throws CompositeException {
        return null;
    }

    @Override
    public List<String> removeSentences(TextComposite textComposite, int wordAmount) {
        return null;
    }

    @Override
    public Map<String, Integer> countSameWords(TextComposite textComposite) {
        return null;
    }

    @Override
    public int countVowel(TextComposite textComposite) {
        return 0;
    }

    @Override
    public int countConsonant(TextComposite textComposite) {
        return 0;
    }
}
