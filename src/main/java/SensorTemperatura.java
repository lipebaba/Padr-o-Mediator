public class SensorTemperatura {
    private final MediadorEstufa mediador;

    public SensorTemperatura(MediadorEstufa mediador) {
        this.mediador = mediador;
    }

    public void medir(int temperatura) {
        mediador.temperaturaAlterada(temperatura);
    }
}