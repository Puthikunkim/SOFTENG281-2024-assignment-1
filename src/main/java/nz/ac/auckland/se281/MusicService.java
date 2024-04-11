package nz.ac.auckland.se281;

public class MusicService extends Service {

  // Constructor for the MusicService class
  public MusicService(String serviceName, int cost, String bookingReference) {
    super(serviceName, cost);

    // Print successful service added to booking message
    String addServiceSuccessfulMessage =
        MessageCli.ADD_SERVICE_SUCCESSFUL.getMessage(serviceName, bookingReference);
    System.out.println(addServiceSuccessfulMessage);
  }

  // Method to return the cost of the music service
  public int calculateCost(int attendeeCount) {
    return this.getCost();
  }
}
