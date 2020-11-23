/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07birthdays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author YingLuo
 * @since 2020-Nov-22
 * @version 1.0
 */
public class Birthday {
    
    private String name;
    private Date birthday;
    
    private static final String NAME_PATTERN = "^[^;][-() \\.A-Za-z0-9]{1,50}$";
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");    

    public Birthday(String name, Date birthday) throws InvalidDataException {
        setName(name);
        setBirthday(birthday);
    }
    
    public Birthday(String dataLine) throws InvalidDataException{
        
        String[] dataStr = dataLine.split(";");
        if (dataStr.length != 2) {
            throw new InvalidDataException("Invalid data structure,\n Name;Birthday per line"); 
        }
        
        try {
            setName(dataStr[0]);
            setBirthday(dateFormat.parse(dataStr[1]));
        } catch (ParseException ex) {
            throw new InvalidDataException("Failed to parse the input date: " + ex.getMessage());
        }
        
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) throws InvalidDataException {
        
        try {
            if(birthday.before(dateFormat.parse("1900-01-01")) || birthday.after(new Date())){
                throw new InvalidDataException("Year must be between 1900 and today");
            }
            
            this.birthday = birthday;
            
        } catch (ParseException ex) {
            throw new InvalidDataException("Failed to parse date", ex);
        }
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidDataException {
        
        if(!name.matches(NAME_PATTERN)){
            throw new InvalidDataException("Name must be 1-50 characters, no semicolon"); 
        }
        this.name = name;
    }
    
    public int getDaysTillBirthday(){
        
        LocalDate today = LocalDate.now();
        LocalDate bday = LocalDate.parse(Birthday.dateFormat.format(this.birthday));
        LocalDate nextBDay = bday.withYear(today.getYear());

        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        long days = ChronoUnit.DAYS.between(today, nextBDay);
        
        return (int)days;
        
    }

    @Override
    public String toString() {
        
        return name + 
                " born : " + dateFormat.format(this.birthday) +
                " birthday in " + this.getDaysTillBirthday() + " days";
        
    }
    
    
    public String toDataString(){
        
        return String.format("%s;%s", this.name, dateFormat.format(this.birthday));
        
    } 
    
    final static Comparator<Birthday> compareByName = (Birthday b1, Birthday b2) -> b1.name.compareTo(b2.name);
    
    final static Comparator<Birthday> compareByBirthday = (Birthday b1, Birthday b2) -> b1.birthday.compareTo(b2.birthday);
    
    final static Comparator<Birthday> compareByDaysTillNextDOB = (Birthday b1, Birthday b2) -> b1.getDaysTillBirthday() - b2.getDaysTillBirthday();
    
}
