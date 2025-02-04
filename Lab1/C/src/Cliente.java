import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            Ponto[] pontos = new Ponto[n];
            for (int i = 0; i < n; i++){
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                pontos[i] = new Ponto(x,y);
            }
            Caminho caminho = new Caminho(pontos);
            double TamanhoTotal = caminho.CalcularTamanho();

            System.out.printf("%.2f", TamanhoTotal);
        }
    }
}