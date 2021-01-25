package student.TaskThread.Exceptions;

public class NoApproachingCarsException extends ParkingLotExceptions{
    public NoApproachingCarsException() {
        super();
    }

    public NoApproachingCarsException(String message) {
        super(message);
    }

    public NoApproachingCarsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoApproachingCarsException(Throwable cause) {
        super(cause);
    }
}
