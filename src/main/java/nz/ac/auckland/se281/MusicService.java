package nz.ac.auckland.se281;

public class MusicService extends Service {
  public MusicService(String serviceName, int cost, String bookingReference) {
    super(serviceName, cost);
    String addServiceSuccessfulMessage =
        MessageCli.ADD_SERVICE_SUCCESSFUL.getMessage(serviceName, bookingReference);
    System.out.println(addServiceSuccessfulMessage);
  }
}
