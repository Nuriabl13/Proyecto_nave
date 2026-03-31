package bcp.framework.consola;

import bpc.daw.consola.Consola;
import bpc.daw.consola.Sprite;

import java.awt.*;

public class SpriteGameObject extends GameObject {

    private Sprite sprite;
    private Image imagen;
    private Point puntoInicial;

    public SpriteGameObject(Image img, int x, int y){
        this.imagen = img;
        this.puntoInicial = new Point(x,y);
        this.sprite = null;
    }

    public int getX(){
        return this.puntoInicial.x;
    }

    public int getY(){
        return this.puntoInicial.y;
    }

    public int getAnchura(){
        return this.imagen.getWidth(null);
    }

    public int getAltura(){
        return this.imagen.getHeight(null);
    }

    public void moverX(int cx){
        this.sprite.moverX(cx);
    }

    public void moverY(int cy){
        this.sprite.moverY(cy);
    }

    public void setX(int x){
        int diferencia = this.sprite.getX()-x;
        this.sprite.moverX(diferencia);
    }

    public void setY(int y){
        int diferencia = this.sprite.getY()-y;
        this.sprite.moverY(diferencia);
    }


    @Override
    public void inicializar() {
        this.sprite = super.consola.getCapaSprites().crearSprite(this.imagen,new Rectangle(this.puntoInicial),this.imagen.getWidth(null),this.imagen.getHeight(null));
    }

    @Override
    public void ejecutarFrame() {

    }

    @Override
    public void finalizar() {
        this.sprite = null;
    }
}
