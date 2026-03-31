package bcp.framework.consola;

import bpc.daw.consola.Consola;

import java.util.ArrayList;
import java.util.List;

public abstract class Escena implements ElementoJuego{
    protected Juego juego;
    protected Consola consola;
    private List<GameObject> objetos;

    public Escena(){
        this.juego=null;
        this.consola=null;
        this.objetos=null;
    }

    protected abstract void añadirObjetosIniciales();

    public void añadir(GameObject obj){
        obj.consola=this.consola;
        obj.escena=this;
        obj.juego=this.juego;
        obj.inicializar();
    }

    public void retirar(GameObject obj){
        obj.finalizar();
        this.objetos.remove(obj);
        obj.consola=null;
        obj.escena=null;
    }

    @Override
    public void inicializar() {
        if (this.consola==null||this.juego==null){
            throw new IllegalStateException("Hay que añadir la escena al juego para poder iniciarla");
        }
        this.objetos=new ArrayList<>();
    }

    @Override
    public void ejecutarFrame(){
        for (int i=0;i<this.objetos.size();i++){
            this.objetos.get(i).ejecutarFrame();
        }
    }

    @Override
    public void finalizar(){
        for (int i=this.objetos.size()-1;i>=0;i--){
            this.retirar(this.objetos.get(i));
        }
    }
}
