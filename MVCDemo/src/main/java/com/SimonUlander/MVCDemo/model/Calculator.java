package com.SimonUlander.MVCDemo.model;

public class Calculator {
    /**
     * Takes in two numbers and an operator to apply on those numbers and either
     * returns the answer or an error message if something went wrong.
     *
     * @param  term1        The first number in the calculation.
     * @param  term2        The second number in the calculation.
     * @param  operator     The operator to apply in the calculation.
     * @return      Either the answer for the calculation or an error message.
     */
    public String Calculate(String term1, String term2, String operator){

        if(!isNum(term1) || !isNum(term2)) {
            return "Error: Not proper numbers.";
        }

        switch(operator) {
            case "+":
                return Double.toString(add(Double.parseDouble(term1),Double.parseDouble(term2)));
            case "-":
                return Double.toString(subtract(Double.parseDouble(term1),Double.parseDouble(term2)));
            case "*":
                return Double.toString(multiply(Double.parseDouble(term1),Double.parseDouble(term2)));
            case "/":
                // Doing this instead of just str.equals in order to avoid cases like "0.000".
                if (Double.parseDouble(term2) == 0) {
                    return "Error: Divide by zero.";
                }
                return Double.toString(divide(Double.parseDouble(term1),Double.parseDouble(term2)));
            default:
                return "Error: Unknown operator.";

        }
    }

    /**
     * Adds two doubles and returns the answer as a double.
     *
     * @param a First number.
     * @param b Second number.
     * @return The sum of a and b as a double.
     */
    private double add(double a, double b){
        return a + b;
    }

    /**
     * Subtracts one number from another and returns the answer as a double.
     *
     * @param a First number.
     * @param b Second number.
     * @return The the answer of a-b as a double.
     */
    private double subtract(double a, double b){
        return a - b;
    }

    /**
     * Multiplies two numbers and returns a double.
     *
     * @param a First number.
     * @param b Second number.
     * @return The answer of a*b as a double.
     */
    private double multiply(double a, double b){
        return a*b;
    }

    /**
     * Divides one number by another and returns the answer as a double.
     *
     * @param a First number.
     * @param b Second number.
     * @return The result of a/b as a double.
     */
    private double divide(double a, double b){
        return a/b;
    }

    /**
     * Handles input validation and makes sure the user actually entered a valid number.
     *
     * @param strNum The string which is expected to be used as a number.
     * @return True if strNum is a number and false if strNum is something else.
     */
    private boolean isNum(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double result = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
