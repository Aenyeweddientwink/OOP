package io.github.aenyeweddientwink.operations;

import io.github.aenyeweddientwink.Operation;

/**
 * Class Cosinus, a cos operation with one argument
 */
public class Cosinus implements Operation{
    @Override
    public int getArity(){
        return 1;
    }

    @Override
    public Double apply (Double... args){
        return (Math.cos(args[0]));
    }

}


