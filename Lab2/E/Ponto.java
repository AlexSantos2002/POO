package Lab2.E;

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
        return Math.sqrt(x * x + y * y);
    }

    public double getX() { return x; }
    public double getY() { return y; }
}
