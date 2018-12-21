package com.example;

import com.example.publisher.Publisher;
import com.example.publisher.impl.PublisherMessangerImpl;
import com.example.wordprovider.WordProvider;
import com.example.wordprovider.impl.WordProviderImpl;
import com.example.wordseeker.WordSeeker;
import com.example.wordseeker.impl.WordSeekerImpl;

public class Manager {

    private static WordProvider wordProvider = new WordProviderImpl();
    private static WordSeeker wordSeeker = new WordSeekerImpl();
    private static Formater formater = new Formater();
    private static Publisher publisher = new PublisherMessangerImpl();

    public static void main(String[] args) {

        while(true){

            String text = "";
            do {
                String randomWord = wordProvider.getWord();
                String stringJSON = wordSeeker.getArticle(randomWord);
                text = formater.textFormater(stringJSON);
            }while (text.equals(""));

            publisher.publishToMessanger(text);

            try {
                Thread.sleep(24*60*60*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
