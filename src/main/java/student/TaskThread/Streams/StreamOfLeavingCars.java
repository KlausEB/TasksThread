package student.TaskThread.Streams;

import student.TaskThread.Resources.Car;
import student.TaskThread.Resources.ParkingLot;

import java.util.concurrent.TimeUnit;

public class StreamOfLeavingCars extends Thread{
    private ParkingLot parkingLot;

    public StreamOfLeavingCars(ParkingLot parkingLot) {
        super();
        this.parkingLot = parkingLot;
    }

    public void run(){
        while(parkingLot.getWorkingDayIsRunning()){
            try {
                TimeUnit.MILLISECONDS.sleep(900);
                Car currentCar;
                if((currentCar = parkingLot.deleteCars()) != null) {
                    System.out.println("Машина с индексом " + currentCar.getCarID() + " покинула стоянку");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Рабочий день закончен, машины больше не едут");
    }
}
