/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day09todoappdb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author YingLuo
 */
public class Todo {
    
    
    enum Status {
        Pending, Done, Delegated
    }
    
    static final String TASK_PATTERN = "^(.{1,100})$";
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    
    private int id;
    private String task; // 1-100 characters (matching varchar length!), any characters are allowed
    private int difficulty; // 1-5
    private Date dueDate; // any valid date where year is 1970 to 2100 both inclusive
    private Status status;

    public Todo(int id, String task, int difficulty, Date dueDate, Status status) throws InvalidDataException {
        setId(id);
        setTask(task);
        setDifficulty(difficulty);
        setDueDate(dueDate);
        setStatus(status);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) throws InvalidDataException {
        if(!task.matches(TASK_PATTERN)){
            throw new InvalidDataException("Task must be 1-100 characters");
        }
        this.task = task;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) throws InvalidDataException {
        if(difficulty>5 || difficulty<1){
            throw new InvalidDataException("Difficulty must be 1-5");
        }
        this.difficulty = difficulty;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) throws InvalidDataException {
        
        try {
            if(dueDate.before(dateFormat.parse("1900-01-01")) || dueDate.after(dateFormat.parse("2100-01-01"))){
                throw new InvalidDataException("dueDate must be between 1900 and 2100");
            }
            this.dueDate = dueDate;
        } catch (ParseException ex) {
            throw new InvalidDataException("Failed to parse date", ex);
        }
        
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    
    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", task=" + task + ", difficulty=" + difficulty + ", dueDate=" + dueDate + ", status=" + status + '}';
    }

    
    
}
