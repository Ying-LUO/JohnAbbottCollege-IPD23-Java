/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day11carowners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Blob;
import java.sql.Types;
import javax.sql.rowset.serial.SerialBlob;

/*Blob blob = result.getBlob("photo");
                byte[] photo = blob.getBytes(1,(int)blob.length());
*/
/**
 *
 * @author YingLuo
 */
public class Database {
    
    private Connection conn;
    private static final String DBURL = "jdbc:mysql://localhost:3306/ipd23carowner";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "StrongPWD123";
            
            
    public Database() throws SQLException{
        
        conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

    }
    
    public ArrayList<Car> getAllCarsOfAOwner(int ownerId) throws SQLException{
        
        
        ArrayList<Car> resultList = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM cars WHERE ownerId=?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, ownerId);
            ResultSet result = statement.executeQuery();
            
            while (result.next()){

                int id = result.getInt("id");
                String makeModel = result.getString("makeModel");
                int prodYear = result.getInt("prodYear");
                String plates = result.getString("plates");

                resultList.add(new Car(id, ownerId, makeModel, prodYear, plates));
                
                } 

            } catch (InvalidDataException ex) {
                    throw new SQLException("Error getting car from database", ex.getMessage());
                }
        return resultList;
    }
    
    public ArrayList<Owner> getAllOwners() throws SQLException{
        
        
        ArrayList<Owner> resultList = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM owners ORDER BY id ASC";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException
            while (result.next()){

                int id = result.getInt("id");
                String name = result.getString("name");
                Blob photo = result.getBlob("photo");

                resultList.add(new Owner(id, name, photo));
                
                } 

            } catch (InvalidDataException ex) {
                    throw new SQLException("Error getting owner from database", ex.getMessage());
                }
        return resultList;
    }
    
    public ArrayList<Car> getAllCars() throws SQLException{
        
        
        ArrayList<Car> resultList = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM cars";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException
            while (result.next()){

                int id = result.getInt("id");
                int ownerId = result.getInt("ownerId");
                String makeModel = result.getString("makeModel");
                int prodYear = result.getInt("prodYear");
                String plates = result.getString("plates");
                
                resultList.add(new Car(id, ownerId, makeModel, prodYear, plates));
                
                } 

            } catch (InvalidDataException ex) {
                    throw new SQLException("Error getting owner from database", ex.getMessage());
                }
        return resultList;
    }
    
    public ArrayList<String> getCarPlates() throws SQLException{
        
        ArrayList<String> resultList = new ArrayList<>();
         
            String sql = "SELECT plates FROM cars;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException
            while (result.next()){
                String plates = result.getString("plates");    
                resultList.add(plates);
                } 
        return resultList;
    }  
    
    public ArrayList<String> getOwnerNames() throws SQLException{
        
        ArrayList<String> resultList = new ArrayList<>();
         
            String sql = "SELECT name FROM owners;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException
            while (result.next()){
                String name = result.getString("name");    
                resultList.add(name);
                } 
        return resultList;
    }     
    
    public ArrayList<String> getCarsWithOwnerName() throws SQLException{
        
        
        ArrayList<String> resultList = new ArrayList<>();
         
            String sql = "SELECT A.id, A.makeModel, A.prodYear, A.plates, B.name \n" +
                            "FROM cars AS A\n" +
                            "LEFT JOIN owners AS B\n" +
                            "ON A.ownerId = B.id;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException
            while (result.next()){

                int id = result.getInt("id");
                String makeModel = result.getString("makeModel");
                int prodYear = result.getInt("prodYear");
                String plates = result.getString("plates");
                String plateStr = (plates==null)? "no plates":plates;
                String name = result.getString("name");
                String nameStr = (name==null)? "has no owner":"owner "+name;

                resultList.add(String.format("%d: %s, %d, %s, %s", id, makeModel, prodYear, nameStr, plateStr));
                
                } 

        return resultList;
    }
    
    public ArrayList<String> getOwnerHasCars() throws SQLException{
        
        
        ArrayList<String> resultList = new ArrayList<>();
         
            String sql = "SELECT A.id, A.name , COUNT(B.id) AS qty\n" +
                            "FROM owners AS A\n" +
                            "LEFT JOIN cars AS B\n" +
                            "ON B.ownerId = A.id\n" +
                            "GROUP BY A.name\n" + 
                            "ORDER BY A.id ASC;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException
            while (result.next()){

                int id = result.getInt("id");
                String name = result.getString("name");
                int qty = result.getInt("qty");
                
                resultList.add(id+": "+name+" owns "+qty+" cars");
                
                } 

        return resultList;
    }
    
    // return new inserted record id
    public int addOwner(Owner o) throws SQLException{
        
        String sql = "INSERT INTO owners (name, photo) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, o.getName());
        Blob blob = new SerialBlob(o.getPhoto());
        statement.setBlob(2, blob);
        
        statement.executeUpdate();  //SQLException

        //obtain ID of the newly inserted record if you need to
        ResultSet rs = statement.getGeneratedKeys();
        
        if(rs.next()){
            int lastInsertedId = rs.getInt(1);
            return lastInsertedId;
        }

        throw new SQLException("Id after insert not found");
    }
    
    public void updateOwner(Owner o) throws SQLException{
        
        String sql = "UPDATE owner SET  (name=?, photo=?) WHERE id=?";

        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, o.getName());
        
        if(o.getPhoto() == null){
            statement.setNull(2, Types.NULL);
        }else{
            Blob blob = new SerialBlob(o.getPhoto());
            statement.setBlob(2, blob);
        }
        
        statement.setInt(3, o.getId());
        
        statement.executeUpdate();  //SQLException
    }
    
    
    public ArrayList<Owner> getOwnerById(int id) throws SQLException{
        
        ArrayList<Owner> resultList = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM owners WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            while (result.next()){

                String name = result.getString("name");
                Blob photo = result.getBlob("photo");

                resultList.add(new Owner(id, name, photo));
                
                } 

            } catch (InvalidDataException ex) {
                    throw new SQLException("Error getting owner from database", ex.getMessage());
                }
        return resultList;

    }
    
    public ArrayList<Car> getCarById(int id) throws SQLException{
        
        ArrayList<Car> resultList = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM cars WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            while (result.next()){

                int ownerId = result.getInt("ownerId");
                String makeModel = result.getString("makeModel");
                int prodYear = result.getInt("prodYear");
                String plates = result.getString("plates");

                resultList.add(new Car(id, ownerId, makeModel, prodYear, plates));
                
                } 

            } catch (InvalidDataException ex) {
                    throw new SQLException("Error getting owner from database", ex.getMessage());
                }
        return resultList;

    }
    
    // return new inserted record id
    public int addCar(Car c) throws SQLException{
        
        
        String sql = "INSERT INTO cars (ownerId, makeModel, prodYear, plates) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        if(c.getOwnerId() == 0){
            statement.setNull(1, Types.NULL);
        }else{
            statement.setInt(1, c.getOwnerId());
        }
        statement.setString(2, c.getMakeModel());
        statement.setInt(3, c.getProdYear());
        if(c.getPlates().isEmpty()){
            statement.setNull(4, Types.NULL);
        }else{
            statement.setString(4, c.getPlates());
        }
        
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
    
    public void updateCar(Car c) throws SQLException{

        String sql = "UPDATE cars SET ownerId=?, makeModel=?, prodYear=?, plates=? WHERE id=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        
        if(c.getOwnerId() == 0){
            statement.setNull(1, Types.NULL);
        }else{
            statement.setInt(1, c.getOwnerId());
        }
        statement.setString(2, c.getMakeModel());
        statement.setInt(3, c.getProdYear());
        if(c.getPlates().isEmpty()){
            statement.setNull(4, Types.NULL);
        }else{
            statement.setString(4, c.getPlates());
        }
        
        statement.setInt(5, c.getId());

        statement.executeUpdate();
       
    }
    
    public void deleteCar(int id) throws SQLException{
        
        String sql = "DELETE FROM cars WHERE id=?";
 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        statement.executeUpdate();
        
    }
    
    public void deleteOwner(int id) throws SQLException{
        
        String sql = "DELETE FROM owner WHERE id=?";
 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        statement.executeUpdate();
        
    }
    
}
