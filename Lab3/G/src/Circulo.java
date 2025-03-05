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

    public Ponto getCentro() {
        return centro;
    }

    public double getRaio() {
        return raio;
    }

    public boolean intersetaSegmento(Segmento segmento) {
        return segmento.distanciaPontoAoCentro(centro) <= raio;
    }
}