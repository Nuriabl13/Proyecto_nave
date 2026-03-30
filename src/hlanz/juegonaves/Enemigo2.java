package hlanz.juegonaves;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Enemigo2 extends Enemigo{
    // Variables
    private int centroX;
    private int centroY;
    private int radio;
    private double angulo;
    private double velocidad;

    // Constructor
    public Enemigo2(int x, int y, int cx, int cy, int r, int v) throws IOException {
        super(x,y,ImageIO.read(new File("recursos/malo2")));
        this.centroX = cx;
        this.centroY = cy;
        this.radio = r;
        this.angulo = 0;
        this.velocidad = v;
    }

    // Métodos
    @Override
    public int getPuntuacion() {
        return 0;
    }

    public void realizarFrame(){

    }
}
