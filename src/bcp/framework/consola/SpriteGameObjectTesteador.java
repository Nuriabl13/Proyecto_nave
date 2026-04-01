package bcp.framework.consola;

import bpc.daw.consola.Consola;
import bpc.daw.consola.Sprite;
import bpc.daw.consola.Teclado;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SpriteGameObjectTesteador extends GameObject{

    private Sprite sprite;

    public SpriteGameObjectTesteador(Image imagen, int x, int y){
        this.sprite = super.consola.getCapaSprites().crearSprite(imagen,new Rectangle(imagen.getWidth(null),imagen.getHeight(null)),x,y);
    }

    @Override
    public void inicializar() {

    }

    @Override
    public void ejecutarFrame() {
        Teclado t = super.consola.getTeclado();
        if (t.teclaPulsada(KeyEvent.VK_W)){
            this.sprite.moverY(-5);
        } else if (t.teclaPulsada(KeyEvent.VK_S)) {
            this.sprite.moverY(5);
        } else if (t.teclaPulsada(KeyEvent.VK_A)) {
            this.sprite.moverX(-5);
        } else if (t.teclaPulsada(KeyEvent.VK_D)) {
            this.sprite.moverX(5);
        }
    }

    @Override
    public void finalizar() {

    }
}
