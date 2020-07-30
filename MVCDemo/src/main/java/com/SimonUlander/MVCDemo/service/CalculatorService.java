package com.SimonUlander.MVCDemo.service;

import com.SimonUlander.MVCDemo.model.Calculator;
import com.SimonUlander.MVCDemo.model.Job;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CalculatorService {
    private Job job;
    private Calculator myCalc;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating CalculatorService bean.");
        job = new Job("0","0","+","0");
        myCalc = new Calculator();
    }

    public void calculate(Job job) {
        this.job.setFirstTerm(job.getFirstTerm());
        this.job.setSecondTerm(job.getSecondTerm());
        this.job.setOperator(job.getOperator());
        this.job.setOutput(myCalc.Calculate(job.getFirstTerm(),job.getSecondTerm(),job.getOperator()));
    }
    public Job getJob() {
        return job;
    }
}
