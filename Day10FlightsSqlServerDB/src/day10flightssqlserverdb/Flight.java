/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day10flightssqlserverdb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author YingLuo
 */
public class Flight {

    static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
    
    enum Type {
        Domestic, International, Private
    }
    
    private int id;
    private Date onDay;
    private String fromCode;
    private String toCode;
    private Type type;
    private int passengers;

    public Flight(int id, Date onDay, String fromCode, String toCode, Type type, int passengers) throws InvalidDataException {
        setId(id);
        setOnDay(onDay);
        setFromCode(fromCode);
        setToCode(toCode);
        setType(type);
        setPassengers(passengers);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOnDay() {
        return onDay;
    }

    public void setOnDay(Date onDay) throws InvalidDataException {
        try {
            if(onDay.before(dateFormat.parse("01-01-1970")) || onDay.after(dateFormat.parse("01-01-2100"))){
                throw new InvalidDataException("dueDate must be between 1970 and 2100");
            }
            this.onDay = onDay;
        } catch (ParseException ex) {
            throw new InvalidDataException("Failed to parse date", ex);
        }
    }

    public String getFromCode() {
        return fromCode;
    }

    public void setFromCode(String fromCode) throws InvalidDataException {
        
        if (fromCode.length() < 3 || fromCode.length() > 5) {
            throw new InvalidDataException("Code must be 3-5 characters");
        }
        this.fromCode = fromCode.toUpperCase();
    }

    public String getToCode() {
        return toCode;
    }

    public void setToCode(String toCode) throws InvalidDataException {
        if (toCode.length() < 3 || toCode.length() > 5) {
            throw new InvalidDataException("Code must be 3-5 characters");
        }
        this.toCode = toCode.toUpperCase();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) throws InvalidDataException {
        if(passengers<0 || passengers>200){
            throw new InvalidDataException("Passengers must be 0-200");
        }
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", onDay=" + onDay + ", fromCode=" + fromCode + ", toCode=" + toCode + ", type=" + type + ", passengers=" + passengers + '}';
    }
    
    public String toDataLine(){
        
        return String.format("%d;%s;%s;%s;%s;%d", id, dateFormat.format(onDay), fromCode, toCode, type.toString(),passengers);
        
    } 
    
}
