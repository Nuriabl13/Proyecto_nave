package bcp.framework.consola;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ResolucionTest {
    @Test
    public void test1(){
        Dimension[] dimensiones={new Dimension(4096,2160),
                new Dimension(1920,1080),
                new Dimension(2560,1440),
                new Dimension(800,600)};

        assertEquals(dimensiones[0],Resolucion.VENTANA_4K.getResolucion());
        assertEquals(dimensiones[1],Resolucion.VENTANA_FULLHD.getResolucion());
        assertEquals(dimensiones[2],Resolucion.VENTANA_QHD.getResolucion());
        assertEquals(dimensiones[3],Resolucion.VENTANA_VGA.getResolucion());
    }
}