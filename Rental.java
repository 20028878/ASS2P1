/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclestarter;

import java.util.Date;

/**
 *
 * @author Admin
 */
public abstract class Rental {
     public static final int DEF_KM_CHARAGE = 1;
     public static final int DEF_DAY_CHARAGE = 100;  
     Date startDate;

    public Date getStartDate() {
        return startDate;
    }

    
     
     
     public abstract double getRentalCharge();
    
}
