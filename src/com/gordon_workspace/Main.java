package com.gordon_workspace;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String testFile = "/Users/gordonm/Documents/Gordon B.A.S Journey/CEN3024C(softwareDevelopment1) FALL2021/module2 intelij/src/input.txt";
        ProcessFile processFile = new ProcessFile(testFile); // add text file here to test

        TreeMap<String, Integer> mapHolder = processFile.getFileResults();

        for (Map.Entry<String, Integer> entry : mapHolder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
