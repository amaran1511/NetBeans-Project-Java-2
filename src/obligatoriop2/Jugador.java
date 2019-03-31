package obligatoriop2;

import java.io.Serializable;

public class Jugador implements Comparable<Jugador>, Serializable {

    private String nombre;
    private String alias;
    
    private boolean esAzul;

    private int partidasGanadas;
    private int partidasEmpatadas;
    private int partidasPerdidas;
    private int edad;

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public void setAlias(String unAlias) {
        this.alias = unAlias;
    }

    public void setEdad(int unaEdad) {
        this.edad = unaEdad;
    }

    public void setPartidasGanadas(int unaPartidaGanada) {
        this.partidasGanadas = unaPartidaGanada;
    }

    public void setPartidasEmpatadas(int unaPartidaEmpatada) {
        this.partidasEmpatadas = unaPartidaEmpatada;
    }

    public void setPartidasPerdidas(int unaPartidaPerdida) {
        this.partidasPerdidas = unaPartidaPerdida;
    }
    
    public void setEsAzul(boolean unIndicadorColor){
        this.esAzul = unIndicadorColor;
    }

            
    public String getNombre() {
        return this.nombre;
    }

    public String getAlias() {
        return this.alias;
    }

    public int getEdad() {
        return this.edad;
    }

    public int getPartidasGanadas() {
        return this.partidasGanadas;
    }

    public int getPartidasEmpatadas() {
        return this.partidasEmpatadas;
    }

    public int getPartidasPerdidas() {
        return this.partidasPerdidas;
    }
    
    public boolean getEsAzul(){
        return this.esAzul;
    }

        
    public Jugador(String unNombre, String unAlias, int unaEdad) {
        this.setNombre(unNombre);
        this.setAlias(unAlias);
        this.setEdad(unaEdad);
        this.setEsAzul(false);
        this.setPartidasPerdidas(0);
        this.setPartidasEmpatadas(0);
        this.setPartidasGanadas(0);
    
    }

    public Jugador() {
        this.setNombre(" ");
        this.setAlias(" ");
        this.setEdad(0);
        this.setEsAzul(false);
        this.setPartidasPerdidas(0);
        this.setPartidasEmpatadas(0);
        this.setPartidasGanadas(0);
    }
     

    @Override
    public boolean equals(Object obj) {
        return this.getAlias().equals(((Jugador) obj).getAlias());
    }

    public int compareTo(Jugador obj) {
        int ret = this.getPartidasGanadas() - obj.getPartidasGanadas();
        if (ret == 0) {
            return obj.getPartidasPerdidas() - this.getPartidasPerdidas();
        }
        return ret;
    }

    public String toString() {
        return "Nombre del Jugador: " + this.getNombre() + " · " 
                + "Alias del Jugador: " + this.getAlias() + " · "
                + "Edad del Jugador: " + this.getEdad() + " años" + " · "
                + "Partidas ganadas/empatadas/perdidas: " 
                + this.getPartidasGanadas() + "/"
                + this.getPartidasEmpatadas() + "/" 
                + this.getPartidasPerdidas() + "\n";
    }
}
