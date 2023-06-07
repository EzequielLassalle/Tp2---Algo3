package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javafx.util.converter.IntegerStringConverter;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class MapaParser {
    final int SIZE = 15;
    private String path;

    public MapaParser(String p) {
        this.path = p;
    }

    private JSONObject setJSON()throws IOException, ParseException{
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(this.path);
        Object obj = parser.parse(reader);
        JSONObject jsonObj = (JSONObject) obj;
        reader.close();
        return jsonObj;
    }

    public Casillero[][] parsearMapa() throws IOException, ParseException {
        JSONObject jsonObj = setJSON();
        JSONObject map = (JSONObject) jsonObj.get("Mapa");
        Casillero[][] mapa = new Casillero[SIZE][SIZE];
        for (int y = 0; y < SIZE; y++) {
            JSONArray line = (JSONArray) map.get(Integer.toString(y + 1));
            for (int x = 0; x < SIZE; x++) {
                mapa[x][y] = asignar((String)line.get(x), x, y);
            }
        }
        return mapa;
    }

    private Casillero asignar(String s, int x, int y){
        Casillero c = null;
        switch (s) {
            case "Tierra":
                c = new Tierra(x, y);
                break;
            case "Rocoso":
                c = new Rocosa(x, y);
                break;
            case "Pasarela":
                c = new Pasarela(x, y);
                break;
        }
        return c;
    }

    public void formatoCorrecto() throws IOException, ParseException, JSONVacio, FormatoJSONInvalido{s
        JSONObject jsonObj = setJSON();
        if(jsonObj.isEmpty()) {
            throw new JSONVacio();
        }
        try{
            JSONObject map = (JSONObject) jsonObj.get("Mapa");
            for (int i = 0; i < SIZE; i++) {
                JSONArray line = (JSONArray) map.get(Integer.toString(i + 1));
                for (int x = 0; x < SIZE; x++) {
                    String s = (String)line.get(x);
                    if(!s.equals("Tierra") && !s.equals("Rocoso") && !s.equals("Pasarela")){
                        throw new FormatoJSONInvalido();
                    }
                }
            }
        } catch (Exception e){
            throw new FormatoJSONInvalido();
        }

    }


    /*private Casillero asignarTipo(String s, int x, int y){
        Casillero c;
        if(s == "Rocoso"){
            c = new Rocosa();

        }

    }*/
}


