package edu.fiuba.algo3.modelo;
////import org.json.simple.JSONobject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnemigosParser {
    private String path;

    public EnemigosParser(String p) {
        this.path = p;
    }

    public void parsearEnemigos() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(this.path);
        Object obj = parser.parse(reader);
        JSONArray map = (JSONArray) obj;
        //System.out.println(turno.get("turno"));
        List todos = new ArrayList();

        for (int i = 0; i < map.size(); i++) {
            JSONObject turno = (JSONObject) map.get(i);


        }
        //return lines;
    }

    public void formatoCorrecto() throws IOException, ParseException, JSONVacio, FormatoJSONInvalido{
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(this.path);
        Object obj = parser.parse(reader);
        JSONArray map = (JSONArray) obj;
        if(map.isEmpty()) {
            throw new JSONVacio();
        }
        for(int i = 0; i < map.size(); i++){
            JSONObject turnoData = (JSONObject) map.get(i);
            try{
                JSONObject enemigos = (JSONObject) turnoData.get("enemigos");
                Object hormiga = enemigos.get("hormiga");
                Object arana = enemigos.get("arana");
            } catch (Exception e){
                throw new FormatoJSONInvalido();
            }
        }
    }
}
