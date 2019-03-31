package obligatoriop2;

public class Ficha {

    private boolean esAlfil;
    private boolean esAzul;
    private int fila;
    private int columna;
    private Jugador jugador;

    public void setEsAlfil(boolean unIndicador) {
        this.esAlfil = unIndicador;
    }

    public void setFila(int unaFila) {
        this.fila = unaFila;
    }

    public void setColumna(int unaColumna) {
        this.columna = unaColumna;
    }
    
    public void setJugador(Jugador unJugador){
        this.jugador = unJugador;
    }
    
    public void setEsAzul(boolean unIndicadorColor){
        this.esAzul = unIndicadorColor;
    }
    

    public int getFila() {
        return this.fila;
    }

    public int getColumna() {
        return this.columna;
    }

    public boolean getEsAlfil() {
        return this.esAlfil;
    }
    
    public boolean getEsAzul(){
        return this.esAzul;
    }
    
    public Jugador getJugador(){
        return this.jugador;
    }

    public char getEstado() {
        if (this.esAlfil) {
            return 'A';
        } else {
            return 'T';
        }
    }
    
    

    public Ficha() {
        this.setEsAlfil(false);
        this.setEsAzul(false);
        this.setFila(0);
        this.setColumna(0);
        this.setJugador(null);
    }

    public Ficha(boolean unIndicador, boolean unIndicadorColor, int unaFila, int unaColumna, Jugador unJugador) {
        this.setEsAlfil(unIndicador);
        this.setEsAzul(unIndicadorColor);
        this.setFila(unaFila);
        this.setColumna(unaColumna);
        this.setJugador(unJugador);
    }

    @Override
    public String toString() {
        //Azul- reset color
        if (this.esAzul) {
            if (this.esAlfil) {
                return "\u001B[34mA\u001B[0m";
            } else {
                return "\u001B[34mT\u001B[0m";
            }
        } //Rojo- reset color
        else {
            if (this.esAlfil) {
                return "\u001B[31mA\u001B[0m";
            } else {
                return "\u001B[31mT\u001B[0m";
            }
        }
    }

}
