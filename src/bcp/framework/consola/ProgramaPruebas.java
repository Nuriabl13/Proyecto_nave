package bcp.framework.consola;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProgramaPruebas {
    public static void main(String[] args){
        File f = new File("recursos/nave1.png");
        try {
            BufferedImage image = ImageIO.read(f);
            Juego juego = new Juego();
            EscenaTesteadora e = new EscenaTesteadora();
            juego.iniciar(e,Resolucion.PANTALLA_COMPLETA);
            SpriteGameObjectTesteador st = new SpriteGameObjectTesteador(image,100,100);
            st.ejecutarFrame();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
