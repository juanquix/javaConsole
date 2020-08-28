package uiconsole;
import biz.TaskManager;
import entities.Task;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCommand extends Command {

    Task task;

    AddCommand(){
        task = new Task();
    }

    @Override
    public void addTask(String[] tokens, TaskManager taskManager, int indexCommand, String inputString){

        if(isValid(tokens, indexCommand, inputString)){

            Task taskResult = taskManager.storeTaskAdd(task);
            if(taskResult != null){
                System.out.println("Created Task "+ taskResult.getNumberTask());
            }else{
                System.err.println("Something happens, I did not create the TASK");
            }
        }
    }

    private boolean isValid(String[] tokens, int index, String inputString){
        boolean result = false;
        int sizeLastToken = 0;

        if(tokens[1].equals("add") ){

            if(inputString.contains("priority:")){ //priority:H

                task.setDescription(getDescription(inputString));

                sizeLastToken = tokens[tokens.length -1].length();
                task.setPriority(   Character.toUpperCase(   tokens[tokens.length -1].charAt(sizeLastToken -1)    ));

                result = true;
            }else{
                task.setDescription(getDescription(inputString));
                task.setPriority('M');
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

