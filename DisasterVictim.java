package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.Arrays;

public class DisasterVictim {
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  private FamilyRelation[] familyConnections;
  private MedicalRecord[] medicalRecords;
  private Supply[] personalBelongings;
  private final LocalDate ENTRY_DATE;
  private String gender;
  private String comments;

  public DisasterVictim(String firstName, LocalDate entryDate) {
    this.firstName = firstName;
    this.ENTRY_DATE = entryDate;

    familyConnections = new FamilyRelation[0];
    medicalRecords = new MedicalRecord[0];
    personalBelongings = new Supply[0];
  }

  public DisasterVictim(String firstName, LocalDate entryDate, LocalDate dateOfBirth) throws IllegalArgumentException {
    if (dateOfBirth.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("dateOfBirth cannot be in the future.");
    }

    this.firstName = firstName;
    this.ENTRY_DATE = entryDate;
    this.dateOfBirth = dateOfBirth;

    familyConnections = new FamilyRelation[0];
    medicalRecords = new MedicalRecord[0];
    personalBelongings = new Supply[0];
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) throws IllegalArgumentException {
    if (dateOfBirth.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("dateOfBirth cannot be in the future.");
    }
    this.dateOfBirth = dateOfBirth;
  }

  public FamilyRelation[] getFamilyConnections() {
    return familyConnections;
  }

  public void setFamilyConnections(FamilyRelation[] connections) {
    this.familyConnections = connections;
  }

  public void addFamilyConnection(FamilyRelation connection) {
    familyConnections = Arrays.copyOf(familyConnections, familyConnections.length + 1);
    familyConnections[familyConnections.length - 1] = connection;
  }

  public void removeFamilyConnection(FamilyRelation connection) throws IllegalArgumentException {
    if (familyConnections.length == 0) {
      throw new IllegalArgumentException("Cannot remove from empty familyConnections");
    }

    FamilyRelation[] newArray = new FamilyRelation[familyConnections.length - 1];
    int i = 0;
    for (FamilyRelation elem : familyConnections) {
      if (elem != connection) {
        newArray[i] = elem;
        i++;
      }
    }
    familyConnections = newArray;
  }

  public MedicalRecord[] getMedicalRecords() {
    return medicalRecords;
  }

  public void setMedicalRecords(MedicalRecord[] records) {
    this.medicalRecords = records;
  }

  public void addMedicalRecord(MedicalRecord record) {
    medicalRecords = Arrays.copyOf(medicalRecords, medicalRecords.length + 1);
    medicalRecords[medicalRecords.length - 1] = record;
  }

  public Supply[] getPersonalBelongings() {
    return personalBelongings;
  }

  public void addPersonalBelonging(Supply belonging) { 
    personalBelongings = Arrays.copyOf(personalBelongings, personalBelongings.length + 1);
    personalBelongings[personalBelongings.length - 1] = belonging;
  }

  public void removePersonalBelonging(Supply belonging) throws IllegalArgumentException {
    if (personalBelongings.length == 0) {
      throw new IllegalArgumentException("Cannot remove from empty personalBelongings");
    }

    Supply[] newArray = new Supply[personalBelongings.length - 1];
    int i = 0;
    for (Supply elem : personalBelongings) {
      if (!elem.equals(belonging)) {
        newArray[i] = elem;
        i++;
      }
    }
    personalBelongings = newArray;
  }

  public void setPersonalBelongings(Supply[] supplies) {
    this.personalBelongings = supplies;
  }

  public LocalDate getEntryDate() {
    return ENTRY_DATE;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) throws IllegalArgumentException { 
    // Sets the correct case for each character of the input.
    String newGender = "";
    boolean keepNextCase = false;

    newGender += Character.toUpperCase(gender.charAt(0));
    for (int i = 1; i < gender.length(); i++) {
      if (keepNextCase) {
        newGender += gender.charAt(i);
      }
      else {
        newGender += Character.toLowerCase(gender.charAt(i));      
      }

      if (newGender.charAt(i) == '-') {
        keepNextCase = true;
      }
      else {
        keepNextCase = false;
      }
    }
   
    // Checks if the input gender is one of the predefined valid ones.
    String[] validGenders = { "Man", "Woman", "Boy", "Girl", "Please specify" };
    if (!(Arrays.asList(validGenders).contains(newGender) || 
          "Please specify".equals(this.gender)))
    {
      throw new IllegalArgumentException("Not a valid gender.");
    }

    // Checks that somebody cannot be a 'Man' if they are a child.
    if (newGender.equals("Man") && LocalDate.now().minusYears(18).isBefore(dateOfBirth)) {
      throw new IllegalArgumentException("Child (under 18) cannot have gender 'Man");
    }

    this.gender = newGender;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }
}
