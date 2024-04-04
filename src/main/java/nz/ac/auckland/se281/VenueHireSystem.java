package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // ArrayList to store venues.
  private ArrayList<Venue> venueList = new ArrayList<Venue>();
  // ArrayList to store bookings.
  private ArrayList<Booking> bookingList = new ArrayList<Booking>();
  // String to store current system date.
  private String systemDate;

  public VenueHireSystem() {}

  // Method to print venues
  public void printVenues() {
    // Check for no venues.
    if (venueList.isEmpty()) {
      String noVenuesMessage = MessageCli.NO_VENUES.getMessage();
      System.out.println(noVenuesMessage);
    } else if (venueList.size() == 1) {
      // Check for one venue.
      String numberVenuesMessage = MessageCli.NUMBER_VENUES.getMessage("is", "one", "");
      System.out.println(numberVenuesMessage);
      String venueEntryMessage =
          MessageCli.VENUE_ENTRY.getMessage(
              venueList.get(0).getVenueName(),
              venueList.get(0).getVenueCode(),
              venueList.get(0).getCapacityInput(),
              venueList.get(0).getHireFeeInput(),
              venueList.get(0).getAvailableDate());
      System.out.println(venueEntryMessage);
    } else if (venueList.size() > 1 && venueList.size() < 10) {
      // Check for under ten venues.
      int number = venueList.size();
      String numberConverted = "";
      switch (number) {
        case 2:
          numberConverted = "two";
          break;
        case 3:
          numberConverted = "three";
          break;
        case 4:
          numberConverted = "four";
          break;
        case 5:
          numberConverted = "five";
          break;
        case 6:
          numberConverted = "six";
          break;
        case 7:
          numberConverted = "seven";
          break;
        case 8:
          numberConverted = "eight";
          break;
        case 9:
          numberConverted = "nine";
          break;
      }
      String numberVenuesMessage = MessageCli.NUMBER_VENUES.getMessage("are", numberConverted, "s");
      System.out.println(numberVenuesMessage);
      // Print details of each venue
      for (int i = 0; i < venueList.size(); i++) {
        String venueEntryMessage =
            MessageCli.VENUE_ENTRY.getMessage(
                venueList.get(i).getVenueName(),
                venueList.get(i).getVenueCode(),
                venueList.get(i).getCapacityInput(),
                venueList.get(i).getHireFeeInput(),
                venueList.get(0).getAvailableDate());
        System.out.println(venueEntryMessage);
      }
    } else {
      // Check for more than 10 venues.
      String numberVenuesMessage =
          MessageCli.NUMBER_VENUES.getMessage("are", String.valueOf(venueList.size()), "s");
      System.out.println(numberVenuesMessage);
      // Print details of each venue
      for (int i = 0; i < venueList.size(); i++) {
        String venueEntryMessage =
            MessageCli.VENUE_ENTRY.getMessage(
                venueList.get(i).getVenueName(),
                venueList.get(i).getVenueCode(),
                venueList.get(i).getCapacityInput(),
                venueList.get(i).getHireFeeInput(),
                venueList.get(0).getAvailableDate());
        System.out.println(venueEntryMessage);
      }
    }
  }

  // Method to create a new venue
  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    boolean validity = true;
    // venueName check.
    if (venueName.trim().isEmpty()) {
      validity = false;
      String venueUnsuccessfulMessage = MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.getMessage();
      System.out.println(venueUnsuccessfulMessage);
    }

    // venueCode check.
    for (int i = 0; i < venueList.size(); i++) {
      if (venueList.get(i).getVenueCode().equals(venueCode)) {
        validity = false;
        String venueUnsuccessfulMessage =
            MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.getMessage(
                venueCode, venueList.get(i).getVenueName());
        System.out.println(venueUnsuccessfulMessage);
        break;
      }
    }

    // capacityInput number check.
    try {
      int intCapacity = Integer.parseInt(capacityInput);
      if (intCapacity < 1) {
        validity = false;
        String venueUnsuccessfulMessage =
            MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.getMessage("capacity", " positive");
        System.out.println(venueUnsuccessfulMessage);
      }
    } catch (Exception e) {
      validity = false;
      String venueUnsuccessfulMessage =
          MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.getMessage("capacity", "");
      System.out.println(venueUnsuccessfulMessage);
    }

    // hireFeeInput number check.
    try {
      int intHireFee = Integer.parseInt(hireFeeInput);
      if (intHireFee < 1) {
        validity = false;
        String venueUnsuccessfulMessage =
            MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.getMessage("hire fee", " positive");
        System.out.println(venueUnsuccessfulMessage);
      }
    } catch (Exception e) {
      validity = false;
      String venueUnsuccessfulMessage =
          MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.getMessage("hire fee", "");
      System.out.println(venueUnsuccessfulMessage);
    }

    // Successful venue created.
    if (validity) {
      String venueSuccessfullyCreatedMessage =
          MessageCli.VENUE_SUCCESSFULLY_CREATED.getMessage(venueName, venueCode);
      System.out.println(venueSuccessfullyCreatedMessage);
      Venue venue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
      venueList.add(venue);
    }
  }

  public void setSystemDate(String dateInput) {
    systemDate = dateInput;
    String dateSetMessage = MessageCli.DATE_SET.getMessage(dateInput);
    System.out.println(dateSetMessage);
    // Update next available date for each venue.
    for (Venue venue : venueList) {
      updateNextAvailableDate(venue.getVenueCode());
    }
  }

  public void printSystemDate() {
    if (systemDate == null) {
      String currentDateMessage = MessageCli.CURRENT_DATE.getMessage("not set");
      System.out.println(currentDateMessage);
    } else {
      String currentDateMessage = MessageCli.CURRENT_DATE.getMessage(systemDate);
      System.out.println(currentDateMessage);
    }
  }

  public void makeBooking(String[] options) {
    boolean validity = true;
    // Check if system date is set.
    if (systemDate == null) {
      String bookingNotMadeMessage = MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.getMessage();
      System.out.println(bookingNotMadeMessage);
      validity = false;
    } else { // Check if booking date is in the past.
      // Split the system date into day, month and year.
      String[] systemDateParts = systemDate.split("/");
      int systemDay = Integer.parseInt(systemDateParts[0]);
      int systemMonth = Integer.parseInt(systemDateParts[1]);
      int systemYear = Integer.parseInt(systemDateParts[2]);

      // Split the booking date into day, month and year.
      String[] bookingDateParts = options[1].split("/");
      int bookingDay = Integer.parseInt(bookingDateParts[0]);
      int bookingMonth = Integer.parseInt(bookingDateParts[1]);
      int bookingYear = Integer.parseInt(bookingDateParts[2]);

      // Past booking date error message.
      String bookingNotMadeMessage =
          MessageCli.BOOKING_NOT_MADE_PAST_DATE.getMessage(options[1], systemDate);

      // Check if booking date is in the past.
      if (bookingYear < systemYear) {
        // Year check.
        System.out.println(bookingNotMadeMessage);
        validity = false;
      } else if (bookingYear == systemYear) {
        if (bookingMonth < systemMonth) {
          // Month check.
          System.out.println(bookingNotMadeMessage);
          validity = false;
        } else if (bookingMonth == systemMonth) {
          // Day check.
          if (bookingDay < systemDay) {
            System.out.println(bookingNotMadeMessage);
            validity = false;
          }
        }
      }
    }

    // Check if there are no venues.
    if (venueList.isEmpty()) {
      String bookingNotMadeMessage = MessageCli.BOOKING_NOT_MADE_NO_VENUES.getMessage();
      System.out.println(bookingNotMadeMessage);
      validity = false;
    }
    // Variable to store venue name.
    String venueName = "";
    // Variable to track if venue code exists.
    boolean venueCodeExists = false;
    // Check if venue code exists.
    for (Venue venue : venueList) {
      if (venue.getVenueCode().equals(options[0])) {
        venueName = venue.getVenueName();
        venueCodeExists = true;
      }
    }
    if (venueCodeExists == false) {
      String bookingNotMadeMessage =
          MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.getMessage(options[0]);
      System.out.println(bookingNotMadeMessage);
      validity = false;
    }
    // Check if venue is already booked.
    for (Booking booking : bookingList) {
      if (booking.getVenueName().equals(venueName) && booking.getBookingDate().equals(options[1])) {
        String bookingNotMadeMessage =
            MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.getMessage(venueName, options[1]);
        System.out.println(bookingNotMadeMessage);
        validity = false;
      }
    }
    // Adjusting number of attendees according to venue capacity.
    for (Venue venue : venueList) {
      if (venue.getVenueName().equals(venueName)) {
        int venueCapacity = Integer.parseInt(venue.getCapacityInput());
        int attendeeCount = Integer.parseInt(options[3]);
        if (attendeeCount > venueCapacity) {
          String bookingAttendeesAdjustedMessage =
              MessageCli.BOOKING_ATTENDEES_ADJUSTED.getMessage(
                  String.valueOf(options[3]),
                  String.valueOf(venueCapacity),
                  String.valueOf(venueCapacity));
          System.out.println(bookingAttendeesAdjustedMessage);
          options[3] = String.valueOf(venueCapacity);
        } else if (attendeeCount < venueCapacity / 4) {
          String bookingAttendeesAdjustedMessage =
              MessageCli.BOOKING_ATTENDEES_ADJUSTED.getMessage(
                  String.valueOf(options[3]),
                  String.valueOf(venueCapacity / 4),
                  String.valueOf(venueCapacity));
          System.out.println(bookingAttendeesAdjustedMessage);
          options[3] = String.valueOf(venueCapacity / 4);
        }
      }
    }

    // Successful booking created.
    if (validity) {
      String bookingReference = BookingReferenceGenerator.generateBookingReference();
      String makeBookingSuccessfulMessage =
          MessageCli.MAKE_BOOKING_SUCCESSFUL.getMessage(
              bookingReference, venueName, options[1], options[3]);
      System.out.println(makeBookingSuccessfulMessage);
      Booking booking =
          new Booking(bookingReference, venueName, options[0], options[1], options[2], options[3]);
      bookingList.add(booking);
      // Update next available date.
      updateNextAvailableDate(options[0]);
    }
  }

  public void updateNextAvailableDate(String venueCode) {
    String[] systemDateParts = systemDate.split("/");
    int systemDay = Integer.parseInt(systemDateParts[0]);
    int systemMonth = Integer.parseInt(systemDateParts[1]);
    int systemYear = Integer.parseInt(systemDateParts[2]);
    // Arraylist to store taken dates.
    ArrayList<String> takenDates = new ArrayList<String>();
    // Loop through booking list to find taken dates.
    for (Booking booking : bookingList) {
      if (booking.getVenueCode().equals(venueCode)) {
        takenDates.add(booking.getBookingDate());
      }
    }
    // Loop through taken dates to sort them from most current to future, starting from the left and
    // comparing to the next index date, if the next date is more current then swap them around.
    for (int i = 0; i < takenDates.size() - 1; i++) {
      for (int j = i + 1; j < takenDates.size(); j++) {
        // Creating index i date, the current index date.
        String[] date1Parts = takenDates.get(i).split("/");
        int day1 = Integer.parseInt(date1Parts[0]);
        int month1 = Integer.parseInt(date1Parts[1]);
        int year1 = Integer.parseInt(date1Parts[2]);
        Date date1 = new Date(day1, month1, year1);
        // Creating index j date, the next index date.
        String[] date2Parts = takenDates.get(j).split("/");
        int day2 = Integer.parseInt(date2Parts[0]);
        int month2 = Integer.parseInt(date2Parts[1]);
        int year2 = Integer.parseInt(date2Parts[2]);
        Date date2 = new Date(day2, month2, year2);
        // If index i date is after index j date then swap them around.
        if (date1.isAfter(date2)) {
          String temp = takenDates.get(i);
          takenDates.set(i, takenDates.get(j));
          takenDates.set(j, temp);
        }
      }
    }
    // Store current venue of interest.
    Venue venueOfInterest = null;
    for (Venue venue : venueList) {
      if (venue.getVenueCode().equals(venueCode)) {
        venueOfInterest = venue;
      }
    }
    if (takenDates.size()
        == 0) { // If there are no bookings for the venue then set the next available date to the
      // system date.
      venueOfInterest.setAvailableDate(systemDate);
    } else if (takenDates.size()
        > 0) { // If there are bookings for the venue and the current system date is taken then find
      // the next available date.
      Date availableDate = new Date(systemDay + 1, systemMonth, systemYear);
      // Loop through dates to find next available date.
      while (true) {
        boolean dateTaken = false;
        // Loop through taken dates to check if current available date is taken.
        for (String date : takenDates) {
          // Split the taken date to check against into day, month and year.
          String[] checkDateParts = date.split("/");
          int checkDay = Integer.parseInt(checkDateParts[0]);
          int checkMonth = Integer.parseInt(checkDateParts[1]);
          int checkYear = Integer.parseInt(checkDateParts[2]);
          // Create a date object for the taken date.
          Date dateToCheckAgainst = new Date(checkDay, checkMonth, checkYear);
          // If current available date is same as another date then it is taken.
          if (availableDate.isSame(dateToCheckAgainst)) {
            dateTaken = true;
            break;
          }
        }
        // If date is not taken then set it as the next available date.
        if (!dateTaken) {
          venueOfInterest.setAvailableDate(availableDate.toString());
          break;
        }
        // If date is taken then increment the day by 1.
        availableDate =
            new Date(availableDate.getDay() + 1, availableDate.getMonth(), availableDate.getYear());
      }
    }
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
