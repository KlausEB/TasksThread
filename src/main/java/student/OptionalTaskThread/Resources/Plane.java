package student.OptionalTaskThread.Resources;

public class Plane {
    private final int planeID;
    private final String planeName;

    public Plane(int planeID, String planeName) {
        this.planeID = planeID;
        this.planeName = planeName;
    }

    public int getPlaneID() {
        return planeID;
    }

    public String getPlaneName(){
        return planeName;
    }
}
