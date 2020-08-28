package uiconsole;
import biz.TaskManager;
import entities.Task;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModifyCommand extends Command {

    Task task;

    ModifyCommand(){
        task = new Task();
    }

    @Override
    public void modifyTask(String[] tokens, TaskManager taskManager, String inputString) {

        if(isValid(tokens, inputString)){
            Task taskResult = taskManager.storeTaskUpdate(task, "modify");

            if(taskResult != null){
                System.out.println("Task was modified "+ taskResult.getNumberTask());
            }else{
                System.err.println("Something happens, I did not modified TASK");
            }
        }
    }

    private boolean isValid(String[] tokens,  String inputString){
        boolean result = false;

        if(tokens[2].equals("modify") ){

            if(inputString.contains("tag")){//momdify ver Completa todo <tag:homework>modify<due:10/10/2020>

                String[] paramters = tokens[1].toLowerCase().split(":");


                //fecha esta al final
                task.setTag(paramters[1]); //for a lot Task with task homework
                String[] paramters2 = tokens[tokens.length -1].split(":");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                String dateInString = paramters2[1].toString();

                try {
                    Date date = formatter.parse(dateInString);
                    task.setDue( date );
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                result = true;
            }else{

                task.setNumberTask( Integer.parseInt(tokens[1]) );
                task.setDescription(getDescription(inputString));

                result = true;
            }
        }

        return result;
    }

    private String getDescription(String inputString){
        String result = "";

        Pattern pattern = Pattern.compile("\"(.*?)\"");
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.find())
        {
            result = matcher.group(1);
        }

        return result;
    }

}
