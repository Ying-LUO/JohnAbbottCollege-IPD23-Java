/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03peopleadvanced;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author YingLuo
 */
public class Person {

    public Person(String name, int heightCm, Date dateOfBirth) {
        this.name = name;
        this.heightCm = heightCm;
        this.dateOfBirth = dateOfBirth;
    }
    
    
    
    String name;
    int heightCm;
    Date dateOfBirth;
   
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    
    
    @Override
    public String toString(){
        return String.format("%s is %dcm tall born %s", name, heightCm, dateOfBirth);
    }
    
}
