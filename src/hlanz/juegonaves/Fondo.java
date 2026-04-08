package hlanz.juegonaves;

import bcp.framework.consola.GameObject;
import bcp.framework.consola.Juego;
import bpc.daw.consola.CapaCanvas;

import java.awt.*;

public class Fondo extends GameObject {
    // Variables
    private Image imagen;
    private Rectangle camara;
    private int velocidadCamara;
    private int camaraX;
    private int camaraY;

    // Constructor
    public Fondo(int vc){
        this.imagen = CacheImagenes.getInstancia().getImagen("recursos/fondo.png");
        this.camara = new Rectangle();
        this.velocidadCamara = vc;
        this.camaraX = 0;
        this.camaraY = 0;
    }

    // Métodos
    @Override
    public void inicializar() {
        this.camara = new Rectangle(0,0,JuegoNaves.juego.getAnchuraPantalla(),JuegoNaves.juego.getAlturaPantalla());
    }

    @Override
    public void ejecutarFrame() {
        CapaCanvas cc = this.consola.getCapaCanvas();
        Graphics g = cc.getGraphics();
        g.drawImage(
                this.imagen,
                0,0,
                this.camara.width,this.camara.height,
                this.camaraX, this.camaraY,
                this.camaraX + this.camara.width, this.camaraY + this.camara.height,
                null
        );
        this.camaraY += this.velocidadCamara;

        if (this.camaraY + this.camara.height > this.imagen.getHeight(null)) {
            this.camaraX = 0;
            this.camaraY = 0;
        }
    }

    @Override
    public void finalizar() {
    }


}
