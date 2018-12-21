package com.example.wordseeker.impl;

import com.example.wordprovider.WordProvider;
import com.example.wordprovider.impl.WordProviderImpl;
import com.example.wordseeker.WordSeeker;

public class WordSeekerImpl implements WordSeeker {
    private WordProvider wordProvider = new WordProviderImpl();

    @Override
    public String getArticle(String word) {

        String url = "http://api.pearson.com/v2/dictionaries/ldoce5/entries?headword=" + word;
        String request = wordProvider.getRequest(url);

        return request;
    }
}
