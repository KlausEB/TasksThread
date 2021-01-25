package student.OptionalTaskThread;

import student.OptionalTaskThread.Resources.Airport;
import student.OptionalTaskThread.Resources.Plane;
import student.OptionalTaskThread.Streams.PlaneDeparture;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main( String[] args )
    {
        List<Plane> planes = new ArrayList<>();
        planes.add(new Plane(0, " Boeing-737 "));
        planes.add(new Plane(1, " Boeing-737-800 "));
        planes.add(new Plane(2, " Boeing-747 "));
        planes.add(new Plane(3, " Airbus A320 "));
        planes.add(new Plane(4, " Airbus A330 "));
        planes.add(new Plane(5, " Embraer 190 "));
        planes.add(new Plane(6, " Sukhoi Superjet 100 "));
        planes.add(new Plane(7, " Bombardier CS300 "));
        planes.add(new Plane(8, " B-1B Lancer "));
        planes.add(new Plane(9, " B-2 Spirit "));

        Airport airport = new Airport(planes);

        for (int i = 0; i < 10; i++) {
            PlaneDeparture planeDeparture = new PlaneDeparture(airport);
            planeDeparture.start();
        }
    }
}
