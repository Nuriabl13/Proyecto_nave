package hlanz.juegonaves;

import bcp.framework.consola.GameObject;

public class ControladorFinJuego extends GameObject {

    // Constructor
    public ControladorFinJuego(){
    }

    // Métodos
    @Override
    public void ejecutarFrame() {
        if(JuegoNaves.getEnemigos().isEmpty()){
            this.juego.detener();
        }
    }

    @Override
    public void inicializar() {
    }

    @Override
    public void finalizar() {
    }
}
