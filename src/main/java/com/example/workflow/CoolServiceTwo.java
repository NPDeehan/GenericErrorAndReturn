package com.example.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CoolServiceTwo implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Cool Service Two is Running");
        Random rando = new Random();

        if(rando.nextBoolean()) {
            delegateExecution.setVariable("ServiceTwo", "Iron Giant :~(");
            throw new BpmnError("GenericError", delegateExecution.getCurrentActivityId());
        }else{
            delegateExecution.setVariable("ServiceTwo", "All Fine and Dandy");
        }
    }
}
