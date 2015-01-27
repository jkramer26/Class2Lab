/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author jkramer26
 */
public class WelcomeService {
    private Calendar date = Calendar.getInstance();
    private String greeting;
        
    
    private String getGreeting() {
        Calendar morning = Calendar.getInstance();
        Calendar afternoon = Calendar.getInstance();
        Calendar evening = Calendar.getInstance();
        Calendar sample = Calendar.getInstance();
        
        morning.set(Calendar.HOUR_OF_DAY, 03);
        morning.set(Calendar.MINUTE, 0);
        morning.set(Calendar.SECOND, 0);
        
        afternoon.set(Calendar.HOUR_OF_DAY, 10);
        afternoon.set(Calendar.MINUTE, 31);
        afternoon.set(Calendar.SECOND, 0);
        
        evening.set(Calendar.HOUR_OF_DAY, 13);
        evening.set(Calendar.MINUTE, 1);
        evening.set(Calendar.SECOND, 0);
        
        sample.set(Calendar.HOUR_OF_DAY, 00);
        sample.set(Calendar.MINUTE, 1);
        sample.set(Calendar.SECOND, 0);
        
//        if (sample.after(morning) == true && sample.after(afternoon) == true && sample.after(evening) == true) {
//            System.out.println("It is evening"); 
//        } else if (sample.after(morning) == true && sample.after(afternoon) == true && sample.after(evening) == false) {
//            System.out.println("It is afternoon");
//        } else if (sample.after(morning) == true && sample.after(afternoon) == false && sample.after(evening) == false) {
//            System.out.println("It is morning");
//        } else if (sample.before(morning) == true) {
//            System.out.println("It is evening because it is before morning");
//        } else {
//            System.out.println("im getting a headache");
//        }
        
        if (date.after(morning) == true && date.after(afternoon) == true && date.after(evening) == true) {
            System.out.println("It is evening"); 
            greeting = "Evening"; 
        } else if (date.after(morning) == true && date.after(afternoon) == true && date.after(evening) == false) {
            System.out.println("It is afternoon");
            greeting = "Afernoon"; 
        } else if (date.after(morning) == true && date.after(afternoon) == false && date.after(evening) == false) {
            System.out.println("It is morning");
            greeting = "Morning"; 
        } else if (date.before(morning) == true) {
            System.out.println("It is evening because it is before morning");
            greeting = "Evening"; 
        } else {
            System.out.println("im getting a headache");
        }
        
        return greeting;
    }
//    
//    public void setFullName(String firstName, String lastName) {
//        getGreeting();
//        fullName = firstName + " " + lastName; 
//    }
//    
    
//    public String getWelcomeMessage() {
//        
//        String message = "Good " + greeting + " " + fullName + ". Welcome!"; 
//        return message; 
//    }
    
    public String getWelcomeMessage(String firstName, String lastName) {
        getGreeting();
        
        String message = "Good " + greeting + " " + firstName + " " + lastName + ". Welcome! "; 
        return message;
    }
    
    
    public static void main(String[] args) {
        WelcomeService s = new WelcomeService();
//        s.setFullName("Jessica", "Kramer");
        System.out.println(s.getWelcomeMessage("Jessica", "Kramer"));
    }
}
