package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class CateringService extends Service {
  private String cateringTypeName;
  private CateringType cateringType;

  public CateringService(
      String serviceName,
      int cost,
      String cateringTypeName,
      CateringType cateringType,
      String bookingReference) {
    super(serviceName, cost);
    this.cateringType = cateringType;
    this.cateringTypeName = cateringTypeName;
    String addServiceSuccessfulMessage =
        MessageCli.ADD_SERVICE_SUCCESSFUL.getMessage(
            serviceName + " (" + cateringTypeName + ")", bookingReference);
    System.out.println(addServiceSuccessfulMessage);
  }

  // Getter method for the catering type
  public String getCateringTypeName() {
    return cateringTypeName;
  }

  public CateringType getCateringType() {
    return cateringType;
  }

  // method to multiply the cost of the catering service by the number of attendees
  public int calculateCost(int attendeeCount) {
    return this.getCost() * attendeeCount;
  }
}
