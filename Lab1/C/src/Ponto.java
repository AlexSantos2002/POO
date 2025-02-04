public class Ponto {
    private double x;
    private double y;

    Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }

    private double distancia(Ponto p) {
        if (VerificaQuadrante(this.x, this.y) == true && VerificaQuadrante(p.x, p.y) == true && VerificaDistanciaCentro(this.x, this.y)==true && VerificaDistanciaCentro(p.x,p.y)) {
            double thetaA= Math.toRadians(this.y);
            double thetaB = Math.toRadians(p.y);

            double resultado = Math.sqrt(Math.pow(this.x, 2) + Math.pow(p.x, 2) - 2 * this.x*p.x * (Math.cos(thetaA - thetaB)));
            return resultado;
        } else {
            return -1;
        }
    }    

    private boolean VerificaQuadrante(double x, double y){
        if (x>=0 && y>=0 && y<=90){
            return true;
        } else{
            return false;
        }
    }

    private boolean VerificaDistanciaCentro(double x, double y){
        if (x<=10){
            return true;
        } else {
            return false;
        }
    }

    public static String CalcularTamanho(Ponto[] pontos) {
        double comprimentoTotal = 0.0;
        for (int i = 0; i < pontos.length - 1; i++) {
            double distancia = pontos[i].distancia(pontos[i + 1]);
            if (distancia != -1) {
                comprimentoTotal += distancia;
            } else {
                return "iv";
            }
        }
        return String.format("%.2f", comprimentoTotal);
    }
}