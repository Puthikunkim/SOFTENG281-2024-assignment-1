package nz.ac.auckland.se281;

public class Booking {
  private String bookingReference;
  private String venueName;
  private String venueCode;
  private String bookingDate;
  private String customerEmail;
  private String attendeeCount;

  // Constructor for the Venue class
  public Booking(
      String bookingReference,
      String venueName,
      String venueCode,
      String bookingDate,
      String customerEmail,
      String attendeeCount) {
    this.bookingReference = bookingReference;
    this.venueName = venueName;
    this.bookingDate = bookingDate;
    this.attendeeCount = attendeeCount;
  }

  // Getter methods for the values
  public String getBookingReference() {
    return bookingReference;
  }

  public String getVenueName() {
    return venueName;
  }

  public String getVenueCode() {
    return venueCode;
  }

  public String getBookingDate() {
    return bookingDate;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public String getAttendeeCount() {
    return attendeeCount;
  }
}
