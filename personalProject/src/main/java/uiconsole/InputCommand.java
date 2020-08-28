package uiconsole;

import biz.TaskManager;
import context.TaskDao;
import contracs.ITaskDao;
import java.util.Scanner;

public class InputCommand {
    public static int runTodoApp(){
        Scanner scanner = new Scanner(System.in);
        boolean next = true;
        ITaskDao itd = new TaskDao();
        TaskManager taskManager = new TaskManager(itd);
        int commandIndex = 0;
        int sizeTokens = 0;

        do{
            System.out.print("$ ");
            String inputString = scanner.nextLine().toLowerCase();
            String[] tokens =  inputString.split(" ");
            sizeTokens = tokens.length;
           // System.out.println("sizeTokens "+ sizeTokens);
           // for(int index =0; index < tokens.length; index++){
            //    System.out.println(tokens[index]);
           // }
           // System.out.println("tokens[1]=> "+tokens[1]);

            if(sizeTokens == 1){

                if(tokens[0].equals("todo")){
                    System.out.println("show help the commands!!!!");
                }else {
                    System.out.println("todo: command not found ");
                }
            }
            if(sizeTokens == 2 && tokens[0].equals("todo")){

                if(tokens[1].equals("exit")){

                    System.out.println("Bye, have a nice day!");
                    next = false;
                }
                if(tokens[1].equals("help")){//debe tener su propia clase

                    System.out.println("aqui mostrar la ayuda desde CASE ****");
                }
                //single version
                if(tokens[1].equals("list")){

                    Command myListCommand = new ListCommand();
                    myListCommand.listTasks(tokens, taskManager);
                }
                //hay algunos mas como "count, y otros del Todo list2" en su single version
                if(tokens[1].equals("count") ){

                    Command myCountCommand = new CountCommand();
                    myCountCommand.countTasks(tokens, taskManager, inputString);
                }

            }
            if(sizeTokens > 2 && tokens[0].equals("todo")){
                if(tokens[1].equals("add") ){

                    Command myAddCommand = new AddCommand();
                    myAddCommand.addTask(tokens, taskManager, commandIndex, inputString);
                }
                if(tokens[2].equals("modify")){

                    Command modifyCommand = new ModifyCommand();
                    modifyCommand.modifyTask(tokens, taskManager, inputString);
                }
                if(tokens[2].equals("done")){

                    Command myDoneCommand = new DoneCommand();
                    myDoneCommand.doneTask(tokens, taskManager, inputString);
                }
                if(tokens[2].equals("info") ){

                    Command myInfoCommand = new InfoCommand();
                    myInfoCommand.infoTasks(tokens, taskManager, inputString);
                }

                if(tokens[2].equals("delete") ){

                    Command myDeleteCommand = new DeleteCommand();
                    myDeleteCommand.deleteTask(tokens, taskManager, inputString);
                }
                //extended version

                if(!tokens[1].equals("list") || tokens[2].equals("list")){//ever [1] or [2]

                    Command myListCommand = new ListCommand();
                    myListCommand.listTasks(tokens, taskManager);
                }
                //next a lot commands from Todo list2" and other in extended version
            }


        }while(next);

        return 0;
    }
/*
    private static boolean isCommand(String token){
        String[] commandList = {"add","modify","list","done","exit","help",  "count", "export", "config", "tags", "info"};
        boolean result = false;

        for (int index = 0; index < commandList.length ; index++){
            if(token.equals(commandList[index])){
                result = true;
            }
        }

        return  result;
    }
    */
}
