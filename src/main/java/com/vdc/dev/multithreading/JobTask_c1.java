/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdc.dev.multithreading;

import com.vdc.dev.utils.Math_op;

/**
 * This Thread will be getting the multiple of requested number
 * @author vdc
 */
public class JobTask_c1 extends Thread{
    Math_op op;
    int plustime;
    int nb;
    
    public JobTask_c1(Math_op op, int plustime, int nb) {
        this.op = op;
        this.plustime = plustime;
        this.nb = nb;
    }
    
    @Override
    public void run() {
        try {
            System.out.println(" Thread 1 is running");
            op.getMultiples(plustime,nb);
            
        } catch (Exception e) {
            System.out.println(" Thread has issues "+ e);
        }
    }
    
}
