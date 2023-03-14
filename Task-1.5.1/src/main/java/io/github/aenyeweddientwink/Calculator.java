package io.github.aenyeweddientwink;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.*;

/**
 * Class for calculating mathematical expressions
 */
public class Calculator {
    /**
     * calcucates expression
     * @param expression expression
     * @return Result of calculation of the expression
     */
    public static Double calculate(List<String> expression) throws IOException{
        OperationCreator operations = new OperationCreator();
        Stack<String> stack = new Stack<>();
        for (int i = expression.size() - 1; i>=0; i--){
            String str = expression.get(i);
            Operation operation = operations.getOperation(str);
            if (operation == null){
                stack.push(str);
            }
            else{
                if (operation.getArity() == 2){
                    try {
                        Double arg1 = Double.valueOf(stack.pop());
                        Double arg2 = Double.valueOf(stack.pop());
                        stack.push(operation.apply(arg1, arg2).toString());
                    }
                    catch(EmptyStackException exception){
                        throw new IOException("Incorrect expression");
                    }

                }
                else{
                    try {
                        Double arg1 = Double.valueOf(stack.pop());
                        stack.push(operation.apply(arg1).toString());
                    }
                    catch(EmptyStackException exception){
                        throw new IOException("Incorrect expression");
                    }
                }
            }
        }
        return Double.valueOf(stack.pop());
    }

}
