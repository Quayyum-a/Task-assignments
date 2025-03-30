public class Airconditioner {

  private int temperature = 16; 

  public void setTemperature(int temp) {
    this.temperature = temp; 
  }
 
  public boolean turnOn() {
    return true;
  }

  public boolean turnOff() {
    return false;
  }

  public int increaseTemperature() {
      temperature++;
      if (temperature > 30) {
        temperature = 30; 
      }
      return temperature;
  }

  public int decreaseTemperature() { 
    temperature--;
    if (temperature < 16) {
      temperature = 16; 
    }
    return temperature;
  }

  public int getTemperature() { 
    return temperature;
  }
}