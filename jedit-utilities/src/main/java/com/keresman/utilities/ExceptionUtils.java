package com.keresman.utilities;

import com.keresman.exceptions.ThrowingExceptionTask;

/**
 * A utility class for basic exception handling.
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
     * @param message
     * @param task 
     * @param <E>
     */
    public static <E extends Exception> void executeUnchecked(ThrowingExceptionTask<E> task, String message) {
        try {
            task.execute();
        } catch (Exception e) {
            throw new RuntimeException(message, e);
        }
    }
}
