package Lab2.E;

/**
 * Classe que representa um Segmento de reta definido por dois pontos
 * @author Alexandre Santos
 * @version 2.0 20/02/2025
 * @inv Os pontos do segmento devem estar totalmente no primeiro quadrante e não podem ser coincidentes
 * @param p1 Ponto inicial do segmento
 * @param p2 Ponto final do segmento
 * @return Distância mínima do segmento ao centro de um círculo
 * @see
 */

 public class Segmento {
    private Ponto p1;
    private Ponto p2;

    public Segmento(Ponto p1, Ponto p2) {
        if (!p1.noPrimeiroQuadrante() || !p2.noPrimeiroQuadrante()) {
            throw new IllegalArgumentException("Ponto:vi");
        }
        if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) {
            throw new IllegalArgumentException("Segmento:vi");
        }
        this.p1 = p1;
        this.p2 = p2;
    }

    // Distância do segmento ao centro do círculo
    public double distanciaPontoAoCentro(Ponto centro) {
        double x0 = centro.getX();
        double y0 = centro.getY();
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();

        double numerador = Math.abs((y2 - y1) * x0 - (x2 - x1) * y0 + x2 * y1 - y2 * x1);
        double denominador = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));

        return numerador / denominador;
    }
}
