package biz;
import com.sun.deploy.security.ruleset.RuleSetParser;
import contracs.ITaskDao;
import entities.Status;
import entities.Task;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.UUID;

public class TaskManager {

    private ITaskDao _taskDao;
    private static int numberTask = 0;

    public TaskManager(ITaskDao taskDao)
    {
        _taskDao = taskDao;
    }

    public Task storeTaskAdd(Task task){

        if (task != null){
            task.setUuid(generateUuid());
            task.setStatus(Status.PENDING.name().toString());
            task.setEntry(dateIsoNowString());
            task.setNumberTask(numberTask +=1);
 /*           try {
                task.setStart(dateIsoNow(dateIsoNowString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
*/
            if(numberTask % 2 == 0){
                task.setTag("homework");
            }else{
                task.setTag("shopping");
            }

            _taskDao.create(task);
        }

        return task;
    }
    public Task storeTaskUpdate(Task task, String command){
        if(command.equals("done")){
  /*          try {
                task.setEnd(dateIsoNow(dateIsoNowString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
   */
        }
        _taskDao.update(task, command);

        return task;
    }

    private boolean isUniqueUuId(UUID myUuid){
        ArrayList<Task> allTasks = getAll();

        for (int index = 0; index < allTasks.size(); index++){
            if(allTasks.get(index).getUuid().equals(myUuid)){
                return false;
            }
        }

        return true;
    }

    private UUID generateUuid(){
        UUID result = null;

        do {
            result = UUID.randomUUID();
        }while(!isUniqueUuId(result));

        return result;
    }

    private String dateIsoNowString(){

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);

        return df.format(new Date());
    }

    private  Date dateIsoNow(String dateString) throws ParseException{

         SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd'T'hh:mm:ssz");

        return ft.parse(dateString);
    }

    public boolean delete(Task task, String filter){
        boolean result = false;
        Task taskUpdate = _taskDao.getForId(task.getNumberTask());

        if(filter != null){

            _taskDao.delete(task, filter);
            result = true;
        }else{

            taskUpdate.setStatus(Status.DELETED.name().toString());
            taskUpdate.setNumberTask(task.getNumberTask());
 /*         try {
                task.setEnd(dateIsoNow(dateIsoNowString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
*/
            _taskDao.delete(taskUpdate, null);
            result = true;
        }

        return result;
    }

    public ArrayList<Task> getAll(){

        ArrayList alllist = _taskDao.getAll();

        return alllist;
    }
}
