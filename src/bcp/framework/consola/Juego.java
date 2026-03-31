package bcp.framework.consola;

import bpc.daw.consola.Consola;

import java.awt.event.KeyEvent;

public class Juego {
    private Consola consola;
    private Escena escena;
    private boolean detener;
    private Resolucion resolucion;

    public void iniciar(Escena e,Resolucion r){
        this.consola=new Consola("Consola",r.getResolucion().width,r.getResolucion().height);
        this.resolucion=r;
        this.escena=e;
        this.detener=false;
        while(this.detener){
            if (this.consola.getTeclado().teclaPulsada(KeyEvent.VK_ESCAPE)){
                this.detener=true;
            }
            this.escena.ejecutarFrame();
            this.consola.esperarSiguienteFrame();
        }
    }

    public Escena getEscena(){
        return this.escena;
    }

    public void setEscena(Escena e){
        this.escena=e;
    }

    public void detener(){

    }

    public int getAnchuraPantalla(){
        return 1;
    }

    public int getAlturaPantalla(){
        return 1;
    }
}
