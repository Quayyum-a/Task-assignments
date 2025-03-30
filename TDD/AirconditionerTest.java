import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class AirconditionerTest {

  @Test
  public void test_TurnOn() {
    Airconditioner ac = new Airconditioner();
    assertTrue(ac.turnOn());
  }

  @Test
  public void test_TurnOff_WhenACIsOn() {
    Airconditioner ac = new Airconditioner();
    ac.turnOn();
    assertFalse(ac.turnOff());
  }
  
  @Test
  public void test_IncreaseTemperature() {
    Airconditioner ac = new Airconditioner();
    assertEquals(17, ac.increaseTemperature()); 
  }
  
  @Test
  public void test_DecreaseTemperature() {
    Airconditioner ac = new Airconditioner();
    ac.increaseTemperature();
    assertEquals(16, ac.decreaseTemperature()); 
  }
  
  @Test
  public void test_TemperatureDoesNotGoBeyond30() {
    Airconditioner ac = new Airconditioner();
    ac.setTemperature(30); 
    ac.increaseTemperature(); 
    int result = ac.getTemperature(); 
    assertEquals(30, result); 
  }

  @Test
  public void test_TemperatureDoesNotGoBelow16() {
    Airconditioner ac = new Airconditioner();
    ac.setTemperature(16); 
    ac.decreaseTemperature(); 
    int result = ac.getTemperature(); 
    assertEquals(16, result); 
  }
}