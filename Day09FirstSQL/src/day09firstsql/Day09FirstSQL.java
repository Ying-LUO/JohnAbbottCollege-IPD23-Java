/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day09firstsql;


import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author YingLuo
 */
public class Day09FirstSQL {

    /**
     * @param args the command line arguments
     */
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipd23people", "root", "root");

            
            //INSERT
            {
                System.out.print("Enter Name: ");
                String name = input.nextLine();
                System.out.print("Enter Age: ");
                int age = input.nextInt();
            
                String sql = "INSERT INTO people (name, age) VALUES (?, ?)";

                PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, name);
                statement.setInt(2, age);

                statement.executeUpdate();  //SQLException

                //obtain ID of the newly inserted record if you need to
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()){
                    int lastInsertedId = rs.getInt(1);
                    System.out.println("Inserted new record with id=" + lastInsertedId);
                }
            }
            
            
            //SELECT
            {
                String sql = "SELECT * FROM people";

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql); //SQLException

                int count = 0;

                while (result.next()){
                    
                    int id = result.getInt("id");
                    
                    String name = result.getString("name");
                    int age = result.getInt("age");
                    
                    System.out.printf("%nPerson: id=%d, name=%s, age=%d", id, name, age);
                }
            }
            
            //UPDATE
            {
                System.out.print("\n\nEnter id of the record to update: ");
                int id = input.nextInt();
                input.nextLine();  // consume the left-over newline, add this after every nextInt
                System.out.print("Enter Name: ");
                String name = input.nextLine();
                
                System.out.print("Enter Age: ");
                int age = input.nextInt();
                input.nextLine();  // consume the left-over newline, add this after every nextInt
            
                String sql = "UPDATE people SET name=?, age=? WHERE id=?";
 
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setInt(2, age);
                statement.setInt(3, id);

                statement.executeUpdate();
                System.out.println("Person updates successfully");
                
            }
            
            //DELETE
            {
                System.out.println("\nEnter the id you want to delete: ");
                int id = input.nextInt();
                input.nextLine();  // consume the left-over newline, add this after every nextInt
                
                String sql = "DELETE FROM people WHERE id=?";
 
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, id);

                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("A record of people was deleted successfully!");
                }else{
                    System.out.println("no such record found - none deleted");
                }

            }
 
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();   // now show to the user, but show in console
        }
        
        
    }
    
}
