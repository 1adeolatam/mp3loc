/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translation;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Tami
 */
public class Translation {

    private final String api_key = "trnsl.1.1.20160427T224857Z.f602bf4284b89014.371be84707d3106f907213aa1dbb1425097486c2";
    private final String yanUrl = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=";
    private final String toLang = "&lang=";
    private final String textmod = "&text=";
    public String text;

    public Translation() throws Exception {
    }

    //Init text
    public void text(String toBeTrans) {
        text = toBeTrans;
       // System.out.println(text);
    } 
    

    // Creates the link that holds the translation of text
    public URL primeLink(Languages languages) throws MalformedURLException, UnsupportedEncodingException {
        String finalUrl = yanUrl + api_key + textmod
                + URLEncoder.encode(text, "UTF-8") + toLang + languages;
        URL url = new URL(finalUrl);
        return url;
    }

    // Returns the json formatted response from the translation website
    public String fromWebsite(URL url) throws IOException, ParseException {
        String str;
        try (Scanner scan = new Scanner(url.openStream())) {
            str = "";
            while (scan.hasNext()) {
                str += scan.nextLine();
            }
        }
        //System.out.println(str);
        JSONObject json = (JSONObject) new JSONParser().parse(str);

        JSONArray arr = (JSONArray) json.get("text");
        Iterator<String> iterator = arr.iterator();
        while (iterator.hasNext()) {
            str = iterator.next();
        }
        // RETURNS THE NEWLY TRANSLATED TEXT
        return str;
    }}

  
