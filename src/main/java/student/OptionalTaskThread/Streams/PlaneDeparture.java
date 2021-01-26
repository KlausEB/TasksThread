package student.OptionalTaskThread.Streams;


import student.OptionalTaskThread.Resources.Airport;
import student.OptionalTaskThread.Resources.Plane;

import java.util.concurrent.TimeUnit;

public class PlaneDeparture implements Runnable{
    Airport airport;
    Plane plane;

    public PlaneDeparture(Airport airport) {
        super();
        this.airport = airport;
        this.plane = airport.getPlane();
    }

    public void run() {
        try {
            int currentAirstrip = airport.prepareTheAirstrip(plane);
            System.out.println("-->Самолёт" + plane.getPlaneName() + "поступает на взлётно-посадочную полосу " + "под номером " + currentAirstrip);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("-->Самолёт" + plane.getPlaneName() + "набирает скорость...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("-->Самолёт" + plane.getPlaneName() + "взлетает...");
            TimeUnit.SECONDS.sleep(1);
            airport.makeFreeTheAirstrip(currentAirstrip);
            System.out.println("-->Самолёт" + plane.getPlaneName() + "взлетел и освободил взлётно-посадочную полосу");

            TimeUnit.SECONDS.sleep(5);
            System.out.println("<--Самолёт" + plane.getPlaneName() + "возвращается в аэропорт");
            currentAirstrip = airport.prepareTheAirstrip(plane);
            System.out.println("<--Самолёт" + plane.getPlaneName() + "приземляется на взлётно-посадочную полосу под номером " + currentAirstrip);
            TimeUnit.SECONDS.sleep(3);
            System.out.println("<--Самолёт" + plane.getPlaneName() + "окончательно приземлился на взлётно-посадочную полосу");
            airport.makeFreeTheAirstrip(currentAirstrip);
            airport.addPlane(plane);
            System.out.println("Самолёт" + plane.getPlaneName() + "вернулся в ангар");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
