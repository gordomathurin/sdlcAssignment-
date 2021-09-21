package com.gordon_workspace;

import java.io.*;
import java.util.*;


public class ProcessFile {
    private TreeMap<String, Integer> mapHolder = null;
    private String file;

    public TreeMap<String, Integer> getMapHolder() {
        return mapHolder;
    }

    public void setMapHolder(TreeMap<String, Integer> mapHolder) {
        this.mapHolder = mapHolder;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public ProcessFile(String file) {
        this.file = file;
        mapHolder = new TreeMap<>();
    }

    public void readWords()  {

        try {
            Scanner s = new Scanner(new File(file));
            while (s.hasNext()) {
                String word = s.next();
                int wordCount = 1;
                if (mapHolder.containsKey(word)) {
                    wordCount = mapHolder.get(word) + 1;
                }
                mapHolder.put(word,wordCount);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public TreeMap<String, Integer> getFileResults() {
        if (mapHolder.isEmpty()) {
            readWords();
        }
        return mapHolder;
    }

}
