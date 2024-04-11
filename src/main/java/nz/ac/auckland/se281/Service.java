package nz.ac.auckland.se281;

public abstract class Service {

  // Variables for the service class
  protected String serviceName;
  protected int cost;

  // Constructor for service class that takes in booking reference and service type
  public Service(String serviceName, int cost) {
    this.serviceName = serviceName;
    this.cost = cost;
  }

  // Getter methods for the values
  public int getCost() {
    return cost;
  }

  // method to add service to booking list
  public void addServiceToBooking(Booking booking) {
    booking.getServiceList().add(this);
  }

  // Abstract method to calculate the cost of each type of service.
  public abstract int calculateCost(int attendeeCount);
}
