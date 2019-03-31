package obligatoriop2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Juego implements Serializable {

    private ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
    
    public ArrayList<Jugador> getListaJugadores(){
        return this.listaJugadores;
    }
    
    public void agregarJugador(Jugador unJugador) {
        this.listaJugadores.add(unJugador);
    
    }
    
    public boolean aliasValido(Jugador unJugador){
        boolean aux = true;
        if (this.listaJugadores.contains(unJugador)) {
            aux = false;            
        }
        return aux;
    }
    
    public ArrayList<Jugador> ranking() {
        ArrayList<Jugador> listaAux = new ArrayList<Jugador>();
        listaAux = this.listaJugadores;
        Collections.sort(listaAux);
        return listaAux;
    }

}
