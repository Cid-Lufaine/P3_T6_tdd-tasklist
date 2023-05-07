package edu.uaslp.objetos.taskslist;
import java.time.LocalDateTime;
public class Task {

    private String title;
    private String description;
    private LocalDateTime date;
    private boolean state;

    public Task(){

    }
    public Task(String title, String description,LocalDateTime date, boolean state){
        this.title=title;
        this.description=description;
        this.date=date;
        this.state=state;
    }

    public String getTitle()
    {
        return title;
    }
    public String getDescription()
    {
        return description;
    }
    public LocalDateTime getDueDate()
    {
        return date;
    }
    public boolean isDone()
    {
        return state;
    }

    public void markAsDone(){
        this.state=true;
    }

    public void markAsNotDone(){
        this.state=false;
    }

    public void setTitle(String title)
    {
        this.title=title;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }

    public void setDueDate(LocalDateTime date) throws TaskListException
    {
        if(date.isBefore(LocalDateTime.now())){
            throw new TaskListException() ;
        }

        this.date=date;
    }
    public void setDone(boolean state)
    {
        this.state=state;
    }


}
