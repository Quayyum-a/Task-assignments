public class Airconditioner {

  private int temperature;
  private boolean isOn;

  public Airconditioner() {
    this.temperature = 16;
    this.isOn = false;
  }

  public boolean turnOn() {
    isOn = true;
    return isOn;
  }

  public boolean turnOff() {
    isOn = false;
    return isOn;
  }

  public void increaseTemperature() {
    if (isOn && temperature < 30) {
      temperature++;
    }
  }

  public void decreaseTemperature() {
    if (isOn && temperature > 16) {
      temperature--;
    }
  }

  public int getTemperature() {
    return temperature;
  }

  public boolean isOn() {
    return isOn;
  }
}
