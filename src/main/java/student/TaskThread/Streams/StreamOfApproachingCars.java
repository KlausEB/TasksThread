package student.TaskThread.Streams;

import student.TaskThread.Exceptions.NoApproachingCarsException;
import student.TaskThread.Resources.Car;
import student.TaskThread.Resources.ParkingLot;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StreamOfApproachingCars extends Thread{
    private final ParkingLot parkingLot;
    private final List<Car> carsOnTheWay;

    public StreamOfApproachingCars(ParkingLot parkingLot, Car[] carsOnTheWay) {
        super();
        this.parkingLot = parkingLot;
        this.carsOnTheWay = Arrays.asList(carsOnTheWay);
    }

    public void run(){
        try {
            if (carsOnTheWay.size() == 0){
                throw new NoApproachingCarsException("No approaching cars");
            }

            System.out.println("Рабочий день начался");
            for (Car car : carsOnTheWay) {
                System.out.println("Машина с индексом " + car.getCarID() + " едет на стоянку");
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println("Машина с индексом " + car.getCarID() + " подъезжает к посту охраны");
                if (parkingLot.setCars(car)) {
                    System.out.println("Машина с индексом " + car.getCarID() + " успешно припарковалась");
                } else {
                    System.out.println("Машине с индексом " + car.getCarID() + " не нашлось места на стоянке");
                }
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException | NoApproachingCarsException e) {
                e.printStackTrace();
        }
        parkingLot.endOfTheWorkingDay();
    }
}
