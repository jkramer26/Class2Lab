package model;

import java.util.Calendar;

/**
 * This is a model class for Lab 4. It receives input from the controller and
 * from that input creates a greeting based on the time of day it is with the 
 * inputted name. 
 * 
 * @author jkramer26
 * @version 1.00
 */
public class WelcomeService {
    private Calendar date;      //Creating an instance of Calendar
    private String greeting;    //This holds the type of greeting being used
    
    /**
     * This method returns a greeting based on the time of day it is.  
     * @return Returns one of 3 possible greetings as a string
     */
    private String getGreeting() {
        //Instantiating object with the current time
        date = Calendar.getInstance();
        
        //Creating calendar objects
        Calendar morning = Calendar.getInstance();
        Calendar afternoon = Calendar.getInstance();
        Calendar evening = Calendar.getInstance();
        Calendar sample = Calendar.getInstance();
        
        //setting the time of day for when it is morning
        morning.set(Calendar.HOUR_OF_DAY, 03);
        morning.set(Calendar.MINUTE, 0);
        morning.set(Calendar.SECOND, 0);
        //setting the time of day for when it is afternoon
        afternoon.set(Calendar.HOUR_OF_DAY, 10);
        afternoon.set(Calendar.MINUTE, 31);
        afternoon.set(Calendar.SECOND, 0);
        //setting the time of day for when it is evening
        evening.set(Calendar.HOUR_OF_DAY, 13);
        evening.set(Calendar.MINUTE, 1);
        evening.set(Calendar.SECOND, 0);
        //setting the time of day for testing purposes.... delete later
        sample.set(Calendar.HOUR_OF_DAY, 00);
        sample.set(Calendar.MINUTE, 1);
        sample.set(Calendar.SECOND, 0);
        
        //If the current time is after the morning, afternoon, & evening time then it is evening
        if (date.after(morning) == true && date.after(afternoon) == true && date.after(evening) == true) {
            System.out.println("It is evening"); 
            greeting = "Evening"; 
        //If the current time is after the morning & afternoon, but not after evening time then it is afternoon
        } else if (date.after(morning) == true && date.after(afternoon) == true && date.after(evening) == false) {
            System.out.println("It is afternoon");
            greeting = "Afernoon"; 
        //If the current time is after the morning, but not after afternoon & evening time then it is morning
        } else if (date.after(morning) == true && date.after(afternoon) == false && date.after(evening) == false) {
            System.out.println("It is morning");
            greeting = "Morning"; 
        //If it is before the morning time than it is still evening
        } else if (date.before(morning) == true) {
            System.out.println("It is evening because it is before morning");
            greeting = "Evening"; 
        }         
        return greeting;
    }
//    
    /**
     * This method will create and return the welcome message. It receives 
     * input for the name as Strings. It also calls the getGreeting method
     * to get what the greeting should be. 
     * 
     * @param firstName Input is a string
     * @param lastName Input is a string
     * @return Returns a welcome message as a string
     */
    public String getWelcomeMessage(String firstName, String lastName) {
        getGreeting();
        
        String message = "Good " + greeting + " " + firstName + " " + lastName + ". Welcome! "; 
        return message;
    }
    
    //Decide if getters and setters are necessary
    //Decide if we need equals and hashcode
    //Decide if we need toString
    
    //For testing... delete later
    public static void main(String[] args) {
        WelcomeService s = new WelcomeService();
        System.out.println(s.getWelcomeMessage("Jessica", "Kramer"));
    }
}
