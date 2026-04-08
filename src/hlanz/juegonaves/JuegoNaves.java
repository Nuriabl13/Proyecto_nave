package hlanz.juegonaves;

import bcp.framework.consola.Escena;
import bcp.framework.consola.GameObject;
import bcp.framework.consola.Juego;
import bcp.framework.consola.Resolucion;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class JuegoNaves extends Escena {
    //variables de la clase
    private static List<Enemigo> enemigos = new ArrayList<>();

    //getters
    public static List<Enemigo> getEnemigos() {
        return Collections.unmodifiableList(JuegoNaves.enemigos);
    }

    //métodos del padre
    @Override
    public void añadir(GameObject obj) {
        super.añadir(obj);
        if (obj instanceof Enemigo) {
            JuegoNaves.enemigos.add((Enemigo)obj);
        }
    }
    @Override
    public void retirar(GameObject obj) {
        super.retirar(obj);
        if (obj instanceof Enemigo) {
            JuegoNaves.enemigos.remove((Enemigo)obj);
        }
    }

    //métodos abstractos del padre
    @Override
    protected void añadirObjetosIniciales() {
        this.añadir(new ControladorFinJuego());
        this.añadir(new Fondo(5));
        this.añadir(new Nave1(KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W));
        this.añadir(new Nave1(KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP));
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
        JuegoNaves jn = new JuegoNaves();
        jn.añadirObjetosIniciales();
        jn.juego.iniciar(jn, Resolucion.VENTANA_FULLHD);
    }
}
