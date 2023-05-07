package edu.uaslp.objetos.taskslist;

import java.util.NoSuchElementException;

public class TaskNotFoundException extends NoSuchElementException  {
    TaskNotFoundException(String s) {
        super(new String("Task with title '"+s+"' not found"));

    }
    TaskNotFoundException(){super();}
}
