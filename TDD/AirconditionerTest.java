import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirconditionerTest {

  @Test
  public void test_Airconditioner_IsInitiallyOff() {
    Airconditioner ac = new Airconditioner();
    assertFalse(ac.isOn());
  }

  @Test
  public void test_TurnOn_Airconditioner() {
    Airconditioner ac = new Airconditioner();
    assertTrue(ac.turnOn());
    assertTrue(ac.isOn());
  }

  @Test
  public void test_TurnOff_Airconditioner() {
    Airconditioner ac = new Airconditioner();
    ac.turnOn();
    assertEquals(false, ac.turnOff());
    assertFalse(ac.isOn());
  }

  @Test
  public void test_CannotIncreaseTemperature_WhenACIsOff() {
    Airconditioner ac = new Airconditioner();
    int tempBefore = ac.getTemperature();
    ac.increaseTemperature();
    assertEquals(tempBefore, ac.getTemperature());
  }

  @Test
  public void test_CannotDecreaseTemperature_WhenACIsOff() {
    Airconditioner ac = new Airconditioner();
    int tempBefore = ac.getTemperature();
    ac.decreaseTemperature();
    assertEquals(tempBefore, ac.getTemperature());
  }

  @Test
  public void test_IncreaseTemperature_WhenACIsOn() {
    Airconditioner ac = new Airconditioner();
    ac.turnOn();
    int tempBefore = ac.getTemperature();
    ac.increaseTemperature();
    assertEquals(tempBefore + 1, ac.getTemperature());
  }

  @Test
  public void test_DecreaseTemperature_WhenACIsOn() {
    Airconditioner ac = new Airconditioner();
    ac.turnOn();
    ac.increaseTemperature();
    int tempBefore = ac.getTemperature();
    ac.decreaseTemperature();
    assertEquals(tempBefore - 1, ac.getTemperature());
  }

  @Test
  public void test_TemperatureDoesNotExceed30() {
    Airconditioner ac = new Airconditioner();
    ac.turnOn();
    for (int count = 0; count < 20; count++) {
      ac.increaseTemperature();
    }
    assertEquals(30, ac.getTemperature());
  }

  @Test
  public void test_TemperatureDoesNotDropBelow16() {
    Airconditioner ac = new Airconditioner();
    ac.turnOn();
    for (int count = 0; count < 20; count++) {
      ac.decreaseTemperature();
    }
    assertEquals(16, ac.getTemperature());
  }
}
