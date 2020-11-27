/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day11carowners;

import java.text.SimpleDateFormat;

/**
 *
 * @author YingLuo
 */
public class Car {
    
    static final String PATTERN = "^[a-zA-Z0-9 ]{6,10}$";
    
    private int id;
    private int ownerId;
    private String makeModel;
    private int prodYear;
    private String plates;

    public Car(int id, int ownerId, String makeModel, int prodYear, String plates) throws InvalidDataException {
        setId(id);
        setOwnerId(ownerId);
        setMakeModel(makeModel);
        setProdYear(prodYear);
        setPlates(plates);
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) throws InvalidDataException {
        if(plates!= null && !plates.isEmpty() && !plates.matches(PATTERN)){
            throw new InvalidDataException("Plates Must be 6-10 Letters/Digits/Spaces");
        }
        this.plates = plates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) throws InvalidDataException {
        if(makeModel.length()<1 || makeModel.length()>100){
            throw new InvalidDataException("Make Model Must be 1-100 Characters");
        }
        this.makeModel = makeModel;
    }

    public int getProdYear() {
        return prodYear;
    }

    public void setProdYear(int prodYear) throws InvalidDataException {
        if(prodYear<1900 || prodYear>2100){
            throw new InvalidDataException("Production Year Must be in 1900-2100");
        }
        this.prodYear = prodYear;
    }

    @Override
    public String toString() {

        String plateStr = (plates!=null)? plates : "no plates";
        return String.format("%d: %s, %d, %s", id, makeModel, prodYear, plateStr);
    }
    
    
    
    
}
