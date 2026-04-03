package hlanz.juegonaves;

public class Nave1 extends Nave {
    //constructores
    public Nave1(int ti, int tde, int tdi) {
        super(ti, tde, tdi, 5, CacheImagenes.getInstancia().getImagen("recursos/nave1.png"));
    }

    //métodos del padre
    @Override
    protected void realizarDisparo() {
        Disparo d = new Disparo(0, this.getX(), this.getY(), 0, -10);
        this.escena.añadir(d);
    }
}
