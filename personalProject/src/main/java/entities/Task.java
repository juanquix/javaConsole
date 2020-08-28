package entities;
import java.util.Date;
import java.util.UUID;

public class Task {//todo tiene q ser private
    private int id;
    private UUID uuid;
    private String description;
    private String status;
    private String entry;
    private int numberTask;
    private char priority;
    private String tag;//nuevo completar ... falta las demas capas
    private Date due;
    private Date start;
    private Date end;

    public Task(){}
    public Task( String description){

        this.id = 0;
        this.uuid = null;
        this.description = description;
        this.status =  null;
        this.entry = null;
        this.numberTask = 0;
        this.priority = 'M';
        this.tag = null;  ////nuevo completar ... falta las demas capas
        this.due = null;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public int getNumberTask() {
        return numberTask;
    }

    public void setNumberTask(int numberTask) {
        this.numberTask = numberTask;
    }

    public char getPriority() {
        return priority;
    }

    public void setPriority(char priority) {
        this.priority = priority;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}

