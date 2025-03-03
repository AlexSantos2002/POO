package Lab2.E;

/**
 * Classe que representa um Círculo com um ponto central e um raio
 * @author Alexandre Santos
 * @version 3.0 20/02/2025
 * @inv O círculo deve estar totalmente no primeiro quadrante
 * @param centro Ponto central do círculo
 * @param raio Raio do círculo
 * @return Perímetro do círculo
 * @see
 */
public class Circulo {
    private Ponto centro;
    private double raio;

    public Circulo(Ponto centro, double raio) {
        if (!centro.noPrimeiroQuadrante()) { 
            throw new IllegalArgumentException("Ponto:vi");
        }
        if (raio <= 0 || centro.getX() - raio < 0 || centro.getY() - raio < 0) {
            throw new IllegalArgumentException("Circulo:vi");
        }
        this.centro = centro;
        this.raio = raio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }

    public int getPerimetroInteiro() {
        return (int) calcularPerimetro();
    }

    public boolean intersetaSegmento(Segmento segmento) {
        return segmento.distanciaPontoAoCentro(centro) <= raio;
    }
}