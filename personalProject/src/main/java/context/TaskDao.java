package context;
import contracs.ITaskDao;
import entities.Status;
import entities.Task;
import java.util.ArrayList;

public class TaskDao implements ITaskDao {

    ArrayList<Task> tasks = new ArrayList<Task>(); // main

    public void create(Task task){

        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {

        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {

        this.tasks = tasks;
    }

    public void update(Task task, String command)
    {
        if(command.equals("modify")){  //hay 2 casos en modify  con NumberTask y con TAG
            if(task.getTag() != null){//a todos del TAG especificado cambie DUE:fecha

                ArrayList<Task> allSameTag = getAllSameTag(task.getTag());

                for(int index = 0; index < allSameTag.size(); index++){

                        allSameTag.get(index).setDue(task.getDue());
                }
            } else if(task.getNumberTask() != 0){
                Task taskUpdate = getForId(task.getNumberTask());

                taskUpdate.setDescription(task.getDescription());
            }
        }
        if(command.equals("done")){//hay 2 casos con done, con numberTask uno solo y con tag:homework
            if(task.getTag() != null){

                ArrayList<Task> allSameTag = getAllSameTag(task.getTag());
                for(int index = 0; index < allSameTag.size(); index++){
                    allSameTag.get(index).setStatus( task.getStatus() );
                    allSameTag.get(index).setEnd(task.getEnd());
                }
            } else if(task.getNumberTask() != 0){
                Task taskUpdate = getForId(task.getNumberTask());

                taskUpdate.setStatus(task.getStatus());
                taskUpdate.setEnd(task.getEnd());
            }
        }
    }
    public ArrayList<Task> getAllSameTag(String specificTag){
        ArrayList<Task> returnlist = new ArrayList<Task>();

        for(int index = 0; index < getAll().size(); index++){

            if(getAll().get(index).getTag().equals(specificTag) ){
                returnlist.add(getAll().get(index));
            }
        }

        return returnlist;
    }

    public void delete(Task task, String filter){

        if(filter != null){
            ArrayList<Task> alllist = getAllSameTag(filter);

            for(int index = 0; index < alllist.size(); index++){

                    alllist.get(index).setStatus(task.getStatus());
                    alllist.get(index).setEnd(task.getEnd());
            }
        }
    }

    public Task getForId(int numberTask)
    {
        Task task = null;

        ArrayList<Task> alllist = getAll();

        for(int index = 0; index < alllist.size(); index++){
            if(alllist.get(index).getNumberTask() == numberTask){
                task = alllist.get(index);
            }
        }

        return task;
    }

    public ArrayList<Task> getAll(){

        return tasks;
    }
}
