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
public class RentalPerKm extends Rental{
    double noOfKm;
    public RentalPerKm(double noOfKm){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate localDate = LocalDate.now();
        try {  
           this.startDate =new SimpleDateFormat("dd/MM/yyyy").parse( dtf.format(localDate));
        } catch (ParseException ex) {
            Logger.getLogger(RentalPerDay.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.noOfKm=noOfKm;
    }

    public double getNoOfKm() {
        return noOfKm;
    }

    public void setNoOfKm(double noOfKm) {
        this.noOfKm = noOfKm;
    }
   
    
    
    @Override
    public double getRentalCharge() {
        return this.noOfKm*Rental.DEF_KM_CHARAGE;
    }
    
    public String toString(){
        return "Date:"+this.startDate.toString()+"\nTotal Kilometers:"+this.getNoOfKm();
    }
    
}
