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

    private String path;

    public MapaParser(String p) {
        this.path = p;
    }

    public List parsearMapa() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(this.path);
        Object obj = parser.parse(reader);
        JSONObject jsonObj = (JSONObject) obj;
        JSONObject map = (JSONObject) jsonObj.get("Mapa");
        List lines = new ArrayList();
        for (int i = 0; i < 15; i++) {
            JSONArray line = (JSONArray) map.get(Integer.toString(i + 1));
            List parsedLine = new ArrayList();
            for (int x = 0; x < 15; x++) {
                parsedLine.add(line.get(x));
            }
            lines.add(parsedLine);
        }
        return lines;
    }


    /*private Casillero asignarTipo(String s, int x, int y){
        Casillero c;
        if(s == "Rocoso"){
            c = new Rocosa();

        }

    }*/
}


