package edu.ucalgary.oop;

import java.time.LocalDate;

public class MedicalRecord {
  private Location location;
  private String treatmentDetails;
  private LocalDate dateOfTreatment;

  public MedicalRecord() {
  }

  public MedicalRecord(Location location, String treatmentDetails, LocalDate dateOfTreatment) {
    this.location = location;
    this.treatmentDetails = treatmentDetails;
    this.dateOfTreatment = dateOfTreatment;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public String getTreatmentDetails() {
    return treatmentDetails;
  }

  public void setTreatmentDetails(String treatmentDetails) {
    this.treatmentDetails = treatmentDetails;
  }

  public LocalDate getDateOfTreatment() {
    return dateOfTreatment;
  }

  public void setDateOfTreatment(LocalDate dateOfTreatment) throws IllegalArgumentException {
    // Checks if date is null.
    if (dateOfTreatment == null) {
      throw new IllegalArgumentException("dateOfTreatment cannot be null");
    }

    // Checks if date is in the future.
    if (dateOfTreatment.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("dateOfTreatment cannot be in the future.");
    } 

    this.dateOfTreatment = dateOfTreatment;
  }

}
