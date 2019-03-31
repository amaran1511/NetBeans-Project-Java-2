package grabacion;

import java.io.*;

public class ArchivoGrabacion {

    BufferedWriter out;

    public ArchivoGrabacion(String unNombre) {
        try {
            out = new BufferedWriter(new FileWriter(unNombre));
        } catch (IOException e) {
            System.out.println("No se puede crear el archivo.");                 
        }
    }
    
    public boolean grabarLinea(String linea) {
        boolean ok = true;
        try {
            out.write(linea);
            out.newLine();
        } catch (IOException e) {
            System.out.println("Error de escritura.");
            ok = false;
        }
        return ok;
    }
    
    public boolean cerrar() {
        boolean ok = true;
        try {
            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar el archivo.");
            ok = false;
        }
        return ok;
    }
}
