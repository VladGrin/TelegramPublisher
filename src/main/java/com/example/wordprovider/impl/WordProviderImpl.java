package com.example.wordprovider.impl;

import com.example.wordprovider.Parser;
import com.example.repository.WordDB;
import com.example.repository.impl.WordDBImpl;
import com.example.stab.StabClass;
import com.example.stab.impl.StabClassImpl;
import com.example.wordprovider.WordProvider;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class WordProviderImpl implements WordProvider {

    private URLConnection connection;
    private Scanner scanner;
    private Parser parser;
    private StabClass stabClass = new StabClassImpl();
    private WordDB wordDB = new WordDBImpl();
    private String stringWords;

    @Override
    public String getRequest(String url) {
        try {
            connection = new URL(url).openConnection();
            scanner = new Scanner(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.useDelimiter("\\Z");
        return scanner.next();
    }

    @Override
    public String getWord() {
        String url = "https://docs.google.com/spreadsheets/d/e/2PACX-1vQ-PQkd25f6SZze5BO8gwuaKsiuHYVX0YIaw9vbANcLcN7oO3dUj4xnBMl_Jk8q40rZZ_ZovznPZ-sD/pub?gid=0&single=true&output=csv";
        String stringWords = getRequest(url);
        parser = new Parser();
        String[] words = parser.getList(stringWords);
        String word = null;
        do {
            int index = (int) (Math.random() * words.length);
            word = wordDB.chooseWorld(words[index]);
        } while (stabClass.validate(word) && word == null);
        return word;
    }
}
