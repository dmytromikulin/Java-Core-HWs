package org.example;

import java.io.*;
import java.util.*;

class WordFrequencyCounter {

    public void countWordFrequency(String fileName) {
        WordFrequencyMap wordFrequencyMap = new WordFrequencyMap();
        wordFrequencyMap.readFile(fileName);

        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordFrequencyMap.getWordCountMap().entrySet());

        wordList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : wordList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String fileName = "words.txt";
        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.countWordFrequency(fileName);
    }
}
