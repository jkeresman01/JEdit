package com.keresman.utilities;

import com.keresman.exceptions.ThrowingExceptionTask;

/**
 * A utility class for basic exception handling.
 *
 * This class is not intended to be extended or instantiated. It follows the
 * utility class design pattern, and explicitly forbids subclassing and
 * instantiation
 *
 */
public final class ExceptionUtils {

    private ExceptionUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    /**
     * Executes a task that may throw a checked exception, wrapping it in a
     * RuntimeException.
     *
     * @param message the message to include in the RuntimeException
     * @param task the task that may throw a checked exception
     * @param <E> the type of checked exception the task may throw
     */
    public static <E extends Exception> void executeUnchecked(ThrowingExceptionTask<E> task, String message) {
        try {
            task.execute();
        } catch (Exception e) {
            throw new RuntimeException(message, e);
        }
    }
}
