package student.TaskThread.Exceptions;

public class NoParkingSpacesException extends ParkingLotExceptions{
    public NoParkingSpacesException() {
        super();
    }

    public NoParkingSpacesException(String message) {
        super(message);
    }

    public NoParkingSpacesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoParkingSpacesException(Throwable cause) {
        super(cause);
    }
}
