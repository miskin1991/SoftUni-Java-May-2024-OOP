//package Exams._20240802_examPreparation.busyWaiters;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class RestaurantTests {
//
//    @Test
//    public void whenNameNull_thenExceptionIsThrown()
//    {
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            Restaurant restaurant = new Restaurant(null, 10);
//        });
//    }
//
//    @Test
//    public void whenNameEmpty_thenExceptionIsThrown()
//    {
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            Restaurant restaurant = new Restaurant("", 10);
//        });
//    }
//
//    @Test
//    public void whenCapacityNegative_thenExceptionIsThrown()
//    {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            Restaurant restaurant = new Restaurant("Restaurant", -10);
//        });
//    }
//
//    @Test
//    public void whenNameAndCapacityCorrect_thenRestaurantCreated()
//    {
//        Restaurant restaurant = new Restaurant("Restaurant", 10);
//
//        Assertions.assertEquals("Restaurant", restaurant.getName());
//        Assertions.assertEquals(10, restaurant.getCapacity());
//        Assertions.assertTrue(restaurant.getWaiters().isEmpty());
//        Assertions.assertEquals(0, restaurant.getCount());
//    }
//
//    @Test
//    public void whenNoMoreWaitersCapacity_thenExceptionIsThrown() {
//        Restaurant restaurant = new Restaurant("Restaurant", 0);
//
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//           restaurant.addFullTimeWaiter(new FullTimeWaiter("John", 8));
//        });
//    }
//
//    @Test
//    public void whenWaiterExists_thenExceptionIsThrown() {
//        Restaurant restaurant = new Restaurant("Restaurant", 10);
//        restaurant.addFullTimeWaiter(new FullTimeWaiter("John", 8));
//
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            restaurant.addFullTimeWaiter(new FullTimeWaiter("John", 8));
//        });
//    }
//
//    @Test
//    public void whenRemoveNotExistingWaiterByName_thenReturnFalse() {
//        Restaurant restaurant = new Restaurant("Restaurant", 10);
//        restaurant.addFullTimeWaiter(new FullTimeWaiter("John", 8));
//
//        Assertions.assertFalse(restaurant.removeFullTimeWaiter("Jjohn"));
//    }
//
//    @Test
//    public void whenRemoveExistingWaiterByName_thenReturnTrue() {
//        Restaurant restaurant = new Restaurant("Restaurant", 10);
//        restaurant.addFullTimeWaiter(new FullTimeWaiter("John", 8));
//
//        Assertions.assertTrue(restaurant.removeFullTimeWaiter("John"));
//    }
//}
