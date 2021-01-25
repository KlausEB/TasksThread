package student.TaskThread;


import student.TaskThread.Exceptions.NoParkingSpacesException;
import student.TaskThread.Resources.Car;
import student.TaskThread.Resources.ParkingLot;
import student.TaskThread.Streams.StreamOfLeavingCars;
import student.TaskThread.Streams.StreamOfApproachingCars;

import java.util.Scanner;

public class Run
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a max number of cars: ");
        int MAX_NUMBER_OF_CARS = in.nextInt();
        in.close();

        Car[] cars = {new Car(1),new Car(2),new Car(3),new Car(4),new Car(5),new Car(6),new Car(7),new Car(8),new Car(9),new Car(10)};
        ParkingLot parkingLot = null;
        try {
            parkingLot = new ParkingLot(MAX_NUMBER_OF_CARS);
        } catch (NoParkingSpacesException e) {
            e.printStackTrace();
        }

        StreamOfApproachingCars streamOfApproachingCars = new StreamOfApproachingCars(parkingLot, cars);
        StreamOfLeavingCars streamOfLeavingCars = new StreamOfLeavingCars(parkingLot);
        streamOfApproachingCars.start();
        streamOfLeavingCars.start();
    }
}
