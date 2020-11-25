/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day09peopledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author YingLuo
 */
public class Database {
    
    // move it outside from the constructor to be a field
    Connection conn;
            
            
    public Database() throws SQLException{
        
        //if define here which is local variable that cannot be used for others
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipd23people", "root", "StrongPWD123");

        
    }
    
    // database lier which exception may happens
    public ArrayList<Person> getAllPeople() throws SQLException{
        
        ArrayList<Person> resultList = new ArrayList<>();
        
        String sql = "SELECT * FROM people";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql); //SQLException

        while (result.next()){

            int id = result.getInt("id");

            String name = result.getString("name");
            int age = result.getInt("age");

            resultList.add(new Person(id, name, age));
        }
        
        return resultList;
    }
    
    // return new inserted record id
    public int addPerson(Person p) throws SQLException{
        
        
        String sql = "INSERT INTO people (name, age) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, p.getName());
        statement.setInt(2, p.getAge());

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
    
    public void updatePerson(Person p) throws SQLException{

        String sql = "UPDATE people SET name=?, age=? WHERE id=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, p.getName());
        statement.setInt(2, p.getAge());
        statement.setInt(3, p.getId());

        statement.executeUpdate();
       
    }
    
    public int deletePerson(int id) throws SQLException{
        
        String sql = "DELETE FROM people WHERE id=?";
 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        return statement.executeUpdate();
        
    }
    
}
