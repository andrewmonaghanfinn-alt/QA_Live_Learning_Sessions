package Labs.lab8;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Honda"));
        cars.add(new Car("Kia"));
        cars.add(new Car("Toyota"));
        cars.add(new RacingCar("McClaren", "Bobert", 2));
        cars.add(new RacingCar("Bugatti", "Jobert", 2));
    }
    static void processCars(ArrayList<Car> cars) {
        for (Car car : cars) {
            car.getToSixty();
            car.accelerate(2);
            System.out.println(car.getModel());
            if (car instanceof RacingCar) {
                System.out.println(((RacingCar) car).getDriver());
            }
            System.out.println(car.getSpeed());
        }
    }
}

class Car {
    private String model;
    private double speed;

    Car(String model) {
        this.model = model;
        getToSixty();
    }
    public void accelerate(int seconds) {
        this.speed += (5 * seconds);
    }
    public String getModel() {
        return model;
    }
    public double getSpeed() {
        return speed;
    }
    public void getToSixty() {
        this.speed = 60.0;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
}

class RacingCar extends Car {
    private String driver;
    private int turboFactor;

    RacingCar(String model, String driver, int turboFactor) {
        super(model);
    }
    public void accelerate(int seconds) {
        super.accelerate(seconds);
        super.setSpeed(super.getSpeed() * turboFactor);
    }
    public String getDriver() {
        return driver;
    }
    public int getTurboFactor() {
        return turboFactor;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public void setTurboFactor(int turboFactor) {
        this.turboFactor = turboFactor;
    }
}

