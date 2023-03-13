package io.github.aenyeweddientwink;


import io.github.aenyeweddientwink.operations.*;
import java.util.HashMap;

/**
 * Creates an Operation class from string that is a function that we want to calculate
 */
public class OperationCreator {
    private final HashMap<String,Operation> operators =new HashMap<>();

    public OperationCreator(){
        operators.put("+", new Plus());
        operators.put("-", new Minus());
        operators.put("/", new Divide());
        operators.put("*", new Multiply());
        operators.put("pow", new Power());
        operators.put("log", new Logarithm());
        operators.put("cos", new Cosinus());
        operators.put("sin", new Sinus());
        operators.put("sqrt", new Squareroot());
    }

    /**
     * method
     * @param str string representation of an operation
     * @return operation
     */
    public Operation getOperation(String str){
        if (operators.containsKey(str)){
            return operators.get(str);
        }
        return null;
    }
}
