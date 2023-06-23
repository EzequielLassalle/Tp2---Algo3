package edu.fiuba.algo3;
 
import edu.fiuba.algo3.vistas.*;
import edu.fiuba.algo3.handlers.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.repositories.*;
 
import java.io.IOException;
 
public class Main {
    public static void main(String[] args) throws IOException, FormatoJSONInvalido {
        Juego juego =   new Juego(new JsonEnemyRepository("src/json/enemigos.json"), 
                        new JsonMapRepository("src/json/mapa.json"));
        /*PantallaInicial init = new PantallaInicial();
        Handler handler = new Handler(juego, init);*/
        Mapa map =  new JsonMapRepository("src/json/mapa.json").parsear();
        System.out.println(map);
        App.main(args, map);
    }
    
}
 