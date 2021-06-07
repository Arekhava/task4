package by.epam.main.service;

import by.epam.main.entity.impl.TextComposite;
import by.epam.main.exception.CompositeException;

import java.util.List;
import java.util.Map;

public interface TextService {

    String paragraphSort(TextComposite textComposite) throws CompositeException;

    List<String> findLongWordSentences(TextComposite textComposite) throws CompositeException;

    List<String> removeSentences(TextComposite textComposite, int wordAmount);

    Map<String, Integer> countSameWords(TextComposite textComposite);

    int countVowel(TextComposite textComposite);

    int countConsonant(TextComposite textComposite);
}
