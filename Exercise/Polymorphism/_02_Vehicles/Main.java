package Exercise.Polymorphism._02_Vehicles;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carDetails = scanner.nextLine().split("\\s+");
        String[] truckDetails = scanner.nextLine().split("\\s+");
        String[] busDetails = scanner.nextLine().split("\\s+");

        Car car = new Car(
            Double.parseDouble(carDetails[1]), Double.parseDouble(carDetails[2]), Double.parseDouble(carDetails[3])
        );
        Truck truck = new Truck(
            Double.parseDouble(truckDetails[1]), Double.parseDouble(truckDetails[2]), Double.parseDouble(truckDetails[3])
        );

        Bus bus = new Bus(
            Double.parseDouble(busDetails[1]), Double.parseDouble(busDetails[2]), Double.parseDouble(busDetails[3])
        );

        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < N; i++) {
            String[] vehicleRun = scanner.nextLine().split("\\s+");

            switch (vehicleRun[0]) {
                case "Drive": {
                    String type = vehicleRun[1];
                    double distance = Double.parseDouble(vehicleRun[2]);
                    if (type.equals("Car")) {
                        System.out.println(car.driving(distance));
                    } else if (type.equals("Bus")) {
                        System.out.println(bus.driving(distance));
                    } else {
                        System.out.println(truck.driving(distance));
                    }
                    break;
                }
                case "DriveEmpty": {
                    double distance = Double.parseDouble(vehicleRun[2]);
                    System.out.println(bus.drivingEmpty(distance));
                    break;
                }
                case "Refuel": {
                    String type = vehicleRun[1];
                    double fuel = Double.parseDouble(vehicleRun[2]);
                    if (type.equals("Car")) {
                        car.refueling(fuel);
                    } else if (type.equals("Bus")) {
                        bus.refueling(fuel);
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
        System.out.println(bus);
    }
}
