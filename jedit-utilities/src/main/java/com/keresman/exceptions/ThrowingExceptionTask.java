package com.keresman.exceptions;

/** Functional interface for throwing exception tasks */
@FunctionalInterface
public interface ThrowingExceptionTask<E extends Exception> {

  /**
   * Executes throwing exception task
   *
   * @throws E exception
   */
  void execute() throws E;
}
