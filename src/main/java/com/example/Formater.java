package com.example;

import com.google.gson.*;

public class Formater {
    public String textFormater(String stringJSON){
        StringBuilder text = new StringBuilder();
//        String text = "";
        JsonObject jsonObject = new JsonParser().parse(stringJSON).getAsJsonObject();
        JsonArray results = jsonObject.get("results").getAsJsonArray();
        for (int i = 0; i < results.size(); i++) {
            JsonElement headword = results.get(i).getAsJsonObject().get("headword");
            if (headword != null) {
                String headwordString = headword.getAsString();
                text.append((i + 1) + ".%20Headword:%20" + headwordString + "%0a");
//                text += (i + 1) + ".%20Headword:%20" + headwordString + "%0a";
            }
            JsonElement partOfSpeech = results.get(i).getAsJsonObject().get("part_of_speech");
            if (partOfSpeech != null){
                String partOfSpeechString = partOfSpeech.getAsString();
                if (!partOfSpeechString.equals("noun")){
                    text.append("%20%20%20%20Part_of_speech:%20" + partOfSpeechString + "%0a");
//                    text += "%20%20%20%20Part_of_speech:%20" + partOfSpeechString + "%0a";
                }
            }
            JsonElement pronunciations = results.get(i).getAsJsonObject().get("pronunciations");
            if (pronunciations != null) {
                JsonArray pronunciationsArray = pronunciations.getAsJsonArray();
                for (int j = 0; j < pronunciationsArray.size(); j++) {
                    JsonElement ipa = pronunciationsArray.get(j).getAsJsonObject().get("ipa");
                    if (ipa != null) {
                        String ipaAsString = ipa.getAsString();
                        text.append("%20%20%20%20Ipa:%20" + ipaAsString + "%0a");
//                        text += "%20%20%20%20Ipa:%20" + ipaAsString + "%0a";
                    }
                }
            }
            JsonElement senses = results.get(i).getAsJsonObject().get("senses");
            if( senses != null ) {
                JsonArray sensesArray = senses.getAsJsonArray();
                for (int j = 0; j < sensesArray.size(); j++) {
                    JsonElement definition = sensesArray.get(j).getAsJsonObject().get("definition").getAsJsonArray().get(0);
                    if (definition != null) {
                        String definitionString = definition.getAsString();
                        text.append("%20%20%20%20Definition:%20" + definitionString + "%0a");
//                        text += "%20%20%20%20Definition:%20" + definitionString + "%0a";
                    }
                }
            }
        }
        return text.toString();
    }
}
