package com.gordon_workspace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ProcessFile {
    private final Map<String, Integer> wordHolder = new HashMap<>();
    private final String file;

    public ProcessFile(String file) {
        this.file = file;
    }


    public void readWords() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.lines().map(pointer -> pointer.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+")).flatMap(Arrays::stream).map(String::trim).forEach(word -> {
                if (wordHolder.containsKey(word)) {
                    wordHolder.put(word, wordHolder.get(word) + 1);
                } else {
                    wordHolder.put(word, 1);
                }
            });
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Map<String, Integer> getFileResults() {
        if (wordHolder.isEmpty()) {
            readWords();
        }
        return wordHolder;
    }

}
