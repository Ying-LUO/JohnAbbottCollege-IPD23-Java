/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07birthdays;

import java.util.Date;

/**
 *
 * @author YingLuo
 * @since 2020-NOV-22
 * @version 1.0
 */
public class Birthday {
    
    private String name;
    private Date birthday;
    
    private static final String NAME_PATTEN = "^[;]*[-() \\.A-Za-z0-9]{1,50}$";
    

    public Birthday(String name, Date birthday) throws InvalidDataException {
        setName(name);
        setBirthday(birthday);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidDataException {
        
        if(!name.matches(NAME_PATTEN)){
            throw new InvalidDataException("Name must be 2-50 characters, uppercase/lowercase, digits, .()-"); 
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "Birthday{" + "name=" + name + ", birthday=" + birthday + '}';
    }
    
    
     
    
}
