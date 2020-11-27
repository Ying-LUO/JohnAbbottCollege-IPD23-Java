/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz3booksandauthors;

/**
 *
 * @author YingLuo
 */
public class Author {
    
    private int id; // INT PK AI
    private int bookId; // INT, FK -> books.id
    private String name; // VC(50), verify 1-50 chars long

    public Author(int id, int bookId, String name) throws InvalidDataException {
        setId(id);
        setBookId(bookId);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidDataException {
        
        if(name.length()<1 || name.length()>50){
            throw new InvalidDataException("Author name must be 1-50 Characters");
        }
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", bookId=" + bookId + ", name=" + name + '}';
    }

}
