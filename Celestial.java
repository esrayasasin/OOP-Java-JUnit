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

public class Celestial {
    private String name;
    private String category;
    private String orbitType;
    private int visibilityScore;
    private boolean isRisky;
    private boolean isObsolete;
    private int lastObservedYear;
    private final ArrayList<Integer> visibilityRecord = new ArrayList<>();

    Celestial(String name, String category, String orbitType, int visibilityScore) {
        this.name = name;
        this.category = category;
        this.orbitType = orbitType;
        this.visibilityScore = visibilityScore;
        this.isRisky = false;
        this.isObsolete = false;
        this.lastObservedYear = 2010;
        visibilityRecord.add(visibilityScore);
    }

    public String getName() {
        return name;
    }

    public int getVisibilityScore() {
        return visibilityScore;
    }

    public void setVisibilityScore(int visibilityScore) {
        this.visibilityScore = visibilityScore;
    }

    public boolean isRisky() {
        return isRisky;
    }

    public void setIsRisky(boolean isRisky) {
        this.isRisky = isRisky;
    }

    public int getLastObservedYear() {
        return lastObservedYear;
    }

    public void setLastObservedYear(int lastObservedYear) {
        this.lastObservedYear = lastObservedYear;
    }

    public boolean isObsolete() {
        return isObsolete;
    }

    public void setIsObsolete(boolean isObsolete) {
        this.isObsolete = isObsolete;
    }

    public List<Integer> getVisibilityRecord() {
        return new ArrayList<>(visibilityRecord);
    }

    /**
     * updates the visibility score
     */
    public void updateVisibility() {
        lastObservedYear++;

        if (orbitType.equals("Elliptical") || orbitType.equals("Irregular")) {
            visibilityScore -= 5;
            if (visibilityScore < 0) visibilityScore = 0;
        }
        visibilityRecord.add(visibilityScore);

        checkObsolete();
        checkRisky();
    }

    /**
     * checks if a body is obsolote
     */
    public void checkObsolete() {
        if (visibilityRecord.size() >= 3) {
            int count = 0;
            for (int i = visibilityRecord.size() - 3; i < visibilityRecord.size(); i++) {
                if (visibilityRecord.get(i) < 20)
                    count++;
                else
                    count = 0;
            }
            if (count == 3) {
                isObsolete = true;
            }
        }
    }

    /**
     * checks if a body is risky
     */
    public void checkRisky() {
    int size = visibilityRecord.size();
    
    if (!orbitType.equals("Irregular") || size < 5) {
        isRisky = false;
        return;
    }

    for (int i = size - 5; i < size - 1; i++) {
        if (visibilityRecord.get(i) <= visibilityRecord.get(i + 1)) {
            isRisky = false;
            return;
        }
    }

    isRisky = true;
}
}
