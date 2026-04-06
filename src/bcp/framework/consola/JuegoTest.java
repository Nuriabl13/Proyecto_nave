package bcp.framework.consola;

import org.junit.Test;

import static org.junit.Assert.*;

public class JuegoTest {
    @Test
    public void test1(){
        EscenaTesteadora et=new EscenaTesteadora();
        Juego j=new Juego();
        j.iniciar(et,Resolucion.VENTANA_VGA);
        j.detener();
        boolean funciona=false;
        if(et.getFrameCounter()>=110 && et.getFrameCounter()<=130){
            funciona=true;
        }
        assertTrue(funciona);
    }
}