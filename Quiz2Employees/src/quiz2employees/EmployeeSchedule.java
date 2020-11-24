/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz2employees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author YingLuo
 */
public class EmployeeSchedule {
   
    static final String PATTERN = "^[^;^?@!~*][-() \\.A-Za-z0-9]{1,50}$";
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
    
    private String name;
    private boolean isManager;
    private String department;
    private Date dateHired;
    private HashSet<Weekday> workdaysList = new HashSet<>();

    public EmployeeSchedule(String name, boolean isManager, String department, Date dateHired) throws InvalidDataException {
        setName(name);
        setIsManager(isManager);
        setDateHired(dateHired);
        setDepartment(department);
    }
    
    public EmployeeSchedule(String dataLine) throws InvalidDataException{
        
        String[] dataStr = dataLine.split(";");
        if (dataStr.length != 4) {
            throw new InvalidDataException("Invalid data structure,\n Name;HireDate;Department;Workdays per line"); 
        }
        
        try {
            
            if(dataStr[0].endsWith("*")){
                setName(dataStr[0].substring(0, dataStr[0].length()-1));
                setIsManager(true);
            }else{
                setName(dataStr[0]);
                setIsManager(false);
            }
            setDateHired(dateFormat.parse(dataStr[1]));
            setDepartment(dataStr[2]);
            String[] workDays = dataStr[3].replace(" ", "").split(",");
            for(int i=0; i<workDays.length; i++){
                workdaysList.add(Weekday.valueOf(workDays[i]));
            }
        } catch(IllegalArgumentException e){                
            throw new InvalidDataException("Failed to find the weekday enum data: " + e.getMessage());               
        } catch (ParseException ex) {
            throw new InvalidDataException("Failed to parse the input date: " + ex.getMessage());
        }
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidDataException {
        
        if(!name.matches(PATTERN)){
            throw new InvalidDataException("Name must be 2-50 characters, not permitted are: ;^?@!~*"); 
        }
        this.name = name;
    }

    public boolean isIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) throws InvalidDataException {
        
        if(!department.matches(PATTERN)){
            
            throw new InvalidDataException("Department must be 2-50 characters, not permitted are: ;^?@!~*"); 
        }
        this.department = department;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) throws InvalidDataException {
        
        try {
            if(dateHired.before(dateFormat.parse("1900-01-01")) || dateHired.after(new Date())){
                throw new InvalidDataException("Hire Date must be between 1900-01-01 and today");
            }
            
            this.dateHired = dateHired;
            
        } catch (ParseException ex) {
            throw new InvalidDataException("Failed to parse date", ex);
        }
        
    }

    public HashSet<Weekday> getWorkdaysList() {
        
        return workdaysList;
    }
   
    public void setWorkdaysList(HashSet<Weekday> workdaysList) {
        this.workdaysList = workdaysList;
    }
    
    @Override
    public String toString() {
        
        String isManager = (isIsManager())? "manager" : "employee";
        
        return name + 
                ", " + isManager +
                " of " + this.department + 
                ", hired on " + dateFormat.format(this.dateHired) +
                ", works on " + this.getWorkdaysList().toString().replace("[", "").replace("]", "");
        
    }
    
    
    public String toDataString(){
        
        String isManager = (isIsManager())? "*" : "";
        
        return String.format("%s;%s;%s;%s", this.name+isManager, dateFormat.format(this.dateHired), this.department, this.getWorkdaysList().toString().replace("[", "").replace("]", ""));
        
    } 
    
    final static Comparator<EmployeeSchedule> compareByName = (EmployeeSchedule e1, EmployeeSchedule e2) -> e1.name.compareTo(e2.name);
    
    final static Comparator<EmployeeSchedule> compareByHiredDate = (EmployeeSchedule e1, EmployeeSchedule e2) -> e1.dateHired.compareTo(e2.dateHired);

    
    
}
