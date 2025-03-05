/**
 * Classe que representa um retângulo definido por quatro pontos.
 * Permite verificar se os pontos formam um retângulo válido e se um segmento
 * de reta intersecciona alguma de suas arestas.
 *
 * @author Alexandre Santos
 * @version 2.0 05/03/2025
 * @inv Os pontos devem formar um retângulo válido com ângulos de 90 graus.
 */
class Retangulo {
    private Ponto[] pontos = new Ponto[4];

    /**
     * Construtor da classe Retangulo.
     *
     * @param p1 Primeiro ponto do retângulo.
     * @param p2 Segundo ponto do retângulo.
     * @param p3 Terceiro ponto do retângulo.
     * @param p4 Quarto ponto do retângulo.
     */
    public Retangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        pontos[0] = p1;
        pontos[1] = p2;
        pontos[2] = p3;
        pontos[3] = p4;
    }

    /**
     * Verifica se os quatro pontos formam um retângulo válido.
     *
     * @return true se os pontos formam um retângulo, false caso contrário.
     */
    public boolean ehRetangulo() {
        double dist1 = distancia(pontos[0], pontos[1]);
        double dist2 = distancia(pontos[1], pontos[2]);
        double dist3 = distancia(pontos[2], pontos[3]);
        double dist4 = distancia(pontos[3], pontos[0]);
        double diag1 = distancia(pontos[0], pontos[2]);
        double diag2 = distancia(pontos[1], pontos[3]);
        return dist1 == dist3 && dist2 == dist4 && diag1 == diag2;
    }

    /**
     * Calcula a distância entre dois pontos.
     *
     * @param p1 Primeiro ponto.
     * @param p2 Segundo ponto.
     * @return A distância entre p1 e p2.
     */
    private double distancia(Ponto p1, Ponto p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    /**
     * Verifica se um segmento de reta intersecciona alguma das arestas do retângulo.
     *
     * @param segmento O segmento de reta a ser testado.
     * @return true se houver interseção, false caso contrário.
     */
    public boolean intersecaSegmento(Segmento segmento) {
        for (int i = 0; i < 4; i++) {
            int j = (i + 1) % 4;
            Segmento aresta = new Segmento(pontos[i], pontos[j]);
            if (segmento.intersecta(aresta)) {
                return true;
            }
        }
        return false;
    }
}