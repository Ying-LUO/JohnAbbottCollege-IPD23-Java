/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day06teammembers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * @author YingLuo
 */
public class Day06TeamMembers {

    /**
     * @param args the command line arguments
     */
    
    static File file = new File("teams.txt");
    
    static HashMap<String, ArrayList<String>> playersByTeams = new HashMap<>();
        
    public static void main(String[] args) {
        
        writeToFile();
        
        readFromFileToArrayList();
        
        playersByTeams.values().iterator().forEachRemaining(System.out::println);
        playersByTeams.keySet().iterator().forEachRemaining(System.out::println);
        
        playersByTeams.entrySet().forEach(entry->{
                System.out.println(entry.getKey() + " plays in: " + entry.getValue());  
        });
        
    }
    
    public static void writeToFile(){
        
        try {
            FileWriter writeToFile = new FileWriter(file);
            
            writeToFile.write(
                                "Green Grass Team:Jerry,Marry,Barry\n" +
                                "Terrific Team Today:Marry,Melinda,Eva,Jerry\n" +
                                "Other Best Team:Eva,Jerry,Barry\n" +
                                "Second to none Team:Melinda,Eva,Marry\n" +
                                "Yet Another Super-Team:Eva,Jerry,Barry,Marry"
                            );
            
            writeToFile.close();
            
        } catch (IOException ex) {
            System.out.println("Error while writing data into File" + ex.getMessage());
        }
        
    }
    
    public static void readFromFileToArrayList(){
        
        try {
           
            Scanner fileInput = new Scanner(file);
            
            while(fileInput.hasNextLine()){
                
                String[] str = fileInput.nextLine().split(":");
                
                if(str.length !=2){
                    System.out.println("Error while extracting data from File: structure error");
                }else{
                    String team = str[0];
                    String[] member = str[1].split(",");
                    for(int i=0; i<member.length; i++){
                        if(!playersByTeams.containsKey(member[i])){
                            ArrayList<String> teamList = new ArrayList<>();
                            teamList.add(team);
                            playersByTeams.put(member[i], teamList);
                        }else{
                            playersByTeams.get(member[i]).add(team);
                        } 
                    }
                }
            }
            
            fileInput.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error while loading data from File" + ex.getMessage());
        }
    }
}
