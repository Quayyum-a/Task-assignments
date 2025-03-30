import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

public class BikeTest {

  @Test
  public void test_TurnOn() {
    Bike bike = new Bike();
    assertTrue(bike.turnOn());
  }

  @Test
  public void testIsOn_TurnOff() {
    Bike bike = new Bike();
    bike.turnOn();
    assertFalse(bike.turnOff());
  }

  @Test
  public void test_GearOne_CanAccelerate() {
    Bike bike = new Bike();
    bike.setSpeed(15);
    assertEquals(bike.accelerate(), 16);
  }

  @Test
  public void test_GearTwo_CanAccelerate() {
    Bike bike = new Bike();
    bike.setSpeed(24);
    assertEquals(bike.accelerate(), 26);
  }

  @Test
  public void test_GearThree_CanAccelerate() {
    Bike bike = new Bike();
    bike.setSpeed(35);
    assertEquals(bike.accelerate(), 38);
  }

  @Test
  public void test_GearFour_CanAccelerate() {
    Bike bike = new Bike();
    bike.setSpeed(44);
    assertEquals(bike.accelerate(), 48);
  }

  @Test
  public void test_GearOne_CanDeccelerate() {
    Bike bike = new Bike();
    bike.setSpeed(15);
    assertEquals(bike.decelerate(), 14);
  }

  @Test
  public void test_GearTwo_CanDeccelerate() {
    Bike bike = new Bike();
    bike.setSpeed(24);
    assertEquals(bike.decelerate(), 22);
  }

  @Test
  public void test_GearThree_CanDeccelerate() {
    Bike bike = new Bike();
    bike.setSpeed(35);
    assertEquals(bike.decelerate(), 32);
  }

  @Test
  public void test_GearFour_CanDeccelerate() {
    Bike bike = new Bike();
    bike.setSpeed(44);
    assertEquals(bike.decelerate(), 40);
  }


}