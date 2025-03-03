package Lab2.D;

/**
 * Representa um Círculo com um ponto central e um raio
 * @author Alexandre Santos
 * @version 1.0 19/02/2025
 * @inv O círculo deve estar totalmente no primeiro quadrante (não podendo estar na "borda")
 * @param centro Ponto
 * @param raio Raio
 * @return Perímetro
 * @see
 */
public class Circulo {
    private Ponto centro;
    private double raio;

    public Circulo(Ponto centro, double raio) {
        if (!centro.noPrimeiroQuadrante()) { 
            System.out.println("Ponto:vi");
            System.exit(0);
        }
        if (raio <= 0 || centro.getX() - raio < 0 || centro.getY() - raio < 0) {
            System.out.println("Circulo:vi");
            System.exit(0);
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
}