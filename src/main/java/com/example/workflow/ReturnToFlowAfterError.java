package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ReturnToFlowAfterError implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Return to flow is Running");
        String errorTaskId = (String)delegateExecution.getVariable("errorTaskId");

        if(errorTaskId == null){
            System.out.println("No where to go back to");
        }else{
            delegateExecution.getProcessEngineServices().getRuntimeService()
                    .createProcessInstanceModification(delegateExecution.getProcessInstanceId())
                    .startAfterActivity(errorTaskId)
                    .execute();

           // delegateExecution.removeVariable("errorTaskId");

        }



    }
}
