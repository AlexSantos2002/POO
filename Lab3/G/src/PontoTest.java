import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class PontoTest {

    @Test
    public void testConstrutorCartesiano() {
        Ponto p1 = new Ponto(3, 4);
        assertEquals(3, p1.getX(), 0.0001);
        assertEquals(4, p1.getY(), 0.0001);
        
        Ponto p2 = new Ponto(-3, -4);
        assertEquals(-3, p2.getX(), 0.0001);
        assertEquals(-4, p2.getY(), 0.0001);
        
        Ponto p3 = new Ponto(0, 0);
        assertEquals(0, p3.getX(), 0.0001);
        assertEquals(0, p3.getY(), 0.0001);
        
        Ponto p4 = new Ponto(5, -2);
        assertEquals(5, p4.getX(), 0.0001);
        assertEquals(-2, p4.getY(), 0.0001);
    }

    @Test
    public void testConstrutorPolar() {
        Ponto p1 = new Ponto(5, 53.13);
        assertEquals(3, p1.getX(), 0.01);
        assertEquals(4, p1.getY(), 0.01);
        
        Ponto p2 = new Ponto(5, 180);
        assertEquals(5, p2.getX(), 0.01);
        assertEquals(180, p2.getY(), 0.01);
        
        Ponto p3 = new Ponto(7, 90);
        assertEquals(7, p3.getX(), 0.01);
        assertEquals(90, p3.getY(), 0.01);
        
        Ponto p4 = new Ponto(10, 270);
        assertEquals(10, p4.getX(), 0.01);
        assertEquals(270, p4.getY(), 0.01);
    }

    @Test
    public void testNoPrimeiroQuadrante() {
        Ponto p1 = new Ponto(2, 3);
        assertTrue(p1.noPrimeiroQuadrante());
        
        Ponto p2 = new Ponto(0, 3);
        assertTrue(p2.noPrimeiroQuadrante());
        
        Ponto p3 = new Ponto(2, 0);
        assertTrue(p3.noPrimeiroQuadrante());
        
        Ponto p4 = new Ponto(0, 0);
        assertTrue(p4.noPrimeiroQuadrante());
    }
    
    @Test
    public void testNoPrimeiroQuadrante_False() {
        Ponto p1 = new Ponto(-2, 3);
        assertFalse(p1.noPrimeiroQuadrante());
        
        Ponto p2 = new Ponto(2, -3);
        assertFalse(p2.noPrimeiroQuadrante());
        
        Ponto p3 = new Ponto(-2, -3);
        assertFalse(p3.noPrimeiroQuadrante());
        
        Ponto p4 = new Ponto(-1, 0);
        assertFalse(p4.noPrimeiroQuadrante());
    }
    
    @Test
    public void testDistanciaOrigem() {
        Ponto p1 = new Ponto(3, 4);
        assertEquals(5.0, p1.distanciaOrigem(), 0.0001);
        
        Ponto p2 = new Ponto(5, 12);
        assertEquals(13.0, p2.distanciaOrigem(), 0.0001);
        
        Ponto p3 = new Ponto(8, 15);
        assertEquals(17.0, p3.distanciaOrigem(), 0.0001);
        
        Ponto p4 = new Ponto(0, 0);
        assertEquals(0.0, p4.distanciaOrigem(), 0.0001);
    }
}
