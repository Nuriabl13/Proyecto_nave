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
    public void realizarFrame() throws IllegalAccessException {
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
        for(int i = 0; i<JuegoNaves.getEnemigos().size(); i++){
            boolean colisionX =
                    this.getX() < JuegoNaves.getEnemigos().get(i).getX() + JuegoNaves.getEnemigos().get(i).getAnchura() &&
                    this.getX() + this.getAnchura() > JuegoNaves.getEnemigos().get(i).getX();
            boolean colisionY =
                    this.getY() < JuegoNaves.getEnemigos().get(i).getY() + JuegoNaves.getEnemigos().get(i).getAltura() &&
                    this.getY() + this.getAltura() > JuegoNaves.getEnemigos().get(i).getY();
            if (colisionX && colisionY) {
                this.escena.retirar(this);
                this.escena.retirar(JuegoNaves.getEnemigos().get(i));

                Marcador.incrementarPuntos(this.idJugador, JuegoNaves.getEnemigos().get(i).getPuntuacion());
            }
        }
    }
}
