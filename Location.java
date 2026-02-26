package edu.ucalgary.oop;

public class Location {

    private String name;
    private String address;
    private DisasterVictim[] occupants;
    private Supply[] supplies;

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
        this.occupants = new DisasterVictim[0];
        this.supplies = new Supply[0];
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DisasterVictim[] getOccupants() {
        return occupants;
    }

    public void setOccupants(DisasterVictim[] occupants) {
        this.occupants = occupants;
    }

    public Supply[] getSupplies() {
        return supplies;
    }

    public void setSupplies(Supply[] supplies) {
        this.supplies = supplies;
    }

    // Add Occupant

    public void addOccupant(DisasterVictim victim) {
        DisasterVictim[] newArray = new DisasterVictim[occupants.length + 1];
        System.arraycopy(occupants, 0, newArray, 0, occupants.length);
        newArray[occupants.length] = victim;
        occupants = newArray;
    }

    // Remove Occupant

    public void removeOccupant(DisasterVictim victim) {
        int index = -1;

        for (int i = 0; i < occupants.length; i++) {
            if (occupants[i].equals(victim)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new IllegalArgumentException("Victim not found.");
        }

        DisasterVictim[] newArray = new DisasterVictim[occupants.length - 1];
        for (int i = 0, j = 0; i < occupants.length; i++) {
            if (i != index) {
                newArray[j++] = occupants[i];
            }
        }

        occupants = newArray;
    }

    // Add Supply

    public void addSupply(Supply supply) {
        Supply[] newArray = new Supply[supplies.length + 1];
        System.arraycopy(supplies, 0, newArray, 0, supplies.length);
        newArray[supplies.length] = supply;
        supplies = newArray;
    }

    // Remove Supply

    public void removeSupply(Supply supply) {
        int index = -1;

        for (int i = 0; i < supplies.length; i++) {
            if (supplies[i].equals(supply)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new IllegalArgumentException("Supply not found.");
        }

        Supply[] newArray = new Supply[supplies.length - 1];
        for (int i = 0, j = 0; i < supplies.length; i++) {
            if (i != index) {
                newArray[j++] = supplies[i];
            }
        }

        supplies = newArray;
    }
}