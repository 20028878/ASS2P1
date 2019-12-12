/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclestarter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class RentalPerDay extends Rental{
    int noOfDays;
    
    public RentalPerDay(int noOfDays){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate localDate = LocalDate.now();
        try {  
           this.startDate =new SimpleDateFormat("dd/MM/yyyy").parse( dtf.format(localDate));
        } catch (ParseException ex) {
            Logger.getLogger(RentalPerDay.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.noOfDays=noOfDays;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }
    
            
    @Override
    public double getRentalCharge() {
        return this.noOfDays*Rental.DEF_DAY_CHARAGE;
    }
    
     public String toString(){
        return "Date:"+this.startDate.toString()+"\nTotal Days:"+this.getNoOfDays();
    }
    
}
