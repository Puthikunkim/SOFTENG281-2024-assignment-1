package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private ArrayList<String> venueList = new ArrayList<String>();


  public VenueHireSystem() {
    
  }

  public void printVenues() {
    if (venueList.isEmpty()) {
      String noVenuesMessage = MessageCli.NO_VENUES.getMessage();
      System.out.println(noVenuesMessage);
    } else if (venueList.size() == 4) {
      String numberVenuesMessage = MessageCli.NUMBER_VENUES.getMessage("is", "one", "");
      System.out.println(numberVenuesMessage);
      String venueEntryMessage = MessageCli.VENUE_ENTRY.getMessage(venueList.get(0), venueList.get(1), venueList.get(2), venueList.get(3), "");
      System.out.println(venueEntryMessage);
    } else if (venueList.size() > 4 && venueList.size() < 40) {
      int number = venueList.size()/4;
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

      int venueMessageSize = 4; 
      for (int i = 0; i < (venueList.size() / venueMessageSize); i++) {
        int startIndex = i * venueMessageSize;
        String venueEntryMessage = MessageCli.VENUE_ENTRY.getMessage(venueList.get(startIndex), venueList.get(startIndex+1), venueList.get(startIndex+2), venueList.get(startIndex+3), "");
        System.out.println(venueEntryMessage);
      }
    } else {
      String numberVenuesMessage = MessageCli.NUMBER_VENUES.getMessage("are", String.valueOf(venueList.size()), "s");
      System.out.println(numberVenuesMessage);

      int venueMessageSize = 4; 
      for (int i = 0; i < (venueList.size() / venueMessageSize); i++) {
        int startIndex = i * venueMessageSize;
        String venueEntryMessage = MessageCli.VENUE_ENTRY.getMessage(venueList.get(startIndex), venueList.get(startIndex+1), venueList.get(startIndex+2), venueList.get(startIndex+3), "");
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
        for (int i = 1; i < venueList.size(); i += 4) {
          if (venueList.get(i).equals(venueCode)) {
              validity = false;
              String venueUnsuccessfulMessage = MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.getMessage(venueCode, venueList.get(i-1));
              System.out.println(venueUnsuccessfulMessage);
              break;
          }
        }

        // capacityInput number check
        try {
          int intCapacity = Integer.parseInt(capacityInput);
          if (intCapacity < 1) {
            validity = false;
            String venueUnsuccessfulMessage = MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.getMessage("capacity", " positive");
            System.out.println(venueUnsuccessfulMessage);
          }
        } catch(Exception e) {
          validity = false;
          String venueUnsuccessfulMessage = MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.getMessage("capacity", "");
          System.out.println(venueUnsuccessfulMessage);
        }

        // hireFeeInput number check
        try {
          int intHireFee = Integer.parseInt(hireFeeInput);
          if (intHireFee < 1) {
            validity = false;
            String venueUnsuccessfulMessage = MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.getMessage("hire fee", " positive");
            System.out.println(venueUnsuccessfulMessage);
          }
        } catch(Exception e) {
          validity = false;
          String venueUnsuccessfulMessage = MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.getMessage("hire fee", "");
          System.out.println(venueUnsuccessfulMessage);
        }

        // Success
        if (validity) {
          String venueSuccessfullyCreatedMessage = MessageCli.VENUE_SUCCESSFULLY_CREATED.getMessage(venueName, venueCode);
          System.out.println(venueSuccessfullyCreatedMessage);
          venueList.add(venueName);
          venueList.add(venueCode);
          venueList.add(capacityInput);
          venueList.add(hireFeeInput);
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
