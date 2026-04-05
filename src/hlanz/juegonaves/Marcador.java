package hlanz.juegonaves;

import bcp.framework.consola.GameObject;
import bpc.daw.consola.CapaCanvas;

import java.awt.*;
import java.util.ArrayList;

public class Marcador extends GameObject {
    // Variables
    private static int[] puntos;

    // Constructor
    public Marcador(){
        Marcador.puntos = new int[]{0,0};
    }

    // Métodos
    @Override
    public void inicializar() {
        Marcador.puntos = new int[]{0,0};
    }

    public static void incrementarPuntos(int jugador, int puntos) throws IllegalAccessException {
        // JUGADOR 1 == 0  |  JUGADOR 2 == 1
        if(puntos >= 0) {
            if (jugador == 0) {
                Marcador.puntos[0] += puntos;
            } else if (jugador == 1) {
                Marcador.puntos[1] += puntos;
            } else {
                throw new IllegalAccessException("ERROR: Número de JUGADOR INCORRECTO. J1 = 0, J2 = 1");
            }
        }else{
            throw new IllegalAccessException("ERROR: La puntuación no puede ser negativa");
        }
    }

    @Override
    public void ejecutarFrame() {
        CapaCanvas cc = this.consola.getCapaCanvas();
        Graphics g = cc.getGraphics();
        g.drawString(
                "J1 : "+Marcador.puntos[0]+"   |   J2 : "+Marcador.puntos[1],
                this.juego.getAnchuraPantalla()/2-30,0
        );
    }

    @Override
    public void finalizar() {
    }
}
