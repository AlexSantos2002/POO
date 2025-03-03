package Lab2.D;

import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int xC = sc.nextInt();
            int yC = sc.nextInt();
            Ponto centro = new Ponto(xC, yC);

            double raio = sc.nextDouble();

            Circulo circulo = new Circulo(centro, raio);

            System.out.println(circulo.getPerimetroInteiro());
        }
    }
}