package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javafx.util.converter.IntegerStringConverter;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class MapaParser {
    /*public static void parsear (String path) throws ParseException, FileNotFoundException, IOException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = parser.parse(reader);
        JSONObject jsonObj = (JSONObject) obj;
        JSONObject map = (JSONObject) jsonObj.get("Mapa");
        List<JSONArray> lines = new ArrayList<>();
        for(int i = 1; i <= 15; i++){
            JSONArray line = (JSONArray) map.get(Integer.toString(i));
            lines.add(line);
        }
    }*/
}



