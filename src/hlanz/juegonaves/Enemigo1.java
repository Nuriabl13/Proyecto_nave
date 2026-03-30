package hlanz.juegonaves;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemigo1 extends Enemigo{
    // Variables
    private int velocidad;

    // Constructor
    public Enemigo1(int x, int y, int v) throws IOException {
        super(x,y,ImageIO.read(new File("recursos/malo1")));
        this.velocidad = v;
    }

    // Métodos
    @Override
    public int getPuntuacion() {
        return this.velocidad * 2;
    }

    public void realizarFrame(){
        if(
            getX() + this.velocidad > super.juego.getAnchuraPantalla() ||
            getX() + this.velocidad < super.juego.getAnchuraPantalla()
        ){
            this.velocidad = -this.velocidad;
        }
        moverX(this.velocidad);
    }
}
