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
