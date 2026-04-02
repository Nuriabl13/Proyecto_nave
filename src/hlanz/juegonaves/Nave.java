package hlanz.juegonaves;

import bcp.framework.consola.SpriteGameObject;

import java.awt.*;
import java.time.Instant;

public abstract class Nave extends SpriteGameObject {
    //variables de instancia
    private int teclaIzquierda;
    private int teclaDerecha;
    private int teclaDisparo;
    private int velocidad;
    private Instant ultimoDisparoRealizado;

    //constructores
    public Nave(int ti, int tde, int tdi, int v, Image imagen) {
        super(imagen, 0, 0);
        this.teclaIzquierda = ti;
        this.teclaDerecha = tde;
        this.teclaDisparo = tdi;
        this.velocidad = v;
    }

    //métodos
    public void ejecutarFrame() {
        if (this.consola.getTeclado().teclaPulsada(this.teclaIzquierda) && this.getX() < 0) {
            this.moverX(-this.velocidad);
        }
        if (this.consola.getTeclado().teclaPulsada(this.teclaDerecha) && this.getX() + this.getAnchura() > Toolkit.getDefaultToolkit().getScreenSize().getWidth()) {
            this.moverX(this.velocidad);
        }
        if (this.consola.getTeclado().teclaPulsada(this.teclaDisparo)) {
            this.disparar();
        }
    }
    public void disparar() {
        if (Instant.now().isAfter(this.ultimoDisparoRealizado.plusSeconds(1))) {
            this.ultimoDisparoRealizado = Instant.now();
            this.realizarDisparo();
        }
    }
    protected void realizarDisparo() {}
}
