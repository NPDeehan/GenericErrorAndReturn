package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class IssueFixer implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Fixing Service is Running");

        String errorMessage = (String) delegateExecution.getVariable("errorMessage");
        delegateExecution.setVariable("errorStatus", "Error is Fixed");
        delegateExecution.removeVariable("errorMessage");

    }
}
