package bcp.framework.consola;

import org.junit.Test;

import static org.junit.Assert.*;

public class JuegoTest {
    @Test
    public void test1(){
        EscenaTesteadora et=new EscenaTesteadora();
        Juego j=new Juego();
        j.iniciar(et,Resolucion.VENTANA_VGA);
    }
}