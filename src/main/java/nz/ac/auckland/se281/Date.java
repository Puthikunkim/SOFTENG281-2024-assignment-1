package nz.ac.auckland.se281;

public class Date {
  private int day;
  private int month;
  private int year;

  // Constructor for the Date class
  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  // Getter methods for the values
  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  // method to compare if a date is after another
  public boolean isAfter(Date other) {
    if (this.year > other.getYear()) {
      return true;
    } else if (this.year == other.getYear()) {
      if (this.month > other.getMonth()) {
        return true;
      } else if (this.month == other.getMonth()) {
        if (this.day > other.getDay()) {
          return true;
        }
      }
    }
    return false;
  }

  // method to compare if a date is the same as another
  public boolean isSame(Date other) {
    return this.year == other.getYear()
        && this.month == other.getMonth()
        && this.day == other.getDay();
  }

  // method to return date as a string in format dd/mm/yyyy
  @Override
  public String toString() {
    return day + "/" + month + "/" + year;
  }
}
