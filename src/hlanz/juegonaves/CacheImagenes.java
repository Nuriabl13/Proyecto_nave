package hlanz.juegonaves;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CacheImagenes {
    //variables de la clase
    private static CacheImagenes instancia = null;

    //variables de instancia
    private Map<String, Image> imagenes;

    //constructores
    private CacheImagenes() {
        this.imagenes = new HashMap<>();
    }

    //métodos
    public Image getImagen(String archivo) {
        Image i = null;
        if (this.imagenes.containsKey(archivo)) {
            i = this.imagenes.get(archivo);
        } else {
            try {
                i = ImageIO.read(new File(archivo));
                this.imagenes.put(archivo, i);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return i;
    }

    //métodos de la clase
    public static CacheImagenes getInstancia() {
        if (CacheImagenes.instancia == null) {
            CacheImagenes.instancia = new CacheImagenes();
        }
        return CacheImagenes.instancia;
    }
}
