package Lab2.D;

/**
 * Classe que representa um Ponto no plano cartesiano ou polar.
 * @author Alexandre Santos
 * @version 2.0 20/02/2025
 * @inv ter coordenadas que respeitem o primeiro quadrante
 * @param x Coordenada X 
 * @param y Coordenada Y
 * @return Distância à origem para a verificação da posição
 * @see
 */
public class Ponto {
    private double x;
    private double y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Ponto(double r, double theta) {
        this.x = r * Math.cos(Math.toRadians(theta));
        this.y = r * Math.sin(Math.toRadians(theta));
    }

    public boolean noPrimeiroQuadrante() {
        return (x >= 0 && y >= 0);
    }

    public double distanciaOrigem() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public double getX() { return x; }
    public double getY() { return y; }
}