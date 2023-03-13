package io.github.aenyeweddientwink.operations;

import io.github.aenyeweddientwink.Operation;

/**
 * Class Power, where the first argument is the power, and the second argument is the base
 */
public class Power implements Operation{
    @Override
    public int getArity(){
        return 2;
    }

    @Override
    public Double apply (Double... args){
        return (Math.pow(args[0],args[1]));
    }

}


