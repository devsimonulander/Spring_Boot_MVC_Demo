package com.SimonUlander.MVCDemo.model;

/**
 * The Job class handles form submissions to and from the view by affording the model access
 * to the values in the elements of the frontend.
 */
public class Job {
    private String FirstTerm;
    private String SecondTerm;
    private String Operator;
    String Output;

    public Job(String FirstTerm, String SecondTerm, String Operator, String Output) {
        this.FirstTerm = FirstTerm;
        this.SecondTerm = SecondTerm;
        this.Operator = Operator;
        this.Output = Output;
    }

    public String getFirstTerm() {
        return FirstTerm;
    }

    public void setFirstTerm(String firstTerm) {
        this.FirstTerm = firstTerm;
    }

    public String getSecondTerm() {
        return SecondTerm;
    }

    public void setSecondTerm(String secondTerm) {
        this.SecondTerm = secondTerm;
    }

    public String getOperator() {
        return Operator;
    }

    public void setOperator(String Operator) {
        this.Operator = Operator;
    }

    public String getOutput() {
        return Output;
    }

    public void setOutput(String Output) {
        this.Output = Output;
    }
}
