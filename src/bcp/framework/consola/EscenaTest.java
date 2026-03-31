package bcp.framework.consola;

import org.junit.Test;

import static org.junit.Assert.*;

public class EscenaTest {
    @Test
    public void test1(){
        EscenaTesteadora et=new EscenaTesteadora();
        et.inicializar();
        assertTrue(et.esInicializado());
        for (int i=0;i<1253;i++){
            et.ejecutarFrame();
        }
        assertEquals(1253,et.getFrameCounter());
        et.finalizar();
        assertFalse(et.esInicializado());
    }
}