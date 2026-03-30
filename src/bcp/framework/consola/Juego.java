package bcp.framework.consola;

import bpc.daw.consola.Consola;

public class Juego {
    private Consola consola;
    private Escena escena;
    private boolean detener;
    private Resolucion resolucion;

    public void iniciar(Escena e,Resolucion r){

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
