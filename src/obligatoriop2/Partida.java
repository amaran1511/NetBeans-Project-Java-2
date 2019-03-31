package obligatoriop2;

import java.util.ArrayList;

public class Partida {

    private Ficha[][] tablero;
    private Jugador jugadorRojo;
    private Jugador jugadorAzul;
    private int turno;
    private boolean tableroRotado;
    private ArrayList<String> historialJugadas = new ArrayList<String>();
    private ArrayList<String> listaJugadasDefensa = new ArrayList<String>();
    private ArrayList<String> listaJugadasAtaque = new ArrayList<String>();
    private ArrayList<String> listaOtrasJugadas = new ArrayList<String>();

    public void setJugadorAzul(Jugador unJugadorAzul) {
        this.jugadorAzul = unJugadorAzul;
    }

    public void setJugadorRojo(Jugador unJugadorRojo) {
        this.jugadorRojo = unJugadorRojo;
    }

    public void setTurno(int unTurno) {
        this.turno = unTurno;
    }

    public void setTableroRotado(boolean estaRotado) {
        this.tableroRotado = estaRotado;
    }

    public int getTurno() {
        return this.turno;
    }

    public Jugador getJugadorAzul() {
        return this.jugadorAzul;
    }

    public Jugador getJugadorRojo() {
        return this.jugadorRojo;
    }

    public Ficha[][] getTablero() {
        return this.tablero;
    }

    public boolean getTableroRotado() {
        return this.tableroRotado;
    }

    public ArrayList<String> getListaJugadasDefensa() {
        return this.listaJugadasDefensa;
    }

    public ArrayList<String> getListaJugadasAtaque() {
        return this.listaJugadasAtaque;
    }

    public ArrayList<String> getListaOtrasJugadas() {
        return this.listaOtrasJugadas;
    }

    public ArrayList<String> getHistorialJugadas() {
        return this.historialJugadas;
    }

    public Partida() {
        this.tablero = null;
        this.setJugadorRojo(null);
        this.setJugadorAzul(null);
        this.setTurno(0);
        this.setTableroRotado(false);
    }

    public void jugadasDefensaDisponibles() {
        this.listaJugadasDefensa.clear(); //borra la lista anterior
        //Para tableros 3x3
        if (this.getTablero().length == 3) {
            //Para el jugador Azul
            if (this.getTablero()[2][1] != null && !this.getTablero()[2][1].getEsAzul() && this.getTurno() % 2 == 0) { 
                // Si el arco del jugador azul esta ocupado, si esta ocupado por el jugador rojo y es el turno del azul:
                
                for (int i = 0; i < this.getTablero().length; i++) {
                    for (int j = 0; j < this.getTablero().length; j++) {
                        if (this.getTablero()[j][i] != null && this.getTablero()[j][i].getEsAzul()) {
                            int[] auxCoordenadas = new int[4];
                            auxCoordenadas[0] = i;
                            auxCoordenadas[1] = j;
                            auxCoordenadas[2] = 1;
                            auxCoordenadas[3] = 2;
                            // auxCoordenadas[0] e [1] son de origen
                            //DX=[2]-COLUMNAS
                            //DY=[3]-FILAS

                            if (movimientoValido(this.getTablero()[j][i], this.getJugadorAzul(),
                                    auxCoordenadas, this.getTablero())) { 
                                //Si el movimiento es valido:

                                String a = String.valueOf((char) (auxCoordenadas[0] + 65)); //letra que pasa a Ascii
                                String b = String.valueOf((char) (numeroCorrespondiente3(auxCoordenadas[1]) + 49)); // num a 
                                this.listaJugadasDefensa.add(a + b + " "
                                        + ((char) (auxCoordenadas[2] + 65))
                                        + ((char) (numeroCorrespondiente3(auxCoordenadas[3]) + 49)));
                            }
                        }
                    }
                }
            }
            //Para el jugador Rojo
            if (this.getTablero()[0][1] != null && this.getTablero()[0][1].getEsAzul() && this.getTurno() % 2 != 0) {
                
                for (int i = 0; i < this.getTablero().length; i++) {
                    for (int j = 0; j < this.getTablero().length; j++) {
                        if (this.getTablero()[j][i] != null && !this.getTablero()[j][i].getEsAzul()) {
                            int[] auxCoordenadas = new int[4];
                            auxCoordenadas[0] = i;
                            auxCoordenadas[1] = j;
                            auxCoordenadas[2] = 1;
                            auxCoordenadas[3] = 0;

                            if (movimientoValido(this.getTablero()[j][i], this.getJugadorRojo(),
                                    auxCoordenadas, this.getTablero())) {

                                String a = String.valueOf((char) (auxCoordenadas[0] + 65));
                                String b = String.valueOf((char) (numeroCorrespondiente3(auxCoordenadas[1]) + 49));
                                this.listaJugadasDefensa.add(a + b + " "
                                        + ((char) (auxCoordenadas[2] + 65))
                                        + ((char) (numeroCorrespondiente3(auxCoordenadas[3]) + 49)));
                            }
                        }
                    }
                }
            }
        } 
        //Para tablero 5x5
        else {
            if (this.getTablero().length == 5) {
                //Para el jugador Azul
                if (this.getTablero()[4][2] != null && !this.getTablero()[4][2].getEsAzul() && this.getTurno() % 2 == 0) {
                    for (int i = 0; i < this.getTablero().length; i++) {
                        for (int j = 0; j < this.getTablero().length; j++) {
                            if (this.getTablero()[j][i] != null && this.getTablero()[j][i].getEsAzul()) {
                                int[] auxCoordenadas = new int[4];
                                auxCoordenadas[0] = i;
                                auxCoordenadas[1] = j;
                                auxCoordenadas[2] = 2;
                                auxCoordenadas[3] = 4;

                                if (movimientoValido(this.getTablero()[j][i], this.getJugadorAzul(),
                                        auxCoordenadas, this.getTablero())) {

                                    String a = String.valueOf((char) (auxCoordenadas[0] + 65));
                                    String b = String.valueOf((char) (numeroCorrespondiente5(auxCoordenadas[1]) + 49));
                                    this.listaJugadasDefensa.add(a + b + " "
                                            + ((char) (auxCoordenadas[2] + 65))
                                            + ((char) (numeroCorrespondiente5(auxCoordenadas[3]) + 49)));
                                }
                            }
                        }
                    }
                }
                //Para el jugador Rojo
                if (this.getTablero()[0][2] != null && this.getTablero()[0][2].getEsAzul() && this.getTurno() % 2 != 0) {
                    for (int i = 0; i < this.getTablero().length; i++) {
                        for (int j = 0; j < this.getTablero().length; j++) {
                            if (this.getTablero()[j][i] != null && !this.getTablero()[j][i].getEsAzul()) {
                                int[] auxCoordenadas = new int[4];
                                auxCoordenadas[0] = i;
                                auxCoordenadas[1] = j;
                                auxCoordenadas[2] = 2;
                                auxCoordenadas[3] = 0;

                                if (movimientoValido(this.getTablero()[j][i], this.getJugadorRojo(),
                                        auxCoordenadas, this.getTablero())) {

                                    String a = String.valueOf((char) (auxCoordenadas[0] + 65));
                                    String b = String.valueOf((char) (numeroCorrespondiente5(auxCoordenadas[1]) + 49));
                                    this.listaJugadasDefensa.add(a + b + " "
                                            + ((char) (auxCoordenadas[2] + 65))
                                            + ((char) (numeroCorrespondiente5(auxCoordenadas[3]) + 49)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void jugadasAtaqueDisponibles() {
        this.listaJugadasAtaque.clear();
        //Para tableros 3x3
        if (this.getTablero().length == 3) {
            //Para el jugador Azul
            if ((this.getTablero()[0][1] == null || !this.getTablero()[0][1].getEsAzul()) && this.getTurno() % 2 == 0) {
                for (int i = 0; i < this.getTablero().length; i++) {
                    for (int j = 0; j < this.getTablero().length; j++) {
                        if (this.getTablero()[j][i] != null && this.getTablero()[j][i].getEsAzul()) {
                            int[] auxCoordenadas = new int[4];
                            auxCoordenadas[0] = i;
                            auxCoordenadas[1] = j;
                            auxCoordenadas[2] = 1;
                            auxCoordenadas[3] = 0;

                            if (movimientoValido(this.getTablero()[j][i], this.getJugadorAzul(),
                                    auxCoordenadas, this.getTablero())) {
                                String a = String.valueOf((char) (auxCoordenadas[0] + 65));
                                String b = String.valueOf((char) (numeroCorrespondiente3(auxCoordenadas[1]) + 49));
                                this.listaJugadasAtaque.add(a + b + " "
                                        + ((char) (auxCoordenadas[2] + 65))
                                        + ((char) (numeroCorrespondiente3(auxCoordenadas[3]) + 49)));
                            }
                        }
                    }
                }
            }
            //Para el jugador Rojo
            if ((this.getTablero()[2][1] == null || this.getTablero()[2][1].getEsAzul()) && this.getTurno() % 2 != 0) {
                for (int i = 0; i < this.getTablero().length; i++) {
                    for (int j = 0; j < this.getTablero().length; j++) {
                        if (this.getTablero()[j][i] != null && !this.getTablero()[j][i].getEsAzul()) {
                            int[] auxCoordenadas = new int[4];
                            auxCoordenadas[0] = i;
                            auxCoordenadas[1] = j;
                            auxCoordenadas[2] = 1;
                            auxCoordenadas[3] = 2;

                            if (movimientoValido(this.getTablero()[j][i], this.getJugadorRojo(),
                                    auxCoordenadas, this.getTablero())) {

                                String a = String.valueOf((char) (auxCoordenadas[0] + 65));
                                String b = String.valueOf((char) (numeroCorrespondiente3(auxCoordenadas[1]) + 49));
                                this.listaJugadasAtaque.add(a + b + " "
                                        + ((char) (auxCoordenadas[2] + 65))
                                        + ((char) (numeroCorrespondiente3(auxCoordenadas[3]) + 49)));
                            }
                        }
                    }
                }
            }
        } //Para tablero 5x5
        else {
            if (this.getTablero().length == 5) {
                //Para el jugador Azul
                if ((this.getTablero()[0][2] == null || !this.getTablero()[0][2].getEsAzul()) && this.getTurno() % 2 == 0) {
                    for (int i = 0; i < this.getTablero().length; i++) {
                        for (int j = 0; j < this.getTablero().length; j++) {
                            if (this.getTablero()[j][i] != null && this.getTablero()[j][i].getEsAzul()) {
                                int[] auxCoordenadas = new int[4];
                                auxCoordenadas[0] = i;
                                auxCoordenadas[1] = j;
                                auxCoordenadas[2] = 2;
                                auxCoordenadas[3] = 0;

                                if (movimientoValido(this.getTablero()[j][i], this.getJugadorAzul(),
                                        auxCoordenadas, this.getTablero())) {

                                    String a = String.valueOf((char) (auxCoordenadas[0] + 65));
                                    String b = String.valueOf((char) (numeroCorrespondiente5(auxCoordenadas[1]) + 49));
                                    this.listaJugadasAtaque.add(a + b + " "
                                            + ((char) (auxCoordenadas[2] + 65))
                                            + ((char) (numeroCorrespondiente5(auxCoordenadas[3]) + 49)));
                                }
                            }
                        }
                    }
                }
                //Para el jugador Rojo
                if ((this.getTablero()[4][2] != null && this.getTablero()[4][2].getEsAzul()) && this.getTurno() % 2 != 0) {
                    for (int i = 0; i < this.getTablero().length; i++) {
                        for (int j = 0; j < this.getTablero().length; j++) {
                            if (this.getTablero()[j][i] != null && !this.getTablero()[j][i].getEsAzul()) {
                                int[] auxCoordenadas = new int[4];
                                auxCoordenadas[0] = i;
                                auxCoordenadas[1] = j;
                                auxCoordenadas[2] = 2;
                                auxCoordenadas[3] = 4;

                                if (movimientoValido(this.getTablero()[j][i], this.getJugadorRojo(),
                                        auxCoordenadas, this.getTablero())) {

                                    String a = String.valueOf((char) (auxCoordenadas[0] + 65));
                                    String b = String.valueOf((char) (numeroCorrespondiente5(auxCoordenadas[1]) + 49));
                                    this.listaJugadasAtaque.add(a + b + " "
                                            + ((char) (auxCoordenadas[2] + 65))
                                            + ((char) (numeroCorrespondiente5(auxCoordenadas[3]) + 49)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void otrasJugadasDisponibles() {
        this.listaOtrasJugadas.clear();
        //Para tableros 3x3
        if (this.getTablero().length == 3) {
            //Para el jugador Azul
            if (this.getTurno() % 2 == 0) {
                for (int i = 0; i < this.getTablero().length; i++) {
                    for (int j = 0; j < this.getTablero().length; j++) {
                        if (this.getTablero()[j][i] != null && this.getTablero()[j][i].getEsAzul()) {
                            for (int k = 0; k < this.getTablero().length; k++) {
                                for (int l = 0; l < this.getTablero().length; l++) {
                                    //Recorre el tablero y por cada elemento (espacio en el tablero). Si esta ocupado y 
                                    // es por una ficha azul entonces recorre los tableros nuevamente.
                                    int[] auxCoordenadas = new int[4];
                                    auxCoordenadas[0] = i;
                                    auxCoordenadas[1] = j;
                                    auxCoordenadas[2] = k;
                                    auxCoordenadas[3] = l;
                                    if (this.getTablero()[l][k] == null
                                            && movimientoValido(this.getTablero()[j][i], this.getJugadorAzul(),
                                                    auxCoordenadas, this.getTablero())
                                            && !esArco(l, k, this.getTablero()) && this.listaOtrasJugadas.size() < 5) {
                                    //Si el destino esta vacio, el mov es valido y el arco esta desocupado entonces se puede mover 
                                    // a su destino.

                                        String a = String.valueOf((char) (auxCoordenadas[0] + 65));
                                        String b = String.valueOf((char) (numeroCorrespondiente3(auxCoordenadas[1]) + 49));
                                        this.listaOtrasJugadas.add(a + b + " "
                                                + ((char) (auxCoordenadas[2] + 65))
                                                + ((char) (numeroCorrespondiente3(auxCoordenadas[3]) + 49)));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            //Para el jugador Rojo
            if (this.getTurno() % 2 != 0) {
                for (int i = 0; i < this.getTablero().length; i++) {
                    for (int j = 0; j < this.getTablero().length; j++) {
                        if (this.getTablero()[j][i] != null && !this.getTablero()[j][i].getEsAzul()) {
                            for (int k = 0; k < this.getTablero().length; k++) {
                                for (int l = 0; l < this.getTablero().length; l++) {
                                    int[] auxCoordenadas = new int[4];
                                    auxCoordenadas[0] = i;
                                    auxCoordenadas[1] = j; 
                                    auxCoordenadas[2] = k; // destino x
                                    auxCoordenadas[3] = l; // destino y
                                    if (this.getTablero()[l][k] == null
                                            && movimientoValido(this.getTablero()[j][i], this.getJugadorRojo(),
                                                    auxCoordenadas, this.getTablero())
                                            && !esArco(l, k, this.getTablero()) && this.listaOtrasJugadas.size() < 6) {

                                        String a = String.valueOf((char) (auxCoordenadas[0] + 65));
                                        String b = String.valueOf((char) (numeroCorrespondiente3(auxCoordenadas[1]) + 49));
                                        this.listaOtrasJugadas.add(a + b + " "
                                                + ((char) (auxCoordenadas[2] + 65))
                                                + ((char) (numeroCorrespondiente3(auxCoordenadas[3]) + 49)));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }//para tablero 5x5
        else {
            if (this.getTablero().length == 5) {
                //para el jugador Azul
                if (this.getTurno() % 2 == 0) {
                    for (int i = 0; i < this.getTablero().length; i++) {
                        for (int j = 0; j < this.getTablero().length; j++) {
                            if (this.getTablero()[j][i] != null && this.getTablero()[j][i].getEsAzul()) {
                                for (int k = 0; k < this.getTablero().length; k++) {
                                    for (int l = 0; l < this.getTablero().length; l++) {
                                        int[] auxCoordenadas = new int[4];
                                        auxCoordenadas[0] = i;
                                        auxCoordenadas[1] = j;
                                        auxCoordenadas[2] = k;
                                        auxCoordenadas[3] = l;
                                        if (this.getTablero()[l][k] == null
                                                && movimientoValido(this.getTablero()[j][i], this.getJugadorAzul(),
                                                        auxCoordenadas, this.getTablero())
                                                && !esArco(l, k, this.getTablero()) && this.listaOtrasJugadas.size() < 5) {

                                            String a = String.valueOf((char) (auxCoordenadas[0] + 65));
                                            String b = String.valueOf((char) (numeroCorrespondiente5(auxCoordenadas[1]) + 49));
                                            this.listaOtrasJugadas.add(a + b + " "
                                                    + ((char) (auxCoordenadas[2] + 65))
                                                    + ((char) (numeroCorrespondiente5(auxCoordenadas[3]) + 49)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //para el jugador Rojo
                if (this.getTurno() % 2 != 0) {
                    for (int i = 0; i < this.getTablero().length; i++) {
                        for (int j = 0; j < this.getTablero().length; j++) {
                            if (this.getTablero()[j][i] != null && !this.getTablero()[j][i].getEsAzul()) {
                                for (int k = 0; k < this.getTablero().length; k++) {
                                    for (int l = 0; l < this.getTablero().length; l++) {
                                        int[] auxCoordenadas = new int[4];
                                        auxCoordenadas[0] = i;
                                        auxCoordenadas[1] = j;
                                        auxCoordenadas[2] = k;
                                        auxCoordenadas[3] = l;
                                        if (this.getTablero()[l][k] == null
                                                && movimientoValido(this.getTablero()[j][i], this.getJugadorRojo(),
                                                        auxCoordenadas, this.getTablero())
                                                && !esArco(l, k, this.getTablero()) && this.listaOtrasJugadas.size() < 6) {

                                            String a = String.valueOf((char) (auxCoordenadas[0] + 65));
                                            String b = String.valueOf((char) (numeroCorrespondiente5(auxCoordenadas[1]) + 49));
                                            this.listaOtrasJugadas.add(a + b + " "
                                                    + ((char) (auxCoordenadas[2] + 65))
                                                    + ((char) (numeroCorrespondiente5(auxCoordenadas[3]) + 49)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void crearTablero(int unaDimension) {
        Ficha[][] tableroAux;
        if (unaDimension == 5) {
            this.tablero = new Ficha[5][5];

            for (int j1 = 0; j1 < 5; j1++) {
                this.tablero[0][j1] = new Ficha(false, false, 0, j1, this.getJugadorRojo());
                // 0 y 4 son los arcos
            }
            for (int j2 = 0; j2 < 5; j2++) {
                this.tablero[4][j2] = new Ficha(false, true, 4, j2, this.getJugadorAzul());
            }

        } else {
            this.tablero = new Ficha[3][3];

            for (int j1 = 0; j1 < 3; j1++) {
                this.tablero[0][j1] = new Ficha(false, false, 0, j1, this.getJugadorRojo());

            }
            for (int j2 = 0; j2 < 3; j2++) {
                this.tablero[2][j2] = new Ficha(false, true, 2, j2, this.getJugadorAzul());
            }
        }
    }

    public boolean movAlfil(int origenX, int origenY, int destinoX, int destinoY) {
        return Math.abs(destinoX - origenX) == Math.abs(destinoY - origenY);
    }

    public boolean esArco(int unaFila, int unaColumna, Ficha[][] unaMatrizFichas) {
        boolean arco = false;
        if (unaMatrizFichas.length == 5) {
            if ((unaFila == 0 || unaFila == 4) && unaColumna == 2) {
                arco = true;
            }
        } else if ((unaFila == 0 || unaFila == 2) && unaColumna == 1) {
            arco = true;
        }
        return arco;
    }

    public boolean movimientoValido(Ficha unaFicha, Jugador unJugador, int[] unasCoordenadas, Ficha[][] unaMatrizFichas) {
        int origenX = unasCoordenadas[0];
        int origenY = unasCoordenadas[1];
        int destinoX = unasCoordenadas[2];
        int destinoY = unasCoordenadas[3];
        boolean esValido = true;
        if (this.getTablero()[origenY][origenX] == null) {
            esValido = false;
        } else {
            if (unaFicha.getEsAlfil() && unaFicha.getJugador().equals(unJugador) && caminoLibreAlfil(unasCoordenadas)) { 
    //true = alfil, es del jugador del turno y el camino esta libre
                if (!movAlfil(origenX, origenY, destinoX, destinoY)) {
                    esValido = false;
                }
                if (unaMatrizFichas[destinoY][destinoX] != null && !esArco(destinoY, destinoX, unaMatrizFichas)) {
                    esValido = false;
                } else if (unaMatrizFichas[destinoY][destinoX] != null && esArco(destinoY, destinoX, unaMatrizFichas)
                        && unaMatrizFichas[destinoY][destinoX].getJugador().equals(unJugador)) {
                    esValido = false;
                }
            } else if (unaFicha.getJugador().equals(unJugador) && caminoLibreTorre(unasCoordenadas)) { //torre
                if (origenX != destinoX && origenY != destinoY) {
                    esValido = false;
                }
                if (origenX == destinoX && origenY == destinoY) {
                    esValido = false;
                }
                if (unaMatrizFichas[destinoY][destinoX] != null && !esArco(destinoY, destinoX, unaMatrizFichas)) {
                    esValido = false;
                } else if (unaMatrizFichas[destinoY][destinoX] != null && esArco(destinoY, destinoX, unaMatrizFichas)
                        && unaMatrizFichas[destinoY][destinoX].getJugador().equals(unJugador)) {
                    esValido = false;
                }
            } else {
                esValido = false;
            }
        }

        return esValido;
    }

    public boolean caminoLibreTorre(int[] unasCoordenadas) {

        int origenX = unasCoordenadas[0];
        int origenY = unasCoordenadas[1];
        int destinoX = unasCoordenadas[2];
        int destinoY = unasCoordenadas[3];

        boolean estaLibre = true;

        if (origenX == destinoX && origenY - destinoY > 0) {
            //se mueve hacia arriba
            int fila = origenY - 1;
            while (fila > destinoY && estaLibre) {
                if (this.getTablero()[fila][origenX] != null) {
                    estaLibre = false;
                }
                fila--;
            }
        }
        if (origenX == destinoX && origenY - destinoY < 0) {
            //se mueve hacia abajo
            int fila = origenY + 1;
            while (fila < destinoY && estaLibre) {
                if (this.getTablero()[fila][origenX] != null) {
                    estaLibre = false;
                }
                fila++;
            }
        }
        if (origenX - destinoX < 0 && origenY == destinoY) {
            //se mueve hacia la derecha
            int columna = origenX + 1;
            while (columna < destinoX && estaLibre) {
                if (this.getTablero()[origenY][columna] != null) {
                    estaLibre = false;
                }
                columna++;
            }
        } else if (origenX - destinoX > 0 && origenY == destinoY) {
            //se mueve hacia la izquierda
            int columna = origenX - 1;
            while (columna > destinoX && estaLibre) {
                if (this.getTablero()[origenY][columna] != null) {
                    estaLibre = false;
                }
                columna--;
            }
        }
        return estaLibre;
    }

    public boolean caminoLibreAlfil(int[] unasCoordenadas) {

        int origenX = unasCoordenadas[0];
        int origenY = unasCoordenadas[1];
        int destinoX = unasCoordenadas[2];
        int destinoY = unasCoordenadas[3];

        boolean estaLibre = true;

        if (origenX - destinoX < 0 && origenY - destinoY > 0) {
            //se mueve hacia arriba a la derecha
            int fila = origenY - 1;
            int columna = origenX + 1;
            while (fila >= destinoY + 1 && columna <= destinoX - 1 && estaLibre) {
                if (this.getTablero()[fila][columna] != null) {
                    estaLibre = false;
                }
                fila--;
                columna++;
            }
        }
        else if (origenX - destinoX < 0 && origenY - destinoY < 0) {
            //se mueve hacia abajo a la derecha
            int fila = origenY + 1;
            int columna = origenX + 1;
            while (fila <= destinoY - 1 && columna <= destinoX - 1 && estaLibre) {
                if (this.getTablero()[fila][columna] != null) {
                    estaLibre = false;
                }
                fila++;
                columna++;
            }
        }
        else if (origenX - destinoX > 0 && origenY - destinoY < 0) {
            //se mueve hacia abajo a la izquierda
            int fila = origenY + 1;
            int columna = origenX - 1;
            while (fila <= destinoY - 1 && columna >= destinoX + 1 && estaLibre) {
                if (this.getTablero()[fila][columna] != null) {
                    estaLibre = false;
                }
                fila++;
                columna--;
            }
        } else {
            int fila = origenY - 1;
            int columna = origenX - 1;
            while (fila >= destinoY + 1 && columna >= destinoX + 1 && estaLibre) {
                if (this.getTablero()[fila][columna] != null) {
                    estaLibre = false;
                }
                fila--;
                columna--;
            }
        }
        return estaLibre;
    }

    public int numeroCorrespondiente5(int unIndice) {
        int indice = unIndice;
        int[] correspondiente = new int[]{4, 3, 2, 1, 0};
        indice = correspondiente[indice];
        return indice;
    }
    //Para transformar lo que ingreso el usuario

    public int numeroCorrespondiente3(int unIndice) {
        int indice = unIndice;
        int[] correspondiente = new int[]{2, 1, 0};
        indice = correspondiente[indice];
        return indice;
    }

    public Ficha[][] mover(int[] unasCoordenadas) {

        int origenX = unasCoordenadas[0];
        int origenY = unasCoordenadas[1];
        int destinoX = unasCoordenadas[2];
        int destinoY = unasCoordenadas[3];
        Ficha fAux = new Ficha(this.tablero[origenY][origenX].getEsAlfil(), this.tablero[origenY][origenX].getEsAzul(), destinoY,
                destinoX, this.tablero[origenY][origenX].getJugador());
        this.getTablero()[destinoY][destinoX] = fAux;
        this.getTablero()[origenY][origenX] = null;
        this.turno = this.turno + 1;

        this.getTablero()[destinoY][destinoX].setEsAlfil(!this.getTablero()[destinoY][destinoX].getEsAlfil());

        if (this.tablero.length == 5) {

            if (this.getTurno() % 2 == 0) {

                this.historialJugadas.add(this.getJugadorRojo().getAlias() + ": " + (char) (origenX + 65) + (char) (numeroCorrespondiente5(origenY) + 49) + " "
                        + (char) (destinoX + 65) + (char) (numeroCorrespondiente5(destinoY) + 49));
            } else {

                this.historialJugadas.add(this.getJugadorAzul().getAlias() + ": " + (char) (origenX + 65) + (char) (numeroCorrespondiente5(origenY) + 49) + " "
                        + (char) (destinoX + 65) + (char) (numeroCorrespondiente5(destinoY) + 49));
            }
        } else {

            if (this.getTurno() % 2 == 0) {
                this.historialJugadas.add(this.getJugadorRojo().getAlias() + ": " + (char) (origenX + 65) + (char) (numeroCorrespondiente3(origenY) + 49) + " "
                        + (char) (destinoX + 65) + (char) (numeroCorrespondiente3(destinoY) + 49));
            } else {

                this.historialJugadas.add(this.getJugadorAzul().getAlias() + ": " + (char) (origenX + 65) + (char) (numeroCorrespondiente3(origenY) + 49) + " "
                        + (char) (destinoX + 65) + (char) (numeroCorrespondiente3(destinoY) + 49));
            }

        }
        this.jugadasAtaqueDisponibles();
        this.jugadasDefensaDisponibles();
        this.otrasJugadasDisponibles();
        
        return this.tablero;
        }
}
