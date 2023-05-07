package edu.uaslp.objetos.taskslist;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class TaskList{

    List <Task> taskList;
    int current;

    public TaskList(){
        taskList = new ArrayList<Task>();
        current=0;
    }


    public int getSize (){
        return taskList.size();
    }

    public void add(Task task)
    {
        taskList.add(task);
    }

    public void remove(Task task)
    {
        taskList.remove(task);
    }

    public Task find(String title) throws TaskNotFoundException
    {
        boolean found=false;
        Task answer = new Task();
        for(Task task :taskList)
        {
            if(title==task.getTitle())
            {
                answer = task;
                found = true;
            }
        }

        if(found==false)
        {
            throw new TaskNotFoundException(title);
        }


        return answer;
    }
    public void markAsDone(String title) throws TaskNotFoundException
    {
        boolean found=false;
        for(Task task :taskList)
        {
            if(title==task.getTitle())
            {
                task.markAsDone();
                found = true;
            }
        }
        if(found==false)
        {
            throw new TaskNotFoundException(title);
        }

    }

    public void markAsNotDone(String title) throws TaskNotFoundException
    {
        boolean found=false;
        for(Task task :taskList)
        {
            if(title==task.getTitle())
            {
                task.markAsNotDone();
                found = true;
            }
        }
        if(found==false)
        {
            throw new TaskNotFoundException(title);
        }
    }

    public Task getNextTask () throws TaskNotFoundException {
        if(current >= taskList.size()-1 ){
            throw new TaskNotFoundException();
        }else{
            current++;
        }
        return taskList.get(current);
    }

    public List<Task> getNextTasks(){
        List<Task> tasksFound = new ArrayList<Task>();

        for(Task task: this.taskList)
        {
            if(task.isDone()==false){
                tasksFound.add(task);
            }
        }
        tasksFound.sort(Comparator.comparing(Task::getDueDate));

        return tasksFound;
    }




}
