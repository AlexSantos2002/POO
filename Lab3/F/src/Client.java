import java.util.Scanner;

public class Client {
    static final String TOTIME = "asTime";
    static final String TOSECS = "asSeconds";
    static final String ADDTIME = "add";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String aString = sc.nextLine(); // Primeiro input
        String operator = sc.nextLine(); // Operação
        String output = "";
        T2time receiver;

        // Determinar se aString está no formato HH:MM:SS ou é um número de segundos
        if (aString.contains(":")) {
            receiver = new T2time(parseTime(aString));
        } else {
            receiver = new T2time(Integer.parseInt(aString));
        }

        switch (operator) {
            case TOTIME:
                output = receiver.toString(); // Converter segundos para HH:MM:SS
                break;
            case TOSECS:
                output = "" + receiver.asSeconds(); // Converter HH:MM:SS para segundos
                break;
            case ADDTIME:
                String bString = sc.nextLine();
                T2time argument;

                if (bString.contains(":")) {
                    argument = new T2time(parseTime(bString));
                } else {
                    argument = new T2time(Integer.parseInt(bString));
                }
                output = receiver.add(argument).toString();
                break;
            default:
                System.out.println("Operação inválida.");
                return;
        }

        System.out.println(output);
        sc.close();
    }

    // Método auxiliar para converter "HH:MM:SS" em segundos
    private static int parseTime(String timeStr) {
        String[] parts = timeStr.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }
}
