public class Aplicacao {
    public static void main(String[] args) {
        Irrigador irrigador = new Irrigador();
        Ventilador ventilador = new Ventilador();
        MediadorEstufa central = new CentralEstufa(irrigador, ventilador);
        SensorUmidade umidade = new SensorUmidade(central);
        SensorTemperatura temperatura = new SensorTemperatura(central);

        umidade.medir(35);
        temperatura.medir(32);
        System.out.println("Irrigador ligado: " + irrigador.isLigado());
        System.out.println("Ventilador ligado: " + ventilador.isLigado());
    }
}