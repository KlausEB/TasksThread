package student.OptionalTaskThread.Resources;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Airport {
    private List<Plane> planes;
    private final List<Boolean> airstrips = Arrays.asList(true, true, true, true, true);

    public Airport(List<Plane> planes) {
        this.planes = planes;
    }

    public synchronized int prepareTheAirstrip(Plane plane) throws InterruptedException {
        int i = 0;
        while(i<5){
            if (airstrips.get(i)) {
                airstrips.set(i, false);
                break;
            }
            if (i == 4) {
                System.out.println("Самолёт" + plane.getPlaneName() + "ожидает освобождения взлётно-посадочной полосы");
                wait();
                TimeUnit.MILLISECONDS.sleep(10);
                i = 0;
            }
            i++;
        }
        return i;
    }

    public synchronized void makeFreeTheAirstrip(int numberOfAirstrip){
        airstrips.set(numberOfAirstrip, true);
        notify();
    }

    public synchronized Plane getPlane(){
        Plane currentPlane = planes.get(0);
        planes.remove(0);
        return currentPlane;
    }

    public synchronized void addPlane(Plane plane){
        planes.add(plane);
    }
}
