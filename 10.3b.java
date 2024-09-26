package org.example;

import java.io.*;
import java.util.*;

class WordFrequencyMap {
    private Map<String, Integer> wordCountMap = new HashMap<>();

    public void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getWordCountMap() {
        return wordCountMap;
    }
}
