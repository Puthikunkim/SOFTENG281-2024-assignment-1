package nz.ac.auckland.se281;

public class CateringService extends Service {

  // Variable for the CateringService class
  private String cateringTypeName;

  public CateringService(
      String serviceName, int cost, String cateringTypeName, String bookingReference) {
    super(serviceName, cost);
    this.cateringTypeName = cateringTypeName;

    // Print successful service added to booking message
    String addServiceSuccessfulMessage =
        MessageCli.ADD_SERVICE_SUCCESSFUL.getMessage(
            serviceName + " (" + cateringTypeName + ")", bookingReference);
    System.out.println(addServiceSuccessfulMessage);
  }

  // Getter method for the catering type
  public String getCateringTypeName() {
    return cateringTypeName;
  }

  // Method to multiply the cost of the catering service by the number of attendees and get actual
  // cost
  @Override
  public int calculateCost(int attendeeCount) {
    return this.getCost() * attendeeCount;
  }
}
