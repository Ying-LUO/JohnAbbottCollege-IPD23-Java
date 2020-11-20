/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day06interfacesabstract;

/**
 *
 * @author YingLuo
 */

abstract class SchrodingersContainer{
    int catsWantedCount;

    
    //partial definition, no completed definition
    abstract String findTheCat();
    int getNumberOfCats(){
        return (int)(Math.random()*2);
    }
    
}

class RealSchrodingersBox extends SchrodingersContainer implements WidgetStatusInterface{

    @Override
    String findTheCat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStatusDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}


interface WidgetStatusInterface{
    
    //constants final value, prefer to have enumeration here
    static final int STATUS_OKAY = 0;   //even if the final is removed here, it's still a constant
    static final int STATUS_ERROR = 1;
    static final int STATUS_OTHER = 2;
    
    
    int getStatus();
    String getStatusDescription();    //method which has no body will be taken as ABSTRACT even when no ABSTRACT here
}

class BestWidge implements WidgetStatusInterface{
    
    public void Initialize(){
        
    }

    //the @override will tell compile that this method has defined in interface or parent class
    @Override
    public String getStatusDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}


public class Day06InterfacesAbstract {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
