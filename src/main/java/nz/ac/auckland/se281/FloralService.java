package nz.ac.auckland.se281;

public class FloralService extends Service {

  // Variables for the FloralService class
  private String floralTypeName;

  // Constructor for the FloralService class
  public FloralService(
      String serviceName, int cost, String floralTypeName, String bookingReference) {
    super(serviceName, cost);
    this.floralTypeName = floralTypeName;

    // Print successful service added to booking message
    String addServiceSuccessfulMessage =
        MessageCli.ADD_SERVICE_SUCCESSFUL.getMessage(
            serviceName + " (" + floralTypeName + ")", bookingReference);
    System.out.println(addServiceSuccessfulMessage);
  }

  // Getter method for the floral type name
  public String getFloralTypeName() {
    return floralTypeName;
  }

  // Method to return the cost of the specific floral service
  @Override
  public int calculateCost(int attendeeCount) {
    return this.getCost();
  }
}
