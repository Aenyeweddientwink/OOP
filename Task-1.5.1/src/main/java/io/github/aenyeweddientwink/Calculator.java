package io.github.aenyeweddientwink;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/**
 * Class for calculating mathematical expressions
 */
public class Calculator {

    public static Double calculate(List<String> expression){
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
                    Double arg1 = Double.valueOf(stack.pop());
                    Double arg2 = Double.valueOf(stack.pop());
                    stack.push(operation.apply(arg1,arg2).toString());
                }
                else{
                    Double arg1 = Double.valueOf(stack.pop());
                    stack.push(operation.apply(arg1).toString());
                }
            }
        }
        return Double.valueOf(stack.pop());
    }

}
