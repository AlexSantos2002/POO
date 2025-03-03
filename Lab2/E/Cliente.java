package Lab2.E;

import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Leitura dos dados do círculo
            int xC = sc.nextInt();
            int yC = sc.nextInt();
            double raio = sc.nextDouble();
            Ponto centro = new Ponto(xC, yC);
            Circulo circulo = new Circulo(centro, raio);

            // Leitura dos dados do segmento
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            Ponto p1 = new Ponto(x1, y1);
            Ponto p2 = new Ponto(x2, y2);
            Segmento segmento = new Segmento(p1, p2);

            // Verificação da interseção
            if (circulo.intersetaSegmento(segmento)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
