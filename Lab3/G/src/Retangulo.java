/**
 * A classe Retangulo representa um retângulo definido por 4 pontos no plano cartesiano.
 * Ela valida se os pontos fornecidos formam um retângulo, se estão no primeiro quadrante
 * e fornece uma representação em string desses pontos.
 *
 * @author Alexandre Santos
 * @version 1.0 04/03/2025
 * @inv Os pontos do retângulo devem estar no primeiro quadrante (x >= 0, y >= 0) e devem formar um retângulo válido
 *      (com ângulos de 90 graus e distâncias adequadas entre os pontos).
 */
public class Retangulo {
    private Ponto[] pontos = new Ponto[4];

    /**
     * Construtor da classe Retangulo
     * @param p1 Ponto inicial do retângulo
     * @param p2 Ponto adjacente ao p1 do retângulo
     * @param p3 Ponto oposto ao p1 do retângulo
     * @param p4 Ponto adjacente ao p3 do retângulo
     */
    public Retangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        pontos[0] = p1;
        pontos[1] = p2;
        pontos[2] = p3;
        pontos[3] = p4;
    }

    /**
     * Verifica se os pontos fornecidos formam um retângulo válido
     * @return true se os pontos formam um retângulo, false caso contrário
     */
    public boolean ehRetangulo() {
        for (Ponto p : pontos) {
            if (!p.noPrimeiroQuadrante()) {
                return false;
            }
        }

        // Verifica se os pontos formam um retângulo
        double dist1 = distancia(pontos[0], pontos[1]);
        double dist2 = distancia(pontos[1], pontos[2]);
        double dist3 = distancia(pontos[2], pontos[3]);
        double dist4 = distancia(pontos[3], pontos[0]);

        double diag1 = distancia(pontos[0], pontos[2]);
        double diag2 = distancia(pontos[1], pontos[3]);

        return dist1 == dist3 && dist2 == dist4 && diag1 == diag2;
    }

    /**
     * Calcula a distância entre dois pontos
     * @param p1 Primeiro ponto
     * @param p2 Segundo ponto
     * @return Distância entre p1 e p2
     */
    private double distancia(Ponto p1, Ponto p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    /**
     * Retorna a representação do retângulo como uma string
     * @return Uma string representando os pontos do retângulo
     */
    @Override
    public String toString() {
        return "[(" + (int) pontos[0].getX() + "," + (int) pontos[0].getY() + "), "
                + "(" + (int) pontos[1].getX() + "," + (int) pontos[1].getY() + "), "
                + "(" + (int) pontos[2].getX() + "," + (int) pontos[2].getY() + "), "
                + "(" + (int) pontos[3].getX() + "," + (int) pontos[3].getY() + ")]";
    }
}
