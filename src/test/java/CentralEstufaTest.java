import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CentralEstufaTest {
    private Irrigador irrigador;
    private Ventilador ventilador;
    private SensorUmidade umidade;
    private SensorTemperatura temperatura;

    @BeforeEach
    void preparar() {
        irrigador = new Irrigador();
        ventilador = new Ventilador();
        MediadorEstufa central = new CentralEstufa(irrigador, ventilador);
        umidade = new SensorUmidade(central);
        temperatura = new SensorTemperatura(central);
    }

    @Test
    void umidadeBaixaLigaIrrigador() {
        umidade.medir(39);
        assertTrue(irrigador.isLigado());
        assertFalse(ventilador.isLigado());
    }

    @Test
    void umidadeNoLimiteDesligaIrrigador() {
        umidade.medir(20);
        umidade.medir(40);
        assertFalse(irrigador.isLigado());
    }

    @Test
    void temperaturaAltaLigaVentilador() {
        temperatura.medir(31);
        assertTrue(ventilador.isLigado());
        assertFalse(irrigador.isLigado());
    }

    @Test
    void temperaturaNoLimiteDesligaVentilador() {
        temperatura.medir(31);
        temperatura.medir(30);
        assertFalse(ventilador.isLigado());
    }

    @Test
    void mediçõesNaoInterferemNoOutroEquipamento() {
        umidade.medir(20);
        temperatura.medir(35);
        umidade.medir(80);
        assertFalse(irrigador.isLigado());
        assertTrue(ventilador.isLigado());
    }

    @Test
    void umidadeInvalidaEhRejeitadaSemAlterarEstado() {
        umidade.medir(20);
        assertThrows(IllegalArgumentException.class, () -> umidade.medir(-1));
        assertThrows(IllegalArgumentException.class, () -> umidade.medir(101));
        assertTrue(irrigador.isLigado());
    }
}