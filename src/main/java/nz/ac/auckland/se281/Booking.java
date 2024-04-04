package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Booking {
  private String bookingReference;
  private String venueName;
  private String venueCode;
  private String bookingDate;
  private String customerEmail;
  private String attendeeCount;
  private String dateOfBooking;
  // ArrayList to store services.
  private ArrayList<Service> serviceList = new ArrayList<Service>();

  // Constructor for the Venue class
  public Booking(
      String bookingReference,
      String venueName,
      String venueCode,
      String bookingDate,
      String customerEmail,
      String attendeeCount,
      String dateOfBooking) {
    this.bookingReference = bookingReference;
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.bookingDate = bookingDate;
    this.customerEmail = customerEmail;
    this.attendeeCount = attendeeCount;
    this.serviceList = new ArrayList<Service>();
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

  public String getDateOfBooking() {
    return dateOfBooking;
  }

  // Getter method for service list
  public ArrayList<Service> getServiceList() {
    return serviceList;
  }

  // Finding the different services.
  public CateringService findCateringService() {
    for (Service service : serviceList) {
      if (service instanceof CateringService) {
        return (CateringService) service;
      }
    }
    return null;
  }

  public MusicService findMusicService() {
    for (Service service : serviceList) {
      if (service instanceof MusicService) {
        return (MusicService) service;
      }
    }
    return null;
  }

  public FloralService findFloralService() {
    for (Service service : serviceList) {
      if (service instanceof FloralService) {
        return (FloralService) service;
      }
    }
    return null;
  }
}
