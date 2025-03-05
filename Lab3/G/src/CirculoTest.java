import static org.junit.Assert.*;
import org.junit.Test;

public class CirculoTest {

    @Test
    public void testConstrutorValido() {
        Circulo c1 = new Circulo(new Ponto(5, 5), 3);
        assertNotNull(c1);

        Circulo c2 = new Circulo(new Ponto(10, 10), 2);
        assertNotNull(c2);

        Circulo c3 = new Circulo(new Ponto(3, 4), 1);
        assertNotNull(c3);

        Circulo c4 = new Circulo(new Ponto(7, 8), 4);
        assertNotNull(c4);
    }

    @Test
    public void testConstrutor_InvalidoCentroForaDoPrimeiroQuadrante() {
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            new Circulo(new Ponto(-2, 3), 2);
        });
        assertEquals("Ponto:vi", exception1.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new Circulo(new Ponto(3, -2), 2);
        });
        assertEquals("Ponto:vi", exception2.getMessage());

        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> {
            new Circulo(new Ponto(-4, -4), 3);
        });
        assertEquals("Ponto:vi", exception3.getMessage());

        Exception exception4 = assertThrows(IllegalArgumentException.class, () -> {
            new Circulo(new Ponto(0, -1), 2);
        });
        assertEquals("Ponto:vi", exception4.getMessage());
    }

    @Test
    public void testConstrutor_InvalidoRaio() {
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            new Circulo(new Ponto(5, 5), 0);
        });
        assertEquals("Circulo:vi", exception1.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new Circulo(new Ponto(6, 6), -3);
        });
        assertEquals("Circulo:vi", exception2.getMessage());

        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> {
            new Circulo(new Ponto(2, 2), 3);
        });
        assertEquals("Circulo:vi", exception3.getMessage());

        Exception exception4 = assertThrows(IllegalArgumentException.class, () -> {
            new Circulo(new Ponto(4, 4), 5);
        });
        assertEquals("Circulo:vi", exception4.getMessage());
    }

    @Test
    public void testCalcularPerimetro() {
        Circulo c1 = new Circulo(new Ponto(5, 5), 3);
        assertEquals(2 * Math.PI * 3, c1.calcularPerimetro(), 0.0001);

        Circulo c2 = new Circulo(new Ponto(7, 7), 5);
        assertEquals(2 * Math.PI * 5, c2.calcularPerimetro(), 0.0001);

        Circulo c3 = new Circulo(new Ponto(10, 10), 2);
        assertEquals(2 * Math.PI * 2, c3.calcularPerimetro(), 0.0001);

        Circulo c4 = new Circulo(new Ponto(5, 5), 4);

        assertEquals(2 * Math.PI * 4, c4.calcularPerimetro(), 0.0001);
    }

    @Test
    public void testGetPerimetroInteiro() {
        Circulo c1 = new Circulo(new Ponto(6, 6), 3);
        assertEquals((int) (2 * Math.PI * 3), c1.getPerimetroInteiro());

        Circulo c2 = new Circulo(new Ponto(8, 8), 5);
        assertEquals((int) (2 * Math.PI * 5), c2.getPerimetroInteiro());

        Circulo c3 = new Circulo(new Ponto(4, 4), 2);
        assertEquals((int) (2 * Math.PI * 2), c3.getPerimetroInteiro());

        Circulo c4 = new Circulo(new Ponto(10, 10), 4);
        assertEquals((int) (2 * Math.PI * 4), c4.getPerimetroInteiro());
    }

    @Test
    public void testIntersetaSegmento() {
        Circulo c = new Circulo(new Ponto(5, 5), 3);

        Segmento s1 = new Segmento(new Ponto(2, 2), new Ponto(8, 8));
        assertTrue(c.intersetaSegmento(s1));

        Segmento s2 = new Segmento(new Ponto(1, 1), new Ponto(2, 2));
        assertFalse(c.intersetaSegmento(s2));

        Segmento s3 = new Segmento(new Ponto(5, 2), new Ponto(5, 8));
        assertTrue(c.intersetaSegmento(s3));

        Segmento s4 = new Segmento(new Ponto(7, 7), new Ponto(10, 10));
        assertTrue(c.intersetaSegmento(s4));
    }

    @Test
    public void testGetCentro() {
        Circulo c1 = new Circulo(new Ponto(5, 5), 3);
        assertEquals(5, c1.getCentro().getX(), 0.0001);
        assertEquals(5, c1.getCentro().getY(), 0.0001);

        Circulo c2 = new Circulo(new Ponto(7, 7), 2);
        assertEquals(7, c2.getCentro().getX(), 0.0001);
        assertEquals(7, c2.getCentro().getY(), 0.0001);

        Circulo c3 = new Circulo(new Ponto(5, 5), 3);
        assertEquals(5, c3.getCentro().getX(), 0.0001);
        assertEquals(5, c3.getCentro().getY(), 0.0001);

        Circulo c4 = new Circulo(new Ponto(9, 9), 5);
        assertEquals(9, c4.getCentro().getX(), 0.0001);
        assertEquals(9, c4.getCentro().getY(), 0.0001);
    }

    @Test
    public void testGetRaio() {
        Circulo c1 = new Circulo(new Ponto(5, 5), 3);
        assertEquals(3, c1.getRaio(), 0.0001);

        Circulo c2 = new Circulo(new Ponto(7, 7), 2);
        assertEquals(2, c2.getRaio(), 0.0001);

        Circulo c3 = new Circulo(new Ponto(5, 5), 3);
        assertEquals(3, c3.getRaio(), 0.0001);

        Circulo c4 = new Circulo(new Ponto(9, 9), 5);
        assertEquals(5, c4.getRaio(), 0.0001);
    }
}
