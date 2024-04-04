package nz.ac.auckland.se281;

public class MusicService extends Service {
  public MusicService(String serviceName, int cost, String bookingReference) {
    super(serviceName, cost);
    String addServiceSuccessfulMessage =
        MessageCli.ADD_SERVICE_SUCCESSFUL.getMessage(serviceName, bookingReference);
    System.out.println(addServiceSuccessfulMessage);
  }

  // method to add service to booking list
  public void addService(Booking booking) {
    booking.getServiceList().add(this);
  }

  // method to multiply the cost of the catering service by the number of attendees
  public int calculateCost(int attendeeCount) {
    return this.getCost();
  }
}
