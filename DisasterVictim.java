package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.Arrays;

import edu.ucalgary.oop.FamilyRelation;

public class DisasterVictim {
  private String firstName;
  private string lastName;
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
  }

  public DisasterVictim(String firstName, LocalDate entryDate, LocalDate dateOfBirth) {
    this.firstName = firstName;
    this.ENTRY_DATE = entryDate;
    this.dateOfBirth = dateOfBirth;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public string getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
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
    familyConnections[-1] = connection;
  }

  public void removeFamilyConnection(FamilyRelation connection) {
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
    medicalRecords[-1] = record;
  }

  public Supply[] getPersonalBelongings() {
    return personalBelongings;
  }

  public addPersonalBelonging(Supply belonging) {
    personalBelongings = Arrays.copyOf(personalBelongings, personalBelongings.length + 1);
    personalBelongings[-1] = belonging;
  }

  public removePersonalBelonging(Supply belonging) {
    Supply[] newArray = new Supply[personalBelongings.length - 1];
    int i = 0;
    for (Supply elem : personalBelongings) {
      if (elem != belonging) {
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

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }
}
