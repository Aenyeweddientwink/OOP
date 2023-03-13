package io.github.aenyeweddientwink.operations;

import io.github.aenyeweddientwink.Operation;

/**
 * Class Squareroot, a sqrt operation with one argument
 */
public class Squareroot implements Operation{
    @Override
    public int getArity(){
        return 1;
    }

    @Override
    public Double apply (Double... args){
        return (Math.sqrt(args[0]));
    }

}



