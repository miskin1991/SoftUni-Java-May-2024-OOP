package Exercise.Polymorphism._01_Vehicles;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carDetails = scanner.nextLine().split("\\s+");
        String[] truckDetails = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carDetails[1]), Double.parseDouble(carDetails[2]));
        Truck truck = new Truck(Double.parseDouble(truckDetails[1]), Double.parseDouble(truckDetails[2]));

        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < N; i++) {
            String[] vehicleRun = scanner.nextLine().split("\\s+");

            switch (vehicleRun[0]) {
                case "Drive": {
                    String type = vehicleRun[1];
                    double distance = Double.parseDouble(vehicleRun[2]);
                    if (type.equals("Car")) {
                        System.out.println(car.driving(distance));
                    } else {
                        System.out.println(truck.driving(distance));
                    }
                    break;
                }
                case "Refuel": {
                    String type = vehicleRun[1];
                    double fuel = Double.parseDouble(vehicleRun[2]);
                    if (type.equals("Car")) {
                        car.refueling(fuel);
                    } else {
                        truck.refueling(fuel);
                    }
                    break;
                }
                default:
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
