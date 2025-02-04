public class Caminho {
    private Ponto[] pontos;

    public Caminho(Ponto[] pontos) {
        this.pontos = pontos;
    }

    public double CalcularTamanho() {
        double comprimentoTotal = 0.0;
        for (int i = 0; i < pontos.length - 1; i++) {
            double distancia = pontos[i].distancia(pontos[i + 1]);
            comprimentoTotal += distancia;
        }
        return comprimentoTotal;
    }
}
