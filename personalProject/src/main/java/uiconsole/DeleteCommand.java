package uiconsole;

import biz.TaskManager;
import entities.Status;
import entities.Task;

public class DeleteCommand extends Command {
     Task task;  //todos deberian ser privaados

    DeleteCommand(){
        task = new Task();
    }

    @Override
    public void deleteTask(String[] tokens, TaskManager taskManager, String inputString) {

        if(isValid(tokens, inputString)){
            boolean taskResult = taskManager.delete( task, task.getTag() );

            if(taskResult == true){
                System.out.println("Task was marked as DELETE");
            }else{
                System.err.println("Something happens, I did not modified TASK");
            }
        }
    }
    private boolean isValid(String[] tokens,  String inputString){
        boolean result = false;

        if(tokens[2].equals("delete") ){

            if(inputString.contains("+")){
                String newfilter = tokens[1].replaceAll("[^a-zA-Z]","");

                task.setTag(newfilter);
                task.setStatus( Status.DELETED.name().toString() );
                task.setNumberTask( Integer.parseInt(tokens[1]) );

                result = true;
            }else{

                task.setStatus( Status.DELETED.name().toString() );
                task.setNumberTask( Integer.parseInt(tokens[1]) );

                result = true;
            }
        }

        return result;
    }
}
