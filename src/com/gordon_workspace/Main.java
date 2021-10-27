package com.gordon_workspace;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String testFile = "/Users/gordonm/Documents/Gordon B.A.S Journey/CEN3024C(softwareDevelopment1) FALL2021/module2 intelij/src/input.txt";
        ProcessFile processFile = new ProcessFile(testFile); // add text file here to test

        Map<String, Integer> wordHolder = processFile.getFileResults();

        LinkedHashMap<String, Integer> sortedHolder = new LinkedHashMap<>();

        wordHolder.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> sortedHolder.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Integer> entry : sortedHolder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
    }

        }
    }

