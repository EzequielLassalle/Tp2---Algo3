package edu.fiuba.algo3.repositories;

import java.io.FileReader;
import java.io.IOException;

import edu.fiuba.algo3.modelo.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/*MapaParser parser = new MapaParser(mapa.json);
Mapa mapa = new Mapa (parser.parsear());*/

public class JsonMapRepository implements MapRepository {
    final int SIZE = 15;
    private String path;

    public JsonMapRepository(String p) {
        this.path = p;
    }

    private JSONObject setJSON() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(this.path);
        Object obj = parser.parse(reader);
        JSONObject jsonObj = (JSONObject) obj;
        reader.close();
        return jsonObj;
    }

    public Mapa parsear() throws IOException, FormatoJSONInvalido {
        JSONObject jsonObj = null;
        try {
            jsonObj = setJSON();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject map = (JSONObject) jsonObj.get("Mapa");
        Casillero[][] mapa = new Casillero[SIZE][SIZE];
        for (int y = 0; y < SIZE; y++) {
            JSONArray line = (JSONArray) map.get(Integer.toString(y + 1));
            for (int x = 0; x < SIZE; x++) {
                mapa[y][x] = asignar((String) line.get(x), x, y);
            }
        }
        Mapa m = new Mapa(mapa);
        return m;
    }


    private Casillero asignar(String s, int x, int y) throws FormatoJSONInvalido {
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
            default:
                throw new FormatoJSONInvalido();
        }
        return c;
    }

    public void formatoCorrecto() throws IOException, ParseException, JSONVacio, FormatoJSONInvalido {
        JSONObject jsonObj = setJSON();
        if (jsonObj.isEmpty()) {
            throw new JSONVacio();
        }
        try {
            JSONObject map = (JSONObject) jsonObj.get("Mapa");
            for (int i = 0; i < SIZE; i++) {
                JSONArray line = (JSONArray) map.get(Integer.toString(i + 1));
                for (int x = 0; x < SIZE; x++) {
                    String s = (String) line.get(x);
                    if (!s.equals("Tierra") && !s.equals("Rocoso") && !s.equals("Pasarela")) {
                        throw new FormatoJSONInvalido();
                    }
                }
            }
        } catch (Exception e) {
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


