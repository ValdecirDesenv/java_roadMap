/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.vdc.dev.roadmap;

import com.vdc.dev.code.Book;
import com.vdc.dev.enums.Calendar;
import com.vdc.dev.multithreading.JobTask_c1;
import com.vdc.dev.multithreading.JobTask_c2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author vdc
 */
public class Roadmap {

    public static void main(String[] args) {
  
        callEnumSample();
        callSerialization();
        callThreadsSample();
        
        
        
        System.out.println("Hello Java best neil code!");
    }
    
    
    
    
    public static void callEnumSample(){
         //==================== Enum ===========
        Calendar month = Calendar.MARCH;
        System.out.println(month.getName() + " is month number " + month.getValue());      
        for (Calendar months: Calendar.values()){
            System.out.println(" Enum value :" + months.name() +" n:" + months.getValue());
        }
        System.out.println("\n");
    }
    
    
    public static void callSerialization(){
         //==================== Serialization ===========
        Book bo = new Book("Sky Blue", 500);
        bo.setValueForServerOnly(3800);

        String filename = "resources//Book.obj";        
        File fileNamePath = new File(filename).getAbsoluteFile();        
        InputStream fileIn = Roadmap.class.getResourceAsStream(filename);        
        FileOutputStream fileOut =null;
        ObjectOutputStream objOut = null;
        
        //Serialization
        try {
            fileOut = new FileOutputStream(fileNamePath);
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(bo);
            fileOut.close();
            System.out.println(" ValueForServerOnly " + bo.getValueForServerOnly() +" \n");
            System.out.println(" Obj serialized !");
            
        } catch (Exception e) {
            System.out.println(" IOException " + e.getMessage());
        }
        
        ObjectInputStream objIn = null;        
        //Deserialization
        try {
            fileIn = new FileInputStream(fileNamePath);
            objIn = new ObjectInputStream(fileIn);
            
            Book bookStreamed = (Book)objIn.readObject();

            System.out.println(" ValueForServerOnly " + bookStreamed.getValueForServerOnly()+" \n");
            System.out.println(" Obj deserialized ! " + bookStreamed);
            
            objIn.close();
            fileIn.close();
        } catch (Exception e) {
            System.out.println(" IOException " + e.getMessage());
        }
         System.out.println("\n");
        //============================================== 
    }

    private static void callThreadsSample() {
        JobTask_c1 td_c1 = new JobTask_c1();
        td_c1.start();
        Thread td_c2 = new Thread(new JobTask_c2());
        td_c2.start();
        
    }
}

