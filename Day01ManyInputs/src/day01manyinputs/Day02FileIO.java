/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01manyinputs;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author YingLuo
 */
public class Day02FileIO {
    
    
    public static void main(String[] args){
        
        // Part 1: saving into a file
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        
        String name = input.nextLine();
        int count = (int)(Math.random()*10 + 1);
        
        PrintWriter fileOutput = null;
                
        try{
            
            fileOutput = new PrintWriter(new File("output.txt"));
            for (int i=0; i<count; i++){
                fileOutput.println(name);
            }
            
        }catch (IOException ex){
            System.out.println("Error writing to file: " + ex.getMessage());
        }finally{
            fileOutput.close();
        }
        
        // Part 2: reading a file
        try(Scanner fileinput = new Scanner(new File("output.txt"))){

            while(fileinput.hasNextLine()){
                String line = fileinput.nextLine();
                System.out.println("Line: " + line);

            }
        }catch(IOException ex){
            System.out.println("Error reading file: " + ex.getMessage());
        }
        
        //
        
    }
}
