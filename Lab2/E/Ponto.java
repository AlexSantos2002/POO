package Lab2.E;

/**
 * Classe que representa um ponto em um plano cartesiano
 */
public class Ponto {
    private double x;
    private double y;

    /**
     * Construtor que inicializa um ponto com coordenadas cartesianas
     * @param x Coordenada X do ponto
     * @param y Coordenada Y do ponto
     */
    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Construtor que inicializa um ponto com coordenadas polares
     * @param r Raio (distância até a origem)
     * @param theta Ângulo em graus
     */
    public Ponto(double r, double theta) {
        this.x = r * Math.cos(Math.toRadians(theta));
        this.y = r * Math.sin(Math.toRadians(theta));
    }

    /**
     * Verifica se o ponto está no primeiro quadrante
     * @return true se o ponto estiver no primeiro quadrante, false caso contrário
     */
    public boolean noPrimeiroQuadrante() {
        return (x >= 0 && y >= 0);
    }    

    /**
     * Calcula a distância do ponto até a origem
     * @return Distância do ponto até a origem
     */
    public double distanciaOrigem() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Retorna a coordenada X do ponto
     * @return Coordenada X
     */
    public double getX() { return x; }
    
    /**
     * Retorna a coordenada Y do ponto
     * @return Coordenada Y
     */
    public double getY() { return y; }
}
