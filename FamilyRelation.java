package edu.ucalgary.oop;

public class FamilyRelation {
    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;

    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        if (personOne == null || personTwo == null || relationshipTo == null) {
            throw new IllegalArgumentException("Null values not allowed");
        }
        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
    }

    public DisasterVictim getPersonOne() { return personOne; }
    
    public void setPersonOne(DisasterVictim p) { if(p == null) throw new IllegalArgumentException(); this.personOne = p; }
    public String getRelationshipTo() { return relationshipTo; }
    
    public void setRelationshipTo(String r) { this.relationshipTo = r; }
    public DisasterVictim getPersonTwo() { return personTwo; }
    public void setPersonTwo(DisasterVictim p) { if(p == null) throw new IllegalArgumentException(); this.personTwo = p; }
}