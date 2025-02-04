import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double xA = sc.nextDouble();
            double yA = sc.nextDouble();
            double xB = sc.nextDouble();
            double yB = sc.nextDouble();

            Ponto a = new Ponto(xA, yA);
            Ponto b = new Ponto(xB, yB);

            int distancia = (int) a.distancia(b);
            System.out.print(distancia);
        }
    }
}