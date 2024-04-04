package nz.ac.auckland.se281;

import java.util.List;

public class Venue {
  private String venueName;
  private String venueCode;
  private String capacityInput;
  private String hireFeeInput;
  private String availableDate;

  // Constructor for the Venue class
  public Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacityInput = capacityInput;
    this.hireFeeInput = hireFeeInput;
  }

  // Getter methods for the values
  public String getVenueName() {
    return venueName;
  }

  public String getVenueCode() {
    return venueCode;
  }

  public String getCapacityInput() {
    return capacityInput;
  }

  public String getHireFeeInput() {
    return hireFeeInput;
  }

  public String getAvailableDate() {
    if (availableDate == null) {
      // Return a blank string if available date is not set
      return "";
    }
    return availableDate;
  }

  // Setter method for available date
  public void setAvailableDate(String availableDate) {
    this.availableDate = availableDate;
  }

  public Venue findVenueByCode(List<Venue> venueList, String venueCode) {
    for (Venue venue : venueList) {
      if (venue.getVenueCode().equals(venueCode)) {
        return venue;
      }
    }
    return null; // return null if no venue is found
  }
}
