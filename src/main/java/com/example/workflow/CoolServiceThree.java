package com.example.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CoolServiceThree implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Cool Service Three is Running");

        Random rando = new Random();
        if(rando.nextBoolean()) {
            delegateExecution.setVariable("ServiceThree", "Iron Giant :~(");
            throw new BpmnError("GenericError", delegateExecution.getCurrentActivityId());
        }else{
            delegateExecution.setVariable("ServiceThree", "All Fine and Dandy");
        }

    }
}

