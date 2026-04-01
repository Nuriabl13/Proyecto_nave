package hlanz.juegonaves;

import bcp.framework.consola.SpriteGameObject;

import java.awt.*;

public class Disparo extends SpriteGameObject {
    // Variables
    private int idJugador;
    private int vx;
    private int vy;

    // Constructor
    public Disparo(int id, int x, int y, int vx, int vy) {
        super(CacheImagenes.getInstancia().getImagen("disparo.png"), x,y);
        this.idJugador = id;
        this.vx = vx;
        this.vy = vy;
    }

    // Métodos
    public void realizarFrame(){
        this.moverX(vx);
        this.moverY(vy);
        if(
            getX() > this.juego.getAnchuraPantalla() ||
            getX() < this.juego.getAnchuraPantalla() ||
            getY() > this.juego.getAlturaPantalla() ||
            getY() < this.juego.getAlturaPantalla()
        ){
            this.finalizar();
        }
        // METODO INCOMPLETO (necesita la lista de enemigos de JuegoNaves)
    }
}
