package uiconsole;
import biz.TaskManager;
import entities.Task;
import java.util.ArrayList;

public class CountCommand extends Command{

    Task task;
    CountCommand(){
        task = new Task();
    }

    @Override
    public void countTasks(String[] tokens, TaskManager taskManager, String inputString) {
        ArrayList<Task> tasks = taskManager.getAll();
        int count = 0;

        if(inputString.contains("count") ){
            if(inputString.contains("status")){

                String[] paramters = tokens[1].toLowerCase().split(":");

                for(int index = 0; index < tasks.size(); index++){
                    if(tasks.get(index).getStatus().equals(paramters[1])){
                        count++;
                    }
                }
                System.out.println(count);
            }else{
                System.out.println(tasks.size());
            }
        }

    }
}
