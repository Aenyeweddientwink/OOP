package io.github.aenyeweddientwink.operations;

import io.github.aenyeweddientwink.Operation;

/**
 * Class Plus, a sum of two arguments
 */
public class Plus implements Operation{
    @Override
    public int getArity(){
        return 2;
    }

    @Override
    public Double apply (Double... args){
        return Double.sum(args[0],args[1]);
    }

}
