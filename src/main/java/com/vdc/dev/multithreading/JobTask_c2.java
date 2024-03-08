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
public class JobTask_c2 implements Runnable{
    Math_op op;
    int plustime;
    int nb;

    public JobTask_c2(Math_op op, int plustime, int nb) {
        this.op = op;
        this.plustime = plustime;
        this.nb = nb;
    }

    
    @Override
    public void run() {
        try {
            System.out.println(" Thread 2 is running");
            op.getMultiples(plustime,nb);
        } catch (Exception e) {
            System.out.println(" Thread 2 has issues "+ e);
        }
    }
    
}