# Generic Error And Return

This is an example in spring boot of how you can have a process throw an error at some point in the process. Then have a generic event subprocess deal with the error before returning to where the process left off. 

![process-model]
 
 you can start the process and each service will throw an error randomly. The error is thrown and the current activity id is added as a message to the error event. 
 
 ```java 
throw new BpmnError("GenericError", delegateExecution.getCurrentActivityId());
 ```
 
 This is then stored in a variable that is accessed in order make the return. Which puts the token back the end of the symbol that threw the error
 
 ````java
 delegateExecution.getProcessEngineServices().getRuntimeService()
                    .createProcessInstanceModification(delegateExecution.getProcessInstanceId())
                    .startAfterActivity(errorTaskId)
                    .execute();  
````
 
[process-model]: ./src/main/resources/genericErrorAndReturn.png "Order Sorter Process Model"