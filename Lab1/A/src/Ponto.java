public class Ponto {
    double x;
    double y;

    Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }

    double distancia(Ponto p){
        double thetaA= Math.toRadians(this.y);
        double thetaB = Math.toRadians(p.y);
        double resultado = Math.sqrt(Math.pow(this.x, 2) + Math.pow(p.x, 2) - 2 * this.x*p.x * (Math.cos(thetaA - thetaB)));
        return resultado;
    }
}