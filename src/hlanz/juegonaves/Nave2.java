package hlanz.juegonaves;

public class Nave2 extends Nave {
    //constructores
    public Nave2(int ti, int tde, int tdi) {
        super(ti, tde, tdi, 3, CacheImagenes.getInstancia().getImagen("recursos/nave2.png"));
    }

    //métodos del padre
    @Override
    protected void realizarDisparo() {
        Disparo d1 = new Disparo(1, this.getX(), this.getY(), -3, -3);
        Disparo d2 = new Disparo(1, this.getX(), this.getY(), 3, -3);
        this.escena.añadir(d1);
        this.escena.añadir(d2);
    }
}
