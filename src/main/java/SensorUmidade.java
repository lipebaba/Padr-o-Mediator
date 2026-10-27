public class SensorUmidade {
    private final MediadorEstufa mediador;

    public SensorUmidade(MediadorEstufa mediador) {
        this.mediador = mediador;
    }

    public void medir(int umidade) {
        if (umidade < 0 || umidade > 100) {
            throw new IllegalArgumentException("A umidade deve estar entre 0 e 100.");
        }
        mediador.umidadeAlterada(umidade);
    }
}