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
import java.util.List;

public class CelestialTest {

    @Test
    public void testVisibilityUpdate() {
        Celestial body = new Celestial("CometX", "Comet", "Elliptical", 50);
        body.updateVisibility();
        assertEquals(45, body.getVisibilityScore());
    }

    @Test
    public void testObsoleteCheck() {
        Celestial body = new Celestial("CometY", "Comet", "Elliptical", 20);

        body.setVisibilityScore(15);
        body.updateVisibility();
        body.setVisibilityScore(10);
        body.updateVisibility();
        body.setVisibilityScore(10);
        body.updateVisibility();

        assertTrue(body.isObsolete());
    }

    @Test
    public void testRiskyCheck() {
        Celestial body = new Celestial("AsteroidZ", "Asteroid", "Irregular", 100);
        
        // decreasing 5 times
        body.setVisibilityScore(90);
        body.updateVisibility();
        body.setVisibilityScore(80);
        body.updateVisibility();
        body.setVisibilityScore(70);
        body.updateVisibility();
        body.setVisibilityScore(60);
        body.updateVisibility();
        body.setVisibilityScore(50);
        body.updateVisibility();

        assertTrue(body.isRisky());
    }

    @Test
    public void testVisibilityRecord() {
        Celestial body = new Celestial("Neptune", "Planet", "Circular", 70);
        body.updateVisibility();
        body.updateVisibility();
        body.updateVisibility(); // updated 3 times more
        
        List<Integer> record = body.getVisibilityRecord();
        assertEquals(4, record.size());
    }
}