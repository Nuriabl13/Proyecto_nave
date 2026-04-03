package hlanz.juegonaves;

import bcp.framework.consola.Escena;
import bcp.framework.consola.GameObject;
import bcp.framework.consola.Juego;
import bcp.framework.consola.Resolucion;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class JuegoNaves extends Escena {
    //variables de instancia
    List<Enemigo> enemigos;

    //getters
    public List<Enemigo> getEnemigos() {
        return Collections.unmodifiableList(this.enemigos);
    }

    //métodos del padre
    @Override
    public void añadir(GameObject obj) {
        super.añadir(obj);
        if (obj instanceof Enemigo) {
            this.enemigos.add((Enemigo)obj);
        }
    }
    @Override
    public void retirar(GameObject obj) {
        super.retirar(obj);
        if (obj instanceof Enemigo) {
            this.enemigos.remove((Enemigo)obj);
        }
    }

    //métodos abstractos del padre
    @Override
    protected void añadirObjetosIniciales() {
        this.añadir(new ControladorFinJuego());
        this.añadir(new Fondo(5));
        this.añadir(new Nave1(KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_S));
        this.añadir(new Nave1(KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN));
        Random r = new Random();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        try {
            for (int i = 0; i < 20; i++) {
                if (r.nextBoolean()) {
                    this.añadir(new Enemigo1(
                            r.nextInt((int) d.getWidth()),
                            r.nextInt((int) d.getHeight()),
                            3 + r.nextInt(4)
                    ));
                } else {
                    this.añadir(new Enemigo2(
                            r.nextInt((int) d.getWidth()),
                            r.nextInt((int) d.getHeight()),
                            r.nextInt(11),
                            r.nextInt(11),
                            10,
                            3 + r.nextInt(4)
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        this.añadir(new Marcador());
    }

    //programa
    public static void main(String[] args) {
        Juego j = new Juego();
        j.iniciar(new JuegoNaves(), Resolucion.VENTANA_FULLHD);
    }
}
