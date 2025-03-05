package ejercicioUnitariasTests;

import org.junit.jupiter.api.Test;

import ejerciciosUnitarias.Persona;

import static org.junit.Assert.assertTrue;
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
        Persona persona = new Persona("Pepe", 19, 'H');
        assertEquals("Pepe", persona.getNombre());
        assertEquals(19, persona.getEdad());
        assertEquals('H', persona.getSexo());
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

        Persona menor = new Persona("Pope", 15, 'H');
        assertFalse(menor.esMayorDeEdad());
        
        Persona persona2 = new Persona("Pape", 18, 'M');
        assertTrue(persona2.esMayorDeEdad());
    }

    @Test
    public void testCalcularIMC() {
        Persona ideal = new Persona("Luis", 28, 'H', 70, 1.75);
        assertEquals(Persona.PESO_IDEAL, ideal.calcularIMC());

        Persona delgada = new Persona("Ana", 20, 'M', 45, 1.70);
        assertEquals(Persona.INFRAPESO, delgada.calcularIMC());

        Persona sobrepeso = new Persona("Pedro", 35, 'H', 90, 1.70);
        assertEquals(Persona.SOBREPESO, sobrepeso.calcularIMC());
    }

	@Test
    public void testComprobarSexo() {
        Persona persona = new Persona("Alex", 22, 'X');
        Persona persona2 = new Persona("Miguel", 50, 'H');
        assertEquals('H', persona.getSexo());
        assertNotEquals('M', persona2.getSexo());
    }
	
	@Test
	public void setNombre() {
		Persona persona = new Persona("", 9, 'M');
		Persona persona2 = new Persona("Luis", 98, 'H');
		persona.setNombre("Luisa");
		persona2.setNombre("Luis");
		assertTrue(persona.toString().contains("Nombre: Luisa"));
		assertTrue(persona2.toString().contains("Nombre: Luis"));
	}
	
	
	
	
	
	
	
	
 
}
