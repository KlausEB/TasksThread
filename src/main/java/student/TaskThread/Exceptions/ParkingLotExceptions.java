package student.TaskThread.Exceptions;

abstract public class ParkingLotExceptions extends Exception{
    public ParkingLotExceptions() {
        super();
    }

    public ParkingLotExceptions(String message) {
        super(message);
    }

    public ParkingLotExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingLotExceptions(Throwable cause) {
        super(cause);
    }
}
