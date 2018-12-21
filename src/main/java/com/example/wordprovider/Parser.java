package com.example.wordprovider;

public class Parser {

    public String[] getList(String string){
        return string.split("[^a-zA-Z]+");
    }
}
