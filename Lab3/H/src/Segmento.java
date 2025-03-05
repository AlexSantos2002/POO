/**
 * Classe que representa um segmento de reta definido por dois pontos.
 * Permite verificar se dois segmentos de reta se intersectam.
 *
 * @author Alexandre Santos
 * @version 2.0 05/03/2025
 * @inv Os pontos que definem o segmento não podem ser coincidentes.
 */
class Segmento {
    private Ponto p1;
    private Ponto p2;

    /**
     * Construtor da classe Segmento.
     *
     * @param p1 Primeiro ponto do segmento.
     * @param p2 Segundo ponto do segmento.
     * @throws IllegalArgumentException se os pontos forem coincidentes.
     */
    public Segmento(Ponto p1, Ponto p2) {
        if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) {
            throw new IllegalArgumentException("Segmento:vi");
        }
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Verifica se este segmento de reta intersecta outro segmento.
     *
     * @param outro O outro segmento de reta a ser testado.
     * @return true se os segmentos se intersectam, false caso contrário.
     */
    public boolean intersecta(Segmento outro) {
        double d1 = orientacao(outro.p1);
        double d2 = orientacao(outro.p2);
        double d3 = outro.orientacao(p1);
        double d4 = outro.orientacao(p2);
        return (d1 * d2 < 0 && d3 * d4 < 0);
    }

    /**
     * Calcula a orientação de um ponto em relação ao segmento.
     *
     * @param p O ponto a ser analisado.
     * @return O valor da orientação do ponto em relação ao segmento.
     */
    private double orientacao(Ponto p) {
        return (p2.getX() - p1.getX()) * (p.getY() - p1.getY()) - (p2.getY() - p1.getY()) * (p.getX() - p1.getX());
    }

        /**
     * Calcula a distância mínima do segmento ao centro de um círculo
     * @param centro O ponto central do círculo
     * @return A menor distância do segmento até o centro
     */
    public double distanciaPontoAoCentro(Ponto centro) {
        double x0 = centro.getX();
        double y0 = centro.getY();
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
    
        double dx = x2 - x1;
        double dy = y2 - y1;
    
        double t = ((x0 - x1) * dx + (y0 - y1) * dy) / (dx * dx + dy * dy);
    
        if (t < 0) {
            return Math.sqrt(Math.pow(x0 - x1, 2) + Math.pow(y0 - y1, 2));
        } else if (t > 1) {
            return Math.sqrt(Math.pow(x0 - x2, 2) + Math.pow(y0 - y2, 2));
        } else {
            double numerador = Math.abs((y2 - y1) * x0 - (x2 - x1) * y0 + x2 * y1 - y2 * x1);
            double denominador = Math.sqrt(dx * dx + dy * dy);
            return numerador / denominador;
        }
    }
}
