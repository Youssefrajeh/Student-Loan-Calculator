/**
 * Coder: Youssef Rajeh 
 * April, 2024
 * Custom exception class for handling negative values.
 * This exception is thrown when an operation encounters a negative value where it is not expected or allowed.
 */
public class y_a_NegativeValueException extends Exception {
    /**
     * Constructor that accepts a message describing the specific reason the exception is thrown.
     * @param message Detailed message about the cause of the exception.
     */
    public y_a_NegativeValueException(String message) {
        super(message);
    }
}