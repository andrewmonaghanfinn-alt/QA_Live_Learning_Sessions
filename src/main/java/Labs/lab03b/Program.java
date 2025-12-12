package Labs.lab03b;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try {
            vehicles.add(new Vehicle(0, 1));
            vehicles.add(new Vehicle(0, 2));
            vehicles.add(new Vehicle(0, 3));
            vehicles.add(new Vehicle(0, 1));
            vehicles.add(new Vehicle(0, 2));
            vehicles.add(new Vehicle(0, 3));
            vehicles.add(new Vehicle(0, 1));
            vehicles.add(new Vehicle(0, 2));
            vehicles.add(new Vehicle(0, 3));
            vehicles.add(new Vehicle(0, 1));
            vehicles.add(new Vehicle(0, 2));
            vehicles.add(new Vehicle(0, 3)); //this one will trigger the exception
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Could not instantiate new vehicle: " + e.getMessage());
        }
        //the rest of the code still continues tho which is kind of a problem

        for (Vehicle v : vehicles) {
            System.out.println(v.getDetails());
        }

        int currentMaxDistance = 0;
        String currentWinner = "";
        Random rand = new Random();
        while (currentMaxDistance < 1000) {
            for (Vehicle car : vehicles) {
                car.accelerate(rand.nextInt(10) + 1);
                System.out.println("Car " + car.registrationPlate.getPlate() + " is now at distance " + car.distanceTravelled);
                if (car.distanceTravelled > currentMaxDistance) {
                    currentMaxDistance = car.distanceTravelled;
                    currentWinner = car.registrationPlate.getPlate();
                }
                if (car.distanceTravelled >= 1000) break;
            }
        }

        System.out.print("The winner is: " + currentWinner);

    }
}


class Vehicle {
    public int speed;
    public int lane;
    public int distanceTravelled;
    RegistrationPlate registrationPlate;
    static int vehicleCount = 0;

    Vehicle(int speed, int lane) {
        this.speed = speed;
        this.lane = lane;
        this.distanceTravelled = 0;
        registrationPlate = RegistrationPlateFactory.getNextRegistrationPlate();
        vehicleCount++;
    }

    static int getCount() { return vehicleCount; }

    void accelerate(int amount) {
        speed += amount;
        if (speed > 200) speed = 200;
        distanceTravelled += amount;
    }
    void brake(int amount) {
        speed -= amount;
        if (speed < 0) speed = 0;
    }

    String getDetails() {
        return "Speed: " + lane + "\n" +
                "Lane: " + lane + "\n" +
                "Distance travelled: " + distanceTravelled + "\n" +
                "Plate: " + registrationPlate.getPlate();
    }
}

class RegistrationPlate {
    private String plate;
    String getPlate() { return plate; }
    RegistrationPlate(String plate) {
        this.plate = plate;
    }

}

class RegistrationPlateFactory {
    private static int regPlateIndex = 0;
    private static String[] registrationPlates = {
            "LA05 XYZ", // London
            "NG58 JKL", // Nottingham
            "MA13 HYP", // Manchester
            "BX06 TUV", // Birmingham
            "CF67 QRS", // Cardiff
            "YS09 PQR", // Yorkshire
            "WD21 NML", // Exeter area (Western region)
            "KR16 FGH", // Northampton
            "SJ04 UVW", // Glasgow
            "LV22 ABC", // Liverpool
            "WX19 XYZ"  // Bristol
    };

    static RegistrationPlate getNextRegistrationPlate() {

        if (regPlateIndex == registrationPlates.length) {
            throw new ArrayIndexOutOfBoundsException("no unique number plates available");
        }

        return new RegistrationPlate(registrationPlates[regPlateIndex++]);
    }

}


