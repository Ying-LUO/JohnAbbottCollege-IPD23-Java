/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz3booksandauthors;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Blob;
import java.sql.Types;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author YingLuo
 */
public class Book {
    
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    static final String ISBN_PATTERN = "^\\d{12}(\\d|X)$";
    
    private int id; // INT PK AI
    private String title; // VC(100), verify 1-100 chars long
    private String isbn; // VC(13) UNIQ, allow ISBN, regex: 13 character format - the first 12 are only 0-9, then last one is 0-9 or X, ignore dashes
    private Date pubDate; // DATE, any date is okay
    private Blob coverImg; // LARGEBLOB, no NULL allowed (picture must be assigned)
    private ArrayList<Author> authorList; 

    public Book(int id, String title, String isbn, Date pubDate, Blob coverImg, ArrayList<Author> authorList) throws InvalidDataException {
        setId(id);
        setTitle(title);
        setIsbn(isbn);
        setPubDate(pubDate);
        setCoverImg(coverImg);
        setAuthorList(authorList);
    }

    public ArrayList<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(ArrayList<Author> authorList) throws InvalidDataException {
        if(authorList == null){
            throw new InvalidDataException("Author List cannot be empty, Please choose author");
        }
        this.authorList = authorList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InvalidDataException {
        if(title.length()<1 || title.length()>100){
            throw new InvalidDataException("title must be 1-100 Characters");
        }
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws InvalidDataException {
        
        String isbnStr = isbn.replaceAll("\\D", "");
        
        if(!isbnStr.matches(ISBN_PATTERN)){
            throw new InvalidDataException("Ignore dashes, ISBN must be 13 characters that first 12 are only 0-9 and last one is 0-9 or X");
        }
        this.isbn = isbnStr;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) throws InvalidDataException {
        if(pubDate == null){
            throw new InvalidDataException("Please input date");
        }
        this.pubDate = pubDate;
    }

    public Blob getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(Blob coverImg) throws InvalidDataException {
        if(coverImg == null){
            throw new InvalidDataException("Please choose cover image");
        }
        this.coverImg = coverImg;
    }
    
    

    @Override
    public String toString() {
        
        String authorListStr = "";
        for(Author author: authorList){
            authorListStr += author.getName()+", ";
        }
         
        return String.format("[%d] %s by %s", id, title, authorListStr.substring(0, authorListStr.length()-2));
    }
        
        
    
}
