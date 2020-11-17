/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz1todo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author YingLuo
 */
public class Todo {
    
    enum Status {
                Pending,
                Done,
                Delegated
            }
    
    String task; // 1-100 characters, made up of uppercase and lowercase letters, digits, space, _-(),./\ only
    int difficulty; // 1-5, as slider
    Date dueDate; // year 1900-2100 both inclusive, use formatted field
    Status status;  // one of: Pending, Done, Delegated - matches the ComboBox in Swing GUI

    public Todo(String task, int difficulty, Date dueDate, Status status) {
        this.task = task;
        this.difficulty = difficulty;
        this.dueDate = dueDate;
        this.status = status;
    }
    
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String toString() {
        return String.format("%s by %s / difficulty %d , %s", task, dateFormat.format(dueDate), difficulty, status);
    }
    
}
