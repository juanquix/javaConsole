package uiconsole;
import biz.TaskManager;
import entities.Task;
import java.util.ArrayList;

public class ListCommand extends Command {
    ListCommand(){
    }

    @Override
    public  void listTasks(String[] parameters, TaskManager taskManager){
        if (parameters[1].equals("list")) {
            ArrayList<Task> tasks = taskManager.getAll();
            showAllTasks(tasks);
        }
    }

    private void showAllTasks(ArrayList<Task> tasks){

        if(tasks.size() == 0){
            System.out.println("Empty List !!");
        }else {
            System.out.println("|=============== UuId ==============|Priority|====== Entry ======|Nro|= Status =|==== Description ====|=== due");
            for (Task task: tasks) {
                System.out.print(task.getUuid()+"");
                System.out.print("|   "+task.getPriority()+"    |");
                System.out.print(" "+task.getEntry()+" | ");
                System.out.print(task.getNumberTask()+" | ");
                System.out.print(task.getStatus()+"  | ");
                System.out.print(task.getDescription());
                System.out.print("     "+task.getDue());
                System.out.println("\n|-----------------------------------|--------|-------------------|---|----------|---------------------");
            }
        }
    }
}

