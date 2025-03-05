import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class SegmentoTest {

    @Test
    public void testConstrutorValido() {
        Ponto p1 = new Ponto(2, 3);
        Ponto p2 = new Ponto(5, 6);
        Segmento s1 = new Segmento(p1, p2);
        assertNotNull(s1);

        Ponto p3 = new Ponto(1, 1);
        Ponto p4 = new Ponto(4, 4);
        Segmento s2 = new Segmento(p3, p4);
        assertNotNull(s2);

        Ponto p5 = new Ponto(3, 7);
        Ponto p6 = new Ponto(6, 9);
        Segmento s3 = new Segmento(p5, p6);
        assertNotNull(s3);

        Ponto p7 = new Ponto(2, 5);
        Ponto p8 = new Ponto(5, 10);
        Segmento s4 = new Segmento(p7, p8);
        assertNotNull(s4);
    }

    @Test
    public void testConstrutor_InvalidoPontosIguais() {
        Ponto p1 = new Ponto(4, 4);
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            new Segmento(p1, p1);
        });
        assertEquals("Segmento:vi", exception1.getMessage());

        Ponto p2 = new Ponto(3, 3);
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new Segmento(p2, p2);
        });
        assertEquals("Segmento:vi", exception2.getMessage());

        Ponto p3 = new Ponto(5, 8);
        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> {
            new Segmento(p3, p3);
        });
        assertEquals("Segmento:vi", exception3.getMessage());

        Ponto p4 = new Ponto(2, 2);
        Exception exception4 = assertThrows(IllegalArgumentException.class, () -> {
            new Segmento(p4, p4);
        });
        assertEquals("Segmento:vi", exception4.getMessage());
    }

    @Test
    public void testConstrutor_InvalidoPontoForaDoPrimeiroQuadrante() {
        Ponto p1 = new Ponto(2, 2);
        Ponto p2 = new Ponto(-3, 4);
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            new Segmento(p1, p2);
        });
        assertEquals("Ponto:vi", exception1.getMessage());

        Ponto p3 = new Ponto(-1, 1);
        Ponto p4 = new Ponto(3, 3);
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new Segmento(p3, p4);
        });
        assertEquals("Ponto:vi", exception2.getMessage());

        Ponto p5 = new Ponto(6, -2);
        Ponto p6 = new Ponto(8, 8);
        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> {
            new Segmento(p5, p6);
        });
        assertEquals("Ponto:vi", exception3.getMessage());

        Ponto p7 = new Ponto(0, 5);
        Ponto p8 = new Ponto(-2, 7);
        Exception exception4 = assertThrows(IllegalArgumentException.class, () -> {
            new Segmento(p7, p8);
        });
        assertEquals("Ponto:vi", exception4.getMessage());
    }

    @Test
    public void testDistanciaPontoAoCentro_NoSegmento() {
        Segmento s = new Segmento(new Ponto(2, 2), new Ponto(6, 2));

        assertEquals(2.0, s.distanciaPontoAoCentro(new Ponto(4, 4)), 0.0001);
        assertEquals(3.0, s.distanciaPontoAoCentro(new Ponto(5, 5)), 0.0001);
        assertEquals(4.0, s.distanciaPontoAoCentro(new Ponto(6, 6)), 0.0001);
        assertEquals(1.0, s.distanciaPontoAoCentro(new Ponto(3, 3)), 0.0001);
    }

    @Test
    public void testDistanciaPontoAoCentro_ForaSegmentoAntes() {
        Segmento s = new Segmento(new Ponto(3, 3), new Ponto(6, 3));

        assertEquals(2.0, s.distanciaPontoAoCentro(new Ponto(1, 3)), 0.0001);
        assertEquals(3.0, s.distanciaPontoAoCentro(new Ponto(0, 3)), 0.0001);
        assertEquals(4.0, s.distanciaPontoAoCentro(new Ponto(-1, 3)), 0.0001);
        assertEquals(5.0, s.distanciaPontoAoCentro(new Ponto(-2, 3)), 0.0001);
    }

    @Test
    public void testDistanciaPontoAoCentro_ForaSegmentoDepois() {
        Segmento s = new Segmento(new Ponto(3, 3), new Ponto(6, 3));

        assertEquals(2.0, s.distanciaPontoAoCentro(new Ponto(8, 3)), 0.0001);
        assertEquals(3.0, s.distanciaPontoAoCentro(new Ponto(9, 3)), 0.0001);
        assertEquals(4.0, s.distanciaPontoAoCentro(new Ponto(10, 3)), 0.0001);
        assertEquals(5.0, s.distanciaPontoAoCentro(new Ponto(11, 3)), 0.0001);
    }

    @Test
    public void testDistanciaPontoAoCentro_PontoSobreOSegmento() {
        Segmento s = new Segmento(new Ponto(1, 1), new Ponto(5, 1));

        assertEquals(0.0, s.distanciaPontoAoCentro(new Ponto(3, 1)), 0.0001);
        assertEquals(0.0, s.distanciaPontoAoCentro(new Ponto(2, 1)), 0.0001);
        assertEquals(0.0, s.distanciaPontoAoCentro(new Ponto(4, 1)), 0.0001);
        assertEquals(0.0, s.distanciaPontoAoCentro(new Ponto(5, 1)), 0.0001);
    }
}
