package io.github.aenyeweddientwink.operations;

import io.github.aenyeweddientwink.Operation;

/**
 * Class Sinus, a sin operation with one argument
 */
public class Sinus implements Operation{
    @Override
    public int getArity(){
        return 1;
    }

    @Override
    public Double apply (Double... args) {
        return (Math.sin(args[0]));
    }

}


