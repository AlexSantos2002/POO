public class Ponto {
    double x;
    double y;

    Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String distancia(Ponto p) {
        if (VerificaQuadrante(this.x, this.y) == true && VerificaQuadrante(p.x, p.y) == true && VerificaDistanciaCentro(this.x, this.y)==true && VerificaDistanciaCentro(p.x,p.y)) {
            double thetaA= this.y;
            double thetaB = p.y;
            int resultado = (int) Math.sqrt(Math.pow(this.x, 2) + Math.pow(p.x, 2) - 2 * this.x*p.x * (Math.cos(thetaA - thetaB)));
            return String.valueOf(resultado);  // Retorna o resultado como String
        } else {
            return "iv";
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
        if (x<10){
            return true;
        } else {
            return false;
        }
    }
}
