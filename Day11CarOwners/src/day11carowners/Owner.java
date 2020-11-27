/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day11carowners;

import java.sql.Blob;

/**
 *
 * @author YingLuo
 */
public class Owner {
    
    private int id;
    private String name;
    private Blob photo;

    public Owner(int id, String name, Blob photo) throws InvalidDataException {
        setId(id);
        setName(name);
        setPhoto(photo);
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidDataException {
        if(name.length()<1||name.length()>100){
            throw new InvalidDataException("Name must be 1-100 characters");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", id, name);
    }
    
}
