/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclestarter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Starter code for Vehicle application. 
 * This class displays sample output to the console.
 * @author AUTHORNAME
 */
public class VehicleStarter {


    static ArrayList<Vehicle> vehicles=new ArrayList<Vehicle>();
    static Scanner scan=new Scanner(System.in);
    
    
    public static int menu(){
        System.out.println("****Vehicle Rentals****");
        System.out.println("1)Add Vehicle");
        System.out.println("2)Book Vehicle");
        System.out.println("3)Set Vehicle as available");
        System.out.println("4)Set Vehicle as unavailable");
        System.out.println("5)Print Vehicle Details");
        System.out.println("6)Service Vehicle");
        System.out.println("7)Print Vehicle rent records");
        System.out.println("8)Print Vehicle service records");
        System.out.println("9)Add feul");
         System.out.println("10)Print all vehicle details");
        System.out.println("11)Exit");
        return scan.nextInt();
        
    }
    public static void main(String[] args) {        
        
        while(true){
            int choice=menu();
            int veh;
            switch(choice){
                case 1:

                        String manufacturer,model,regNum;
                        int myear,odo,tank,kmperliter;
                        System.out.println("Enter Manufacturer:");
                        manufacturer=scan.nextLine();
                        manufacturer=scan.nextLine();
                        System.out.println("Enter model:");
                        model=scan.nextLine();
                        System.out.println("Enter make year:");
                        
                        myear=scan.nextInt();
                        System.out.println("Enter Registeration Number:");
                        regNum=scan.nextLine();
                        regNum=scan.nextLine();
                        System.out.println("Enter make Odometer Reading:");
                        odo=scan.nextInt();
                        System.out.println("Enter make Tank Capacity:");
                        tank=scan.nextInt();
                        System.out.println("Enter make Km Per Liter:");
                        kmperliter=scan.nextInt();
                        Vehicle v = new Vehicle(manufacturer, model, myear,regNum,odo,tank,kmperliter);
                        vehicles.add(v);
                        break;
                  
                    
                case 2: 
                        System.out.println("Enter vehicle id:");
                        veh=scan.nextInt();
                        if(veh<0 || veh>vehicles.size()){
                            System.out.println("Invalid Vehicle id");
                            continue;
                        }
                        
                        if(!vehicles.get(veh-1).isAvailable()){
                            System.out.println("Vehicle is not available!");
                             continue;
                        }
                        
                        if(vehicles.get(veh-1).isDueForService()){
                            System.out.println("Vehicle is due for service!");
                             continue;
                        }
                        System.out.println("Rental Type");
                        System.out.println("1)Per Day");
                        System.out.println("2)Per KM");
                        
                        int option=scan.nextInt();
                        if(option==1){
                             System.out.println("Enter number of days");
                             int days=scan.nextInt();
                             vehicles.get(veh-1).addRental(new RentalPerDay(days));
                             vehicles.get(veh-1).addKilometers(100);
                        }
                        if(option==2){
                             System.out.println("Enter number of kilometers");
                             int kms=scan.nextInt();
                             vehicles.get(veh-1).addRental(new RentalPerKm(kms));
                              vehicles.get(veh-1).addKilometers(kms);
                        }
                        break;
                    
                case 3: System.out.println("Enter vehicle id:");
                        veh=scan.nextInt();
                        if(veh<0 || veh>vehicles.size()){
                            System.out.println("Invalid Vehicle id");
                            continue;
                        }else{
                            vehicles.get(veh-1).setAvailable(true);
                        }break;
                case 4: System.out.println("Enter vehicle id:");
                        veh=scan.nextInt();
                        if(veh<0 || veh>vehicles.size()){
                            System.out.println("Invalid Vehicle id");
                            continue;
                        }else{
                            vehicles.get(veh-1).setAvailable(false);
                        }break;
                    
                    
                case 5:
                        System.out.println("Enter vehicle id:");
                        veh=scan.nextInt();
                        if(veh<0 || veh>vehicles.size()){
                            System.out.println("Invalid Vehicle id");
                            continue;
                        }else{
                            System.out.println("**************************************************");       
                            vehicles.get(veh-1).printDetails();
                        }break;
                        
                case 6: 
                        System.out.println("Enter vehicle id:");
                        veh=scan.nextInt();
                        if(veh<0 || veh>vehicles.size()){
                            System.out.println("Invalid Vehicle id");
                            continue;
                        }else{     
                            vehicles.get(veh-1).serviceVehicle();
                        }break;
              
                case 7: System.out.println("Enter vehicle id:");
                        veh=scan.nextInt();
                        if(veh<0 || veh>vehicles.size()){
                            System.out.println("Invalid Vehicle id");
                            continue;
                        }else{
                            System.out.println("Rent Records");       
                            vehicles.get(veh-1).printRentals();
                        }break;
                       
                    
                case 8: System.out.println("Enter vehicle id:");
                        veh=scan.nextInt();
                        if(veh<0 || veh>vehicles.size()){
                            System.out.println("Invalid Vehicle id");
                            continue;
                        }else{
                            System.out.println("Service Record");       
                            vehicles.get(veh-1).printService();
                        }break;
                    
                    
                case 9: System.out.println("Enter vehicle id:");
                        veh=scan.nextInt();
                        if(veh<0 || veh>vehicles.size()){
                            System.out.println("Invalid Vehicle id");
                            continue;
                        }else{   
                            System.out.println("Enter Liters:");
                            double ltr=scan.nextDouble();
                            if(ltr>vehicles.get(veh-1).getTankcapity()){
                                System.out.println("Max tank capacity is: "+vehicles.get(veh-1).getTankcapity());
                                continue;
                            }
                            System.out.println("Enter Price:");
                            double price=scan.nextDouble();
                            
                            vehicles.get(veh-1).addFuel(ltr, price);
                        }break;
                case 10: 
                        System.out.println("All vehicles");
                        for(int i=0;i<vehicles.size();i++){    
                            System.out.println("**************************************************");       
                            System.out.println("ID:"+(i+1));
                            vehicles.get(i).printDetails();
                        }
                        break;
                case 11:System.exit(0);
                        
                default: System.out.println("");
            
           
        }
    }
    
}}
