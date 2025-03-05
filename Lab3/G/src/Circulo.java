/**
 * Classe que representa um Círculo com um ponto central e um raio
 * @author Alexandre Santos
 * @version 3.0 20/02/2025
 * @inv O círculo deve estar totalmente no primeiro quadrante
 */
public class Circulo {
    private Ponto centro;
    private double raio;

    /**
     * Construtor da classe Circulo
     * @param centro Ponto central do círculo
     * @param raio Raio do círculo
     * @throws IllegalArgumentException se o círculo não estiver no primeiro quadrante ou se o raio for inválido
     */
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

    /**
     * Calcula o perímetro do círculo
     * @return Perímetro do círculo
     */
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }

    /**
     * Retorna o perímetro do círculo como um número inteiro
     * @return Perímetro do círculo convertido para inteiro
     */
    public int getPerimetroInteiro() {
        return (int) calcularPerimetro();
    }

    /**
     * Obtém o ponto central do círculo
     * @return Centro do círculo
     */
    public Ponto getCentro() {
        return centro;
    }

    /**
     * Obtém o raio do círculo
     * @return Raio do círculo
     */
    public double getRaio() {
        return raio;
    }

    /**
     * Verifica se um segmento de reta intersecta o círculo
     * @param segmento Segmento a ser verificado
     * @return true se o segmento intersecta o círculo, false caso contrário
     */
    public boolean intersetaSegmento(Segmento segmento) {
        return segmento.distanciaPontoAoCentro(centro) <= raio;
    }
}