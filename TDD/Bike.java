public class Bike {

  private int speed = 1;

  public boolean turnOn() {
    return true;
  }

  public boolean turnOff() {
    return false;
  }

  public void setGear(int gear) {
    this.speed = gear;
  }

  public int accelerate() {
    if (speed == 24) {
      return speed + 2;
    }
    if( speed == 35) {
      return speed + 3;
    }
    if (speed == 44) {
      return speed + 4;
    }
    return speed + 1;
  }

  public int decelerate() {
    if (speed == 24) {
      return speed - 2;
    }
    if (speed == 35) {
      return speed - 3;
    }
    if (speed == 44) {
      return speed - 4;
    }
    return speed - 1;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

}