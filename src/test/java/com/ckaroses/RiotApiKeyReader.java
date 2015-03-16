package com.ckaroses;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;

/**
 * Created by Colton on 3/13/2015.
 */
public class RiotApiKeyReader {

    public static String getApiKey() {
        try {
            return Resources.toString(RiotApiKeyReader.class.getResource("apikey.txt"), Charsets.UTF_8);
        } catch (IOException e) {
            throw new NullPointerException("The API key not be read from the apikey.txt file.  " +
                    "Please read the examplekey.txt file.");
        }
    }

}
