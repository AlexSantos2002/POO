import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RetanguloTest {

    @Test
    public void testConstrutorValido() {
        Ponto p1 = new Ponto(2, 2);
        Ponto p2 = new Ponto(5, 2);
        Ponto p3 = new Ponto(5, 6);
        Ponto p4 = new Ponto(2, 6);
        Retangulo r = new Retangulo(p1, p2, p3, p4);
        assertNotNull(r);
    }

    @Test
    public void testEhRetangulo_True() {
        Ponto p1 = new Ponto(1, 1);
        Ponto p2 = new Ponto(4, 1);
        Ponto p3 = new Ponto(4, 3);
        Ponto p4 = new Ponto(1, 3);
        Retangulo r = new Retangulo(p1, p2, p3, p4);
        assertTrue(r.ehRetangulo());
    }

    @Test
    public void testEhRetangulo_False() {
        Ponto p1 = new Ponto(1, 1);
        Ponto p2 = new Ponto(4, 1);
        Ponto p3 = new Ponto(5, 3); // Ponto deslocado
        Ponto p4 = new Ponto(1, 3);
        Retangulo r = new Retangulo(p1, p2, p3, p4);
        assertFalse(r.ehRetangulo());
    }

    @Test
    public void testEhRetangulo_PontosForaDoPrimeiroQuadrante_false() {
        Ponto p1 = new Ponto(-1, -1);
        Ponto p2 = new Ponto(2, -1);
        Ponto p3 = new Ponto(2, 3);
        Ponto p4 = new Ponto(-1, 7);
        Retangulo r = new Retangulo(p1, p2, p3, p4);
        assertFalse(r.ehRetangulo());
    }
}

