package io.github.aenyeweddientwink;

/**
 * Interface of an operation
 */
public interface Operation {

    /**
     * Gets an arity of an operation, how many arguments does this function get?
     * @return a number of arguments of an operation
     */
    int getArity();

    /**
     * applies an operation to it's arguments
     * @param args arguments of an operation
     * @return
     */
    Double apply(Double... args);
}
