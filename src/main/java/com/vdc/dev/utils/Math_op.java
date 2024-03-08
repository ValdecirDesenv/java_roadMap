/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdc.dev.utils;

import static java.lang.Math.sqrt;

/**
 *
 * @author vdc
 */
public class Math_op {


    /**
     * This method will get the multiples of requested number
     * until  the amount required from setNb value
     * @param nb_for_multiples 
     * Notes: this synchronization works when it is dealing with the same obj
     */
    public synchronized void getMultiples(int plustime, int nb){
        
        for (int i = 1; i <= plustime; i++) {
           System.out.println(nb * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    /**
     * Return the Some of One/Sqr(number)
     * @param rangeNb 
     */
    public synchronized double getSomeOnePsqrt(int plustime, int nb){
        double sValue = 0;
        for (int i = 1; i <= plustime; i++) {
            sValue += 1/sqrt(nb);
            System.out.println("1divSqtr:"+sValue);
        }
        return sValue;
    }

}
