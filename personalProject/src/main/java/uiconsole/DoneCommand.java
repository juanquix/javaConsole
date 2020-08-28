package uiconsole;
import biz.TaskManager;
import entities.Status;
import entities.Task;


public class DoneCommand extends Command {

    Task task;

    DoneCommand(){
        task = new Task();
    }

    @Override
    public void doneTask(String[] tokens, TaskManager taskManager, String inputString) {

        if(isValid(tokens, inputString)){
            Task taskResult = taskManager.storeTaskUpdate(task, "done");

            if(taskResult != null){
                System.out.println("Task was marked as DONE");
            }else{
                System.err.println("Something happens, I did not modified TASK");
            }
        }
    }
    private boolean isValid(String[] tokens,  String inputString){
        boolean result = false;

        if(tokens[2].equals("done") ){
// todo<tag:homework>done guardarlo en task y update eso a todos con ese tag
            if(inputString.contains("tag")){

                String[] filter = tokens[1].toLowerCase().split(":");
                task.setTag(filter[1]); //for Task with homework
//falta todos los q tengan ese filtro ponerlos como done State = Done
                result = true;
            }else{

                task.setStatus( Status.COMPLETED.name().toString() );
                task.setNumberTask( Integer.parseInt(tokens[1]) );

                result = true;
            }
        }

        return result;
    }
}
