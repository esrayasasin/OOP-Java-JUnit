/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author esrayasasin
 */

public class ObservatoryTest {

    @Test
    public void testAddCelestialBody() {
        Observatory observatory = new Observatory();
        Celestial body = new Celestial("Mars", "Planet", "Circular", 50);
        
        observatory.addCelestialBody(body);
    }

    @Test
    public void testMostVisibleBody() {
        Observatory observatory = new Observatory();
        Celestial body4 = new Celestial("CometY", "Comet", "Elliptical", 25);
        Celestial body5 = new Celestial("Uranus", "Planet", "Elliptical", 60);

        observatory.addCelestialBody(body4);
        observatory.addCelestialBody(body5);

        assertEquals(body5, observatory.mostVisibleBody());
    }

    @Test
    public void testUpdateYear() {
        Observatory observatory = new Observatory();
        Celestial body = new Celestial("CometX", "Comet", "Regular", 25);
        
        observatory.addCelestialBody(body);
        int initialYear = body.getLastObservedYear();
        
        observatory.updateYear();
        
        assertEquals(initialYear + 1, body.getLastObservedYear());
    }

    @Test
    public void testRemoveObsoleteBodies() {
        Observatory observatory = new Observatory();
        Celestial body = new Celestial("CometX", "Comet", "Elliptical", 10);
        
        observatory.addCelestialBody(body);
        
        // set obsolete
        body.setIsObsolete(true);
        observatory.removeObsoleteBodies();
        
        // remove obsolete
        assertEquals(0, observatory.getRiskyBodies().size());
    }

    @Test
    public void testAverageVisibility() {
        Observatory observatory = new Observatory();
        observatory.addCelestialBody(new Celestial("Mars", "Planet", "Circular", 50));
        observatory.addCelestialBody(new Celestial("Venus", "Planet", "Circular", 30));

        assertEquals(40.0, observatory.averageVisibility(), 0.01);
    }
}

