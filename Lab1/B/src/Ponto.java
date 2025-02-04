public class Ponto {
    private double x;
    private double y;

    Ponto(double x, double y){
        if (!VerificaQuadrante(x, y) || !VerificaDistanciaCentro(x, y)) {
            System.out.print("iv");  
            System.exit(0);      
        }
        this.x = x;
        this.y = y;
    }

    public double distancia(Ponto p) {
            double thetaA= this.y;
            double thetaB = p.y;
            double resultado =  Math.sqrt(Math.pow(this.x, 2) + Math.pow(p.x, 2) - 2 * this.x*p.x * (Math.cos(thetaA - thetaB)));
            return resultado;
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
