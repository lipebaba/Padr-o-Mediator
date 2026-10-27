public class Ventilador {
    private boolean ligado;

    public void ligar() { ligado = true; }
    public void desligar() { ligado = false; }
    public boolean isLigado() { return ligado; }
}