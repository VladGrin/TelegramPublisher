package com.example.repository.impl;

import com.example.repository.WordDB;

import java.util.ArrayList;
import java.util.List;

public class WordDBImpl implements WordDB {

    private List<String> list = new ArrayList<String>();

    public String chooseWorld(String word) {
        if(list.contains(word)){
            return null;
        }
        list.add(word);
        return word;
    }
}
