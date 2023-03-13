package io.github.aenyeweddientwink.operations;

import io.github.aenyeweddientwink.Operation;

/**
 * Class Multiply, a multiplication of two arguments
 */
public class Multiply implements Operation{
    @Override
    public int getArity(){
        return 2;
    }

    @Override
    public Double apply (Double... args){
        return (args[0]*args[1]);
    }

}

