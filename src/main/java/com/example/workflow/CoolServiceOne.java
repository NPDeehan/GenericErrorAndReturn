package com.example.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CoolServiceOne implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Cool Service One is Running");
        Random rando = new Random();
        if(rando.nextBoolean()) {
            delegateExecution.setVariable("ServiceOne", "Iron Giant :~(");
            throw new BpmnError("GenericError", delegateExecution.getCurrentActivityId());

        }else{
            delegateExecution.setVariable("ServiceOne", "All Fine and Dandy");
        }
    }
}

