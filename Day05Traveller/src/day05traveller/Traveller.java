/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day05traveller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author YingLuo
 * @since 2020-NOV-18
 * @version 1.0
 */
public class Traveller {
    
    private String name;
    private Gender gender;
    private String passportNo;
    private String destAirportCode;
    private Date depDate;
    private Date retDate;

    static final String AIRPORT_PATTERN = "^[A-Z]{3}$";
    
    static final String PASSPORT_PATTERN = "^[A-Z]{2}[0-9]{6}$";
    
    static final String NAME_PATTERN = "^[-/() \\.A-Za-z0-9]{2,50}$";
    
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public Traveller(String name, Gender gender, String passportNo, String destAirportCode, Date depDate, Date retDate) throws InvalidDataException {
        setName(name);
        setGender(gender);
        setPassportNo(passportNo);
        setDestAirportCode(destAirportCode);
        setDepDate(depDate);
        setRetDate(retDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidDataException {
        
        if(!name.matches(NAME_PATTERN)){
            throw new InvalidDataException("Input Name must be 2-50 characters, uppercase/lowercase, digits, space .()-"); 
        }
        this.name = name;
    }

    public Gender getGender() {

        return gender;
    }

    public void setGender(Gender gender) {
        
        this.gender = gender;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) throws InvalidDataException {
        if(!passportNo.matches(PASSPORT_PATTERN)){
            throw new InvalidDataException("Input passport number must be two uppercase letters with 6 digits, e.g. AA123456"); 
        }
        this.passportNo = passportNo;
    }

    public String getDestAirportCode() {
        return destAirportCode;
    }

    public void setDestAirportCode(String destAirportCode) throws InvalidDataException {
        
        if(!destAirportCode.matches(AIRPORT_PATTERN)){
            throw new InvalidDataException("Input Destination Airport Code must be three uppercase letters, e.g. YUL"); 
        }
        this.destAirportCode = destAirportCode;
    }

    public Date getDepDate() {
        return depDate;
    }

    public void setDepDate(Date depDate) throws InvalidDataException {
        
        try {
            if(depDate.before(dateFormat.parse("1900-01-01")) || depDate.after(dateFormat.parse("2100-01-01"))){
                throw new InvalidDataException("Year must be between 1900 and 2100");
            }
            
            this.depDate = depDate;
            
        } catch (ParseException ex) {
            throw new InvalidDataException("Year must be between 1900 and 2100", ex);
        }
        
    }

    public Date getRetDate() {
        return retDate;
    }

    public void setRetDate(Date retDate) throws InvalidDataException {
        
        try {
            if(retDate.before(dateFormat.parse("1900-01-01")) || retDate.after(dateFormat.parse("2100-01-01"))){
                throw new InvalidDataException("Year must be between 1900 and 2100");
            }
            
            if(retDate.before(depDate)){
                throw new InvalidDataException("Return Date must be after departure date");
            }
            
            this.retDate = retDate;
            
        } catch (ParseException ex) {
            throw new InvalidDataException("Year must be between 1900 and 2100", ex);
        }
    }

    public void setDepretDates(Date depDate, Date retDate) throws InvalidDataException {
        
        this.setDepDate(depDate);
        this.setRetDate(retDate);
        
    }

    @Override
    public String toString() {
        
        return "Traveller Name: " + name + 
                ", Gender: " + gender + 
                ", passportNo: " + passportNo + 
                ", Destination Airport Code: " + destAirportCode + 
                ", Depature Date: " + dateFormat.format(this.depDate) + 
                ", Return Date: " + dateFormat.format(this.retDate);
    }
    
    public String toDataString(){
        
        return String.format("%s;%s;%s;%s;%s;%s", 
                                    this.name, 
                                    this.gender,
                                    this.passportNo, 
                                    this.destAirportCode, 
                                    dateFormat.format(this.depDate), 
                                    dateFormat.format(this.retDate));
        
    }
    
}
