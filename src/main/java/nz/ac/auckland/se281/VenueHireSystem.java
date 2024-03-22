package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private ArrayList<Venue> venueList = new ArrayList<Venue>();

  public VenueHireSystem() {}

  public void printVenues() {
    // No venues
    if (venueList.isEmpty()) {
      String noVenuesMessage = MessageCli.NO_VENUES.getMessage();
      System.out.println(noVenuesMessage);
    } else if (venueList.size() == 1) { // One venue
      String numberVenuesMessage = MessageCli.NUMBER_VENUES.getMessage("is", "one", "");
      System.out.println(numberVenuesMessage);
      String venueEntryMessage =
          MessageCli.VENUE_ENTRY.getMessage(
              venueList.get(0).getVenueName(),
              venueList.get(0).getVenueCode(),
              venueList.get(0).getCapacityInput(),
              venueList.get(0).getHireFeeInput(),
              "");
      System.out.println(venueEntryMessage);
    } else if (venueList.size() > 1 && venueList.size() < 10) { // Under ten venues
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

      for (int i = 0; i < venueList.size(); i++) {
        String venueEntryMessage =
            MessageCli.VENUE_ENTRY.getMessage(
                venueList.get(i).getVenueName(),
                venueList.get(i).getVenueCode(),
                venueList.get(i).getCapacityInput(),
                venueList.get(i).getHireFeeInput(),
                "");
        System.out.println(venueEntryMessage);
      }
    } else { // More than 10 venues
      String numberVenuesMessage =
          MessageCli.NUMBER_VENUES.getMessage("are", String.valueOf(venueList.size()), "s");
      System.out.println(numberVenuesMessage);

      for (int i = 0; i < venueList.size(); i++) {
        String venueEntryMessage =
            MessageCli.VENUE_ENTRY.getMessage(
                venueList.get(i).getVenueName(),
                venueList.get(i).getVenueCode(),
                venueList.get(i).getCapacityInput(),
                venueList.get(i).getHireFeeInput(),
                "");
        System.out.println(venueEntryMessage);
      }
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    boolean validity = true;
    // venueName check
    if (venueName.trim().isEmpty()) {
      validity = false;
      String venueUnsuccessfulMessage = MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.getMessage();
      System.out.println(venueUnsuccessfulMessage);
    }

    // venueCode check
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

    // capacityInput number check
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

    // hireFeeInput number check
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

    // Success
    if (validity) {
      String venueSuccessfullyCreatedMessage =
          MessageCli.VENUE_SUCCESSFULLY_CREATED.getMessage(venueName, venueCode);
      System.out.println(venueSuccessfullyCreatedMessage);
      Venue venue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
      venueList.add(venue);
    }
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
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
