package contracs;

import entities.Task;

import java.util.ArrayList;

public interface ITaskDao {
    void create(Task task);
    void update(Task task, String command);
    void delete(Task task, String filter);
    Task getForId(int id);
    ArrayList<Task> getAll();
}
