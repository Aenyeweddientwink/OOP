package io.github.aenyeweddientwink.operations;

import io.github.aenyeweddientwink.Operation;

/**
 * Class Logarithm, a logarithm, where the first argument is the base, and the second argument is the argument
 */
public class Logarithm implements Operation{
    @Override
    public int getArity(){
        return 2;
    }

    @Override
    public Double apply (Double... args) throws IllegalArgumentException,NullPointerException{
        if (args[0] == null){
            throw new NullPointerException();
        }
        if (args[0] <= 0 | args[0] == 1) {
            throw new IllegalArgumentException("Base is invalid");
        }
        if (args[1] <= 0){
            throw new IllegalArgumentException("Argument is invalid");
        }
        return (Math.log(args[1])/Math.log(args[0]));
    }



}

