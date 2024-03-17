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
    } else if (venueList.size() > 1 && venueList.size() < 10) {
      String numberVenuesMessage = MessageCli.NUMBER_VENUES.getMessage("are", String.valueOf(venueList.size()), "s");
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
       
    // TODO implement this method
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
