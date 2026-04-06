package bcp.framework.consola;

public class EscenaTesteadora extends Escena {
    private GameObjectTesteador tester;

    public EscenaTesteadora(){
        this.tester=new GameObjectTesteador();
    }

    @Override
    protected void añadirObjetosIniciales() {
        this.añadir(this.tester);
    }

    public int getFrameCounter(){
        return this.tester.frameCounter();
    }

    public boolean esInicializado(){
        return this.tester.inicializado();
    }

    public GameObjectTesteador getTester(){
        return this.tester;
    }

    @Override
    public void inicializar(){
        super.inicializar();
        this.tester.inicializar();
    }

    @Override
    public void finalizar(){
        super.finalizar();
        this.tester.finalizar();
    }

    @Override
    public void ejecutarFrame(){
        super.ejecutarFrame();
        this.tester.ejecutarFrame();
    }
}
