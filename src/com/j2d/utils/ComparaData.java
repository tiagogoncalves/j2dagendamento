/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2d.utils;

import java.sql.Date;

/**
 *
 * @author Jun
 */
public class ComparaData {
    public static boolean compara(Date d1, Date d2){
        System.out.println(d1.getDate()+"=="+d2.getDate());
        
        if((d1.getMonth() == d2.getMonth()-1)&&(d1.getDate()==d2.getDate()))
            return true;
        return false;
    }
    
}
