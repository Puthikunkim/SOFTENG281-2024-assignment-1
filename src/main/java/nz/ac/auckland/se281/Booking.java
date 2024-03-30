package nz.ac.auckland.se281;

public class Booking {
  private String bookingReference;
  private String venueName;
  private String bookingDate;
  private String attendeeCount;
  private String venueCapacity;

  // Constructor for the Venue class
  public Booking(
      String bookingReference, String venueName, String bookingDate, String attendeeCount) {
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

  public String getBookingDate() {
    return bookingDate;
  }

  public String getAttendeeCount() {
    return attendeeCount;
  }

  public String getVenueCapacity() {
    return venueCapacity;
  }
}
