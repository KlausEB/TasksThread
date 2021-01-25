package student.TaskThread.Resources;

import student.TaskThread.Exceptions.NoParkingSpacesException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ParkingLot {
    private final BlockingQueue<Car> cars;
    private boolean workingDayIsRunning = true;

    public ParkingLot(int MAX_NUMBER_OF_CARS) throws NoParkingSpacesException {
        if (MAX_NUMBER_OF_CARS <= 0){
            throw new NoParkingSpacesException("Incorrect number of parking spaces specified");
        }
        cars = new LinkedBlockingQueue<>(MAX_NUMBER_OF_CARS);
    }

    public Car deleteCars() {
        return cars.poll();
    }

    public boolean setCars(Car car) {
        return cars.offer(car);
    }

    public void endOfTheWorkingDay() {
        this.workingDayIsRunning = false;
    }

    public boolean getWorkingDayIsRunning() {
        return workingDayIsRunning;
    }
}
