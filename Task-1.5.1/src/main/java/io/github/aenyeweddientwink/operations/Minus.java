package io.github.aenyeweddientwink.operations;

import io.github.aenyeweddientwink.Operation;

/**
 * Class Minus, a substraction of the second argument from the first argument
 */
public class Minus implements Operation{
    @Override
    public int getArity(){
        return 2;
    }

    @Override
    public Double apply (Double... args){
        return Double.sum(args[0],-args[1]);
    }

}

