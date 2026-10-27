public class CentralEstufa implements MediadorEstufa {
    private final Irrigador irrigador;
    private final Ventilador ventilador;

    public CentralEstufa(Irrigador irrigador, Ventilador ventilador) {
        this.irrigador = irrigador;
        this.ventilador = ventilador;
    }

    @Override
    public void umidadeAlterada(int umidade) {
        if (umidade < 40) {
            irrigador.ligar();
        } else {
            irrigador.desligar();
        }
    }

    @Override
    public void temperaturaAlterada(int temperatura) {
        if (temperatura > 30) {
            ventilador.ligar();
        } else {
            ventilador.desligar();
        }
    }
}