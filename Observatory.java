/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esrayasasin
 */
public class Observatory {
    private int currentYear;
    private final List<Celestial> celestialBodies;

    public Observatory() {
        this.currentYear = 2010;
        this.celestialBodies = new ArrayList<>();
    }

    public void addCelestialBody(Celestial body) {
        celestialBodies.add(body);
    }
    
    /**
     * updates the year, calls the functions to starts the program
     */
    public void updateYear() {
        currentYear++;

        for (Celestial body : celestialBodies) {
            body.updateVisibility();
        }

        removeObsoleteBodies();
    }
    
    /**
     * removes obsolote bodies
     */
    public void removeObsoleteBodies() {
        for (int i = celestialBodies.size() - 1; i >= 0; i--) {
            if (celestialBodies.get(i).isObsolete()) {
                celestialBodies.remove(i);
            }
        }
    }

    /**
     * returns most visible body
     */
    public Celestial mostVisibleBody() {
        if (celestialBodies.isEmpty()) return null;
        Celestial mostVisible = celestialBodies.get(0);

        for (Celestial body : celestialBodies) {
            if (body.getVisibilityScore() > mostVisible.getVisibilityScore()) {
                mostVisible = body;
            }
        }
        return mostVisible;
    }

    /**
     * returns all risky bodies as a list
     */
    public List<Celestial> getRiskyBodies() {
        List<Celestial> riskyBodies = new ArrayList<>();
        for (Celestial body : celestialBodies) {
            if (body.isRisky()) {
                riskyBodies.add(body);
            }
        }
        return riskyBodies;
    }
    
    /**
     * returns most visible risky body
     */
    public Celestial mostVisibleRiskyBody() {
        List<Celestial> riskyBodies = getRiskyBodies();
        if (riskyBodies.isEmpty()) return null;

        Celestial mostVisibleRisky = riskyBodies.get(0);
        for (Celestial body : riskyBodies) {
            if (body.getVisibilityScore() > mostVisibleRisky.getVisibilityScore()) {
                mostVisibleRisky = body;
            }
        }
        return mostVisibleRisky;
    }
    
    /**
     * calculates the average visibility of all bodies
     */
    public double averageVisibility() {
        if (celestialBodies.isEmpty()) return 0.0;
        int totalVisibility = 0;
        for (Celestial body : celestialBodies) {
            totalVisibility += body.getVisibilityScore();
        }
        return (double) totalVisibility / celestialBodies.size();
    }
}
