/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author esrayasasin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Observatory observatory = new Observatory();

        Celestial celestial1 = new Celestial("Mars", "Planet", "Elliptical", 50);
        Celestial celestial2 = new Celestial("Venus", "Planet", "Circular", 30);
        Celestial celestial3 = new Celestial("Asteroid", "Asteroid", "Irregular", 40);
        Celestial celestial4 = new Celestial("CometY", "Comet", "Regular", 25);
        Celestial celestial5 = new Celestial("Uranus", "Planet", "Elliptical", 60);
        Celestial celestial6 = new Celestial("Jupiter", "Planet", "Circular", 80);
        

        observatory.addCelestialBody(celestial1);
        observatory.addCelestialBody(celestial2);
        observatory.addCelestialBody(celestial3);
        observatory.addCelestialBody(celestial4);
        observatory.addCelestialBody(celestial5);
        observatory.addCelestialBody(celestial6);
    }
    
}
