package com.gordon_workspace;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
            bufferedReader.lines().map(pointer -> pointer.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase().replaceAll("^ +| +$|( )+", "$1").split("\\s+")).flatMap(Arrays::stream).map(String::trim).forEach(word -> {
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

