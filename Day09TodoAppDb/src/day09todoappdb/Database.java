/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day09todoappdb;

import day09todoappdb.Todo.Status;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author YingLuo
 */
public class Database {
    
    // move it outside from the constructor to be a field
    Connection conn;
            
            
    public Database() throws SQLException{
        
        String dbURL = "jdbc:mysql://localhost:3306/ipd23todoapp";
        String username = "root";
        String password = "StrongPWD123";

        conn = DriverManager.getConnection(dbURL, username, password);

    }
    
    // database lier which exception may happens
    public ArrayList<Todo> getAllTodos() throws SQLException, InvalidDataException{
        
        ArrayList<Todo> resultList = new ArrayList<>();
        
        String sql = "SELECT * FROM todos";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql); //SQLException

        while (result.next()){
    
                int id = result.getInt("id");
                String task = result.getString("task");
                int difficulty = result.getInt("difficulty");
                Date dueDate = result.getDate("dueDate");
                Status status = Status.valueOf(result.getString("status"));

                resultList.add(new Todo(id, task, difficulty, dueDate, status));
        }
        
        return resultList;
    }
    
    // return new inserted record id
    public int addTodo(Todo t) throws SQLException{
        
        
        String sql = "INSERT INTO todos (task, difficulty, dueDate, status) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, t.getTask());
        statement.setInt(2, t.getDifficulty());
        statement.setDate(3, t.getDueDate());
        statement.setString(4, t.getStatus().toString());

        statement.executeUpdate();  //SQLException

        //obtain ID of the newly inserted record if you need to
        ResultSet rs = statement.getGeneratedKeys();
        
        if(rs.next()){
            int lastInsertedId = rs.getInt(1);
            return lastInsertedId;
        }
        //return -1;  // not good choice without any documentation
        throw new SQLException("Id after insert not found");
    }
    
    public void updateTodo(Todo t) throws SQLException{

        String sql = "UPDATE todos SET task=?, difficulty=? , dueDate=?, status=? WHERE id=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, t.getTask());
        statement.setInt(2, t.getDifficulty());
        statement.setDate(3, t.getDueDate());
        statement.setString(4, t.getStatus().toString());
        statement.setInt(5, t.getId());

        statement.executeUpdate();
       
    }
    
    public int deleteTodo(int id) throws SQLException{
        
        String sql = "DELETE FROM todos WHERE id=?";
 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        return statement.executeUpdate();
        
    }
    
}
