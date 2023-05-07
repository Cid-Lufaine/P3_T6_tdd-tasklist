package edu.uaslp.objetos.taskslist;

public class TaskListException extends RuntimeException{
    TaskListException(){
        super(new String("Due date is set in the past"));
    }

}
