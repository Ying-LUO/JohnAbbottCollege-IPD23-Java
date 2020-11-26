/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day10flightssqlserverdb;

import day10flightssqlserverdb.Flight.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author YingLuo
 */
public class Database {
    
    // move it outside from the constructor to be a field
    private Connection conn;

    private String connectionUrl = "jdbc:sqlserver://localhost;databaseName=IPD23FLIGHTS;user=sa;password=StrongPWD123;";
    
    public Database() throws SQLException{
        
        //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        conn = DriverManager.getConnection(connectionUrl);

    }
    
    // database lier which exception may happens
    public ArrayList<Flight> getAllFlights() throws SQLException{
        
        ArrayList<Flight> resultList = new ArrayList<>();
        
        try {
            

            String sql = "SELECT * FROM IPD23.Flights";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException

            while (result.next()){
    
                int id = result.getInt("id");
                Date onDay = result.getDate("onDay");
                String fromCode = result.getString("fromCode");
                String toCode = result.getString("toCode");
                Type type = Type.valueOf(result.getString("type"));
                int passengers = result.getInt("passengers");

                resultList.add(new Flight(id, onDay, fromCode, toCode, type, passengers));
            
            }
        } catch (InvalidDataException | IllegalArgumentException ex) {
                throw new SQLException("Error getting flight from database", ex.getMessage());
        }
        return resultList;
    }
    
    // return new inserted record id
    public int addFlight(Flight f) throws SQLException{
        
        
        String sql = "INSERT INTO IPD23.Flights (onDay, fromCode, toCode, type, passengers) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setDate(1, new java.sql.Date(f.getOnDay().getTime()));
        statement.setString(2, f.getFromCode());
        statement.setString(3, f.getToCode());
        statement.setString(4, f.getType().toString());
        statement.setInt(5, f.getPassengers());
        
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
    
    public void updateFlight(Flight f) throws SQLException{

        String sql = "UPDATE IPD23.Flights SET onDay=?, fromCode=?, toCode=?, type=?, passengers=? WHERE id=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setDate(1, new java.sql.Date(f.getOnDay().getTime()));
        statement.setString(2, f.getFromCode());
        statement.setString(3, f.getToCode());
        statement.setString(4, f.getType().toString());
        statement.setInt(5, f.getPassengers());
        
        statement.setInt(6, f.getId());

        statement.executeUpdate();
       
    }
    
    public void deleteFlight(int id) throws SQLException{
        
        String sql = "DELETE FROM IPD23.Flights WHERE id=?";
 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        statement.executeUpdate();
        
    }
    
}
