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
        this.setEscena(e);
        this.resolucion=r;
        this.detener=false;
        while (!this.detener){
            if(this.consola.getTeclado().teclaPulsada(KeyEvent.VK_ESCAPE)){
                this.detener();
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
        this.escena.juego=this;
        this.escena.consola=this.consola;
        this.escena.inicializar();
    }

    public void detener(){
        this.detener=true;
    }

    public int getAnchuraPantalla(){
        return this.resolucion.getResolucion().width;
    }

    public int getAlturaPantalla(){
        return this.resolucion.getResolucion().height;
    }
}
