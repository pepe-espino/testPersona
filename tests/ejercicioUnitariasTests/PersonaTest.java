package ejerciciosUnitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonaTest {

    @Test
    public void testConstructorPorDefecto() {
        Persona persona = new Persona();
        assertEquals("", persona.getNombre());
        assertEquals(0, persona.getEdad());
        assertEquals('H', persona.getSexo());
        assertEquals(0, persona.getPeso());
        assertEquals(0, persona.getAltura());
    }

    @Test
    public void testConstructorConParametros() {
        Persona persona = new Persona("Ana", 25, 'M');
        assertEquals("Ana", persona.getNombre());
        assertEquals(25, persona.getEdad());
        assertEquals('M', persona.getSexo());
    }

    @Test
    public void testSettersYGetters() {
        Persona persona = new Persona();
        persona.setNombre("Carlos");
        persona.setEdad(30);
        persona.setSexo('H');
        persona.setPeso(80);
        persona.setAltura(1.80);

        assertEquals("Carlos", persona.getNombre());
        assertEquals(30, persona.getEdad());
        assertEquals('H', persona.getSexo());
        assertEquals(80, persona.getPeso());
        assertEquals(1.80, persona.getAltura());
    }

    @Test
    public void testEsMayorDeEdad() {
        Persona persona = new Persona("Pepe", 19, 'H');
        assertTrue(persona.esMayorDeEdad());

        Persona menor = new Persona("Laura", 16, 'M');
        assertFalse(menor.esMayorDeEdad());
    }

    @Test
    public void testCalcularIMC() {
        Persona persona = new Persona("Luis", 28, 'H', 70, 1.75); // IMC ≈ 22.86 (Peso ideal)
        assertEquals(Persona.PESO_IDEAL, persona.calcularIMC());

        Persona delgada = new Persona("Ana", 20, 'M', 45, 1.70); // IMC ≈ 15.57 (Infrapeso)
        assertEquals(Persona.INFRAPESO, delgada.calcularIMC());

        Persona sobrepeso = new Persona("Pedro", 35, 'H', 90, 1.70); // IMC ≈ 31.14 (Sobrepeso)
        assertEquals(Persona.SOBREPESO, sobrepeso.calcularIMC());
    }

    @Test
    public void testComprobarSexo() {
        Persona persona = new Persona("Alex", 22, 'X'); // Sexo inválido
        assertEquals('H', persona.getSexo());
    }
}
