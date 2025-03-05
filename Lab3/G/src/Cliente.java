import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Leitura dos 4 pontos
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int x3 = sc.nextInt();
            int y3 = sc.nextInt();
            int x4 = sc.nextInt();
            int y4 = sc.nextInt();

            // Criação dos pontos
            Ponto p1 = new Ponto(x1, y1);
            Ponto p2 = new Ponto(x2, y2);
            Ponto p3 = new Ponto(x3, y3);
            Ponto p4 = new Ponto(x4, y4);

            // Criação do retângulo
            Retangulo retangulo = new Retangulo(p1, p2, p3, p4);

            // Verificação dos pontos
            if (!p1.noPrimeiroQuadrante() || !p2.noPrimeiroQuadrante() || !p3.noPrimeiroQuadrante() || !p4.noPrimeiroQuadrante()) {
                System.out.println("Ponto:vi");
            } else if (!retangulo.ehRetangulo()) {
                System.out.println("Retangulo:vi");
            } else {
                System.out.println(retangulo.toString());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
