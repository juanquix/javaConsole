package uiconsole;

import biz.TaskManager;
import entities.Task;

import java.util.ArrayList;

public class InfoCommand extends  Command{
    Task task;
    InfoCommand(){
        task = new Task();
    }

    @Override
    public void infoTasks(String[] tokens, TaskManager taskManager, String inputString) {
        ArrayList<Task> tasks = taskManager.getAll();
        task.setNumberTask(Integer.parseInt(tokens[1]));

        if(tokens[2].equals("info")){
            for(int index = 0; index < tasks.size(); index++){
                if(tasks.get(index).getNumberTask() == task.getNumberTask()){
                    task = tasks.get(index);
                }
            }
        }

        showInfo(task);
    }
    public void showInfo(Task task){
        System.out.println("=== Selected Task ---------------");
        System.out.println("uuid        : "+ task.getUuid());
        System.out.println("description : "+ task.getDescription());
        System.out.println("status      : "+ task.getStatus());
        System.out.println("entry       : "+ task.getEntry());
        System.out.println("numberTask  : "+ task.getNumberTask());
        System.out.println("priority    : "+ task.getPriority());
        System.out.println("tag         : "+ task.getTag());
        System.out.println("due         : "+ task.getDue());
        System.out.println("=== End Selected Task ------------");
    }
}
