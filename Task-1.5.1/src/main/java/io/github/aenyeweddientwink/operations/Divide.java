package io.github.aenyeweddientwink.operations;

import io.github.aenyeweddientwink.Operation;

/**
 * Class Divide, a division of two arguments
 */
public class Divide implements Operation{
    @Override
    public int getArity(){
        return 2;
    }

    @Override
    public Double apply (Double... args){
        if (args[1] == 0.0){
            throw new IllegalArgumentException("You can't divide by zero");
        }
        return (args[0]/args[1]);
    }

}

