package bcp.framework.consola;

import bpc.daw.consola.Consola;

import java.util.List;

public abstract class Escena {
    protected Juego juego;
    protected Consola consola;
    private List<GameObject> objetos;

    public Escena(){

    }

    protected abstract void añadirObjetosIniciales();

    public void añadir(GameObjetct obj){

    }

    public void retirar(GameObject obj){

    }
}
