package obligatoriop2;

import interfaz.JFrameMenuPrincip;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class ObligatorioP2 {

    public static void main(String[] args) {
        Juego juego = deserializar();
        
        JFrameMenuPrincip i = new JFrameMenuPrincip(juego);
        i.setVisible(true);      
        }
    
    private static Juego deserializar(){
        Juego j = null;
        
        try{
         FileInputStream f= new FileInputStream("datos.txt");
           BufferedInputStream l = new BufferedInputStream(f);
           ObjectInputStream o = new ObjectInputStream(l);
           j = (Juego)o.readObject();
           
           o.close();
       }
       catch(Exception e){
           // System.out.println(" " + e);
           j = new Juego();
       }
        
        return j;
    }
}
