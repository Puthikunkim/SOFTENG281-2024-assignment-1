package nz.ac.auckland.se281;

public abstract class Service {
  protected String serviceName;
  protected int cost;

  // Constructor for service class that takes in booking reference and service type
  public Service(String serviceName, int cost) {
    this.serviceName = serviceName;
    this.cost = cost;
  }

  // Getter methods for the values
  public String getServiceName() {
    return serviceName;
  }

  public int getCost() {
    return cost;
  }

  // Setter method for the cost
  public void setCost(int cost) {
    this.cost = cost;
  }

  // Setter method for the service name
  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  // method to add service to booking list
  public void addService(Booking booking) {
    booking.getServiceList().add(this);
  }

  // method to calculate the cost of the service
  public abstract int calculateCost(int attendeeCount);
}
