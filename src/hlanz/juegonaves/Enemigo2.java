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
        super(x,y,Placeholder_malo2);
        this.centroX = cx;
        this.centroY = cy;
        this.radio = r;
        this.angulo = 0;
        this.velocidad = v;
    }

    // Métodos
    @Override
    public int getPuntuacion() {
        return (int)Math.round(this.velocidad*3);
    }

    public void realizarFrame(){
        this.angulo += this.velocidad;
        if (this.angulo >= 2 * Math.PI) {
            this.angulo = 0;
        }
        int nuevoX = (int) (this.centroX + this.radio * Math.cos(this.angulo));
        int nuevoY = (int) (this.centroY + this.radio * Math.sin(this.angulo));
        this.setX(nuevoX);
        this.setY(nuevoY);
    }
}
