package com.postfixcalculator;

import java.util.Stack;

/**
 * @author oscarmalagon
 * @since 8/13/17.
 */
public class PostFixCalculator {

    Stack<Integer> stack;
    public static final String ADD = "+";
    public static final String MINUS = "-";
    public static final String TIMES = "*";

    public Integer calculate(String[] args){
        int calc = 0;
        this.stack = new Stack<>();

        if(args.length == 0 ){
            return 0;
        }

        for (String s: args) {
            boolean isInteger = isIntegerValue(s);

            if(isInteger){
                stack.push(Integer.parseInt(s));
            }

            if(!isInteger){
                int result = applyOperation(stack.pop(), stack.pop(), s);
                stack.push(result);
            }
        }
        calc = stack.pop();
        if(!stack.isEmpty()){
            throw new IllegalArgumentException("Faltan operaciones");
        }
        return calc;
    }

    private int applyOperation(Integer right, Integer left, String operation) {
        int result = 0;
        switch (operation){
            case ADD:
                result = left + right;
                break;
            case TIMES:
                result = left * right;
                break;
            case MINUS:
                result = left - right;
                break;
        }

        return result;
    }

    private boolean isIntegerValue(String s) {
        boolean isInteger = false;
        try{
            Integer.parseInt(s);
            isInteger = true;
        }catch (Exception e){
            // does nothing
        }

        return isInteger;
    }

}
