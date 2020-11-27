/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz3booksandauthors;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author YingLuo
 */
public class Database {
    
    private Connection conn;
    private static final String DBURL = "jdbc:mysql://localhost:3306/ipd23quiz3booksandauthors";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "StrongPWD123";
            
            
    public Database() throws SQLException{
        
        conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

    }
    
    public ArrayList<Book> getAllBooks() throws SQLException{
        
        
        ArrayList<Book> resultList = new ArrayList<>();
        
        ArrayList<Author> authorList = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM books";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException
            while (result.next()){

                int id = result.getInt("id");
                String title = result.getString("title");
                String isbn = result.getString("isbn");
                Date pubDate = result.getDate("pubDate");
                Blob coverImg = result.getBlob("coverImg");
                authorList = getAllAuthorsByBookId(id);
                resultList.add(new Book(id, title, isbn, pubDate, coverImg, authorList));
                
                } 

            } catch (InvalidDataException ex) {
                    throw new SQLException("Error getting owner from database", ex.getMessage());
                }
        return resultList;
    }
    
    public ArrayList<Author> getAllAuthorsByBookId(int bookId) throws SQLException{
        
        
        ArrayList<Author> resultList = new ArrayList<>();
        
        try {

            String sql = "SELECT * FROM authors WHERE bookId=?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, bookId);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                String name = result.getString("name");

                resultList.add(new Author(0, bookId, name));
                } 

            } catch (InvalidDataException ex) {
                    throw new SQLException("Error getting owner from database", ex.getMessage());
                }
        return resultList;
    }
    
    public ArrayList<String> getBookISBN() throws SQLException{
        
        ArrayList<String> resultList = new ArrayList<>();
         
            String sql = "SELECT isbn FROM books;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException
            while (result.next()){
                String isbn = result.getString("isbn");    
                resultList.add(isbn);
                } 
        return resultList;
    } 
    
    public int addBook(Book b) throws SQLException{
        
        String sql = "INSERT INTO books (title, isbn, pubDate, coverImg) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, b.getTitle());
        statement.setString(2, b.getIsbn());
        statement.setDate(3, new java.sql.Date(b.getPubDate().getTime()));
        Blob blob = new SerialBlob(b.getCoverImg());
        statement.setBlob(4, blob);
        
        statement.executeUpdate();  //SQLException

        //obtain ID of the newly inserted record if you need to
        ResultSet rs = statement.getGeneratedKeys();
        
        if(rs.next()){
            int lastInsertedId = rs.getInt(1);
            return lastInsertedId;
        }

        throw new SQLException("Id after insert not found");
    }
    
    public int addAuthor(Author a) throws SQLException{
        
        String sql = "INSERT INTO authors (bookId, name) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setInt(1, a.getBookId());
        statement.setString(2, a.getName());
        
        statement.executeUpdate();  //SQLException

        //obtain ID of the newly inserted record if you need to
        ResultSet rs = statement.getGeneratedKeys();
        
        if(rs.next()){
            int lastInsertedId = rs.getInt(1);
            return lastInsertedId;
        }

        throw new SQLException("Id after insert not found");
    }
    
}
